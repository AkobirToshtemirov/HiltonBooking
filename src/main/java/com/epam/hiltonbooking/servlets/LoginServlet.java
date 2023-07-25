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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/login.jsp");
            dispatcher.forward(req, resp);
        } else if (user.isAdmin()) {
            resp.sendRedirect(req.getContextPath() + "/dashboard");
        } else {
            resp.sendRedirect(req.getContextPath() + "/profile");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = ServiceFactory.getInstance().getUserService();

        try {
            Optional<User> optionalResult = userService.loginUser(username, password);

            if (optionalResult.isPresent()) {
                User user = optionalResult.get();

                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                if (user.isAdmin()) {
                    resp.sendRedirect(req.getContextPath() + "/dashboard");
                } else {
                    resp.sendRedirect(req.getContextPath() + "/book");
                }
            } else {
                String errorMessage = "Invalid Credentials, please login again!";
                req.setAttribute("error", errorMessage);
                doGet(req, resp);
            }

        } catch (ServiceException e) {
//            req.getRequestDispatcher("/html/error.jsp");
            e.printStackTrace();
            logger.error("Unable to login");
            throw new RuntimeException(e);
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        UserService userService = ServiceFactory.getInstance().getUserService();
//
//        try {
//            boolean isValidUser = userService.validateUser(username, password);
//
//            if (isValidUser) {
//                HttpSession session = req.getSession();
//                session.setAttribute("username", username);
//                session.setAttribute("password", password);
//
//                req.getRequestDispatcher("/html/book.jsp").forward(req, resp);
//            } else {
//                String errorMessage = "Invalid Credentials, please login again!";
//                req.setAttribute("error", errorMessage);
//                req.getRequestDispatcher("/html/login.jsp").forward(req, resp);
//            }
//        } catch (ServiceException e) {
////            req.getRequestDispatcher("/html/error.jsp");
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
}
