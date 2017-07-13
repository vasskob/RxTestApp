package com.task.vasskob.testrx.data.entity;

import com.google.gson.annotations.SerializedName;

public class StoreEntity {

    private long id;
    private String name;
    @SerializedName("address_line_1")
    private String address1;
    @SerializedName("address_line_2")
    private String address2;
    private String city;
    private String telephone;
    private double latitude;
    private double longitude;
    private boolean hasWheelchairAccessability;
    private boolean hasBilingualServices;
    private boolean hasTastingBar;
    private boolean hasBeerColdRoom;
    private boolean hasVintagesCorner;
    private boolean hasParking;

    public StoreEntity(long id, String name, String address1, String address2, String city) {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
    }

    public StoreEntity() {
    }

    public StoreEntity(String name, String address1, String city) {
        this.name = name;
        this.address1 = address1;
        this.city = city;
    }

    public StoreEntity(long id, String name, String address1, String address2, String city,
                       String telephone, double latitude, double longitude,
                       boolean hasWheelchairAccessability, boolean hasBilingualServices,
                       boolean hasTastingBar, boolean hasBeerColdRoom, boolean hasVintagesCorner,
                       boolean hasParking) {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.telephone = telephone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hasWheelchairAccessability = hasWheelchairAccessability;
        this.hasBilingualServices = hasBilingualServices;
        this.hasTastingBar = hasTastingBar;
        this.hasBeerColdRoom = hasBeerColdRoom;
        this.hasVintagesCorner = hasVintagesCorner;
        this.hasParking = hasParking;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean getHasWheelchairAccessability() {
        return this.hasWheelchairAccessability;
    }

    public void setHasWheelchairAccessability(boolean hasWheelchairAccessability) {
        this.hasWheelchairAccessability = hasWheelchairAccessability;
    }

    public boolean getHasBilingualServices() {
        return this.hasBilingualServices;
    }

    public void setHasBilingualServices(boolean hasBilingualServices) {
        this.hasBilingualServices = hasBilingualServices;
    }

    public boolean getHasTastingBar() {
        return this.hasTastingBar;
    }

    public void setHasTastingBar(boolean hasTastingBar) {
        this.hasTastingBar = hasTastingBar;
    }

    public boolean getHasBeerColdRoom() {
        return this.hasBeerColdRoom;
    }

    public void setHasBeerColdRoom(boolean hasBeerColdRoom) {
        this.hasBeerColdRoom = hasBeerColdRoom;
    }

    public boolean getHasVintagesCorner() {
        return this.hasVintagesCorner;
    }

    public void setHasVintagesCorner(boolean hasVintagesCorner) {
        this.hasVintagesCorner = hasVintagesCorner;
    }

    public boolean getHasParking() {
        return this.hasParking;
    }

    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }
}
