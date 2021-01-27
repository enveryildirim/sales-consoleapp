package com.company.models;


import java.util.UUID;

public class User {

    private int id;
    private String nameSurname;
    private String username;
    private String password;
    private int userType;

    public User(int id, String nameSurname, String username, String password, int userType) {
        this.id = id;
        this.nameSurname = nameSurname;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
    public int getId() {
        return id;
    }
    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }




}
