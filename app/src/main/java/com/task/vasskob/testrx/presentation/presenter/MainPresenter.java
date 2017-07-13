package com.task.vasskob.testrx.presentation.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.task.vasskob.testrx.data.repository.CombinedDataRepository;
import com.task.vasskob.testrx.presentation.mapper.ShopVsProductDataMapper;
import com.task.vasskob.testrx.presentation.model.ProductModel;
import com.task.vasskob.testrx.presentation.model.SpecialStoreModel;
import com.task.vasskob.testrx.presentation.model.StoreModel;
import com.task.vasskob.testrx.presentation.model.StoreVsProductModel;
import com.task.vasskob.testrx.presentation.view.MainView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainPresenter implements IMainPresenter {

    private static final String TAG = MainPresenter.class.getSimpleName();
    private static final String CITY = " city";
    private static final String FILTER_STRING = "a";
    private static final String MODIFIER = " !";
    private MainView mView;
    private Subscription subscription;

    @Override
    public void loadData() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        subscription = new CombinedDataRepository()
                .storesVsProducts()
                .subscribeOn(Schedulers.io())
                .map(storeVsProducts -> new ShopVsProductDataMapper().transform(storeVsProducts))
                .map(this::getSpecialStores)
                .flatMapIterable(specialStores -> specialStores)
                .filter(specialStore -> specialStore.getCity().contains(FILTER_STRING))
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber());
    }

    @NonNull
    private List<SpecialStoreModel> getSpecialStores(List<StoreVsProductModel> storeVsProductList) {
        List<SpecialStoreModel> specialStoreList = new ArrayList<>();
        if (storeVsProductList != null && !storeVsProductList.isEmpty()) {
            for (StoreVsProductModel storeVsProduct : storeVsProductList) {
                StoreModel store = storeVsProduct.getStore();
                ProductModel product = storeVsProduct.getProduct();
                specialStoreList.add(new SpecialStoreModel(store.getId(), store.getName() + MODIFIER, store.getCity() + CITY, store.getAddress1(), product.getName()));
            }
        }
        return specialStoreList;
    }

    @Override
    public void attachView(MainView view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
        unSubscribe();
    }

    private void unSubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    private class MySubscriber extends Subscriber<List<SpecialStoreModel>> {

        @Override
        public void onCompleted() {
            mView.showLoadingSuccessToast();
            Log.d(TAG, "onCompleted: ");
        }

        @Override
        public void onError(Throwable e) {
            mView.showLoadingErrorToast();
            Log.e(TAG, "My onError: ", e);
        }

        @Override
        public void onNext(List<SpecialStoreModel> stores) {
            int prevSize = stores.size();
            Log.d(TAG, "onNext: " + prevSize);
            mView.showStoreList(stores);
        }

    }
}
