package com.task.vasskob.testrx;

import android.app.Application;

import com.task.vasskob.testrx.api.RetrofitSingleton;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitSingleton.init();
    }
}