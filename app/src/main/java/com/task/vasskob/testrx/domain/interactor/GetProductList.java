package com.task.vasskob.testrx.domain.interactor;

import com.task.vasskob.testrx.domain.entity.Product;
import com.task.vasskob.testrx.domain.executor.PostExecutionThread;
import com.task.vasskob.testrx.domain.executor.ThreadExecutor;
import com.task.vasskob.testrx.domain.repository.ProductRepository;

import java.util.List;

import io.reactivex.Observable;

public class GetProductList extends UseCase<List<Product>, Void> {

    private final ProductRepository productRepository;

    GetProductList(ProductRepository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        productRepository = repository;
    }

    @Override
    Observable<List<Product>> buildUseCaseObservable(Void aVoid) {
        return productRepository.products();
    }
}
