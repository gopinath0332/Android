/**
 * Created by Gopi on 10-09-2016.
 */
package com.zero.project.helloworld;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zero.project.helloworld.provider.StudentProvider;
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
        EditText nameBox = (EditText) findViewById(R.id.std_name);
        EditText departmentBox = (EditText) findViewById(R.id.std_dept);

        String name = nameBox.getText().toString();
        String department = departmentBox.getText().toString();
        Log.d(TAG, "addName: " + name + ":::::=>" + department);

//      Add new record
        ContentValues values = new ContentValues();
        values.put(StudentProvider.NAME, name);
        values.put(StudentProvider.GRADE, department);

        Uri uri = getContentResolver().insert(StudentProvider.CONTENT_URI, values);
        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_SHORT).show();
    }

    public void getStudents(View view) {
        Log.d(TAG, "getStudents: ");
        String URL = "content://com.zero.provider.college/students";

        Uri students = Uri.parse(URL);
        Cursor cursor = managedQuery(students, null, null, null, StudentProvider.NAME);
        if (cursor.moveToFirst()) {
            do {
                String record = cursor.getString(cursor.getColumnIndex(StudentProvider._ID)) + " , " + cursor.getString(cursor.getColumnIndex(StudentProvider.NAME)) + " , " + cursor.getString(cursor.getColumnIndex(StudentProvider.GRADE));
                Log.d(TAG, record);
            } while (cursor.moveToNext());
        }
        Toast.makeText(this, "See console for output", Toast.LENGTH_SHORT).show();
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