package com.epam.hiltonbooking.dao.api;

import com.epam.hiltonbooking.bean.Message;
import com.epam.hiltonbooking.exceptions.DaoException;

public interface MessageDao extends Dao<Message> {
    void setMessageRead(Message message) throws DaoException;
}
