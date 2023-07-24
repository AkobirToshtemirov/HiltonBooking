package com.epam.hiltonbooking.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Booking implements Identifiable, Serializable {
    private Integer bookingId;
    private User user;
    private Room room;
    private String status;
    private Date checkIn;
    private Date checkOut;
    private int bedsAmount;
    private String roomClass;
    private BigDecimal totalCost;
    private Timestamp bookingTime;

    public Booking() {
    }

    public Booking(int bookingId, User user, Room room, String status, Date checkIn, Date checkOut, int bedsAmount, String roomClass, BigDecimal totalCost, Timestamp bookingTime) {
        this.bookingId = bookingId;
        this.user = user;
        this.room = room;
        this.status = status;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bedsAmount = bedsAmount;
        this.roomClass = roomClass;
        this.totalCost = totalCost;
        this.bookingTime = bookingTime;
    }


    public Booking(User user, Date checkIn, Date checkOut, int bedsAmount, String roomClass) {
        this.user = user;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bedsAmount = bedsAmount;
        this.roomClass = roomClass;
    }

    @Override
    public Integer getId() {
        return bookingId;
    }

    public String getStatus() {
        return status;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public int getBedsAmount() {
        return bedsAmount;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public Timestamp getBookingTime() {
        return bookingTime;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public void setBedsAmount(int bedsAmount) {
        this.bedsAmount = bedsAmount;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return bookingId == booking.bookingId && getBedsAmount() == booking.getBedsAmount() && getUser().equals(booking.getUser()) && Objects.equals(getRoom(), booking.getRoom()) && getStatus().equals(booking.getStatus()) && getCheckIn().equals(booking.getCheckIn()) && getCheckOut().equals(booking.getCheckOut()) && getRoomClass().equals(booking.getRoomClass()) && Objects.equals(getTotalCost(), booking.getTotalCost()) && getBookingTime().equals(booking.getBookingTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, getUser(), getRoom(), getStatus(), getCheckIn(), getCheckOut(), getBedsAmount(), getRoomClass(), getTotalCost(), getBookingTime());
    }
}
