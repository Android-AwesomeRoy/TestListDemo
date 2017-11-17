package com.example.testrandomactivity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Handler mHandler = new Handler();
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                Log.d("finish", "已调用runnable");
                // 需要判断当前的activity是哪一个
                finish();
            }
        };
        mHandler.postDelayed(mRunnable, 2000);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mHandler.removeCallbacks(mRunnable);
                break;

            case MotionEvent.ACTION_UP:
                mHandler.postDelayed(mRunnable, 2000);
                break;
        }
        super.dispatchTouchEvent(ev);
        return false;

    }
}
