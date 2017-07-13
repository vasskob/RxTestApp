package com.task.vasskob.testrx.domain.repository;


import com.task.vasskob.testrx.domain.entity.StoreVsProduct;

import java.util.List;

import rx.Observable;


public interface StoreVsProductRepository {
    Observable<List<StoreVsProduct>> storesVsProducts();
}
