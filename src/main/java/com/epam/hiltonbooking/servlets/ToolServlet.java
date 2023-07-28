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

                if (action.equals("newBookings") || action.equals("approvedBookings") || action.equals("cancelledBookings")) {
                    BookingService bookingService = ServiceFactory.getInstance().getBookingService();
                    try {
                        List<Booking> bookings = bookingService.getAllBookings();
                        req.setAttribute("bookings", sortList(bookings));
                    } catch (ServiceException e) {
                        logger.error("Unable to get bookings!");
                        resp.sendRedirect(req.getContextPath() + "/error");
                        throw new RuntimeException(e);
                    }
                } else if (action.equals("rooms")) {
                    resp.sendRedirect(req.getContextPath() + "/rooms");
                    return;
                } else if (action.equals("users")) {
                    resp.sendRedirect(req.getContextPath() + "/users");
                    return;
                } else if(action.equals("newMessages")) {
                    resp.sendRedirect(req.getContextPath() + "/messages");
                    return;
                }

                req.setAttribute("tool", action);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/html/tool.jsp");
                dispatcher.forward(req, resp);

            } else {
                resp.sendRedirect(req.getContextPath() + "/error");
            }
        } else if (user != null) {
            String lastURL = (String) session.getAttribute("lastURL");
            resp.sendRedirect(lastURL);
        } else {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath);
        }
    }

    List<Booking> sortList(List<Booking> list) {
        list.sort(Comparator.comparing(Booking::getId));
        return list;
    }
}
