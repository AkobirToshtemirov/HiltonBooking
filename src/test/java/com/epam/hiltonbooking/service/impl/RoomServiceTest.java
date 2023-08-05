//package com.epam.hiltonbooking.service.impl;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//import com.epam.hiltonbooking.bean.Room;
//import com.epam.hiltonbooking.exceptions.ServiceException;
//import com.epam.hiltonbooking.service.api.RoomService;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class RoomServiceTest {
//
//    private RoomService roomService;
//
//    @Before
//    public void setUp() {
//        // Create a mock instance of RoomService
//        roomService = mock(RoomService.class);
//    }
//
//    @Test
//    public void testAddNewRoom() throws ServiceException {
//        // Given
//        int roomNumber = 101;
//        String roomClass = "Standard";
//        int bedsAmount = 2;
//        double roomCost = 100.00;
//
//        // When
//        when(roomService.addNewRoom(roomNumber, roomClass, bedsAmount, roomCost)).thenReturn(true);
//
//        // Then
//        boolean isRoomAdded = roomService.addNewRoom(roomNumber, roomClass, bedsAmount, roomCost);
//        assertTrue(isRoomAdded);
//    }
//
//    @Test
//    public void testGetAllRooms() throws ServiceException {
//        // Given
//        List<Room> expectedRooms = new ArrayList<>();
//        // Assuming some setup of expectedRooms
//
//        // When
//        when(roomService.getAllRooms()).thenReturn(expectedRooms);
//
//        // Then
//        List<Room> actualRooms = roomService.getAllRooms();
//        assertEquals(expectedRooms, actualRooms);
//    }
//
//    @Test
//    public void testGetRoomById() throws ServiceException {
//        // Given
//        Integer roomId = 123;
//        Room expectedRoom = new Room();
//        // Assuming some setup of expectedRoom
//
//        // When
//        when(roomService.getRoomById(roomId)).thenReturn(Optional.of(expectedRoom));
//
//        // Then
//        Optional<Room> actualRoom = roomService.getRoomById(roomId);
//        assertEquals(expectedRoom, actualRoom.orElse(null));
//    }
//
//    @Test
//    public void testGetSuitableRooms() throws ServiceException {
//        // Given
//        int bedsAmount = 2;
//        String roomClass = "Standard";
//        List<Room> expectedRooms = new ArrayList<>();
//        // Assuming some setup of expectedRooms
//
//        // When
//        when(roomService.getSuitableRooms(bedsAmount, roomClass)).thenReturn(expectedRooms);
//
//        // Then
//        List<Room> actualRooms = roomService.getSuitableRooms(bedsAmount, roomClass);
//        assertEquals(expectedRooms, actualRooms);
//    }
//
//    @Test
//    public void testSetRoomInActiveById() throws ServiceException {
//        // Given
//        Room room = new Room();
//        // Assuming some setup of room
//
//        // When - No need to use 'when' for void methods
//
//        // Then - Verify that the method was called once
//        roomService.setRoomInActiveById(room);
//        verify(roomService, times(1)).setRoomInActiveById(room);
//    }
//
//    @Test
//    public void testIsRoomAdded() throws ServiceException {
//        // Given
//        int roomNumber = 101;
//
//        // When
//        when(roomService.isRoomAdded(roomNumber)).thenReturn(true);
//
//        // Then
//        boolean isRoomAdded = roomService.isRoomAdded(roomNumber);
//        assertTrue(isRoomAdded);
//    }
//
//    @Test
//    public void testDeleteById() throws ServiceException {
//        // Given
//        Integer roomId = 789;
//
//        // When - No need to use 'when' for void methods
//
//        // Then - Verify that the method was called once
//        roomService.deleteById(roomId);
//        verify(roomService, times(1)).deleteById(roomId);
//    }
//}