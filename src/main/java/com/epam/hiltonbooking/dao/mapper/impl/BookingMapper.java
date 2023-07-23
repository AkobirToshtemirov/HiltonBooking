package com.epam.hiltonbooking.dao.mapper.impl;

import com.epam.hiltonbooking.bean.Booking;
import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.dao.mapper.Column;
import com.epam.hiltonbooking.dao.mapper.Mapper;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class BookingMapper implements Mapper<Booking> {
    private final Mapper<User> userMapper;
    private final Mapper<Room> roomMapper;

    public BookingMapper(Mapper<User> userMapper, Mapper<Room> roomMapper) {
        this.userMapper = userMapper;
        this.roomMapper = roomMapper;
    }

    @Override
    public Booking map(ResultSet resultSet) throws SQLException {
        int bookingId = resultSet.getInt(Column.BOOKING_ID);
//        int userId = resultSet.getInt(Column.USER_ID.getColumnName());
//        int roomId = resultSet.getInt(Column.ROOM_ID.getColumnName());
        String status = resultSet.getString(Column.BOOKING_STATUS);
        Date checkIn = resultSet.getDate(Column.BOOKING_CHECK_IN);
        Date checkOut = resultSet.getDate(Column.BOOKING_CHECK_OUT);
        int bedsAmount = resultSet.getInt(Column.ROOM_BEDS_AMOUT);
        BigDecimal totalCost = resultSet.getBigDecimal(Column.BOOKING_TOTAL_COST);
        String roomClass = resultSet.getString(Column.BOOKING_ROOM_CLASS);
        Timestamp bookingTime = resultSet.getTimestamp(Column.BOOKING_TIME);

        Booking booking = new Booking(bookingId, null, null, status, checkIn, checkOut, bedsAmount, roomClass, totalCost, bookingTime);

        User user = userMapper.map(resultSet);
        Room room = roomMapper.map(resultSet);

        booking.setUser(user);
        booking.setRoom(room);

        return booking;
    }
}
