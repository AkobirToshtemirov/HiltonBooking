package com.epam.hiltonbooking.dao.impl;

import com.epam.hiltonbooking.bean.Booking;
import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.dao.Table;
import com.epam.hiltonbooking.dao.api.AbstractDao;
import com.epam.hiltonbooking.dao.api.BookingDao;
import com.epam.hiltonbooking.dao.api.DaoFactory;
import com.epam.hiltonbooking.dao.api.UserDao;
import com.epam.hiltonbooking.dao.mapper.Mapper;
import com.epam.hiltonbooking.dao.mapper.MapperFactory;
import com.epam.hiltonbooking.exceptions.DaoException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final String FIND_USER_BY_USERNAME_AND_PASSWORD_QUERY =
            "SELECT * FROM " + Table.USERS.getTableName() + " WHERE username = ? and password = ?";
    private static final String SAVE_USER_QUERY =
            "INSERT INTO " + Table.USERS.getTableName() + "(first_name, last_name, email, username, password) VALUES (?, ?, ?, ?, ?)";
    private static final String DELETE_USER_QUERY =
            "DELETE FROM " + Table.USERS.getTableName() + " WHERE user_id = ?";
    private static final String GET_ALL_USER_QUERY =
            "SELECT * FROM " + Table.USERS.getTableName();
    private static final String FIND_USER_BY_EMAIL_QUERY =
            "SELECT * FROM " + Table.USERS.getTableName() + " WHERE email = ?";
    private static final String FIND_USER_BY_USERNAME_QUERY =
            "SELECT * FROM " + Table.USERS.getTableName() + " WHERE username = ?";
    private static final String UPDATE_USER_INFORMATION_QUERY = "UPDATE " + Table.USERS.getTableName() + " SET first_name = ?, last_name = ?, email = ?, username = ?, password = ? WHERE user_id = ?";


    public UserDaoImpl(Mapper<User> mapper, Connection connection) {
        super(mapper, String.valueOf(connection));
    }

    public UserDaoImpl() {
        super(MapperFactory.getInstance().getUserMapper(), Table.USERS.getTableName());
    }

    @Override
    public Integer save(User user) throws DaoException {
        return executeInsertQuery(SAVE_USER_QUERY, user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getUsername(), user.getPassword());
    }

    @Override
    public void updateUserInformation(User user) throws DaoException {
        executeUpdateQuery(UPDATE_USER_INFORMATION_QUERY, user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getUsername(), user.getPassword(), user.getId());
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) throws DaoException {
        return executeQueryForSingleResult(FIND_USER_BY_USERNAME_AND_PASSWORD_QUERY, username, password);
    }

    @Override
    public void deleteById(int id) throws DaoException {
        executeUpdateQuery(DELETE_USER_QUERY, id);
    }

    @Override
    public List<User> findAll() throws DaoException {
        return executeQuery(GET_ALL_USER_QUERY);
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws DaoException {
        return executeQueryForSingleResult(FIND_USER_BY_EMAIL_QUERY, email);
    }

    @Override
    public Optional<User> findUserByUsername(String username) throws DaoException {
        return executeQueryForSingleResult(FIND_USER_BY_USERNAME_QUERY, username);
    }
}
