package com.task.vasskob.testrx.data.entity.maper;

import com.task.vasskob.testrx.data.entity.StoreEntity;
import com.task.vasskob.testrx.domain.entity.Store;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShopEntityDataMapper {

    public ShopEntityDataMapper() {
    }

    public Store transform(StoreEntity storeEntity) {
        Store store = null;
        if (storeEntity != null) {
            store = new Store();
            store.setId(storeEntity.getId());
            store.setName(storeEntity.getName());
            store.setAddress1(storeEntity.getAddress1());
            store.setAddress2(storeEntity.getAddress2());
            store.setCity(storeEntity.getCity());
            store.setTelephone(storeEntity.getTelephone());
            store.setLatitude(storeEntity.getLatitude());
            store.setLongitude(storeEntity.getLongitude());
            store.setHasWheelchairAccessability(storeEntity.getHasWheelchairAccessability());
            store.setHasBilingualServices(storeEntity.getHasBilingualServices());
            store.setHasTastingBar(storeEntity.getHasTastingBar());
            store.setHasBeerColdRoom(storeEntity.getHasBeerColdRoom());
            store.setHasVintagesCorner(storeEntity.getHasVintagesCorner());
            store.setHasParking(storeEntity.getHasParking());
        }
        return store;
    }

    public List<Store> transform(Collection<StoreEntity> storeEntityCollection) {
        final List<Store> storeList = new ArrayList<>();
        for (StoreEntity storeEntity : storeEntityCollection) {
            final Store store = transform(storeEntity);
            if (store != null) {
                storeList.add(store);
            }
        }
        return storeList;
    }
}
