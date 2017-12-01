package com.example.multiitem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by Roy12 on 2017/11/28.
 * recycler 的数据解析类
 */

public class RecyclerGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements View.OnClickListener {

    private LayoutInflater mLayoutInflater;
    private List<DynamicBean.ItemsBean> mItems;
    private Context mContext;
    private OnItemClickListener mClickListener = null;


    public RecyclerGridAdapter(Context context, List<DynamicBean.ItemsBean> items) {
        mItems = items;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    /**
     * 通过类型判断每个 item 应该需要什么类型的布局
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        Logger.d(mItems.get(position).getColumn_type());
        return mItems.get(position).getColumn_type();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 2:
                // 拿到每个item的对象, 设置点击事件
                View itemView1 = mLayoutInflater.inflate(R.layout.item_rect, parent, false);
                //itemView1.setOnClickListener(this);
                return new Type0Holder(mContext, itemView1);
            case 1:
                //todo 需要在这里按照上面的方式重写一个.
                View itemView2 = mLayoutInflater.inflate(R.layout.item_square, parent, false);
                //itemView2.setOnClickListener(this);
                return new Type1Holder(mContext, itemView2);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case 2:
                // 拿到每一个 item 去设置 tag
                holder.itemView.setTag(position);
                ((Type0Holder) holder).bindHolder(mItems.get(position));
                break;
            case 1:
                holder.itemView.setTag(position);
                ((Type1Holder) holder).bindHolder(mItems.get(position));
                break;

        }

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /**
     * 实现自 view 本身的点击事件, 传递给接口
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (mClickListener != null) {
            mClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    /**
     * 由初始化 adapter 的地方调用, 把点击的内容 传递给 view 的点击事件
     *
     * @param listener
     */
    void setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }

    /**
     * 实现一个接口, 方便在其他地方实现点击事件的效果
     */
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
