package com.systementor.testbed.model;

public class UserAgreement {
    private int id;
    public int getId() {
        return id;
    }

    private String email;
    public String getEmail() {
        return email;
    }

    private int agreementId;

    public int getAgreementId() {
        return agreementId;
    }

    public UserAgreement(int id,String email, int agreementId) {
        super();
        this.id = id;
        this.email = email;
        this.agreementId = agreementId;
    }
}
