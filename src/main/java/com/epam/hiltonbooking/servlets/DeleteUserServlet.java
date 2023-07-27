package com.epam.hiltonbooking.servlets;

import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.ServiceFactory;
import com.epam.hiltonbooking.service.api.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/delete-user")
public class DeleteUserServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Optional<String> userId = Optional.ofNullable(req.getParameter("user-id"));

        UserService userService = ServiceFactory.getInstance().getUserService();

        String infoMessage = null;
        try {
            if (userId.isPresent()) {
                if (userService.hasBookings(Integer.parseInt(userId.get()))) {
                    infoMessage = "User has booking(s). You cannot delete user.";
                } else {
                    infoMessage = "Successfully deleted!";
                    userService.deleteUserById(Integer.valueOf(userId.get()));
                }
                session.setAttribute("infoMessage", infoMessage);
                resp.sendRedirect(req.getContextPath() + "/users");
            } else {
                resp.sendRedirect(req.getContextPath() + "/error");
            }
        } catch (ServiceException e) {
            logger.error("Unable to delete user!");
            throw new RuntimeException(e);
        }
    }
}
