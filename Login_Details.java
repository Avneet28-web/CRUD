package com.example.test2b_csd214;

public class Login_Details {
    private int UserID;
    private String Password;


    public Login_Details(int userID, String password) {
        UserID = userID;
        Password = password;
    }


    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

