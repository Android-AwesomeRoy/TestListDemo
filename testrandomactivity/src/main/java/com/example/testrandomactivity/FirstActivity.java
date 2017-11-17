package com.example.testrandomactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class FirstActivity extends AppCompatActivity {

    String url = "http://img.gank.io/d3acd780-a1a6-4529-a026-b8bd7967626a";
    public ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mImageView = findViewById(R.id.imageView);

        Glide.with(this).load(url).downloadOnly(mImageView.getMaxWidth(), mImageView.getHeight());

        Glide.with(FirstActivity.this)
             .load(url)
             .placeholder(android.R.color.holo_blue_bright)
             .diskCacheStrategy(DiskCacheStrategy.ALL)
             .into(mImageView);
        // 1. 跳转到2Activity,
        // 2. 使用runnable/service去关闭Activity
        // 3. 拦截点击事件, touch时 removeCallback,
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(FirstActivity.this, SecondActivity.class));
                Glide.with(FirstActivity.this)
                     .load(url)
                     .placeholder(android.R.color.holo_blue_bright)
                     .diskCacheStrategy(DiskCacheStrategy.ALL)
                     .into(mImageView);
            }
        });
    }
}
