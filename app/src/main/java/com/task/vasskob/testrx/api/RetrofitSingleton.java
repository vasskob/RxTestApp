package com.task.vasskob.testrx.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.task.vasskob.testrx.Constants;
import com.task.vasskob.testrx.model.ApiResponse;
import com.task.vasskob.testrx.model.Store;

import java.util.List;

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

    private static Observable<ApiResponse<List<Store>>> observableRetrofit;
    private static ReplaySubject<List<Store>> observableModelsList;
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

        StoreService apiService = retrofit.create(StoreService.class);
        observableRetrofit = apiService.loadStores();
    }

    private static void resetModelsObservable() {
        observableModelsList = ReplaySubject.create();

        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        subscription = observableRetrofit.subscribe(new Subscriber<ApiResponse<List<Store>>>() {
            @Override
            public void onCompleted() {
                observableModelsList.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                observableModelsList.onError(e);
            }

            @Override
            public void onNext(ApiResponse<List<Store>> storesResponse) {
                observableModelsList.onNext(storesResponse.getData());
            }
        });
    }

    public static Observable<List<Store>> getModelsObservable() {
        if (observableModelsList == null) {
            resetModelsObservable();
        }
        return observableModelsList;
    }
}
