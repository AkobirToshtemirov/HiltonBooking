package com.epam.hiltonbooking.bean;

import java.sql.Timestamp;
import java.util.Objects;

public class User implements Identifiable {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private boolean isAdmin;
    private Timestamp joinedTime;

    public User() {
    }

    public User(String firstName, String lastName, String email, String username, String password, boolean isAdmin, Timestamp joinedTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.joinedTime = joinedTime;
    }

    public User(int userId, String firstName, String lastName, String email, String username, String password, boolean isAdmin, Timestamp joinedTime) {
        this(firstName, lastName, email, username, password, isAdmin, joinedTime);
        this.userId = userId;
    }

    @Override
    public Integer getId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setJoinedTime(Timestamp joinedTime) {
        this.joinedTime = joinedTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public Timestamp getJoinedTime() {
        return joinedTime;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userId == user.userId &&
                isAdmin() == user.isAdmin() &&
                getFirstName().equals(user.getFirstName()) &&
                getLastName().equals(user.getLastName()) &&
                getEmail().equals(user.getEmail()) &&
                getUsername().equals(user.getUsername()) &&
                getPassword().equals(user.getPassword()) &&
                getJoinedTime().equals(user.getJoinedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, getFirstName(), getLastName(), getEmail(), getUsername(), getPassword(), isAdmin(), getJoinedTime());
    }
}
