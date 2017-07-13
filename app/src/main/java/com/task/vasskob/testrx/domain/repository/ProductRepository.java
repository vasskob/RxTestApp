package com.task.vasskob.testrx.domain.repository;

import com.task.vasskob.testrx.domain.entity.Product;

import java.util.List;

import rx.Observable;


public interface ProductRepository {
    Observable<List<Product>> products(long shopId);
}
