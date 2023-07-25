package com.epam.hiltonbooking.dao.impl;


import com.epam.hiltonbooking.bean.Booking;
import com.epam.hiltonbooking.bean.Invoice;
import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.dao.Table;
import com.epam.hiltonbooking.dao.api.AbstractDao;
import com.epam.hiltonbooking.dao.api.BookingDao;
import com.epam.hiltonbooking.dao.mapper.MapperFactory;
import com.epam.hiltonbooking.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public class BookingDaoImpl extends AbstractDao<Booking> implements BookingDao {
    private static final String GET_ALL_BOOKINGS_QUERY =
            "SELECT b.*, u.*, r.* FROM " + Table.BOOKINGS.getTableName() + " b" +
                    " JOIN " + Table.USERS.getTableName() + " u ON b.user_id = u.user_id" +
                    " LEFT JOIN " + Table.ROOMS.getTableName() + " r ON b.room_id = r.room_id";
    private static final String GET_BOOKINGS_BY_USER_ID_QUERY =
            "SELECT b.*, u.*, r.* FROM " + Table.BOOKINGS.getTableName() + " b" +
                    " JOIN " + Table.USERS.getTableName() + " u ON b.user_id = u.user_id" +
                    " LEFT JOIN " + Table.ROOMS.getTableName() + " r ON b.room_id = r.room_id" +
                    " WHERE b.user_id = ?";

    private static final String FIND_BY_STATUS_QUERY =
            "SELECT * FROM " + Table.BOOKINGS.getTableName() + " WHERE status = ?";

    private static final String FIND_BOOKING_BY_ID_QUERY =
            "SELECT b.*, u.*, r.* FROM " + Table.BOOKINGS.getTableName() + " b" +
                    " JOIN " + Table.USERS.getTableName() + " u ON b.user_id = u.user_id" +
                    " LEFT JOIN " + Table.ROOMS.getTableName() + " r ON b.room_id = r.room_id" +
                    " WHERE b.booking_id = ?";

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
    public List<Booking> getBookingsByUserId(Integer userId) throws DaoException {
        return executeQuery(GET_BOOKINGS_BY_USER_ID_QUERY, userId);
    }

    @Override
    public List<Booking> findByStatus(String status) throws DaoException {
        return executeQuery(FIND_BY_STATUS_QUERY, status);
    }

    // Implement generate Invoice
    @Override
    public Invoice generateInvoice(Integer bookingId) throws DaoException {
        return null;
    }

    @Override
    public Optional<Booking> findById(Integer id) throws DaoException {
        return executeQueryForSingleResult(FIND_BOOKING_BY_ID_QUERY, id);
    }

    @Override
    public Integer save(Booking booking) throws DaoException {
        Room room = booking.getRoom();
        Integer roomId = (room != null) ? room.getId() : null;

        return executeInsertQuery(SAVE_BOOKING_QUERY, booking.getUser().getId(), roomId, booking.getStatus(),
                booking.getCheckIn(), booking.getCheckOut(), booking.getBedsAmount(), booking.getRoomClass(), booking.getTotalCost());
    }
}
