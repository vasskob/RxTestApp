package com.task.vasskob.testrx.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;

import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

public class InternetConnection {
    public Observable<Boolean> isInternetOn(Context context) {
        final IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        return Observable.create((Observable.OnSubscribe<Boolean>) subscriber -> {
            final BroadcastReceiver receiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context1, Intent intent) {
                    ConnectivityManager cm = (ConnectivityManager) context1.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo netInfo = cm.getActiveNetworkInfo();
                    subscriber.onNext(netInfo != null && netInfo.isConnected());
                }
            };

            context.registerReceiver(receiver, filter);

            subscriber.add(unsubscribeInUiThread(() -> context.unregisterReceiver(receiver)));
        }).defaultIfEmpty(false);
    }

    private Subscription unsubscribeInUiThread(final Action0 unsubscribe) {
        return Subscriptions.create(() -> {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                unsubscribe.call();
            } else {
                final Scheduler.Worker inner = AndroidSchedulers.mainThread().createWorker();
                inner.schedule(() -> {
                    unsubscribe.call();
                    inner.unsubscribe();
                });
            }
        });
    }
}
