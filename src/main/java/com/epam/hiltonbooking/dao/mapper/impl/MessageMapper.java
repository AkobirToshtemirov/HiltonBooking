package com.epam.hiltonbooking.dao.mapper.impl;


import com.epam.hiltonbooking.bean.Message;
import com.epam.hiltonbooking.dao.mapper.Column;
import com.epam.hiltonbooking.dao.mapper.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MessageMapper implements Mapper<Message> {
    @Override
    public Message map(ResultSet resultSet) throws SQLException {
        int messageId = resultSet.getInt(Column.MESSAGE_ID);
        String name = resultSet.getString(Column.MESSANGER_NAME);
        String email = resultSet.getString(Column.MESSANGER_EMAIL);
        String phoneNumber = resultSet.getString(Column.MESSANGER_PHONE_NUMBER);
        String text = resultSet.getString(Column.MESSAGE_TEXT);
        Timestamp sentAt = resultSet.getTimestamp(Column.MESSAGE_SENT_AT);
        return new Message(messageId, name, email, phoneNumber, text, sentAt);
    }
}
