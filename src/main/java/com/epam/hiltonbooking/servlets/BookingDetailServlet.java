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
import java.math.BigDecimal;
import java.sql.Date;
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
                if (bookingId.isPresent()) {
                    Optional<Booking> bookingOptional = bookingService.getBookingById(Integer.parseInt(bookingId.get()));
                    if (bookingOptional.isPresent()) {
                        Booking booking = bookingOptional.get();

                        req.setAttribute("booking", booking);

                        RoomService roomService = ServiceFactory.getInstance().getRoomService();
                        List<Room> roomList = roomService.getSuitableRooms(booking.getBedsAmount(), booking.getRoomClass());

                        req.setAttribute("roomList", roomList);

                        RequestDispatcher dispatcher = req.getRequestDispatcher("/html/bookingDetails.jsp");
                        dispatcher.forward(req, resp);
                    } else {
                        resp.sendRedirect(req.getContextPath() + "/error");
                    }
                } else {
                    resp.sendRedirect(req.getContextPath() + "/error");
                }
            } catch (ServiceException e) {
                logger.error("Unable to get Booking by booking id!");
                throw new RuntimeException(e);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String roomId = req.getParameter("room-id");
        String bookingId = req.getParameter("booking-id");

        switch (action) {
            case "APPROVE":
                if (roomId == null || roomId.isEmpty() || bookingId == null || bookingId.isEmpty()) {
                    resp.sendRedirect(req.getContextPath() + "/error");
                    return;
                }

                try {
                    RoomService roomService = ServiceFactory.getInstance().getRoomService();
                    Optional<Room> roomOptional = roomService.getRoomById(Integer.parseInt(roomId));

                    if (roomOptional.isPresent()) {
                        Room room = roomOptional.get();
                        roomService.setRoomStatus(room, false);

                        BookingService bookingService = ServiceFactory.getInstance().getBookingService();
                        Optional<Booking> bookingOptional = bookingService.getBookingById(Integer.parseInt(bookingId));

                        if (bookingOptional.isPresent()) {
                            Booking booking = bookingOptional.get();
                            int stayingDays = calculateStayingDays(booking.getCheckIn(), booking.getCheckOut());

                            BigDecimal totalCost = BigDecimal.valueOf(room.getRoomCost() * stayingDays);

                            bookingService.approveBooking(Integer.parseInt(bookingId), room, totalCost);
                        } else {
                            resp.sendRedirect(req.getContextPath() + "/error");
                        }
                    } else {
                        resp.sendRedirect(req.getContextPath() + "/error");
                    }

                } catch (ServiceException e) {
                    logger.error("Unable to approve booking");
                    throw new RuntimeException(e);
                }

                resp.sendRedirect(req.getContextPath() + "/reservations");
                break;
            case "CANCEL": {
                BookingService bookingService = ServiceFactory.getInstance().getBookingService();
                try {
                    bookingService.cancelBooking(Integer.parseInt(bookingId));
                } catch (ServiceException e) {
                    logger.error("Unable to cancel booking");
                    throw new RuntimeException(e);
                }

                resp.sendRedirect(req.getContextPath() + "/reservations");
                break;
            }
            case "CHECK IN": {
                BookingService bookingService = ServiceFactory.getInstance().getBookingService();
                try {
                    bookingService.checkInBooking(Integer.parseInt(bookingId));
                } catch (ServiceException e) {
                    logger.error("Unable to check in booking");
                    throw new RuntimeException(e);
                }

                resp.sendRedirect(req.getContextPath() + "/reservations");
                break;
            }
            case "CHECK OUT": {
                BookingService bookingService = ServiceFactory.getInstance().getBookingService();

                try {
                    Optional<Booking> optionalBooking = bookingService.getBookingById(Integer.valueOf(bookingId));
                    if (optionalBooking.isPresent()) {
                        Booking booking = optionalBooking.get();
                        RoomService roomService = ServiceFactory.getInstance().getRoomService();

                        Room room = booking.getRoom();
                        roomService.setRoomStatus(room, true);

                        bookingService.checkOutBooking(Integer.parseInt(bookingId));
                    }
                } catch (ServiceException e) {
                    logger.error("Unable to check in booking");
                    throw new RuntimeException(e);
                }

                resp.sendRedirect(req.getContextPath() + "/reservations");
                break;
            }
        }
    }

    private int calculateStayingDays(Date checkIn, Date checkOut) {
        long millisecondsPerDay = 24 * 60 * 60 * 1000;
        long checkInTime = checkIn.getTime();
        long checkOutTime = checkOut.getTime();
        return (int) ((checkOutTime - checkInTime) / millisecondsPerDay);
    }

}
