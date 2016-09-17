package com.zero.project.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.zero.project.helloworld.utils.AppConstants;
import com.zero.project.helloworld.utils.Shakespeare;

public class DisplayMessage extends Activity {

    public final String TAG = "Display Message ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        showDetails();
    }

    private void showDetails() {
        Intent intent = getIntent();
        int index = intent.getIntExtra(AppConstants.INDEX, 0);
        String detail = Shakespeare.DIALOGUE[index];
        String title = Shakespeare.TITLES[index];
        Log.d(TAG, "showDetails: " + detail);
        TextView textView = (TextView) this.findViewById(R.id.head_title);
        textView.setText(title);

        TextView detailView = (TextView) this.findViewById(R.id.detail);
        detailView.setText(detail);
//        TextView titleView = new TextView(this);
//        titleView.setText(title);
//        titleView.setTextSize(40);
//
//        TextView dialogue = new TextView(this);
//        dialogue.setText(detail);
//
//        ViewGroup viewGroup = (ViewGroup) this.findViewById(R.id.display_message);
//        viewGroup.addView(titleView);
//        viewGroup.addView();

    }
}
