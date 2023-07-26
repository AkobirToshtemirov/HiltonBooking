package com.epam.hiltonbooking.dao.api;

import com.epam.hiltonbooking.bean.Identifiable;
import com.epam.hiltonbooking.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao<T extends Identifiable> {

    List<T> findAll() throws DaoException;

    Optional<T> findById(Integer id) throws DaoException;

    Integer save(T item) throws DaoException;

    void deleteById(int id) throws DaoException;

}
