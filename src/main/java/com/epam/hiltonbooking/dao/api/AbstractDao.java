package com.epam.hiltonbooking.dao.api;

import com.epam.hiltonbooking.bean.Identifiable;
import com.epam.hiltonbooking.dao.mapper.Mapper;
import com.epam.hiltonbooking.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Identifiable> extends AbstractQueryExecutor<T> implements Dao<T> {
    private final String tableName;

    public AbstractDao(Mapper<T> mapper, String tableName) {
        super(mapper);
        this.tableName = tableName;
    }

    @Override
    public List<T> findAll() throws DaoException {
        String query = "SELECT * FROM " + tableName;
        return executeQuery(query);
    }

    @Override
    public Optional<T> findById(int id) throws DaoException {
        String query = "SELECT * FROM " + tableName + " WHERE id = ?";
        return executeQueryForSingleResult(query, id);
    }

    @Override
    public void deleteById(int id) throws DaoException {
        String deleteQuery = "DELETE FROM " + tableName + " WHERE id = ?";
        executeUpdateQuery(deleteQuery, id);
    }
}
