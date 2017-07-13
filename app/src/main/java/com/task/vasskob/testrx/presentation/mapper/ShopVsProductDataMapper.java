package com.task.vasskob.testrx.presentation.mapper;


import com.task.vasskob.testrx.domain.entity.StoreVsProduct;
import com.task.vasskob.testrx.presentation.model.StoreVsProductModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ShopVsProductDataMapper {

    public ShopVsProductDataMapper() {
    }

    public StoreVsProductModel transform(StoreVsProduct storeVsProduct) {
        if (storeVsProduct == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }

        return new StoreVsProductModel(
                new ShopDataMapper().transform(storeVsProduct.getStore()),
                new ProductDataMapper().transform(storeVsProduct.getProduct()));
    }

    public List<StoreVsProductModel> transform(Collection<StoreVsProduct> storeVsProducts) {
        List<StoreVsProductModel> storeVsProductModels;

        if (storeVsProducts != null && !storeVsProducts.isEmpty()) {
            storeVsProductModels = new ArrayList<>();
            for (StoreVsProduct storeVsProduct : storeVsProducts) {
                storeVsProductModels.add(transform(storeVsProduct));
            }
        } else {
            storeVsProductModels = Collections.emptyList();
        }

        return storeVsProductModels;
    }

}
