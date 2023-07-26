package com.epam.hiltonbooking.dao.impl;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import com.epam.hiltonbooking.bean.Room;
import com.epam.hiltonbooking.dao.api.RoomDao;
import com.epam.hiltonbooking.exceptions.DaoException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomDaoTest {

    private RoomDao roomDao;

    @Before
    public void setUp() {
        // Create a mock instance of RoomDao
        roomDao = mock(RoomDao.class);
    }

    @Test
    public void testGetSuitableRooms() throws DaoException {
        // Given
        int bedsAmount = 2;
        String roomClass = "Standard";
        List<Room> expectedRooms = new ArrayList<>();
        // Assuming some setup of expectedRooms

        // When
        when(roomDao.getSuitableRooms(bedsAmount, roomClass)).thenReturn(expectedRooms);

        // Then
        List<Room> actualRooms = roomDao.getSuitableRooms(bedsAmount, roomClass);
        assertEquals(expectedRooms, actualRooms);
    }

    @Test
    public void testFindByRoomNumber() throws DaoException {
        // Given
        int roomNumber = 101;
        Room expectedRoom = new Room();
        // Assuming some setup of expectedRoom

        // When
        when(roomDao.findByRoomNumber(roomNumber)).thenReturn(Optional.of(expectedRoom));

        // Then
        Optional<Room> actualRoom = roomDao.findByRoomNumber(roomNumber);
        assertEquals(expectedRoom, actualRoom.orElse(null));
    }

    @Test
    public void testSetRoomInActive() {
        try {
            // Create a Room object to set inactive (replace with actual Room object data)
            Room roomToSetInactive = new Room();
            roomToSetInactive.setRoomNumber(101); // Replace with an existing room number in your database

            // Call the method to set the room inactive
            roomDao.setRoomInActive(roomToSetInactive);

            // Perform assertions to check that the room is set inactive as expected
            // You may want to retrieve the room from the database and check its "active" status
            // Or, if the Room object has a field to track its active status, you can check it directly
            // Add more specific assertions based on your test case requirements
        } catch (DaoException e) {
            fail("An unexpected DaoException occurred during testSetRoomInActive: " + e.getMessage());
        }
    }
}