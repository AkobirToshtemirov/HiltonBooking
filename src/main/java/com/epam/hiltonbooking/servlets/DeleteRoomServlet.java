package com.epam.hiltonbooking.servlets;

import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.RoomService;
import com.epam.hiltonbooking.service.api.ServiceFactory;
import com.epam.hiltonbooking.service.api.UserService;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> roomId = Optional.ofNullable(req.getParameter("room-id"));

        RoomService roomService = ServiceFactory.getInstance().getRoomService();

        try {
            if (roomId.isPresent()) {
                Optional<Room> roomOptional = roomService.getRoomById(Integer.valueOf(roomId.get()));
                String infoMessage;
                if (roomOptional.get().isActive()) {
                    roomService.deleteById(Integer.valueOf(roomId.get()));
                    infoMessage = "Room is deleted successfully!";
                } else {
                    infoMessage = "Room is not deleted. Room is booked!";
                }
                req.setAttribute("error", infoMessage);
                resp.sendRedirect(req.getContextPath() + "/rooms");
            }
        } catch (ServiceException e) {
            logger.error("Unable to delete room!");
            throw new RuntimeException(e);
        }
    }
}
