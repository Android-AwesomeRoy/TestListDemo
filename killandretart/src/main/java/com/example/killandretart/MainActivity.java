package com.example.killandretart;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(v -> restartAPP(MainActivity.this, 1000));
    }
    public static void restartAPP(Context context, long Delayed){

        /**开启一个新的服务，用来重启本APP*/
        //Intent intent1=new Intent(context, killSelfService.class);
        //intent1.putExtra("PackageName",context.getPackageName());
        //Log.d(TAG, "restartAPP: "+context.getPackageName());
        //intent1.putExtra("Delayed",Delayed);
        //context.startService(intent1);
        /**杀死整个进程**/

        Intent intent = new Intent(context, MainActivity.class);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pi = PendingIntent.getActivity(context, 0, intent,
                                                     Intent.FLAG_ACTIVITY_NEW_TASK);
        am.set(AlarmManager.RTC, System.currentTimeMillis() + 2000, pi);
        android.os.Process.killProcess(android.os.Process.myPid());
    }
    /***重启整个APP*/
    public static void restartAPP(Context context){
        restartAPP(context,2000);
    }
}
