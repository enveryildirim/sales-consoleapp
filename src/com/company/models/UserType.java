package com.company.models;

public enum UserType {
    ADMIN(0),
    EMPLOYEE(1),
    CUSTOMER(2);

    private int type;

    UserType(int type) {
        this.type = type;
    }
    public int getType() {
        return this.type;
    }
}
