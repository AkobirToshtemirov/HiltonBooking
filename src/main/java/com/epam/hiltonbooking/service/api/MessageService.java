package com.epam.hiltonbooking.service.api;

import com.epam.hiltonbooking.bean.Message;
import com.epam.hiltonbooking.exceptions.ServiceException;

import java.util.List;

public interface MessageService {
    boolean addNewMessage(String name, String email, String phoneNumber, String text) throws ServiceException;

    List<Message> getAllMessages() throws ServiceException;
}
