package com.epam.hiltonbooking.servlets;

import com.epam.hiltonbooking.bean.Booking;
import com.epam.hiltonbooking.bean.Message;
import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.BookingService;
import com.epam.hiltonbooking.service.api.MessageService;
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
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@WebServlet("/tool")
public class ToolServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null && user.isAdmin()) {
            Optional<String> tool = Optional.ofNullable(req.getParameter("action"));

            if (tool.isPresent()) {
                String action = tool.get();

                if (action.equals("newBookings") || action.equals("approvedBookings") || action.equals("cancelledBookings")
                        || action.equals("checkedInBookings") || action.equals("checkedOutBookings")) {
                    BookingService bookingService = ServiceFactory.getInstance().getBookingService();
                    try {
                        List<Booking> bookings = bookingService.getAllBookings();
                        req.setAttribute("bookings", sortList(bookings));
                    } catch (ServiceException e) {
                        logger.error("Unable to get bookings!");
//                        resp.sendRedirect(req.getContextPath() + "/error");
                        throw new RuntimeException(e);
                    }
                } else if (action.equals("newMessages")) {
                    MessageService messageService = ServiceFactory.getInstance().getMessageService();
                    try {
                        List<Message> messages = messageService.getAllMessages();
                        req.setAttribute("messages", sortMessagesInDesc(messages));
                    } catch (ServiceException e) {
                        logger.error("Unable to get messages!");
//                        resp.sendRedirect(req.getContextPath() + "/error");
                        throw new RuntimeException(e);
                    }
                }

                req.setAttribute("tool", action);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/html/tool.jsp");
                dispatcher.forward(req, resp);

            } else {
                resp.sendRedirect(req.getContextPath() + "/error");
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }

    List<Booking> sortList(List<Booking> list) {
        list.sort(Comparator.comparing(Booking::getId).reversed());
        return list;
    }

    List<Message> sortMessagesInDesc(List<Message> messageList) {
        messageList.sort(Comparator.comparing(Message::getId).reversed());
        return messageList;
    }
}
