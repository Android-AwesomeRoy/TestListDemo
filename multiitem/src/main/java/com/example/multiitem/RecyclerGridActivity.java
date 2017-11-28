package com.example.multiitem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class RecyclerGridActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private String mJson;
    private List<Bean> mData;
    private List<Bean.ItemsBean> mItems;
    RecyclerGridAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_grid);

        initData();

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(
//                new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false)
                new FlowLayoutManager(this, false)
        );
        int dimen = getResources().getDimensionPixelSize(R.dimen.space);
        Logger.d("dimen  ==  "+dimen);
        mRecyclerView.addItemDecoration(new SpaceDecoration(dimen),0);
        mAdapter = new RecyclerGridAdapter(this, mItems);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mRecyclerView.setAdapter(mAdapter);

    }

    private void initData() {
        mJson = Utils.getJson(this, "data.json");
        mData = new ArrayList<>();
        Bean bean = new Gson().fromJson(mJson, Bean.class);
        mData.add(bean);
        for (Bean datum : mData) {
            mItems = datum.getItems();
        }
    }

}
