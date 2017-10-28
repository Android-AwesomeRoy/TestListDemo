package com.example.roy12.testlistdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Roy12 on 2017/10/14.
 */

public class Utils {

    public static StringBuilder readJson(InputStream file) {
        InputStreamReader inputStreamReader;
        StringBuilder stringBuilder = null;
        try {
            inputStreamReader = new InputStreamReader(file);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            stringBuilder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }
}
