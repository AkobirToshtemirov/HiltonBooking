package com.epam.hiltonbooking.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Message implements Identifiable, Serializable {
    private Integer messageId;
    private String name;
    private String email;
    private String phoneNumber;
    private String text;
    private boolean isRead;
    private Timestamp sentAt;

    public Message() {
    }

    public Message(int messageId, String name, String email, String phoneNumber, String text, boolean isRead, Timestamp sentAt) {
        this.messageId = messageId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.text = text;
        this.isRead = isRead;
        this.sentAt = sentAt;
    }

    @Override
    public Integer getId() {
        return messageId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getText() {
        return text;
    }

    public Timestamp getSentAt() {
        return sentAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return messageId == message.messageId && getName().equals(message.getName()) && getEmail().equals(message.getEmail()) && getPhoneNumber().equals(message.getPhoneNumber()) && getText().equals(message.getText()) && getSentAt().equals(message.getSentAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, getName(), getEmail(), getPhoneNumber(), getText(), getSentAt());
    }
}
