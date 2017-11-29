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

public class Type0Holder extends RecyclerView.ViewHolder {

    private ImageView mImageView;
    private TextView mTextView;
    private Context mContext; // 给 Glide 调用
    public Type0Holder(Context context,View itemView) {
        super(itemView);
        mContext = context;
        mImageView = itemView.findViewById(R.id.item_iv_rect);
        mTextView = itemView.findViewById(R.id.item_tv_rect);
    }
    public void bindHolder(Bean.ItemsBean items) {
        Glide.with(mContext).load(items.getImage_path()).into(mImageView);
        mTextView.setText(items.getType() + "  " + items.getTitle());
    }
}
