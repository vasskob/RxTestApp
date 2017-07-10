package com.task.vasskob.testrx.model;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("price_in_cents")
    private long priceInCents;

    @SerializedName("primary_category")
    private String primaryCategory;

    @SerializedName("inventory_count")
    private long inventoryCount;

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

    public long getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(long priceInCents) {
        this.priceInCents = priceInCents;
    }

    public String getPrimaryCategory() {
        return primaryCategory;
    }

    public void setPrimaryCategory(String primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    public long getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(long inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}
