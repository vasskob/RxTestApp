package com.task.vasskob.testrx.model;

public class SpecialStore {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;
    private String shopName;
    private String city;
    private String address;
    private String productName;

    public SpecialStore(long id, String name, String city, String address, String productName) {
        this.id = id;
        this.shopName = name;
        this.city = city;
        this.address = address;
        this.productName = productName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
