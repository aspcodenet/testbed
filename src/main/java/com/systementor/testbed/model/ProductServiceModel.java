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



    public ProductServiceModel(int id, String manufacturerName, String productName, String categoryName, float price) {
        super();
        this.id = id;
        this.manufacturerName = manufacturerName;
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
    }
}
