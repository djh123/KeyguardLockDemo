package com.example.djh.keyguardlockdemo;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by root on 16-6-20.
 */
public class LockScreenReciever extends BroadcastReceiver {

    public static final String TAG = LockScreenReciever.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        Log.v(TAG,"action " + action);
        if (action.equals("android.intent.action.SCREEN_ON")
                || action.equals("android.intent.action.SCREEN_OFF")) {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(context.KEYGUARD_SERVICE);
            KeyguardManager.KeyguardLock keyguardLock = keyguardManager.newKeyguardLock("");
            keyguardLock.disableKeyguard();
            Intent intent1 = new Intent(context, MainActivity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }

    }
}
