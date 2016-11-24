package com.zero.project.helloworld.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.zero.project.helloworld.utils.AppConstants;
import com.zero.project.helloworld.utils.Shakespeare;

/**
 * Created by Gopi on 17-09-2016.
 */
public class DetailsFragment extends Fragment {

    public static DetailsFragment newInstance(int index) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstants.INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void setTargetFragment(Fragment fragment, int requestCode) {
        super.setTargetFragment(fragment, requestCode);
    }

    private int getIndex() {
        return getArguments().getInt(AppConstants.INDEX);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        int index = getIndex();
        ScrollView scrollView = new ScrollView(getActivity());
        TextView textView = new TextView(getActivity());
        textView.setText(Shakespeare.DIALOGUE[index]);
        textView.setTextSize(15);
        scrollView.addView(textView);
        return scrollView;
    }
}
