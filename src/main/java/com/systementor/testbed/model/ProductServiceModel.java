package com.systementor.testbed.model;

public class ProductServiceModel {
    private int id;
    public int getId() {
        return id;
    }

    private String manufacturerName;
    public String getManufacturerName() {
        return manufacturerName;
    }

    private String productName;
    public String getProductName() {
        return productName;
    }

    private float percentageDiscount;
    public float getPercentageDiscount() {
        return percentageDiscount;
    }

    private int agreementId;
    private float price;
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAgreementId() {
        return agreementId;
    }

    public ProductServiceModel(int id, String manufacturerName, String productName, String categoryName, float percentageDiscount, int agreementId, float price) {
        super();
        this.id = id;
        this.manufacturerName = manufacturerName;
        this.productName = productName;
        this.categoryName = categoryName;
        this.percentageDiscount = percentageDiscount;
        this.agreementId = agreementId;
        this.price = price;
    }
}
