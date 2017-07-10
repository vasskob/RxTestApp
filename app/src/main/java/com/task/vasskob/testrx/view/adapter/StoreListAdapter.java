package com.task.vasskob.testrx.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.task.vasskob.testrx.R;
import com.task.vasskob.testrx.model.SpecialStore;

import java.util.ArrayList;
import java.util.List;


public class StoreListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = StoreListAdapter.class.getSimpleName();
    private final ArrayList<SpecialStore> stores;

    public StoreListAdapter(List<SpecialStore> stores) {
        this.stores = (ArrayList<SpecialStore>) stores;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_model, parent, false);
        return new StoreViewHolder(v);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        StoreViewHolder storeHolder = (StoreViewHolder) holder;
        if (stores != null) {
            SpecialStore store = stores.get(position);
            storeHolder.storeName.setText(store.getName());
            storeHolder.storeLocation.setText(store.getCity() + ", " + store.getAddress());
        }
    }

    @Override
    public int getItemCount() {
        if (stores != null) {
            return stores.size();
        } else return 0;
    }

    private class StoreViewHolder extends RecyclerView.ViewHolder {
        TextView storeName, storeLocation;

        StoreViewHolder(View v) {
            super(v);
            storeName = v.findViewById(R.id.tv_store_name);
            storeLocation = v.findViewById(R.id.tv_store_location);
        }
    }
}
