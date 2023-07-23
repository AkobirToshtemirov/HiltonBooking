package com.epam.hiltonbooking.dao.impl;


import com.epam.hiltonbooking.bean.Booking;
import com.epam.hiltonbooking.bean.Invoice;
import com.epam.hiltonbooking.dao.Table;
import com.epam.hiltonbooking.dao.api.AbstractDao;
import com.epam.hiltonbooking.dao.api.BookingDao;
import com.epam.hiltonbooking.dao.mapper.MapperFactory;
import com.epam.hiltonbooking.exceptions.DaoException;

import java.util.List;

public class BookingDaoImpl extends AbstractDao<Booking> implements BookingDao {
    private static final String GET_ALL_BOOKINGS_QUERY =
            "SELECT * FROM " + Table.BOOKINGS.getTableName();
    private static final String GET_BOOKINGS_BY_USER_ID_QUERY =
            "SELECT * FROM " + Table.BOOKINGS.getTableName() + " WHERE user_id = ?";
    private static final String FIND_BY_STATUS_QUERY =
            "SELECT * FROM " + Table.BOOKINGS.getTableName() + " WHERE status = ?";
    private static final String SAVE_BOOKING_QUERY =
            "INSERT INTO " + Table.BOOKINGS.getTableName() + "(user_id, room_id, status, check_in, check_out, beds_amount, room_class, total_cost) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public BookingDaoImpl() {
        super(MapperFactory.getInstance().getBookingMapper(), Table.BOOKINGS.getTableName());
    }

    @Override
    public List<Booking> findAll() throws DaoException {
        return executeQuery(GET_ALL_BOOKINGS_QUERY);
    }

    @Override
    public List<Booking> getBookingsByUserId(int userId) throws DaoException {
        return executeQuery(GET_BOOKINGS_BY_USER_ID_QUERY, userId);
    }

    @Override
    public List<Booking> findByStatus(String status) throws DaoException {
        return executeQuery(FIND_BY_STATUS_QUERY, status);
    }

    // Implement generate Invoice
    @Override
    public Invoice generateInvoice(int bookingId) throws DaoException {
        return null;
    }

    @Override
    public int save(Booking booking) throws DaoException {
        return executeInsertQuery(SAVE_BOOKING_QUERY, booking.getUser(), booking.getRoom(), booking.getStatus(),
                booking.getCheckIn(), booking.getCheckOut(), booking.getBedsAmount(), booking.getTotalCost());
    }
}
