package com.task.vasskob.testrx.api;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.task.vasskob.testrx.Constants;
import com.task.vasskob.testrx.model.ApiResponse;
import com.task.vasskob.testrx.model.Product;
import com.task.vasskob.testrx.model.Store;
import com.task.vasskob.testrx.model.StoreVsProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subjects.ReplaySubject;

public class RetrofitSingleton {
    private static final String TAG = RetrofitSingleton.class.getSimpleName();

    private static Observable<List<StoreVsProduct>> combined;
    private static ReplaySubject<List<StoreVsProduct>> observableModelsList;
    private static Subscription subscription;

    private RetrofitSingleton() {
    }

    public static void init() {

        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxAdapter)
                .build();

        StoreService storeService = retrofit.create(StoreService.class);

        Observable<ApiResponse<List<Store>>> observableStore = storeService.loadStores();
        Observable<ApiResponse<List<Product>>> observableProduct = storeService.loadAllProducts();
        combined = Observable.zip(observableStore, observableProduct, RetrofitSingleton::getStoreVsProducts);
    }

    @NonNull
    private static List<StoreVsProduct> getStoreVsProducts(ApiResponse<List<Store>> listApiResponse, ApiResponse<List<Product>> listApiResponse2) {
        List<StoreVsProduct> storeVsProductList = new ArrayList<>();
        Random r = new Random();
        List<Product> products = listApiResponse2.getData();
        for (Store store : listApiResponse.getData()) {
            int index = r.nextInt(products.size());
            storeVsProductList.add(new StoreVsProduct(store, products.get(index)));
        }
        return storeVsProductList;
    }

    private static void resetModelsObservable() {
        observableModelsList = ReplaySubject.create();

        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        subscription = combined.subscribe(new Subscriber<List<StoreVsProduct>>() {
            @Override
            public void onCompleted() {
                observableModelsList.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                observableModelsList.onError(e);
            }

            @Override
            public void onNext(List<StoreVsProduct> listApiResponse) {
                for (StoreVsProduct store : listApiResponse) {
                    Log.d(TAG, "onNext: " + store.getStore().getName());
                }
                observableModelsList.onNext(listApiResponse);
            }
        });
    }

    public static Observable<List<StoreVsProduct>> getModelsObservable() {
        if (observableModelsList == null) {
            resetModelsObservable();
        }
        return observableModelsList;
    }
}
