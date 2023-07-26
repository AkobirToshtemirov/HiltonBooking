package com.epam.hiltonbooking.servlets;

import com.epam.hiltonbooking.bean.Booking;
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
import java.sql.Date;
import java.util.Optional;

@WebServlet("/invoice")
public class GenerateInvoiceServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        Optional<String> bookingId = Optional.ofNullable(req.getParameter("booking-id"));

        if (user != null && bookingId.isPresent()) {
            BookingService bookingService = ServiceFactory.getInstance().getBookingService();
            try {
                Optional<Booking> booking = bookingService.getBookingById(Integer.valueOf(bookingId.get()));
                req.setAttribute("booking", booking.get());
                int stayingDays = calculateStayingDays(booking.get().getCheckIn(), booking.get().getCheckOut());
                req.setAttribute("stayingDays", stayingDays);
            } catch (ServiceException e) {
                logger.error("unable to get invoice!");
                throw new RuntimeException(e);
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/invoice.jsp");
            dispatcher.forward(req, resp);
        } else if (user != null) {
            String lastURL = (String) session.getAttribute("lastURL");
            resp.sendRedirect(lastURL);
        } else {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath);
        }
    }

    private int calculateStayingDays(Date checkIn, Date checkOut) {
        long millisecondsPerDay = 24 * 60 * 60 * 1000;
        long checkInTime = checkIn.getTime();
        long checkOutTime = checkOut.getTime();
        return (int) ((checkOutTime - checkInTime) / millisecondsPerDay);
    }
}
