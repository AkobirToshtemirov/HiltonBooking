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
import java.util.Optional;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            req.getRequestDispatcher("/login").forward(req, resp);
        } else if (user.isAdmin()) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/adminSettings.jsp");
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/profile.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        Optional<String> firstName = Optional.ofNullable(req.getParameter("firstname"));
        Optional<String> lastName = Optional.ofNullable(req.getParameter("lastname"));
        Optional<String> email = Optional.ofNullable(req.getParameter("email"));
        Optional<String> username = Optional.ofNullable(req.getParameter("username"));
        Optional<String> password = Optional.ofNullable(req.getParameter("password"));

        UserService userService = ServiceFactory.getInstance().getUserService();

        try {
            String infoMessage = null;
            if (firstName.isPresent() && lastName.isPresent() && email.isPresent() && username.isPresent() &&
                    password.isPresent()) {
                if (!user.getEmail().equals(email.get())) {
                    // Check if the email is in use by other users
                    if (userService.isEmailInUse(email.get())) {
                        infoMessage = "Email is already in use by another user. Please choose another email!";
                        req.setAttribute("info", infoMessage);
                        doGet(req, resp);
                    } else {
                        user.setEmail(email.get());
                    }
                }

                if (!user.getUsername().equals(username.get())) {
                    // Check if the username is in use by other users
                    if (userService.isUsernameInUse(username.get())) {
                        infoMessage = "Username is already in use by another user. Please choose another username!";
                        req.setAttribute("info", infoMessage);
                        doGet(req, resp);
                    } else {
                        user.setUsername(username.get());
                    }
                }

                user.setFirstName(firstName.get());
                user.setLastName(lastName.get());
                user.setPassword(password.get());

                boolean result = userService.updateUser(user);

                if (result) {
                    infoMessage = "Successfully updated!";
                    session.setAttribute("user", user);
                    req.setAttribute("info", infoMessage);
                    doGet(req, resp);
                }

            } else {
                resp.sendRedirect(req.getContextPath() + "/error");
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            logger.error("Unable to update user information!");
            throw new RuntimeException(e);
        }
    }

}
