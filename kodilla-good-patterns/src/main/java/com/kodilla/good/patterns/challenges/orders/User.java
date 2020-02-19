package com.kodilla.good.patterns.challenges.orders;

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
        return "User{" +
                "userName='" + userName + '\'' +
                ", userID=" + userID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userID != user.userID) return false;
        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + userID;
        return result;
    }
}
