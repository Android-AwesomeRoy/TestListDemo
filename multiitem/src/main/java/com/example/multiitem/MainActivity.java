package com.example.multiitem;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String mJson;
    private List<Bean> mData;
    private GridView mGv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.addLogAdapter(new AndroidLogAdapter());

        mJson = getJson("data.json");
        //Logger.json(mJson);
        initView();
        initData();

        mGv.setAdapter(new GvAdapter(mData, this));
    }


    private void initData() {
        mData = new ArrayList<>();
        Bean bean = new Gson().fromJson(mJson, Bean.class);
        mData.add(bean);
        for (Bean datum : mData) {
            List<Bean.ItemsBean> items = datum.getItems();
            for (Bean.ItemsBean item : items) {
                Logger.d("title == " + item.getTitle() + "   " + "type == " + item.getType());

            }
        }
    }

    private void initView() {
        mGv = findViewById(R.id.gv_root);
    }

    @NonNull
    private String getJson(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        AssetManager assets = getAssets();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(assets.open(s)));
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    private class GvAdapter extends BaseAdapter {

        private List<Bean> data;
        Context mContext;

        public GvAdapter(List<Bean> data, Context context) {
            this.data = data;
            mContext = context;
        }

        @Override
        public int getCount() {
            return data == null ? 0 : data.size();
        }

        @Override
        public Object getItem(int position) {
            return data == null ? 0 : data.get(position);
        }

        @Override
        public int getItemViewType(int position) {
            List<Bean.ItemsBean> items = data.get(position).getItems();
            for (Bean.ItemsBean item : items) {
                return item.getType();
            }
            return super.getItemViewType(position);
        }

        @Override
        public int getViewTypeCount() {
            return 3;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            Bean bean = data.get(position);
            int type = getItemViewType(position);
            switch (type) {
                case 0:
                    View view1 = inflater.inflate(R.layout.gv_item_rect, parent);
                    ImageView ivRect = view1.findViewById(R.id.item_iv_rect);
                    TextView tvRect = view1.findViewById(R.id.item_tv_rect);
                    tvRect.setText(bean.getItems().get(position).getTitle());
                    Glide.with(mContext)
                         .load(bean.getItems().get(position).getImage_path())
                         .into(ivRect);
                    return view1;

                case 1:
                    View view2 = inflater.inflate(R.layout.gv_item_square, parent);
                    ImageView ivSquare = view2.findViewById(R.id.item_iv_rect);
                    TextView tvSquare = view2.findViewById(R.id.item_tv_rect);
                    tvSquare.setText(bean.getItems().get(position).getTitle());
                    Glide.with(mContext)
                         .load(bean.getItems().get(position).getImage_path())
                         .into(ivSquare);
                    return view2;
            }
            return null;
        }
    }
}
