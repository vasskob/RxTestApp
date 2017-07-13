package com.task.vasskob.testrx.presentation.view;


import com.task.vasskob.testrx.presentation.model.SpecialStoreModel;

import java.util.List;

public interface MainView extends BaseView {
    void showStoreList(List<SpecialStoreModel> list);
}
