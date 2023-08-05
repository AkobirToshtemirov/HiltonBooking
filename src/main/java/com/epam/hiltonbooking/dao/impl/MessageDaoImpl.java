package com.epam.hiltonbooking.dao.impl;

import com.epam.hiltonbooking.bean.Message;
import com.epam.hiltonbooking.dao.Table;
import com.epam.hiltonbooking.dao.api.AbstractDao;
import com.epam.hiltonbooking.dao.api.MessageDao;
import com.epam.hiltonbooking.dao.mapper.MapperFactory;
import com.epam.hiltonbooking.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public class MessageDaoImpl extends AbstractDao<Message> implements MessageDao {
    private static final String SAVE_MESSAGE =
            "INSERT INTO " + Table.MESSAGES.getTableName() + "(name, email, phone_number, text) VALUES(?, ?, ?, ?)";
    private static final String GET_ALL_MESSAGES =
            "SELECT * FROM " + Table.MESSAGES.getTableName();
    private static final String GET_BOOKING_BY_ID_QUERY =
            "SELECT * FROM " + Table.MESSAGES.getTableName() + " WHERE message_id = ?";
    private static final String SET_MESSAGE_READ_QUERY =
            "UPDATE " + Table.MESSAGES.getTableName() + " SET is_read = true WHERE message_id = ?";

    public MessageDaoImpl() {
        super(MapperFactory.getInstance().getMessageMapper(), Table.MESSAGES.getTableName());
    }

    @Override
    public Integer save(Message message) throws DaoException {
        return executeInsertQuery(SAVE_MESSAGE, message.getName(),
                message.getEmail(), message.getPhoneNumber(), message.getText());
    }

    @Override
    public List<Message> findAll() throws DaoException {
        return executeQuery(GET_ALL_MESSAGES);
    }

    @Override
    public Optional<Message> findById(Integer id) throws DaoException {
        return executeQueryForSingleResult(GET_BOOKING_BY_ID_QUERY, id);
    }

    @Override
    public void setMessageRead(Message message) throws DaoException {
        executeUpdateQuery(SET_MESSAGE_READ_QUERY, message.getId());
    }
}
