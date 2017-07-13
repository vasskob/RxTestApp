package com.task.vasskob.testrx.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.pwittchen.reactivenetwork.library.ReactiveNetwork;
import com.task.vasskob.testrx.presentation.Constants;
import com.task.vasskob.testrx.R;
import com.task.vasskob.testrx.presentation.model.SpecialStoreModel;
import com.task.vasskob.testrx.presentation.presenter.MainPresenter;
import com.task.vasskob.testrx.presentation.view.MainView;
import com.task.vasskob.testrx.presentation.view.adapter.StoreListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();
    private MainPresenter presenter;
    private Subscription internetConnectionSubscription;


    @BindView(R.id.rv_stores)
    RecyclerView rvStores;

    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;

    private final StoreListAdapter.onStoreClickListener onClickListener = view -> {
        int position = rvStores.getChildAdapterPosition(view);
        Intent intent = new Intent(this, DetailActivity.class);
        //SpecialStore store = mAdapter.getItem(position);
        //intent.putExtra(Constants.STORE_ID, store.getId());
        intent.putExtra(Constants.STORE_POSITION, position);
        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        rvStores.setLayoutManager(new LinearLayoutManager(this));

        presenter = new MainPresenter();
        presenter.attachView(this);

        checkNetworkConnection();
    }

    private void checkNetworkConnection() {
        internetConnectionSubscription = ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(isConnectedToInternet -> {
                    if (isConnectedToInternet) {
                        showConnectionSuccessToast();
                        loadData();
                    } else showConnectionFailedToast();
                });
    }

    private void loadData() {
        presenter.loadData();
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        safelyUnSubscribe(internetConnectionSubscription);
    }

    private void safelyUnSubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void showStoreList(List<SpecialStoreModel> storeList) {
        Log.d(TAG, "!!! showStoreList: " + storeList.size());
        pbLoading.setVisibility(View.GONE);
        StoreListAdapter mAdapter = new StoreListAdapter(storeList, this, onClickListener);
        rvStores.setAdapter(mAdapter);
    }

    @Override
    public void showLoadingSuccessToast() {
        showToast(getString(R.string.data_load_success));
    }

    @Override
    public void showLoadingErrorToast() {
        showToast(getString(R.string.data_load_error));
    }

    @Override
    public void showConnectionFailedToast() {
        showToast(getString(R.string.connection_error));
    }

    @Override
    public void showConnectionSuccessToast() {
        showToast(getString(R.string.connection_success));
    }



    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }
}
