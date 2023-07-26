package com.epam.hiltonbooking.dao.mapper;

import com.epam.hiltonbooking.bean.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T extends Identifiable> {

    T map(ResultSet resultSet) throws SQLException;
}
