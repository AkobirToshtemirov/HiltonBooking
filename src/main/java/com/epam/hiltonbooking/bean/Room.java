package com.epam.hiltonbooking.bean;

import java.io.Serializable;
import java.util.Objects;

public class Room implements Identifiable, Serializable {
    private Integer roomId;
    private int roomNumber;
    private String roomClass;
    private int bedsAmount;
    private boolean active;
    private double roomCost;

    public Room() {
    }

    public Room(int roomId, int roomNumber, String roomClass, int bedsAmount, boolean isActive, double roomCost) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomClass = roomClass;
        this.bedsAmount = bedsAmount;
        this.active = isActive;
        this.roomCost = roomCost;
    }

    @Override
    public Integer getId() {
        return roomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public int getBedsAmount() {
        return bedsAmount;
    }

    public void setBedsAmount(int bedsAmount) {
        this.bedsAmount = bedsAmount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(double roomCost) {
        this.roomCost = roomCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return Objects.equals(roomId, room.roomId) &&
                getRoomNumber() == room.getRoomNumber() &&
                getBedsAmount() == room.getBedsAmount() &&
                isActive() == room.isActive() &&
                Double.compare(room.getRoomCost(), getRoomCost()) == 0 &&
                getRoomClass().equals(room.getRoomClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, getRoomNumber(), getRoomClass(), getBedsAmount(), isActive(), getRoomCost());
    }
}
