package com.zero.project.helloworld.fragment;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zero.project.helloworld.DisplayMessage;
import com.zero.project.helloworld.utils.AppConstants;
import com.zero.project.helloworld.utils.Shakespeare;

/**
 * Created by Gopi on 17-09-2016.
 */
public class TitlesFragment extends ListFragment {
    public static final String TAG = "Titles Fragment ";

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");

//        populate list with data
        this.setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Shakespeare.TITLES));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.d(TAG, "onListItemClick: " + l.getItemAtPosition(position));
        Intent intent = new Intent();
        intent.setClass(getActivity(), DisplayMessage.class);
        intent.putExtra(AppConstants.INDEX, position);

        startActivity(intent);
    }
}
