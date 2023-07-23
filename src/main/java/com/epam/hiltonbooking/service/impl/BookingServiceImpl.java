package com.epam.hiltonbooking.service.impl;

import com.epam.hiltonbooking.bean.Booking;
import com.epam.hiltonbooking.bean.Invoice;
import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.dao.api.BookingDao;
import com.epam.hiltonbooking.dao.api.DaoFactory;
import com.epam.hiltonbooking.exceptions.DaoException;
import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.BookingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class BookingServiceImpl implements BookingService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean addNewBooking(User user, Date checkIn, Date checkOut, int bedsAmount, String roomClass) throws ServiceException {
        if (checkIn == null || checkOut == null || roomClass == null || user == null || bedsAmount < 1) {
            return false;
        }

        // Validation code here:
        // code...

        try {
            BookingDao bookingDao = DaoFactory.getInstance().getBookingDao();
            Booking booking = buildBooking(user, checkIn, checkOut, bedsAmount, roomClass);
            bookingDao.save(booking);
            return true;
        } catch (DaoException e) {
            logger.error("Unable to add booking!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Booking> getBookingsByUserId(int userId) throws ServiceException {
        List<Booking> userBookings;
        try {
            BookingDao bookingDao = DaoFactory.getInstance().getBookingDao();
            userBookings = bookingDao.getBookingsByUserId(userId);
        } catch (DaoException e) {
            logger.error("Unable to get booking by userId!");
            throw new ServiceException(e.getMessage(), e);
        }
        return userBookings;
    }

    @Override
    public Optional<Booking> getBookingById(int id) throws ServiceException {
        try {
            BookingDao bookingDao = DaoFactory.getInstance().getBookingDao();
            return bookingDao.findById(id);
        } catch (DaoException e) {
            logger.error("Unable to get booking by id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Booking> getAllBookings() throws ServiceException {
        List<Booking> bookings;
        try {
            BookingDao bookingDao = DaoFactory.getInstance().getBookingDao();
            bookings = bookingDao.findAll();
        } catch (DaoException e) {
            logger.error("Unable to get all bookings!");
            throw new ServiceException(e.getMessage(), e);
        }
        return bookings;
    }
    @Override
    public void approveBooking(int id, Room room, BigDecimal totalCost) throws ServiceException {
        try {
            BookingDao bookingDao = DaoFactory.getInstance().getBookingDao();
            Booking booking = bookingDao.findById(id).
                    orElseThrow(() -> new ServiceException("Booking is not found by id! ID = " + id));
            String status = booking.getStatus();
            if (!status.equals("WAITING")) {
                throw new ServiceException("Cannot approve th booking which is " + status);
            }
            booking.setRoom(room);
            booking.setTotalCost(totalCost);
            booking.setStatus("APPROVED");
            bookingDao.save(booking);
        } catch (DaoException e) {
            logger.error("Unable to approve the booking!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public void cancelBooking(int id) throws ServiceException {
        try {
            BookingDao bookingDao = DaoFactory.getInstance().getBookingDao();
            Optional<Booking> optional = bookingDao.findById(id);
            if(!optional.isPresent()) {
                throw new ServiceException("Booking is not found by id! ID = " + id);
            }
            Booking booking = optional.get();
            String status = booking.getStatus();
            if(status.equals("CANCELLED")) {
                throw new ServiceException("Cannot cancel th booking which is " + status);
            }
            booking.setStatus("CANCELLED");
            bookingDao.save(booking);
        } catch (DaoException e) {
            logger.error("Unable to cancel the booking!");
            throw new ServiceException(e.getMessage(), e);
        }
    }


    // Generate invoice is not written
    @Override
    public Invoice generateInvoice(int bookingId) throws ServiceException {
        return null;
    }

    private Booking buildBooking(User user, Date checkIn, Date checkOut, int bedsAmount, String roomClass) {
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setCheckIn(checkIn);
        booking.setCheckOut(checkOut);
        booking.setBedsAmount(bedsAmount);
        booking.setRoomClass(roomClass);
        return booking;
    }
}
