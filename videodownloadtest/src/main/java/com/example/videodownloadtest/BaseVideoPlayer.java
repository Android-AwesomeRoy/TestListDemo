package com.example.videodownloadtest;

import android.content.Context;
import android.util.AttributeSet;

import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import java.io.File;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Roy12 on 2017/10/26.
 */

public class BaseVideoPlayer extends JZVideoPlayerStandard {
    private File[] mVideoFiles;
    private int COUNT = 0;


    public BaseVideoPlayer(Context context) {
        super(context);
    }

    public BaseVideoPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    /*
     *  1. 重写各个关键方法, 监控播放状态
     *  2. 错误状态下的提醒处理
     *  3. 播放完成后重复播放
     *  4. 处理文件夹内的文件查询, 播放完成后自动下一个
     */



    @Override
    public void onStatePreparing() {
        super.onStatePreparing();
        //Logger.d("进入preparing 状态");
    }

    @Override
    public void onVideoRendingStart() {
        super.onVideoRendingStart();
        Logger.d("已经preparing完毕 准备进入播放状态");
        //EventBus.getDefault().post(new MsgEvent(MsgEvent.ON_LOAD_FINISH));
    }

    @Override
    public void onStatePlaying() {
        super.onStatePlaying();
        //Logger.d("正在播放");
    }

    @Override
    public void onStateAutoComplete() {
        super.onStateAutoComplete();
        Logger.d("已播放完成");
        // 播放完成后, count++,  从file中拿到下一个进行播放
        EventBus.getDefault().post(new MsgEvent(MsgEvent.ON_PLAY_COMPLETE));

    }


    @Override
    public void onStateError() {
        super.onStateError();
        Logger.d("播放错误");
    }

}
