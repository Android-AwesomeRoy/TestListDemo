package com.example.kcb;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String url = "http://59.110.237.176:8081/obpm/ClassCurriculumScheduleDemo?id=11e7-b256-43575ddb-b550-e35bb93ed9eb";

    String mJson;
    List<Kcb> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.addLogAdapter(new AndroidLogAdapter());

        new KcbTask().execute(url);
    }


    List<Kcb> getData(String url) {
        mData = new ArrayList<>();
        try {
            mJson = readStream(new URL(url).openStream());
            Logger.json(mJson);
            Gson gson = new Gson();
            Kcb kcb = gson.fromJson(mJson, Kcb.class);
            List<Kcb.ItemsBean> items = kcb.getItems();
            for (Kcb.ItemsBean item : items) {
                List<Kcb.ItemsBean.CoursesBean> courses = item.getCourses();
                switch (item.getWeek()) {
                    case "周一":
                        for (Kcb.ItemsBean.CoursesBean cours : courses) {
                            String start = cours.getStart();
                            String end = cours.getEnd();
                            String subject = cours.getSubject();
                            String keshi = cours.getKeshi();
                            Logger.d("周一 : start == %s, end == %s, keshi == %s, subject == %s",
                                     start, end, keshi, subject);
                        }
                        break;
                    case "周二":
                        for (Kcb.ItemsBean.CoursesBean cours : courses) {
                            String start = cours.getStart();
                            String end = cours.getEnd();
                            String subject = cours.getSubject();
                            String keshi = cours.getKeshi();
                            Logger.d("周二 : start == %s, end == %s, keshi == %s, subject == %s",
                                     start, end, keshi, subject);
                        }
                        break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mData;
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

    private class KcbTask extends AsyncTask<String, Void, List<Kcb>> {
        @Override
        protected List<Kcb> doInBackground(String... strings) {
            return getData(strings[0]);
        }
    }


}
