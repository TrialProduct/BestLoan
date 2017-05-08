package com.wl.atomsparenting.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wl.atomsparenting.R;

/**
 * Created by le on 2017/4/13.
 */

public class ThreeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.threefragment, null);
        ThreefragmentCursorfragment threefragmentCursorfragment = new ThreefragmentCursorfragment();
        getChildFragmentManager().beginTransaction().add(R.id.three_fragment, threefragmentCursorfragment).commit();


        return view;
    }


}
