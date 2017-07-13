package com.task.vasskob.testrx.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.task.vasskob.testrx.R;
import com.task.vasskob.testrx.presentation.model.SpecialStore;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class StoreListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    // private static final String TAG = StoreListAdapter.class.getSimpleName();
    private final ArrayList<SpecialStore> stores;
    private final Context context;
    private final onStoreClickListener listener;

    public StoreListAdapter(List<SpecialStore> stores, Context context, onStoreClickListener listener) {
        this.stores = (ArrayList<SpecialStore>) stores;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store, parent, false);
        return new StoreViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        StoreViewHolder storeHolder = (StoreViewHolder) holder;
        if (stores != null) {
            SpecialStore store = stores.get(position);
            storeHolder.storeName.setText(store.getShopName());
            storeHolder.storeLocation.setText(store.getCity() + ", " + store.getAddress());
            String title = String.format(context.getString(R.string.best_offer), store.getProductName());
            CharSequence styledTitle = fromHtml(title);
            storeHolder.storeProducts.setText(styledTitle);
        }
    }

    @SuppressWarnings("deprecation")
    private static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }

    @Override
    public int getItemCount() {
        if (stores != null) {
            return stores.size();
        } else return 0;
    }

    public SpecialStore getItem(int position) {
        return stores.get(position);
    }

    class StoreViewHolder extends RecyclerView.ViewHolder {

        private final onStoreClickListener mOnStoreClickListener;

        @OnClick(R.id.cv_store)
        void onClick(View v) {
            mOnStoreClickListener.onStoreClick(v);
        }

        @BindView(R.id.tv_store_name)
        TextView storeName;
        @BindView(R.id.tv_store_location)
        TextView storeLocation;
        @BindView(R.id.tv_best_offer_product)
        TextView storeProducts;

        StoreViewHolder(View v, onStoreClickListener listener) {
            super(v);
            ButterKnife.bind(this, v);
            mOnStoreClickListener = listener;
        }
    }

    public interface onStoreClickListener {
        void onStoreClick(View view);
    }
}
