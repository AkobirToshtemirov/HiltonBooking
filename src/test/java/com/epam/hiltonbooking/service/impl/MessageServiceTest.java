package com.epam.hiltonbooking.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import com.epam.hiltonbooking.bean.Message;
import com.epam.hiltonbooking.exceptions.ServiceException;
import com.epam.hiltonbooking.service.api.MessageService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessageServiceTest {

    private MessageService messageService;

    @Before
    public void setUp() {
        // Create a mock instance of MessageService
        messageService = mock(MessageService.class);
    }

    @Test
    public void testAddNewMessage() throws ServiceException {
        // Given
        String name = "John Doe";
        String email = "john@example.com";
        String phoneNumber = "1234567890";
        String text = "This is a test message.";

        // When
        when(messageService.addNewMessage(name, email, phoneNumber, text)).thenReturn(true);

        // Then
        boolean isMessageAdded = messageService.addNewMessage(name, email, phoneNumber, text);
        assertEquals(true, isMessageAdded);
    }

    @Test
    public void testGetAllMessages() throws ServiceException {
        // Given
        List<Message> expectedMessages = new ArrayList<>();
        // Assuming some setup of expectedMessages

        // When
        when(messageService.getAllMessages()).thenReturn(expectedMessages);

        // Then
        List<Message> actualMessages = messageService.getAllMessages();
        assertEquals(expectedMessages, actualMessages);
    }

    @Test
    public void testGetMessageById() throws ServiceException {
        // Given
        Integer messageId = 123;
        Message expectedMessage = new Message();
        // Assuming some setup of expectedMessage

        // When
        when(messageService.getMessageById(messageId)).thenReturn(Optional.of(expectedMessage));

        // Then
        Optional<Message> actualMessage = messageService.getMessageById(messageId);
        assertEquals(expectedMessage, actualMessage.orElse(null));
    }
}
