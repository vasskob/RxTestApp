package com.task.vasskob.testrx.presenter;

import android.util.Log;

import com.task.vasskob.testrx.api.RetrofitSingleton;
import com.task.vasskob.testrx.model.Product;
import com.task.vasskob.testrx.view.DetailView;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DetailPresenter implements IDetailPresenter {
    private static final String TAG = DetailPresenter.class.getSimpleName();
    private final int position;
    private DetailView mView;
    private Subscription subscription;

    public DetailPresenter(int position) {
        this.position = position;
    }

    @Override
    public void loadData() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        subscription = RetrofitSingleton.getStoreObservable()
                .subscribeOn(Schedulers.io())
                .flatMapIterable(stores -> stores)
                .flatMap(store -> getProductsForStore(store.getId()))
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber());
    }

    private rx.Observable<List<Product>> getProductsForStore(long id) {
        return RetrofitSingleton.getProductObservable(id);

    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void attachView(DetailView view) {
        mView = view;
    }

    private class MySubscriber extends Subscriber<List<List<Product>>> {
        @Override
        public void onCompleted() {
            mView.showLoadingSuccessToast();
            Log.d(TAG, "My onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            mView.showLoadingErrorToast();
            Log.e(TAG, "My onError: ", e);
        }

        @Override
        public void onNext(List<List<Product>> listProductsList) {
            mView.showProductList(listProductsList.get(position));

        }
    }
}
