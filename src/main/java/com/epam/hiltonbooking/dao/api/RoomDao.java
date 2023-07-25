package com.epam.hiltonbooking.dao.api;

import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.exceptions.DaoException;

import java.util.List;


public interface RoomDao extends Dao<Room> {
   List<Room> getSuitableRooms(int bedsAmount, String roomClass) throws DaoException;
}
