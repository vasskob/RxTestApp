package com.task.vasskob.testrx.presentetion.view;


import com.task.vasskob.testrx.presentetion.model.SpecialStore;

import java.util.List;

public interface MainView extends BaseView{
    void showStoreList(List<SpecialStore> storeList);
}
