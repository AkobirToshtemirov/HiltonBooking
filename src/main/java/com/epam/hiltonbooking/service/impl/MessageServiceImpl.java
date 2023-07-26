package com.epam.hiltonbooking.service.impl;

import com.epam.hiltonbooking.bean.Message;
import com.epam.hiltonbooking.dao.api.DaoFactory;
import com.epam.hiltonbooking.dao.api.MessageDao;
import com.epam.hiltonbooking.exceptions.DaoException;
import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class MessageServiceImpl implements MessageService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean addNewMessage(String name, String email, String phoneNumber, String text) throws ServiceException {
        if (name == null || email == null || phoneNumber == null || text == null) {
            return false;
        }

        try {
            MessageDao messageDao = DaoFactory.getInstance().getMessageDao();
            Message message = buildMessage(name, email, phoneNumber, text);
            messageDao.save(message);
            return true;
        } catch (DaoException e) {
            logger.error("Unable to add message!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Message> getAllMessages() throws ServiceException {
        List<Message> messages;
        try {
            MessageDao messageDao = DaoFactory.getInstance().getMessageDao();
            messages = messageDao.findAll();
        } catch (DaoException e) {
            logger.error("Unable to get all messages!");
            throw new ServiceException(e.getMessage(), e);
        }
        return messages;
    }

    @Override
    public Optional<Message> getMessageById(Integer id) throws ServiceException {
        try {
            MessageDao messageDao = DaoFactory.getInstance().getMessageDao();
            return messageDao.findById(id);
        } catch (DaoException e) {
            logger.error("Unable to get message by id!");
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private Message buildMessage(String name, String email, String phoneNumber, String text) {
        Message message = new Message();
        message.setName(name);
        message.setEmail(email);
        message.setPhoneNumber(phoneNumber);
        message.setText(text);
        return message;
    }
}
