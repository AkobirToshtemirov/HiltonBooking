package com.epam.hiltonbooking.dao.mapper.impl;

import com.epam.hiltonbooking.bean.User;
import com.epam.hiltonbooking.dao.mapper.Column;
import com.epam.hiltonbooking.dao.mapper.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UserMapper implements Mapper<User> {

    @Override
    public User map(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt(Column.USER_ID);
        String firstName = resultSet.getString(Column.USER_FIRST_NAME);
        String lastName = resultSet.getString(Column.USER_LAST_NAME);
        String email = resultSet.getString(Column.USER_EMAIL);
        String userName = resultSet.getString(Column.USER_USERNAME);
        String password = resultSet.getString(Column.USER_PASSWORD);
        boolean isAdmin = resultSet.getBoolean(Column.USER_IS_ADMIN);
        Timestamp jointTime = resultSet.getTimestamp(Column.USER_JOINT_TIME);
        return new User(userId, firstName, lastName, email, userName, password, isAdmin, jointTime);
    }
}
