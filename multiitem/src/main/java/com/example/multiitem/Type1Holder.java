package com.example.multiitem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Roy12 on 2017/11/28.
 */

public class Type1Holder extends RecyclerView.ViewHolder {

    public ImageView mImageView;
    public TextView mTextView;
    public Context mContext;
    public Type1Holder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        mImageView = itemView.findViewById(R.id.item_iv_square);
        mTextView = itemView.findViewById(R.id.item_tv_square);
    }
    public void bindHolder(DynamicBean.ItemsBean items) {
        Glide.with(mContext).load(items.getImage_path()).into(mImageView);
        mTextView.setText(items.getColumn_type() + "  " + items.getColumn_name());
    }
}
