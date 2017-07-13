package com.task.vasskob.testrx.presentation.model;

public class StoreVsProductModel {
    private StoreModel store;
    private ProductModel product;

    public StoreVsProductModel(StoreModel store, ProductModel product) {
        this.store = store;
        this.product = product;
    }

    public StoreModel getStore() {
        return store;
    }

    public void setStore(StoreModel store) {
        this.store = store;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
}
