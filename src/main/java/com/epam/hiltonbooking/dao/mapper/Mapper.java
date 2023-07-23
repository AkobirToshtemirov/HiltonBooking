package com.epam.hiltonbooking.dao.mapper;

import com.epam.hiltonbooking.bean.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T extends Identifiable> {
    /**
     * Method to create an entity object from ResultSet
     * @param resultSet
     * @return
     * @throws SQLException
     */

    T map(ResultSet resultSet) throws SQLException;
}
