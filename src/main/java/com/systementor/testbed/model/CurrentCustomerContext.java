package com.systementor.testbed.model;

import java.util.ArrayList;

public class CurrentCustomerContext {
    private String userEmail;
    private String name;

    public String getName() {
        return name;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public CurrentCustomerContext(String userEmail, String name) {
        super();
        this.userEmail = userEmail;
        this.name = name;
    }

}
