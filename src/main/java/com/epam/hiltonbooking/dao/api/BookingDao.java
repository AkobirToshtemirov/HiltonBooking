package com.epam.hiltonbooking.dao.api;

import com.epam.hiltonbooking.bean.Booking;
import com.epam.hiltonbooking.bean.Invoice;
import com.epam.hiltonbooking.exceptions.DaoException;

import java.util.List;

public interface BookingDao extends Dao<Booking> {
    List<Booking> getBookingsByUserId(int userId) throws DaoException;
    List<Booking> findByStatus(String status) throws DaoException;
    Invoice generateInvoice(int bookingId) throws DaoException;
}
