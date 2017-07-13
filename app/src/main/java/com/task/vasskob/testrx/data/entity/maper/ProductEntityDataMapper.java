package com.task.vasskob.testrx.data.entity.maper;

import com.task.vasskob.testrx.data.entity.ProductEntity;
import com.task.vasskob.testrx.domain.entity.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductEntityDataMapper {

    public ProductEntityDataMapper() {
    }

    public Product transform(ProductEntity productEntity) {
        Product product = null;
        if (productEntity != null) {
            product = new Product();
            product.setId(productEntity.getId());
            product.setName(productEntity.getName());
            product.setImageUrl(productEntity.getImageUrl());
            product.setPriceInCents(productEntity.getPriceInCents());
            product.setPrimaryCategory(productEntity.getPrimaryCategory());
            product.setInventoryCount(productEntity.getInventoryCount());
        }
        return product;
    }

    public List<Product> transform(Collection<ProductEntity> productEntities) {
        final List<Product> productList = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {
            final Product product = transform(productEntity);
            if (product != null) {
                productList.add(product);
            }
        }
        return productList;
    }
}
