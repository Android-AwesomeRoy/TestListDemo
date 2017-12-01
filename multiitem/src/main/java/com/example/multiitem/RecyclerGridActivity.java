package com.example.multiitem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现 multi type 的视图页
 */
public class RecyclerGridActivity extends AppCompatActivity
        implements RecyclerGridAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private String mJson;
    private List<DynamicBean> mData;
    private List<DynamicBean.ItemsBean> mItems;
    RecyclerGridAdapter mAdapter;
    //String url = "http://192.168.3.13:8081/obpm/ClassColumnDisplay?id=11e7-9f38-0b377c52-befc-cfffeac8f141";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.addLogAdapter(new AndroidLogAdapter());
        setContentView(R.layout.activity_recycler_grid);
        initData();
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true); // 确定 item 大小的时候实现true可以提高绘制性能
        // Google 提供的lib 用于调整布局
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
        //layoutManager.setFlexWrap(FlexWrap.WRAP); // 设置可换行
        mRecyclerView.setLayoutManager(layoutManager);
        int dimen = getResources().getDimensionPixelSize(R.dimen.space); // 设置 item 固定宽度
        mRecyclerView.addItemDecoration(new SpaceDecoration(dimen));
        mAdapter = new RecyclerGridAdapter(this, mItems);
        mRecyclerView.setAdapter(mAdapter);
        //mAdapter.setOnItemClickListener(this); // 设置 item 的点击事件

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mJson = Utils.getJson(this, "data.json");
        Logger.json(mJson);
        mData = new ArrayList<>();
        Bean bean = new Gson().fromJson(mJson, Bean.class);
        DynamicBean dynamicBean = new Gson().fromJson(mJson, DynamicBean.class);
        mData.add(dynamicBean);
        for (DynamicBean datum : mData) {
            mItems = datum.getItems();
        }
    }

    /**
     * 点击时通过 Bean 的数据对象获取 position, 可以拿到相应 item 中内容.
     *
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, mItems.get(position).getColumn_name(), Toast.LENGTH_SHORT).show();
    }
}
