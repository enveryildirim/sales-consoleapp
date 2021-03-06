package com.company.models;

/**
 * kullanıcı ile alakalı verileri tutuan sınıf
 */
public class User {

    private int id;
    private String nameSurname;
    private String username;
    private String password;
    private UserType userType;

    public User(String nameSurname, String username, String password, UserType userType) {
        this.nameSurname = nameSurname;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

}
