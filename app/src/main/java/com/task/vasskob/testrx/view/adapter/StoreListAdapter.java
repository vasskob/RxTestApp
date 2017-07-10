package com.task.vasskob.testrx.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.task.vasskob.testrx.R;
import com.task.vasskob.testrx.model.SpecialStore;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class StoreListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = StoreListAdapter.class.getSimpleName();
    private final ArrayList<SpecialStore> stores;
    private final Context context;

    public StoreListAdapter(List<SpecialStore> stores, Context context) {
        this.stores = (ArrayList<SpecialStore>) stores;
        this.context = context;
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
            storeHolder.storeName.setText(store.getShopName());
            storeHolder.storeLocation.setText(store.getCity() + ", " + store.getAddress());
            String title=String.format(context.getString(R.string.best_offer),store.getProductName());
            CharSequence styledTitle= Html.fromHtml(title);
            storeHolder.storeProducts.setText(styledTitle);
        }
    }

    @Override
    public int getItemCount() {
        if (stores != null) {
            return stores.size();
        } else return 0;
    }

    class StoreViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_store_name)
        TextView storeName;
        @BindView(R.id.tv_store_location)
        TextView storeLocation;
        @BindView(R.id.tv_best_offer_product)
        TextView storeProducts;

        StoreViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
