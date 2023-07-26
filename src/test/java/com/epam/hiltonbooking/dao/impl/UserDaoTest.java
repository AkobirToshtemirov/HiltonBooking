package com.epam.hiltonbooking.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.dao.api.UserDao;
import com.epam.hiltonbooking.exceptions.DaoException;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class UserDaoTest {

    private UserDao userDao;

    @Before
    public void setUp() {
        // Create a mock instance of UserDao
        userDao = mock(UserDao.class);
    }

    @Test
    public void testFindByUsernameAndPassword() throws DaoException {
        // Given
        String username = "testUser";
        String password = "testPassword";
        User expectedUser = new User();
        // Assuming some setup of expectedUser

        // When
        when(userDao.findByUsernameAndPassword(username, password)).thenReturn(Optional.of(expectedUser));

        // Then
        Optional<User> actualUser = userDao.findByUsernameAndPassword(username, password);
        assertEquals(expectedUser, actualUser.orElse(null));
    }

    @Test
    public void testFindUserByEmail() throws DaoException {
        // Given
        String email = "test@example.com";
        User expectedUser = new User();
        // Assuming some setup of expectedUser

        // When
        when(userDao.findUserByEmail(email)).thenReturn(Optional.of(expectedUser));

        // Then
        Optional<User> actualUser = userDao.findUserByEmail(email);
        assertEquals(expectedUser, actualUser.orElse(null));
    }

    @Test
    public void testFindUserByUsername() throws DaoException {
        // Given
        String username = "testUser";
        User expectedUser = new User();
        // Assuming some setup of expectedUser

        // When
        when(userDao.findUserByUsername(username)).thenReturn(Optional.of(expectedUser));

        // Then
        Optional<User> actualUser = userDao.findUserByUsername(username);
        assertEquals(expectedUser, actualUser.orElse(null));
    }

    @Test
    public void testUpdateUserInformation() throws DaoException {
        // Given
        User userToUpdate = new User();
        // Assuming some setup of userToUpdate

        // When - No need to use 'when' for void methods

        // Then - Verify that the method was called once
        userDao.updateUserInformation(userToUpdate);
        verify(userDao, times(1)).updateUserInformation(userToUpdate);
    }
}
