package com.epam.hiltonbooking.service.api;

import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.exceptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    boolean addNewRoom(int roomNumber, String roomClass, int bedsAmount, double roomCost) throws ServiceException;

    List<Room> getAllRooms() throws ServiceException;

    Optional<Room> getRoomById(Integer id) throws ServiceException;
    List<Room> getSuitableRooms(int bedsAmount, String roomClass) throws ServiceException;

    void setRoomActiveById(Integer id, boolean isActive) throws ServiceException;
    boolean isRoomAdded(int roomNumber) throws ServiceException;
    void deleteById(Integer id) throws ServiceException;

}
