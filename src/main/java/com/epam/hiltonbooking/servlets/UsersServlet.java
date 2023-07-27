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
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String currentURL = req.getRequestURI();
        session.setAttribute("lastURL", currentURL);

        if (user != null && user.isAdmin()) {
            UserService userService = ServiceFactory.getInstance().getUserService();

            try {
                List<User> userList = userService.getAllUsers();
                session.setAttribute("userList", sortUsersInDesc(userList));
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Optional<String> firstName = Optional.ofNullable(req.getParameter("firstname-user"));
        Optional<String> lastName = Optional.ofNullable(req.getParameter("lastname-user"));
        Optional<String> email = Optional.ofNullable(req.getParameter("email-user"));
        Optional<String> username = Optional.ofNullable(req.getParameter("username-user"));
        Optional<String> password = Optional.ofNullable(req.getParameter("password-user"));

        UserService userService = ServiceFactory.getInstance().getUserService();

        try {
            String infoMessage = null;
            if (firstName.isPresent() && lastName.isPresent() && email.isPresent() && username.isPresent() && password.isPresent()) {
                if (userService.isEmailInUse((email.get()))) {
                    infoMessage = "Email is already registered!";
                } else if (userService.isUsernameInUse(username.get())) {
                    infoMessage = "Username is in use. Please choose another username!";
                } else {
                    boolean result = userService.registerUser(firstName.get(), lastName.get(), email.get(), username.get(), password.get());

                    if (result) {
                        infoMessage = "Successfully registered!";
                    }
                }
                req.setAttribute("info", infoMessage);
                doGet(req, resp);
            }
        } catch (ServiceException e) {
            logger.error("Unable to register user(admin)!");
            throw new RuntimeException(e);
        }
    }

    List<User> sortUsersInDesc(List<User> userList) {
        userList.sort(Comparator.comparing(User::getId).reversed());
        return userList;
    }

}
