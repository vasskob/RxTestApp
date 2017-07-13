package com.task.vasskob.testrx.presentation.view;

import com.task.vasskob.testrx.presentation.model.Product;

import java.util.List;

public interface DetailView extends BaseView {
    void showProductList(List<Product> productList);
}
