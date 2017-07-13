package com.task.vasskob.testrx.domain.interactor;

import com.task.vasskob.testrx.domain.entity.Store;
import com.task.vasskob.testrx.domain.executor.PostExecutionThread;
import com.task.vasskob.testrx.domain.executor.ThreadExecutor;
import com.task.vasskob.testrx.domain.repository.StoreRepository;

import java.util.List;
import io.reactivex.Observable;

public class GetStoreList extends UseCase<List<Store>, Void> {

    private final StoreRepository storeRepository;

    GetStoreList(StoreRepository repository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        storeRepository = repository;
    }

    @Override
    Observable<List<Store>> buildUseCaseObservable(Void aVoid) {
        return storeRepository.stores();
    }
}
