package com.epam.hiltonbooking.dao.api;

import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.exceptions.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<User> {
    Optional<User> findByUsernameAndPassword(String username, String password) throws DaoException;

    Optional<User> findUserByEmail(String email) throws DaoException;

    Optional<User> findUserByUsername(String username) throws DaoException;

    void updateUserInformation(User user) throws DaoException;
}
