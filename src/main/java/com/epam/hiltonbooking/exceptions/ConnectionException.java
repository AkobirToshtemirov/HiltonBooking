package com.epam.hiltonbooking.exceptions;

import java.sql.SQLException;

public class ConnectionException extends SQLException {
//    public ConnectionException(String reason) {
//        super(reason);
//    }
//
//    public ConnectionException() {
//        super();
//    }

    public ConnectionException(String reason, Throwable cause) {
        super(reason, cause);
    }

//    public ConnectionException(Throwable cause) {
//        super(cause);
//    }
}
