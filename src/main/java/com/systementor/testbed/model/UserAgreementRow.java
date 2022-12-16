package com.systementor.testbed.model;

public class UserAgreementRow {
    private int agreementId;
    private String manufacturerMatch;
    public String getManufacturerMatch() {
        return manufacturerMatch;
    }

    private String categoryMatch;
    public String getCategoryMatch() {
        return categoryMatch;
    }


    private float percentageDiscount;
    private String productMatch;

    public String getProductMatch() {
        return productMatch;
    }

    public float getPercentageDiscount() {
        return percentageDiscount;
    }

    public UserAgreementRow(int agreementId, String manufacturerMatch,  String productMatch,String categoryMatch, float percentageDiscount) {
        super();
        this.agreementId = agreementId;
        this.manufacturerMatch = manufacturerMatch;
        this.productMatch = productMatch;
        this.categoryMatch = categoryMatch;
        this.percentageDiscount = percentageDiscount;
    }
}
