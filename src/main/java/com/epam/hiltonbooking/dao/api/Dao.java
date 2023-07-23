package com.epam.hiltonbooking.dao.api;

import com.epam.hiltonbooking.bean.Identifiable;
import com.epam.hiltonbooking.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao<T extends Identifiable> {

    /**
     * Method to get all entities from table
     * @return
     * @throws DaoException
     */
    List<T> findAll() throws DaoException;

    // Method to get an entity object from table by ID
    Optional<T> findById(int id) throws DaoException;

    /*
    Saves an entity to the storage, if there is no entry with such id or id is null.
    If the entry with such id already exists, then the information of this object is updated.
    */
    int save(T item) throws DaoException;

    //Method to delete an entity from table by ID
    void deleteById(int id) throws DaoException;

}
