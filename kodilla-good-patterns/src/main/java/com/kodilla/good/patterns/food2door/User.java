package com.kodilla.good.patterns.food2door;

public class User {

    private String userName;
    private int userID;

    public User(String userName, int userID) {
        this.userName = userName;
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "User: " + userName;
    }
}
