package com.epam.hiltonbooking.servlets;

import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.BookingService;
import com.epam.hiltonbooking.service.api.ServiceFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Optional;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String currentURL = req.getRequestURL().toString();
        session.setAttribute("lastURL", currentURL);

        if (user != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/book.jsp");
            dispatcher.forward(req, resp);
        } else {
            resp.sendRedirect("login");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        Optional<String> checkIn = Optional.ofNullable(req.getParameter("check-in"));
        Optional<String> checkOut = Optional.ofNullable(req.getParameter("check-out"));
        Optional<String> bedsAmount = Optional.ofNullable(req.getParameter("beds-amount"));
        Optional<String> roomClass = Optional.ofNullable(req.getParameter("room-class"));

        BookingService bookingService = ServiceFactory.getInstance().getBookingService();

        try {
            String infoMessage = null;

            if (checkIn.isPresent() && checkOut.isPresent() && bedsAmount.isPresent() && roomClass.isPresent()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date checkInDate = dateFormat.parse(checkIn.get());
                java.util.Date checkOutDate = dateFormat.parse(checkOut.get());

                if (checkOutDate.before(checkInDate) || checkOutDate.equals(checkInDate)) {
                    infoMessage = "Check-in date cannot be after the checkout date. Or same either!";
                    req.setAttribute("error", infoMessage);
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/html/book.jsp");
                    dispatcher.forward(req, resp);
                } else {
                    Date sqlCheckInDate = new Date(checkInDate.getTime());
                    Date sqlCheckOutDate = new Date(checkOutDate.getTime());

                    boolean result = bookingService.addNewBooking(user, null, "WAITING", sqlCheckInDate, sqlCheckOutDate, Integer.parseInt(bedsAmount.get()), roomClass.get());

                    if (result) {
                        infoMessage = "Booking added Successfully";
                        req.setAttribute("info", infoMessage);
                        resp.sendRedirect(req.getContextPath() + "/reservations");
                    } else {
                        // Handle the case when any of the required parameters are missing
                        infoMessage = "Please fill in all the required fields.";
                        req.setAttribute("info", infoMessage);
                        resp.sendRedirect(req.getContextPath() + "/book");
                    }
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/error");
            }
        } catch (ServiceException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
