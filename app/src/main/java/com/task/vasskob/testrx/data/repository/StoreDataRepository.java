package com.task.vasskob.testrx.data.repository;

import com.task.vasskob.testrx.data.api.RetrofitSingleton;
import com.task.vasskob.testrx.data.entity.maper.ShopEntityDataMapper;
import com.task.vasskob.testrx.domain.entity.Store;
import com.task.vasskob.testrx.domain.repository.StoreRepository;

import java.util.List;

import rx.Observable;


public class StoreDataRepository implements StoreRepository {

    @Override
    public Observable<List<Store>> stores() {
        return RetrofitSingleton
                .getStoreObservable()
                .map(storeCollection -> new ShopEntityDataMapper().transform(storeCollection));
    }
}
