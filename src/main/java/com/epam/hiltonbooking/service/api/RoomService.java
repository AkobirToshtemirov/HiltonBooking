package com.epam.hiltonbooking.service.api;

import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.exceptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    boolean addNewRoom(int roomNumber, String roomClass, int bedsAmount, double roomCost) throws ServiceException;

    List<Room> getAllRooms() throws ServiceException;

    Optional<Room> getRoomById(int id) throws ServiceException;

    void setRoomActiveById(int id, boolean isActive) throws ServiceException;
    void deleteById(int id) throws ServiceException;

}
