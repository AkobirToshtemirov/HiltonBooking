package com.epam.hiltonbooking.dao.impl;

import com.epam.hiltonbooking.dao.api.BookingDao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.epam.hiltonbooking.bean.Booking;
import com.epam.hiltonbooking.exceptions.DaoException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BookingDaoTest {
    private BookingDao bookingDao;

    @Before
    public void setUp() {
        // Create a mock instance of BookingDao
        bookingDao = mock(BookingDao.class);
    }

    @Test
    public void testGetBookingsByUserId() throws DaoException {
        // Given
        Integer userId = 123;
        List<Booking> expectedBookings = new ArrayList<>();
        // Assuming some setup of expectedBookings

        // When
        when(bookingDao.getBookingsByUserId(userId)).thenReturn(expectedBookings);

        // Then
        List<Booking> actualBookings = bookingDao.getBookingsByUserId(userId);
        assertEquals(expectedBookings, actualBookings);
    }

    @Test
    public void testFindByStatus() throws DaoException {
        // Given
        String status = "CONFIRMED";
        List<Booking> expectedBookings = new ArrayList<>();
        // Assuming some setup of expectedBookings

        // When
        when(bookingDao.findByStatus(status)).thenReturn(expectedBookings);

        // Then
        List<Booking> actualBookings = bookingDao.findByStatus(status);
        assertEquals(expectedBookings, actualBookings);
    }
    @Test
    public void testUpdateBooking() throws DaoException {
        // Given
        Booking bookingToUpdate = new Booking();
        // Assuming some setup of bookingToUpdate

        // When - No need to use 'when' for void methods

        // Then - Verify that the method was called once
        bookingDao.updateBooking(bookingToUpdate);
        verify(bookingDao, times(1)).updateBooking(bookingToUpdate);
    }
}
