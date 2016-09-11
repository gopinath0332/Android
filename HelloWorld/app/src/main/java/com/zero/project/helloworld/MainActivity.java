/**
 * Created by Gopi on 10-09-2016.
 */
package com.zero.project.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.zero.project.helloworld.service.MyService;

public class MainActivity extends AppCompatActivity {

    public final String MESSAGE = "Android: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(MESSAGE, "onCreate event");
    }

    public void startService(View view) {
        Log.d(MESSAGE, "service started ");
        startService(new Intent(getBaseContext(), MyService.class));
    }

    public void broadcastIntent(View view){
        Log.d(MESSAGE, "broadcasting Intent: ");
        Intent intent = new Intent();
        intent.setAction("com.zero.project.CUSTOM_EVENT");
        sendBroadcast(intent);
    }

    public void stopService(View view) {
        Log.d(MESSAGE, "stop Service: ");
        stopService(new Intent(getBaseContext(), MyService.class));
    }


    //Activity Life cycle
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MESSAGE, "onStart event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MESSAGE, "onResume event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MESSAGE, "onPause event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MESSAGE, "onStop event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MESSAGE, "onDestroy event");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(MESSAGE, "onRestart event");
    }
}