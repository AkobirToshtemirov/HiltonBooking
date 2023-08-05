package com.epam.hiltonbooking.servlets;

import com.epam.hiltonbooking.bean.Message;
import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.exceptions.ServiceException;
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
import java.util.Optional;

@WebServlet("/view-message")
public class ViewMessageServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null && user.isAdmin()) {
            Optional<String> messageId = Optional.ofNullable(req.getParameter("message-id"));

            MessageService messageService = ServiceFactory.getInstance().getMessageService();

            try {
                if (messageId.isPresent()) {
                    Optional<Message> messageOptional = messageService.getMessageById(Integer.parseInt(messageId.get()));

                    if (messageOptional.isPresent()) {
                        Message message = messageOptional.get();

                        req.setAttribute("message", message);

                        RequestDispatcher dispatcher = req.getRequestDispatcher("/html/viewMessage.jsp");
                        dispatcher.forward(req, resp);
                    } else {
                        resp.sendRedirect(req.getContextPath() + "/error");
                    }
                } else {
                    resp.sendRedirect(req.getContextPath() + "/error");
                }

            } catch (ServiceException e) {
                logger.error("Unable to get Message by message id!");
                throw new RuntimeException(e);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null && user.isAdmin()) {
            Optional<String> messageId = Optional.ofNullable(req.getParameter("message-id"));

            MessageService messageService = ServiceFactory.getInstance().getMessageService();

            try {
                if (messageId.isPresent()) {
                    Optional<Message> messageOptional = messageService.getMessageById(Integer.parseInt(messageId.get()));

                    if (messageOptional.isPresent()) {
                        Message message = messageOptional.get();

                        message.setRead(true);
                        messageService.setMessageRead(message);
                        req.setAttribute("message", message);
                        doGet(req, resp);
                    } else {
                        resp.sendRedirect(req.getContextPath() + "/error");
                    }
                } else {
                    resp.sendRedirect(req.getContextPath() + "/error");
                }
            } catch (ServiceException e) {
                logger.error("Unable to get Message by message id!");
                throw new RuntimeException(e);
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }
}
