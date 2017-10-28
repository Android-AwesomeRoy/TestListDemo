package com.example.videodownloadtest;

/**
 * Created by Roy12 on 2017/10/27.
 */

public class MsgEvent {
    public String getMessage() {
        return message;
    }

    public final String message;

    public static final String ON_LOAD_FINISH = "已加载视频";
    public static final String ON_PLAY_COMPLETE = "已播放完成";

    public MsgEvent(String message) {
        this.message = message;
    }
}
