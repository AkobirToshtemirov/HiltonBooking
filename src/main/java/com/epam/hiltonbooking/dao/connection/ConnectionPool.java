package com.epam.hiltonbooking.dao.connection;

import com.epam.hiltonbooking.exceptions.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingQueue;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;

public class ConnectionPool {
    private static final Logger logger = LogManager.getLogger();
    private static final String POOL_SIZE = "db_default_pool_size";
    private static final String DB_CONNECTION_PATH = "connection/DBConnection.properties";

    private BlockingQueue<ProxyConnection> availableConnections;
    private BlockingQueue<ProxyConnection> usedConnections;

    public static ConnectionPool getInstance() {
        return Holder.INSTANCE;
    }

    private ConnectionPool() {
    }

    public void initialize() throws ConnectionException {
        try {
            Properties dbProperties = new Properties();
            dbProperties.load(ConnectionFactory.class.getClassLoader().getResourceAsStream(DB_CONNECTION_PATH));
            int poolSize = Integer.parseInt(dbProperties.getProperty(POOL_SIZE));
            availableConnections = new ArrayBlockingQueue<>(poolSize);
            usedConnections = new ArrayBlockingQueue<>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                ProxyConnection connection = ConnectionFactory.createConnection(dbProperties);
                availableConnections.add(connection);
            }
        } catch (IOException e) {
            logger.error("Unable to load DB properties!", e);
            throw new ConnectionException(e.getMessage(), e);
        }

        logger.info("Connection pool initialized");
    }

    public void releaseConnection(ProxyConnection proxyConnection) throws ConnectionException {
        if (proxyConnection != null) {
            usedConnections.remove(proxyConnection);
            try {
                availableConnections.put(proxyConnection);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Unable to release connection!", e);
                throw new ConnectionException(e.getMessage(), e);
            }
        }
    }

    public ProxyConnection getConnection() throws ConnectionException {
        ProxyConnection connection;
        try {
            connection = availableConnections.take();
            usedConnections.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Unable to get connection!", e);
            throw new ConnectionException(e.getMessage(), e);
        }
        return connection;
    }

    public void destroy() throws ConnectionException {
        for (ProxyConnection connection : availableConnections) {
            connection.closeConnection();
        }
        for (ProxyConnection connection : usedConnections) {
            connection.closeConnection();
        }

        logger.info("Connection pool closed");
    }

    private static class Holder {
        static final ConnectionPool INSTANCE = new ConnectionPool();
    }
}
