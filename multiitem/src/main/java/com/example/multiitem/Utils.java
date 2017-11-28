package com.example.multiitem;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Roy12 on 2017/11/28.
 */

public class Utils {
    @NonNull
    public static String getJson(Context context,String s) {
        StringBuilder stringBuilder = new StringBuilder();
        AssetManager assets = context.getAssets();
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
}
