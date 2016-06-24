package com.example.djh.keyguardlockdemo;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class LockScreenService extends Service {

    private static final boolean DBG = true;
    private static final String TAG = "FxLockService";

    private BroadcastReceiver mLockScreenReciver;


    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        IntentFilter filter = new IntentFilter();
        mLockScreenReciver = new LockScreenReciever();
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(mLockScreenReciver, filter);
    }


    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        LockScreenService.this.unregisterReceiver(mLockScreenReciver);
        startService(new Intent(LockScreenService.this, LockScreenService.class));
    }

    @Override
    public IBinder onBind(Intent arg0) {

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return 1;
    }


}
