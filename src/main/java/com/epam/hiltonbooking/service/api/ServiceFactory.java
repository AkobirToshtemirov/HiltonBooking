package com.epam.hiltonbooking.service.api;

import com.epam.hiltonbooking.service.impl.BookingServiceImpl;
import com.epam.hiltonbooking.service.impl.MessageServiceImpl;
import com.epam.hiltonbooking.service.impl.RoomServiceImpl;
import com.epam.hiltonbooking.service.impl.UserServiceImpl;

public class ServiceFactory {
    private final UserService userService = new UserServiceImpl();
    private final RoomService roomService = new RoomServiceImpl();
    private final BookingService bookingService = new BookingServiceImpl();
    private final MessageService messageService = new MessageServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return Holder.INSTANCE;
    }

    public UserService getUserService() {
        return userService;
    }

    public RoomService getRoomService() {
        return roomService;
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    private static class Holder {
        static final ServiceFactory INSTANCE = new ServiceFactory();
    }
}
