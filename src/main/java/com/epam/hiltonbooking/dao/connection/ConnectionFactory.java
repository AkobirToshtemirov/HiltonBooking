package com.epam.hiltonbooking.dao.connection;

import com.epam.hiltonbooking.exceptions.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final Logger logger = LogManager.getLogger();
    private static final String DB_DRIVER = "db_driver";
    private static final String DB_URL = "db_url";
    private static final String DB_USER = "db_user";
    private static final String DB_PASSWORD = "db_password";

    static ProxyConnection createConnection(Properties dbProperties) throws ConnectionException {
        ProxyConnection proxyConnection = null;
        try {
            Class.forName(dbProperties.getProperty(DB_DRIVER));
            String dbUrl = dbProperties.getProperty(DB_URL);
            String dbUser = dbProperties.getProperty(DB_USER);
            String dbPassword = dbProperties.getProperty(DB_PASSWORD);
            proxyConnection = new ProxyConnection(DriverManager.getConnection(dbUrl, dbUser, dbPassword));
        } catch (SQLException e) {
            logger.error("Unable to connect to DB!", e);
            throw new ConnectionException(e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            logger.error("PostgreSQl JDBC driver not found!", e);
            throw new ConnectionException(e.getMessage(), e);
        }
        return proxyConnection;
    }
}
