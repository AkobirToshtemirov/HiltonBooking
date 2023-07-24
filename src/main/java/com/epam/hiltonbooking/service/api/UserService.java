package com.epam.hiltonbooking.service.api;

import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.exceptions.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean registerUser(String firstName, String lastName,
                         String email, String username, String password) throws ServiceException;

    Optional<User> loginUser(String username, String password) throws ServiceException;

    void deleteUserById(Integer id) throws ServiceException;

    List<User> getAllUsers() throws ServiceException;
    boolean isEmailInUse(String email) throws ServiceException;

    boolean isUsernameInUse(String username) throws ServiceException;
    boolean updateUser(User updatedUser) throws ServiceException;

    boolean validateUser(String username, String password) throws ServiceException;
}
