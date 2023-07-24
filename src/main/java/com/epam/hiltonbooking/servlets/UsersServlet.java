package com.epam.hiltonbooking.servlets;

import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.ServiceFactory;
import com.epam.hiltonbooking.service.api.UserService;
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

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null && user.isAdmin()) {
            UserService userService = ServiceFactory.getInstance().getUserService();

            try {
                List<User> userList = userService.getAllUsers();
                session.setAttribute("userList", userList);
            } catch (ServiceException e) {
                logger.error("Unable to get users!");
                throw new RuntimeException(e);
            }


            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/users.jsp");
            dispatcher.forward(req, resp);
        } else if (user != null) {
            String lastURL = (String) session.getAttribute("lastURL");
            resp.sendRedirect(lastURL);
        } else {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath);
        }
    }
}
