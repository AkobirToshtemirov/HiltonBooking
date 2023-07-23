package com.epam.hiltonbooking.dao;

public enum Table {
    USERS("users"),
    ROOMS("rooms"),
    BOOKINGS("bookings"),
    MESSAGES("messages");

    private final String tableName;

    Table(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
}
