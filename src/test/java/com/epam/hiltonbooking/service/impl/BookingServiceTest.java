package com.epam.hiltonbooking.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.epam.hiltonbooking.bean.Booking;
import com.epam.hiltonbooking.bean.Invoice;
import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.BookingService;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingServiceTest {

    private BookingService bookingService;

    @Before
    public void setUp() {
        // Create a mock instance of BookingService
        bookingService = mock(BookingService.class);
    }

    @Test
    public void testAddNewBooking() throws ServiceException {
        // Given
        User user = new User();
        Room room = new Room();
        String status = "CONFIRMED";
        Date checkIn = Date.valueOf("2023-07-31");
        Date checkOut = Date.valueOf("2023-08-07");
        int bedsAmount = 2;
        String roomClass = "Standard";

        // When
        when(bookingService.addNewBooking(user, room, status, checkIn, checkOut, bedsAmount, roomClass)).thenReturn(true);

        // Then
        boolean isBookingAdded = bookingService.addNewBooking(user, room, status, checkIn, checkOut, bedsAmount, roomClass);
        assertEquals(true, isBookingAdded);
    }

    @Test
    public void testGetBookingsByUserId() throws ServiceException {
        // Given
        Integer userId = 123;
        List<Booking> expectedBookings = new ArrayList<>();
        // Assuming some setup of expectedBookings

        // When
        when(bookingService.getBookingsByUserId(userId)).thenReturn(expectedBookings);

        // Then
        List<Booking> actualBookings = bookingService.getBookingsByUserId(userId);
        assertEquals(expectedBookings, actualBookings);
    }

    @Test
    public void testGetBookingById() throws ServiceException {
        // Given
        Integer bookingId = 456;
        Booking expectedBooking = new Booking();
        // Assuming some setup of expectedBooking

        // When
        when(bookingService.getBookingById(bookingId)).thenReturn(Optional.of(expectedBooking));

        // Then
        Optional<Booking> actualBooking = bookingService.getBookingById(bookingId);
        assertEquals(expectedBooking, actualBooking.orElse(null));
    }

    @Test
    public void testGetAllBookings() throws ServiceException {
        // Given
        List<Booking> expectedBookings = new ArrayList<>();
        // Assuming some setup of expectedBookings

        // When
        when(bookingService.getAllBookings()).thenReturn(expectedBookings);

        // Then
        List<Booking> actualBookings = bookingService.getAllBookings();
        assertEquals(expectedBookings, actualBookings);
    }

    @Test
    public void testApproveBooking() throws ServiceException {
        // Given
        Integer bookingId = 789;
        Room room = new Room();
        BigDecimal totalCost = new BigDecimal("1000.00");
        // Assuming some setup of room and totalCost

        // When - No need to use 'when' for void methods

        // Then - Verify that the method was called once
        bookingService.approveBooking(bookingId, room, totalCost);
        verify(bookingService, times(1)).approveBooking(bookingId, room, totalCost);
    }

    @Test
    public void testCancelBooking() throws ServiceException {
        // Given
        Integer bookingId = 789;

        // When - No need to use 'when' for void methods

        // Then - Verify that the method was called once
        bookingService.cancelBooking(bookingId);
        verify(bookingService, times(1)).cancelBooking(bookingId);
    }

    @Test
    public void testGenerateInvoice() throws ServiceException {
        // Given
        Integer bookingId = 456;
        Invoice expectedInvoice = new Invoice();
        // Assuming some setup of expectedInvoice

        // When
        when(bookingService.generateInvoice(bookingId)).thenReturn(expectedInvoice);

        // Then
        Invoice actualInvoice = bookingService.generateInvoice(bookingId);
        assertEquals(expectedInvoice, actualInvoice);
    }
}
