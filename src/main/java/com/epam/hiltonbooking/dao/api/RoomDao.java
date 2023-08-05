package com.epam.hiltonbooking.dao.api;

import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.exceptions.DaoException;

import java.util.List;
import java.util.Optional;


public interface RoomDao extends Dao<Room> {
    List<Room> getSuitableRooms(int bedsAmount, String roomClass) throws DaoException;

    Optional<Room> findByRoomNumber(int roomNumber) throws DaoException;

    void setRoomStatus(Room room, boolean status) throws DaoException;
}
