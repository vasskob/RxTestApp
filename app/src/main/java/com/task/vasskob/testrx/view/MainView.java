package com.task.vasskob.testrx.view;

import com.task.vasskob.testrx.model.SpecialStore;

import java.util.List;

public interface MainView extends BaseView{
    void showStoreList(List<SpecialStore> storeList);
}
