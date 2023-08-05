package com.epam.hiltonbooking.servlets;

import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.RoomService;
import com.epam.hiltonbooking.service.api.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/delete-room")
public class DeleteRoomServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/error");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> roomId = Optional.ofNullable(req.getParameter("room-id"));

        RoomService roomService = ServiceFactory.getInstance().getRoomService();

        try {
            if (roomId.isPresent()) {
                Optional<Room> roomOptional = roomService.getRoomById(Integer.valueOf(roomId.get()));

                if (roomOptional.isPresent()) {
                    String deleteMessage;
                    if (roomOptional.get().isActive()) {
                        roomService.deleteById(Integer.valueOf(roomId.get()));
                        deleteMessage = "Room is deleted successfully!";
                    } else {
                        deleteMessage = "Room is not deleted. Room is booked!";
                    }
                    req.getSession().setAttribute("deleteMessage", deleteMessage);
                    resp.sendRedirect(req.getContextPath() + "/rooms");
                } else {
                    resp.sendRedirect(req.getContextPath() + "/error");
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/error");
            }
        } catch (ServiceException e) {
            logger.error("Unable to delete room!");
            throw new RuntimeException(e);
        }
    }
}
