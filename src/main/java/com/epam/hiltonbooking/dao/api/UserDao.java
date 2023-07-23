package com.epam.hiltonbooking.dao.api;

import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.exceptions.DaoException;

import java.util.Optional;

public interface UserDao extends Dao<User>{
    /**
     * Method to get user by username and password from DB
     * @param username
     * @param password
     * @return
     * @throws DaoException
     */
    Optional<User> findByUsernameAndPassword(String username, String password) throws DaoException;

    Optional<User> findUserByEmail(String email) throws DaoException;
    Optional<User> findUserByUsername(String username) throws DaoException;
}
