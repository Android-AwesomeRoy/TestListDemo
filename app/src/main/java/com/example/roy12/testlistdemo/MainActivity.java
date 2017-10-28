package com.example.roy12.testlistdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 1,拿到JSON; 2,解析JSON; 3,插入list中; 4;在list view展示
 */
public class MainActivity extends AppCompatActivity {

    List<CBean> mData;
    private String mJson;
    public static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            // StringBuilder stringBuilder = Utils.readJson(getAssets().open("base.json"));
            mJson = stringBuilder.toString();
            Log.d(TAG, mJson);
            mData = new ArrayList<>();

            Gson gson = new Gson();
            mData = gson.fromJson(mJson, new TypeToken<List<CBean.ItemsBean>>() {
            }.getType());


        } catch (IOException e) {
            e.printStackTrace();
        }


        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new MyAdapter());
    }


    private class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public List<CBean> getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(android.R.layout.simple_list_item_1, container, false);
            }

            return convertView;
        }
    }
}
