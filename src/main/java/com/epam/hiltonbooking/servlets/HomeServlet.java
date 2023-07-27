package com.epam.hiltonbooking.servlets;

import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.MessageService;
import com.epam.hiltonbooking.service.api.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> messangerName = Optional.ofNullable(req.getParameter("messanger_name"));
        Optional<String> messangerEmail = Optional.ofNullable(req.getParameter("messanger_email"));
        Optional<String> messangerPhone = Optional.ofNullable(req.getParameter("messanger_phone"));
        Optional<String> messageText = Optional.ofNullable(req.getParameter("message_text"));

        MessageService messageService = ServiceFactory.getInstance().getMessageService();

        try {
            String infoMessage = null;
            boolean result = false;
            if (messangerName.isPresent() && messangerEmail.isPresent() && messangerPhone.isPresent() && messageText.isPresent()) {
                result = messageService.addNewMessage(messangerName.get(), messangerEmail.get(), messangerPhone.get(), messageText.get());
                if (result) {
                    infoMessage = "Message is sent!";
                } else {
                    infoMessage = "Message is not sent! Try again! Please make sure you filled all inputs!";
                }
                req.setAttribute("infoMessage", infoMessage);

                doGet(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/error");
            }
        } catch (ServiceException e) {
            logger.error("Unable to send message!");
            throw new RuntimeException(e);
        }
    }
}