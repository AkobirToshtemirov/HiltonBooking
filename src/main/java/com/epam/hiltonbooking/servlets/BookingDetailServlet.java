package com.epam.hiltonbooking.servlets;

import com.epam.hiltonbooking.bean.Booking;
import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.BookingService;
import com.epam.hiltonbooking.service.api.RoomService;
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
import java.util.List;
import java.util.Optional;

@WebServlet("/booking-details")
public class BookingDetailServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null && user.isAdmin()) {
            Optional<String> bookingId = Optional.ofNullable(req.getParameter("booking-id"));

            BookingService bookingService = ServiceFactory.getInstance().getBookingService();

            try {
                Optional<Booking> bookingOptional = bookingService.getBookingById(Integer.parseInt(bookingId.get()));
                Booking booking = bookingOptional.get();

                req.setAttribute("booking", booking);

                RoomService roomService = ServiceFactory.getInstance().getRoomService();
                List<Room> roomList = roomService.getSuitableRooms(booking.getBedsAmount(), booking.getRoomClass());

                req.setAttribute("roomList", roomList);

                RequestDispatcher dispatcher = req.getRequestDispatcher("/html/bookingDetails.jsp");
                dispatcher.forward(req, resp);

            } catch (ServiceException e) {
                logger.error("Unable to get Booking by booking id!");
                throw new RuntimeException(e);
            }
        } else if (user != null) {
            String lastURL = (String) session.getAttribute("lastURL");
            resp.sendRedirect(lastURL);
        } else {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath);
        }
    }


}
