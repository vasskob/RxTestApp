package com.task.vasskob.testrx.presenter;

import com.task.vasskob.testrx.view.MainView;

public interface IMainPresenter {
    void loadData();
    void attachView(MainView view);
    void detachView();
}
