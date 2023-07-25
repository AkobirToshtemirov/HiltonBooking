package com.epam.hiltonbooking.servlets;

import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.RoomService;
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
import java.util.List;
import java.util.Optional;

@WebServlet("/rooms")
public class RoomsServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null && user.isAdmin()) {
            RoomService roomService = ServiceFactory.getInstance().getRoomService();

            try {
                List<Room> roomList = roomService.getAllRooms();
                session.setAttribute("roomList", roomList);
            } catch (ServiceException e) {
                logger.error("Unable to get users!");
                throw new RuntimeException(e);
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher("/html/rooms.jsp");
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
        Optional<String> roomNumber = Optional.ofNullable(req.getParameter("room-number"));
        Optional<String> roomClass = Optional.ofNullable(req.getParameter("room-class"));
        Optional<String> bedsAmount = Optional.ofNullable(req.getParameter("beds-amount"));
        Optional<String> roomCost = Optional.ofNullable(req.getParameter("room-cost"));

        RoomService roomService = ServiceFactory.getInstance().getRoomService();

        try {
            if (roomNumber.isPresent() && roomClass.isPresent() && bedsAmount.isPresent() && roomCost.isPresent()) {
                String infoMessage = null;

                if (roomService.isRoomAdded(Integer.parseInt(roomNumber.get()))) {
                    infoMessage = "Room is already added! You are trying to enter already entered room number!";
                } else {
                    boolean result = roomService.addNewRoom(Integer.parseInt(roomNumber.get()), roomClass.get(),
                            Integer.parseInt(bedsAmount.get()), Double.parseDouble(roomCost.get()));

                    if (result) {
                        infoMessage = "Successfully add the new room!";
                    } else {
                        infoMessage = "Error occurred. Room is not add! Try again!";
                    }
                }

                req.setAttribute("info", infoMessage);
                doGet(req, resp);
            }
        } catch (ServiceException e) {
            logger.error("Unable to add new room(admin)!");
            throw new RuntimeException(e);
        }

    }
}
