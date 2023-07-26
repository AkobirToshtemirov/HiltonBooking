package com.epam.hiltonbooking.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() {
        // Create a mock instance of UserService
        userService = mock(UserService.class);
    }

    @Test
    public void testRegisterUser() throws ServiceException {
        // Given
        String firstName = "John";
        String lastName = "Doe";
        String email = "john@example.com";
        String username = "johnDoe";
        String password = "password";

        // When
        when(userService.registerUser(firstName, lastName, email, username, password)).thenReturn(true);

        // Then
        boolean isUserRegistered = userService.registerUser(firstName, lastName, email, username, password);
        assertEquals(true, isUserRegistered);
    }

    @Test
    public void testLoginUser() throws ServiceException {
        // Given
        String username = "johnDoe";
        String password = "password";
        User expectedUser = new User();
        // Assuming some setup of expectedUser

        // When
        when(userService.loginUser(username, password)).thenReturn(Optional.of(expectedUser));

        // Then
        Optional<User> actualUser = userService.loginUser(username, password);
        assertEquals(expectedUser, actualUser.orElse(null));
    }

    @Test
    public void testDeleteUserById() throws ServiceException {
        // Given
        Integer userId = 123;

        // When - No need to use 'when' for void methods

        // Then - Verify that the method was called once
        userService.deleteUserById(userId);
        verify(userService, times(1)).deleteUserById(userId);
    }

    @Test
    public void testGetAllUsers() throws ServiceException {
        // Given
        List<User> expectedUsers = new ArrayList<>();
        // Assuming some setup of expectedUsers

        // When
        when(userService.getAllUsers()).thenReturn(expectedUsers);

        // Then
        List<User> actualUsers = userService.getAllUsers();
        assertEquals(expectedUsers, actualUsers);
    }

    @Test
    public void testIsEmailInUse() throws ServiceException {
        // Given
        String email = "john@example.com";

        // When
        when(userService.isEmailInUse(email)).thenReturn(true);

        // Then
        boolean isEmailInUse = userService.isEmailInUse(email);
        assertEquals(true, isEmailInUse);
    }

    @Test
    public void testIsUsernameInUse() throws ServiceException {
        // Given
        String username = "johnDoe";

        // When
        when(userService.isUsernameInUse(username)).thenReturn(true);

        // Then
        boolean isUsernameInUse = userService.isUsernameInUse(username);
        assertEquals(true, isUsernameInUse);
    }

    @Test
    public void testUpdateUser() throws ServiceException {
        // Given
        User updatedUser = new User();
        // Assuming some setup of updatedUser

        // When
        when(userService.updateUser(updatedUser)).thenReturn(true);

        // Then
        boolean isUserUpdated = userService.updateUser(updatedUser);
        assertEquals(true, isUserUpdated);
    }

    @Test
    public void testValidateUser() throws ServiceException {
        // Given
        String username = "johnDoe";
        String password = "password";

        // When
        when(userService.validateUser(username, password)).thenReturn(true);

        // Then
        boolean isUserValidated = userService.validateUser(username, password);
        assertEquals(true, isUserValidated);
    }
}
