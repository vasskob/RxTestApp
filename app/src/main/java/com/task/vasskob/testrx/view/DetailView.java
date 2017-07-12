package com.task.vasskob.testrx.view;

import com.task.vasskob.testrx.model.Product;

import java.util.List;

public interface DetailView extends BaseView {
    void showProductList(List<Product> productList);
}
