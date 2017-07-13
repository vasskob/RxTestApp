package com.task.vasskob.testrx.data.repository;

import com.task.vasskob.testrx.data.api.RetrofitSingleton;
import com.task.vasskob.testrx.domain.entity.StoreVsProduct;
import com.task.vasskob.testrx.domain.repository.StoreVsProductRepository;

import java.util.List;

import rx.Observable;

public class CombinedDataRepository implements StoreVsProductRepository {

    @Override
    public Observable<List<StoreVsProduct>> storesVsProducts() {
        return RetrofitSingleton
                .getModelsObservable();
    }
}
