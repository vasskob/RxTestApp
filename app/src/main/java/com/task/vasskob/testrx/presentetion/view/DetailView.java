package com.task.vasskob.testrx.presentetion.view;

import com.task.vasskob.testrx.presentetion.model.Product;

import java.util.List;

public interface DetailView extends BaseView {
    void showProductList(List<Product> productList);
}
