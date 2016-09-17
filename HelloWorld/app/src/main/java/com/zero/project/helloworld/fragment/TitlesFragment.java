package com.zero.project.helloworld.fragment;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zero.project.helloworld.DisplayMessage;
import com.zero.project.helloworld.R;
import com.zero.project.helloworld.utils.AppConstants;
import com.zero.project.helloworld.utils.Shakespeare;

/**
 * Created by Gopi on 17-09-2016.
 */
public class TitlesFragment extends ListFragment {
    public static final String TAG = "Titles Fragment ";
    private boolean dualPane = false;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");

//        populate list with data
        this.setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Shakespeare.TITLES));

//        check if we have frame to embed details Fragment dirctlt in same Activity
        View detailFrame = getActivity().findViewById(R.id.content);
        if (detailFrame != null) {
            dualPane = true;
        }
        Log.d(TAG, "dual pane status " + dualPane);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.d(TAG, "onListItemClick: " + l.getItemAtPosition(position));

        if (dualPane) {
            this.getListView().setItemChecked(position, true);
            TitlesFragment titlesFragment = (TitlesFragment) this.getFragmentManager().findFragmentById(R.id.titles);

            DetailsFragment fragment = DetailsFragment.newInstance(position);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.remove(titlesFragment);
            fragmentTransaction.replace(R.id.content, fragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), DisplayMessage.class);
            intent.putExtra(AppConstants.INDEX, position);
            startActivity(intent);
        }
    }
}
