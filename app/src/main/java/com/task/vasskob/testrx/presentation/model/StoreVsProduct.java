package com.task.vasskob.testrx.presentation.model;

public class StoreVsProduct {
    private Store store;
    private Product product;

    public StoreVsProduct(Store store, Product product) {
        this.store = store;
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
