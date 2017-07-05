package com.task.vasskob.testrx.view;

import com.task.vasskob.testrx.model.Store;

import java.util.List;

public interface MainView {
    void showStoreList(List<Store> storeList);
    void showLoadingSuccessToast();
    void showLoadingErrorToast();
    void showConnectionFailedToast();
    void showConnectionSuccessToast();
}
