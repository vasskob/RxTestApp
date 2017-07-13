package com.task.vasskob.testrx.presentation.view;

import com.task.vasskob.testrx.presentation.model.ProductModel;

import java.util.List;

public interface DetailView extends BaseView {
    void showProductList(List<ProductModel> list);
}
