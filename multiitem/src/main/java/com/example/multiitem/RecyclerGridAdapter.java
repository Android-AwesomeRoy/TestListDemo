package com.example.multiitem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Roy12 on 2017/11/28.
 */

public class RecyclerGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Bean.ItemsBean> mItems;
    private Context mContext;


    public RecyclerGridAdapter(Context context, List<Bean.ItemsBean> items) {
        mItems = items;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new Type0Holder(mContext,
                                       mLayoutInflater.inflate(R.layout.gv_item_rect, parent,
                                                               false));
            case 1:
                return new Type1Holder(mContext,
                                       mLayoutInflater.inflate(R.layout.gv_item_square, parent,
                                                               false));

        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case 0:
                ((Type0Holder) holder).bindHolder(mItems.get(position));
                break;
            case 1:
                ((Type1Holder) holder).bindHolder(mItems.get(position));
                break;

        }

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
