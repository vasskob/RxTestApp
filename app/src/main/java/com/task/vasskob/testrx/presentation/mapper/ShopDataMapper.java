package com.task.vasskob.testrx.presentation.mapper;


import com.task.vasskob.testrx.domain.entity.Store;
import com.task.vasskob.testrx.presentation.model.StoreModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShopDataMapper {

    public StoreModel transform(Store store) {
        StoreModel storeModel = null;
        if (store != null) {
            storeModel = new StoreModel();
            storeModel.setId(store.getId());
            storeModel.setName(store.getName());
            storeModel.setAddress1(store.getAddress1());
            storeModel.setAddress2(store.getAddress2());
            storeModel.setCity(store.getCity());
            storeModel.setTelephone(store.getTelephone());
            storeModel.setLatitude(store.getLatitude());
            storeModel.setLongitude(store.getLongitude());
            storeModel.setHasWheelchairAccessability(store.getHasWheelchairAccessability());
            storeModel.setHasBilingualServices(store.getHasBilingualServices());
            storeModel.setHasTastingBar(store.getHasTastingBar());
            storeModel.setHasBeerColdRoom(store.getHasBeerColdRoom());
            storeModel.setHasVintagesCorner(store.getHasVintagesCorner());
            storeModel.setHasParking(store.getHasParking());
        }
        return storeModel;
    }

    public List<StoreModel> transform(Collection<Store> storeEntityCollection) {
        final List<StoreModel> storeList = new ArrayList<>();
        for (Store storeEntity : storeEntityCollection) {
            final StoreModel storeModel = transform(storeEntity);
            if (storeModel != null) {
                storeList.add(storeModel);
            }
        }
        return storeList;
    }

}
