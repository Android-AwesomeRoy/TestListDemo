package com.example.killandretart;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class killSelfService extends Service {
    private static final String TAG = "killSelfService";
    private Handler handler;
    private String PackageName;
    public killSelfService() {
        handler=new Handler();
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        /*关闭应用后多久重新启动*/
        Log.d(TAG, "onStartCommand: start");
        long stopDelayed = intent.getLongExtra("Delayed", 2000);
        PackageName=intent.getStringExtra("PackageName");
        handler.post(()->{
            Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(PackageName);
            startActivity(LaunchIntent);
            killSelfService.this.stopSelf();
        });
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
