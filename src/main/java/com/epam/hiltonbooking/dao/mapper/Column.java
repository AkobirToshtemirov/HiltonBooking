package com.epam.hiltonbooking.dao.mapper;


public final class Column {

    // ID for id column
    public static final String ID = "id";


    // user table's columns
    public static final String USER_ID = "user_id";
    public static final String USER_FIRST_NAME = "first_name";
    public static final String USER_LAST_NAME = "last_name";
    public static final String USER_EMAIL = "email";
    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";
    public static final String USER_IS_ADMIN = "is_admin";
    public static final String USER_JOINT_TIME = "join_time";


    // room table's columns
    public static final String ROOM_ID = "room_id";
    public static final String ROOM_NUMBER = "room_number";
    public static final String ROOM_CLASS = "room_class";
    public static final String ROOM_BEDS_AMOUT = "beds_amount";
    public static final String ROOM_IS_ACTIVE = "is_active";
    public static final String ROOM_COST = "room_cost";


    // booking table's columns
    public static final String BOOKING_ID = "booking_id";
//    public static final String BOOKING_USER_ID = "user_id";
//    public static final String BOOKING_ROOM_ID = "room_id";
    public static final String BOOKING_STATUS = "status";
    public static final String BOOKING_CHECK_IN = "check_in";
    public static final String BOOKING_CHECK_OUT = "check_out";
    public static final String BOOKING_TOTAL_COST = "total_cost";
    public static final String BOOKING_TIME = "booking_time";
    public static final String BOOKING_ROOM_CLASS = "room_class";

    // message table's columns
    public static final String MESSAGE_ID = "message_id";
    public static final String MESSANGER_NAME = "name";
    public static final String MESSANGER_EMAIL = "email";
    public static final String MESSANGER_PHONE_NUMBER = "phone_number";
    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_IS_READ = "is_read";
    public static final String MESSAGE_SENT_AT = "sent_at";

}
