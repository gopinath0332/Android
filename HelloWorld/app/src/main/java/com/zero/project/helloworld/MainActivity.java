/**
 * Created by Gopi on 10-09-2016.
 */
package com.zero.project.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.zero.project.helloworld.service.MyService;

public class MainActivity extends AppCompatActivity {

    public final String TAG = "Android: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate event");
    }

    public void startService(View view) {
        Log.d(TAG, "service started ");
        startService(new Intent(getBaseContext(), MyService.class));
    }

    public void broadcastIntent(View view) {
        Log.d(TAG, "broadcasting Intent: ");
        Intent intent = new Intent();
        intent.setAction("com.zero.project.CUSTOM_EVENT");
        sendBroadcast(intent);
    }

    public void stopService(View view) {
        Log.d(TAG, "stop Service: ");
        stopService(new Intent(getBaseContext(), MyService.class));
    }

    public void addName(View view) {
        EditText editText = (EditText)findViewById(R.id.std_name);
        Log.d(TAG, "addName: "+editText.getText());
    }

    //Activity Life cycle
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy event");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart event");
    }
}