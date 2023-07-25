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

@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html/register.jsp");
        dispatcher.forward(req, resp);
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
                if (userService.isEmailInUse((email.get()))) {
                    infoMessage = "Email is already registered!";
                    req.setAttribute("info", infoMessage);
                    doGet(req, resp);
                } else if (userService.isUsernameInUse(username.get())) {
                    infoMessage = "Username is in use. Please choose another username!";
                    req.setAttribute("info", infoMessage);
                    doGet(req, resp);
                } else {
                    boolean result = userService.registerUser(firstName.get(), lastName.get(), email.get(), username.get(), password.get());
                    if (result) {
                        req.getRequestDispatcher("/login").forward(req, resp);
                    }
                }
            }

        } catch (ServiceException e) {
            e.printStackTrace();
            logger.error("Unable to register");
            throw new RuntimeException(e);
        }

    }
}
