package com.epam.hiltonbooking.dao.api;

import com.epam.hiltonbooking.bean.Identifiable;
import com.epam.hiltonbooking.dao.connection.ConnectionPool;
import com.epam.hiltonbooking.dao.connection.ProxyConnection;
import com.epam.hiltonbooking.dao.mapper.Mapper;
import com.epam.hiltonbooking.exceptions.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractQueryExecutor<T extends Identifiable> {
    private static final Logger logger = LogManager.getLogger();

    private final Mapper<T> rowMapper;

    public AbstractQueryExecutor(Mapper<T> mapper) {
        this.rowMapper = mapper;
    }

    protected List<T> executeQuery(String query, Object... params) throws DaoException {
        List<T> entities;
        try (PreparedStatement statement = createStatement(query, params);
             ResultSet resultSet = statement.executeQuery()) {
            entities = createEntitiesList(resultSet);
        } catch (SQLException e) {
            logger.error("Unable to execute query", e);
            throw new DaoException(e.getMessage(), e);
        }
        return entities;
    }

    protected Optional<T> executeQueryForSingleResult(String query, Object... params) throws DaoException {
        List<T> items = executeQuery(query, params);
        if (items.isEmpty()) {
            return Optional.empty();
        }

        if (!(items.size() == 1)) {
            return Optional.empty();
        }

        return Optional.of(items.get(0));
    }

    protected int executeInsertQuery(String query, Object... params) throws DaoException {
        int result = 0;
        try (PreparedStatement statement = createStatement(query, params)) {
            statement.executeUpdate();
            ResultSet generatedKey = statement.getGeneratedKeys();
            if (generatedKey.next()) {
                result = generatedKey.getInt(1);
            }
        } catch (SQLException e) {
            logger.error("Unable to execute insert query", e);
            throw new DaoException(e.getMessage(), e);
        }
        return result;
    }

    protected void executeUpdateQuery(String query, Object... params) throws DaoException {
        try (PreparedStatement statement = createStatement(query, params)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Unable to execute update query", e);
            throw new DaoException(e.getMessage(), e);
        }
    }

    private PreparedStatement createStatement(String query, Object... params) throws DaoException {
        try {
            ProxyConnection proxyConnection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = proxyConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            ConnectionPool.getInstance().releaseConnection(proxyConnection);
            return preparedStatement;
        } catch (SQLException e) {
            logger.error("Unable to create statement!", e);
            throw new DaoException(e.getMessage(), e);
        }
    }

    private List<T> createEntitiesList(ResultSet resultSet) throws DaoException {
        List<T> entities = new ArrayList<>();
        try {
            while (resultSet.next()) {
                T entity = rowMapper.map(resultSet);
                entities.add(entity);
            }
        } catch (SQLException e) {
            logger.error("Unable to create entity list!", e);
            throw new DaoException(e.getMessage(), e);
        }
        return entities;
    }

}
