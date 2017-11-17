package com.example.get_android_id;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnGetID, mBtnCopy,mBtnUninstall;
    private TextView mTvShowId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnGetID = findViewById(R.id.btn_get_id);
        mBtnCopy = findViewById(R.id.btn_copy);
        mBtnUninstall = findViewById(R.id.btn_uninstall);
        mTvShowId = findViewById(R.id.tv_show_id);


        mBtnGetID.setOnClickListener(this);
        mBtnCopy.setOnClickListener(this);
        mBtnUninstall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get_id:
                mTvShowId.setText(getDigit(getAndroidID()));
                Log.d("getID", "onClick: " + getAndroidID());
                Log.d("getDigit", "getDigit: " + getDigit(getAndroidID()));
                break;

            case R.id.btn_copy:
                ClipboardManager clip = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData data = ClipData.newPlainText("get ID", mTvShowId.getText());
                if (clip != null) {
                    clip.setPrimaryClip(data);
                }
                break;
            case R.id.btn_uninstall:
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                           Uri.fromParts("package", getPackageName(), null));
                startActivity(intent);
                break;
        }
    }

    private String getAndroidID() {
        return Settings.System.getString(getContentResolver(), "android_id");
    }

    @NonNull
    private String getDigit(String id) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        return p.matcher(id).replaceAll("").trim();
    }
}
