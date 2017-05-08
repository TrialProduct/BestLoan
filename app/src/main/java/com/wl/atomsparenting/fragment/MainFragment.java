package com.wl.atomsparenting.fragment;

import android.content.Intent;
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
import com.wl.atomsparenting.activity.SearchActivity;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/7.
 */

public class MainFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {
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
        view = inflater.inflate(R.layout.mainfragment, null);
        initsearch();
        initRadio();
        initFragment();
        return view;
    }

    private void initsearch() {
        main_search = (ImageView) view.findViewById(R.id.main_search);
        main_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initFragment() {
        list = new ArrayList<>();
        MainActivity_GoodTrick mm = new MainActivity_GoodTrick();
        MainActivity_Toptic mg = new MainActivity_Toptic();
        list.add(mm);
        list.add(mg);
        fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction().add(R.id.main_layout, mm).commit();
    }

    private void initRadio() {
        rg = (RadioGroup) view.findViewById(R.id.main_rg);
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
            case R.id.main_rb1:
                showfragment(i);
                rb[0].setTextColor(Color.WHITE);
                rb[1].setTextColor(Color.rgb(219, 219, 227));
                break;
            case R.id.main_rb2:
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
                    fragmentTransaction.show(list.get(i)).hide(list.get(num)).commit();
                } else {
                    fragmentTransaction.add(R.id.main_layout, list.get(i)).hide(list.get(num)).commit();
                }
                num = i;
            }
        }
    }
}
