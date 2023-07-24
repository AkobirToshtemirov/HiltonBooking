package com.epam.hiltonbooking.dao.mapper.impl;


import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.dao.mapper.Column;
import com.epam.hiltonbooking.dao.mapper.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomMapper implements Mapper<Room> {
    @Override
    public Room map(ResultSet resultSet) throws SQLException {
        Integer roomId = resultSet.getInt(Column.ROOM_ID);
        int roomNumber = resultSet.getInt(Column.ROOM_NUMBER);
        String roomClass = resultSet.getString(Column.ROOM_CLASS);
        int bedsAmount = resultSet.getInt(Column.ROOM_BEDS_AMOUT);
        boolean isActive = resultSet.getBoolean(Column.ROOM_IS_ACTIVE);
        double roomCost = resultSet.getDouble(Column.ROOM_COST);
        return new Room(roomId, roomNumber, roomClass, bedsAmount, isActive, roomCost);
    }
}
