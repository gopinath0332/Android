package com.zero.project.helloworld.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Gopi on 11-09-2016.
 */
public class MyReceiver extends BroadcastReceiver {
    public  final String TAG = "Adnroid: ";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "broadcast message received"+intent.toString());
        Toast.makeText(context, "Intent detected", Toast.LENGTH_SHORT).show();
    }
}
