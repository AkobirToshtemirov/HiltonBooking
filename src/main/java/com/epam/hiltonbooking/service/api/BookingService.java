package com.epam.hiltonbooking.service.api;

import com.epam.hiltonbooking.bean.Booking;
import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.exceptions.ServiceException;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface BookingService {
    boolean addNewBooking(User user, Room room, String status, Date checkIn, Date checkOut, int bedsAmount, String roomClass) throws ServiceException;

    List<Booking> getBookingsByUserId(Integer userId) throws ServiceException;

    Optional<Booking> getBookingById(Integer id) throws ServiceException;

    List<Booking> getAllBookings() throws ServiceException;

    void approveBooking(Integer id, Room room, BigDecimal totalCost) throws ServiceException;

    void cancelBooking(Integer id) throws ServiceException;

}
