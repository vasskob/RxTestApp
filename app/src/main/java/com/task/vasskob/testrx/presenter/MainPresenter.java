package com.task.vasskob.testrx.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.task.vasskob.testrx.api.RetrofitSingleton;
import com.task.vasskob.testrx.model.Product;
import com.task.vasskob.testrx.model.SpecialStore;
import com.task.vasskob.testrx.model.Store;
import com.task.vasskob.testrx.model.StoreVsProduct;
import com.task.vasskob.testrx.view.MainView;

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

        subscription = RetrofitSingleton.getModelsObservable()
                .subscribeOn(Schedulers.io())
                .map(this::getSpecialStores)
                .flatMapIterable(specialStores -> specialStores)
                .filter(specialStore -> specialStore.getCity().contains(FILTER_STRING))
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber());
    }

    @NonNull
    private List<SpecialStore> getSpecialStores(List<StoreVsProduct> storeVsProductList) {
        List<SpecialStore> specialStoreList = new ArrayList<>();
        for (StoreVsProduct storeVsProduct : storeVsProductList) {
            Store store = storeVsProduct.getStore();
            Product product = storeVsProduct.getProduct();
            specialStoreList.add(new SpecialStore(store.getId(), store.getName() + MODIFIER, store.getCity() + CITY, store.getAddress1(), product.getName()));
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

    private class MySubscriber extends Subscriber<List<SpecialStore>> {

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
        public void onNext(List<SpecialStore> stores) {
            int prevSize = stores.size();
            Log.d(TAG, "onNext: " + prevSize);
            mView.showStoreList(stores);
        }

    }
}
