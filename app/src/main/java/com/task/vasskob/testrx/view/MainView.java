package com.task.vasskob.testrx.view;

import com.task.vasskob.testrx.model.SpecialStore;

import java.util.List;

public interface MainView {
    void showStoreList(List<SpecialStore> storeList);
    void showLoadingSuccessToast();
    void showLoadingErrorToast();
    void showConnectionFailedToast();
    void showConnectionSuccessToast();
}
