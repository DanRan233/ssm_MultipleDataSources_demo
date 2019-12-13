package com.wzk.entity;

/**
 * @program: ssm_MultipleDataSources_demo
 * @author: DANRAN2333
 * @create: 2019-12-06 13:37
 * @description:
 */
public class User {

    int UserID;
    String UserName;
    String Password;

    public User(int userID, String userName, String password) {
        UserID = userID;
        UserName = userName;
        Password = password;
    }

    public User() {
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
