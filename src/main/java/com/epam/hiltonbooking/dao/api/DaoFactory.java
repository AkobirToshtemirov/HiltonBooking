package com.epam.hiltonbooking.dao.api;

import com.epam.hiltonbooking.dao.impl.BookingDaoImpl;
import com.epam.hiltonbooking.dao.impl.MessageDaoImpl;
import com.epam.hiltonbooking.dao.impl.RoomDaoImpl;
import com.epam.hiltonbooking.dao.impl.UserDaoImpl;

public class DaoFactory {
    private final UserDao userDao = new UserDaoImpl();
    private final RoomDao roomDao = new RoomDaoImpl();
    private final BookingDao bookingDao = new BookingDaoImpl();
    private final MessageDao messageDao = new MessageDaoImpl();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return Holder.INSTANCE;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }

    public BookingDao getBookingDao() {
        return bookingDao;
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    private static class Holder {
        static final DaoFactory INSTANCE = new DaoFactory();
    }
}
