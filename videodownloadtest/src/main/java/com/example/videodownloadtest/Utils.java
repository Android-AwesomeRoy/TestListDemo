package com.example.videodownloadtest;

import java.io.File;

/**
 * Created by Roy12 on 2017/10/24.
 */

public class Utils {
    /**
     * 获取文件列表
     *
     * @param fileDir
     */
    public static File[] getFiles(String fileDir) {
        return getFiles(new File(fileDir));
    }

    /**
     * 获取文件列表
     *
     * @param fileDir
     */
    public static File[] getFiles(File fileDir) {
        if (!fileDir.isDirectory()) {
            return null;
        }
        return fileDir.listFiles();
    }
}
