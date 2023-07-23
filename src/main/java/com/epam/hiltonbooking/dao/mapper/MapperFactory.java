package com.epam.hiltonbooking.dao.mapper;

import com.epam.hiltonbooking.bean.Booking;
import com.epam.hiltonbooking.bean.Message;
import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.dao.mapper.impl.BookingMapper;
import com.epam.hiltonbooking.dao.mapper.impl.MessageMapper;
import com.epam.hiltonbooking.dao.mapper.impl.RoomMapper;
import com.epam.hiltonbooking.dao.mapper.impl.UserMapper;

public class MapperFactory {
    private final Mapper<User> userMapper = new UserMapper();
    private final Mapper<Room> roomMapper = new RoomMapper();
    private final Mapper<Booking> bookingMapper = new BookingMapper(userMapper, roomMapper);
    private final Mapper<Message> messageMapper = new MessageMapper();

    public static MapperFactory getInstance() {
        return Holder.INSTANCE;
    }

    public Mapper<User> getUserMapper() {
        return userMapper;
    }

    public Mapper<Room> getRoomMapper() {
        return roomMapper;
    }

    public Mapper<Booking> getBookingMapper() {
        return bookingMapper;
    }

    public Mapper<Message> getMessageMapper() {
        return messageMapper;
    }

    private static class Holder {
        private static final MapperFactory INSTANCE = new MapperFactory();
    }
}
