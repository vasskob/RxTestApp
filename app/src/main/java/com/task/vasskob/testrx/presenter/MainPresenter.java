package com.task.vasskob.testrx.presenter;

import android.util.Log;

import com.task.vasskob.testrx.api.RetrofitSingleton;
import com.task.vasskob.testrx.model.Store;
import com.task.vasskob.testrx.view.MainView;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainPresenter implements IMainPresenter {

    private static final String TAG = MainPresenter.class.getSimpleName();
    private MainView mView;
    private Subscription subscription;

    @Override
    public void loadData() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        subscription = RetrofitSingleton.getModelsObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber());
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

    private class MySubscriber extends Subscriber<List<Store>> {

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
        public void onNext(List<Store> stores) {
            int prevSize = stores.size();
            Log.d(TAG, "onNext: " + prevSize);
            mView.showStoreList(stores);
        }

    }
}
