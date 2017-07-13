package com.task.vasskob.testrx.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.task.vasskob.testrx.R;
import com.task.vasskob.testrx.presentation.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {
    // private static final String TAG = StoreListAdapter.class.getSimpleName();
    private final ArrayList<ProductModel> products;
    private final Context context;

    public ProductListAdapter(List<ProductModel> products, Context context) {
        this.products = (ArrayList<ProductModel>) products;
        this.context = context;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        if (products != null) {
            ProductModel product = products.get(position);
            holder.productName.setText(product.getName());
            holder.productPrice.setText("Price: " + product.getPriceInCents() / 100 + " $");
            holder.productCategory.setText("Category: " + product.getPrimaryCategory() + "");
            Glide.with(context)
                    .load(product.getImageUrl())
                    .into(holder.productIcon);
        }
    }

    @Override
    public int getItemCount() {
        if (products != null) {
            return products.size();
        } else return 0;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_product_name)
        TextView productName;
        @BindView(R.id.tv_product_price)
        TextView productPrice;
        @BindView(R.id.tv_product_category)
        TextView productCategory;
        @BindView(R.id.iv_product_icon)
        ImageView productIcon;

        ProductViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
