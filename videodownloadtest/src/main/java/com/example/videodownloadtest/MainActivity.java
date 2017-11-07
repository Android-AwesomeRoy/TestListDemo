package com.example.videodownloadtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.wenld.downloadutils.DownloadUtils;
import com.wenld.downloadutils.bean.FileInfo;
import com.wenld.downloadutils.constant.IntentAction;
import com.wenld.downloadutils.db.FileInfoDB;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

import static com.example.videodownloadtest.Utils.getFiles;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;
    private String mJson;
    private List<String> mPath = new ArrayList<>();
    private File mFile;
    File[] files; // 文件夹内的文件数组
    File videoDir = new File(BaseApp.VIDEO_DOWNLOAD_PATH); // 下载路径

    public String videoUrl = "http://192.168.3.13:8080/obpm/VideoServletDemo?id=11e7-614c-38e267c6-b750-c5ed3f8a5e41&date=2017-08-30";

    public static String[] videoUrlList = {"http://jzvd.nathen.cn/c494b340ff704015bb6682ffde3cd302/64929c369124497593205a4190d7d128-5287d2089db37e62345123a1be272f8b.mp4", "http://jzvd.nathen.cn/63f3f73712544394be981d9e4f56b612/69c5767bb9e54156b5b60a1b6edeb3b5-5287d2089db37e62345123a1be272f8b.mp4", "http://jzvd.nathen.cn/b201be3093814908bf987320361c5a73/2f6d913ea25941ffa78cc53a59025383-5287d2089db37e62345123a1be272f8b.mp4"};

    private BaseVideoPlayer mPlayer;
    public int count = 0;

    private Handler mHnadler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    mTv.setText("当前网速： " + msg.obj.toString());
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver();
        mPlayer = (BaseVideoPlayer) findViewById(R.id.video_player);
        files = getFiles(BaseApp.VIDEO_DOWNLOAD_PATH);


        mTv = (TextView) findViewById(R.id.tv_show_net);
        new NetWorkSpeedUtils(this, mHnadler).startShowNetSpeed();

        new VideoAsyncTask().execute(videoUrl);

        if (videoDir.exists() && files.length != 0) {
            for (File file : files) {
                Logger.d("file中的文件是: " + file);
            }
            playVideo();
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMsgEvent(MsgEvent event) {
        switch (event.getMessage()) {
            case MsgEvent.ON_PLAY_COMPLETE:
                Logger.d("Main Activity 收到了播放完成的通知");
                if (count <= files.length - 1) {
                    Logger.d("if count 的数字是: %d", count);
                    playVideo();
                } else {
                    Logger.d("else count 的数字是 %d", count);
                    count = 0;
                    playVideo();
                }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }


    private void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(IntentAction.ACTION_UPDATE);   //
        filter.addAction(IntentAction.ACTION_FINISH);   //结束时
        filter.addAction(IntentAction.ACTION_PAUSE);    //暂停
        filter.addAction(IntentAction.ACTION_FAILED);    //下载失败
        filter.addAction(IntentAction.ACTION_WAIT_DownLoad);    //进入下载队列等待下载
        registerReceiver(mReceiver, filter);
        Logger.d("已注册receiver");

        //mPlayer.onStateAutoComplete();
    }

    private void playVideo() {
        try {
            Logger.d("开始播放第 %s 个", count);
            mPlayer.setUp(files[count].toString(), JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,
                          files[count].getName());
            mPlayer.startButton.performClick();
            Logger.d("开始播放的本地文件路径是 %s ", files[count].toString());
            count++;

        } catch (Exception e) {
            Toast.makeText(this, "请等待视频下载完成", Toast.LENGTH_SHORT).show();
            //e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
        JZVideoPlayer.releaseAllVideos();
        unregisterReceiver(mReceiver);
        Logger.d("反注册receiver");
        EventBus.getDefault().unregister(this);
    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case IntentAction.ACTION_START:
                    Logger.d("START DOWNLOAD");
                    Toast.makeText(MainActivity.this, "开始下载", Toast.LENGTH_LONG).show();
                    break;
                case IntentAction.ACTION_FINISH:
                    Logger.d(" DOWNLOAD FINISHED");
                    // Logger.d(DownloadUtils.getFileInfosByFinished());
                    files = getFiles(BaseApp.VIDEO_DOWNLOAD_PATH);
                    for (File file : files) {
                        Logger.d("路径中的文件是: " + file.toString());
                    }
                    playVideo();
                    //mPlayer.setUp(files[count].toString(), JZVideoPlayer.SCREEN_LAYOUT_NORMAL, "1");
                    break;
                case IntentAction.ACTION_WAIT_DownLoad:
                    // Logger.d("DOWNLOAD WAIT");

                    break;
                case IntentAction.ACTION_OVER_LOOK:
                    // Logger.d("ACTION_OVER_LOOK");
                    break;
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();

    }

    // read stream, read json, export json, download video
    List<VideoBean> getJsonData(String url) {
        List<VideoBean> videoBeenList = new ArrayList<>();
        try {
            mJson = readStream(new URL(url).openStream());
            Gson gson = new Gson();
            VideoBean videoBean = gson.fromJson(mJson, VideoBean.class);
            List<VideoBean.ItemsBean> items = videoBean.getItems();
            for (VideoBean.ItemsBean item : items) {
                List<VideoBean.ItemsBean.VideoDescribeBean> video_describe = item.getVideo_describe();
                for (VideoBean.ItemsBean.VideoDescribeBean videoDescribeBean : video_describe) {
                    downloadVideo(videoDescribeBean.getPath(), videoDescribeBean.getVideo_name());
                    //Logger.d(videoDescribeBean.getVideo_name());
                    //mPath.add(videoDescribeBean.getPath());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videoBeenList;
    }

    /**
     * 下载视频的方法
     *
     * @param path       下载链接
     * @param video_name 文件名
     */
    private void downloadVideo(String path, String video_name) {
        //数据库是否为空
        //Logger.d(path + "  ++  " + video_name);
        FileInfoDB fileDB = DownloadUtils.getFileDB(); // 数据库操作对象
        List<FileInfo> fileInfos = fileDB.loadAll(); // 读取所有内容到啊bean对象
        // 判断这个文件[是否下载过]或者[是否存在]
        // 如果本地没有文件, 则删除数据库的内容

        new File(BaseApp.VIDEO_DOWNLOAD_PATH).mkdirs();
        if (fileInfos.size() == 0) {
            //Logger.d("数据库大小 == " + fileInfos.size());
            DownloadUtils.startDownload(this, path, video_name, 1);
        } else if (fileInfos.size() != 0 && files.length == 0) {
            fileDB.deleteAll();
        }
        for (FileInfo fileInfo : fileInfos) {
           //Logger.d("fileInfo里的URL %s 和 文件名是: %s  ", fileInfo.getUrl(), fileInfo.getFileName());
           //Logger.d("收到的path = %s  文件名是 %s:  ", path, video_name);
           //Logger.d("是否匹配? : " + fileInfo.getUrl().contains(path));
            if (files == null || !videoDir.exists()) {
                Logger.d("file == %b 或者是 dir == %b", files == null, !videoDir.exists());
                DownloadUtils.ReDownLoad(this, path, 1);
                //files = getFiles(videoDir);
                if ((files != null ? files.length : 0) == 0 || !fileInfo.getUrl().contains(path)) {
                    Logger.d("重新下载的链接是: %s 下载的是 %s", path, video_name);
                    DownloadUtils.ReDownLoad(this, path, 1);

                }
            }
        }
    }


    String readStream(InputStream is) {
        InputStreamReader isr;
        String result = "";
        try {
            String line;
            isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                result += line;
            }
            isr.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private class VideoAsyncTask extends AsyncTask<String, Void, List<VideoBean>> {
        @Override
        protected List<VideoBean> doInBackground(String... strings) {
            return getJsonData(strings[0]);
        }
    }
}
