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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@WebServlet("/reservations")
public class BookingsServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");

        if (user == null) {
            resp.sendRedirect("login");
        } else if (user.isAdmin()) {
            BookingService bookingService = ServiceFactory.getInstance().getBookingService();

            try {
                List<Booking> allBookings = bookingService.getAllBookings();
                req.setAttribute("allBookings", sortBookingsInDesc(allBookings));
            } catch (ServiceException e) {
                logger.error("Unable to get list of bookings!");
                throw new RuntimeException(e);
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/reservations.jsp");
            dispatcher.forward(req, resp);
        } else {
            BookingService bookingService = ServiceFactory.getInstance().getBookingService();

            try {
                List<Booking> userBookings = bookingService.getBookingsByUserId(user.getId());
                req.setAttribute("userBookings", sortBookingsInDesc(userBookings));
            } catch (ServiceException e) {
                logger.error("Unable to get list of bookings by userID!");
                throw new RuntimeException(e);
            }


            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/bookings.jsp");
            dispatcher.forward(req, resp);
        }
    }

    List<Booking> sortBookingsInDesc(List<Booking> bookingList) {
        bookingList.sort(Comparator.comparing(Booking::getId).reversed());
        return bookingList;
    }

}
