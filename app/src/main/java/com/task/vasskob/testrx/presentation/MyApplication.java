package com.task.vasskob.testrx.presentation;

import android.app.Application;

import com.task.vasskob.testrx.data.api.RetrofitSingleton;

//import com.task.vasskob.testrx.presentation.api.RetrofitSingleton;


public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitSingleton.init();
    }
}
