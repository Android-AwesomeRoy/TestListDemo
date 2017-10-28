package com.example.videodownloadtest;

import android.app.Application;
import android.os.Environment;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.wenld.downloadutils.DownLoadSetting;
import com.wenld.downloadutils.DownloadUtils;

/**
 * Created by Roy12 on 2017/10/16.
 */

public class BaseApp extends Application {
    public static String VIDEO_DOWNLOAD_PATH = Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DOWNLOADS + "/video";
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        DownLoadSetting.changeFileDir(VIDEO_DOWNLOAD_PATH);
        DownloadUtils.initDataBase(this);

    }
}
