package com.task.vasskob.testrx.data.repository;

import com.task.vasskob.testrx.data.api.RetrofitSingleton;
import com.task.vasskob.testrx.data.entity.maper.ProductEntityDataMapper;
import com.task.vasskob.testrx.domain.entity.Product;
import com.task.vasskob.testrx.domain.repository.ProductRepository;

import java.util.List;

import rx.Observable;


public class ProductDataRepository implements ProductRepository {

    @Override
    public Observable<List<Product>> products(long shopId) {
        return RetrofitSingleton
                .getProductObservable(shopId)
                .map(productCollection -> new ProductEntityDataMapper().transform(productCollection));
    }
}
