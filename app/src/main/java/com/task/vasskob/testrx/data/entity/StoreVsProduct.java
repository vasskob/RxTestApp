package com.task.vasskob.testrx.data.entity;

public class StoreVsProduct {
    private StoreEntity store;
    private ProductEntity product;

    public StoreVsProduct(StoreEntity store, ProductEntity product) {
        this.store = store;
        this.product = product;
    }

    public StoreEntity getStore() {
        return store;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
