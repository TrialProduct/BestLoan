package com.wl.atomsparenting.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wl.atomsparenting.R;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/13.
 */

public class TwoFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
    private RadioButton[] rb;
    private RadioGroup rg;
    private View view;
    private ArrayList<Fragment> list;
    private FragmentManager fragmentManager;
    private int num;
    private ImageView main_search;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.twofragment, null);
        initsearch();
        initRadio();
        initFragment();
        return view;
    }

    private void initsearch() {


    }

    private void initFragment() {
        list = new ArrayList<>();
        TwoFragment_Circle mm = new TwoFragment_Circle();
        TwoFragmentAction mg = new TwoFragmentAction();
        list.add(mm);
        list.add(mg);
        fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction().add(R.id.two_layout, mm).commit();
    }

    private void initRadio() {
        rg = (RadioGroup) view.findViewById(R.id.two_rg);
        rb = new RadioButton[rg.getChildCount()];
        for (int i = 0; i < rg.getChildCount(); i++) {
            rb[i] = (RadioButton) rg.getChildAt(i);
        }
        rb[0].setChecked(true);
        rb[0].setTextColor(Color.WHITE);
        rg.setOnCheckedChangeListener(this);

    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i) {
            case R.id.two_rb1:
                showfragment(i);
                rb[0].setTextColor(Color.WHITE);
                rb[1].setTextColor(Color.rgb(219, 219, 227));
                break;
            case R.id.two_rb2:
                showfragment(i);
                rb[1].setTextColor(Color.WHITE);
                rb[0].setTextColor(Color.rgb(219, 219, 227));
                break;
        }
    }

    private void showfragment(int j) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = 0; i < rg.getChildCount(); i++) {
            if (rb[i].getId() == j) {
                if (list.get(i).isAdded()) {
                    fragmentTransaction.hide(list.get(num)).show(list.get(i)).commit();
                } else {
                    fragmentTransaction.hide(list.get(num)).add(R.id.two_layout, list.get(i)).commit();
                }
                num = i;
            }
        }
    }
}
