package com.epam.hiltonbooking.service.api;

import com.epam.hiltonbooking.bean.Booking;
import com.epam.hiltonbooking.bean.Invoice;
import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.exceptions.ServiceException;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface BookingService {
    boolean addNewBooking(User user, Date checkIn, Date checkOut, int bedsAmount, String roomClass) throws ServiceException;

    List<Booking> getBookingsByUserId(int userId) throws ServiceException;

    Optional<Booking> getBookingById(int id) throws ServiceException;

    List<Booking> getAllBookings() throws ServiceException;

    void approveBooking(int id, Room room, BigDecimal totalCost) throws ServiceException;

    void cancelBooking(int id) throws ServiceException;

    Invoice generateInvoice(int bookingId) throws ServiceException;
}
