package com.wl.atomsparenting.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wl.atomsparenting.R;
import com.wl.atomsparenting.fragment.FourFragment;
import com.wl.atomsparenting.fragment.MainFragment;
import com.wl.atomsparenting.fragment.ThreeFragment;
import com.wl.atomsparenting.fragment.TwoFragment;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/7.
 */

public class HomeActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rg;
    private RadioButton[] rb;
    private ArrayList<Fragment> fragmentArrayList;
    private FragmentManager supportFragmentManager;
    private int num;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity);

        initView();

        initFragment();


        SharedPreferences sp = getSharedPreferences("count", Context.MODE_PRIVATE + Context.MODE_APPEND);

        //获取count文件下的appcount的值
        int i = sp.getInt("appcount", 0);
        //获取编辑对象
        SharedPreferences.Editor ed = sp.edit();
        ed.putInt("appcount", ++i);
        ed.commit();


    }


    private void initFragment() {

        fragmentArrayList = new ArrayList<>();

        MainFragment mainFragment = new MainFragment();
        TwoFragment twoFragment = new TwoFragment();
        ThreeFragment threeFragment = new ThreeFragment();
        FourFragment fourFragment = new FourFragment();

        fragmentArrayList.add(mainFragment);
        fragmentArrayList.add(twoFragment);
        fragmentArrayList.add(threeFragment);
        fragmentArrayList.add(fourFragment);

        supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().add(R.id.home_relativeLayout, fragmentArrayList.get(0)).commit();

    }

    private void initView() {
        rg = (RadioGroup) findViewById(R.id.home_rg);

        rb = new RadioButton[rg.getChildCount()];
        for (int i = 0; i < rg.getChildCount(); i++) {
            rb[i] = (RadioButton) rg.getChildAt(i);
        }

        rb[0].setChecked(true);
        rb[0].setTextColor(Color.rgb(255, 153, 158));

        rg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        switch (i) {
            case R.id.home_rb1:
                showfragment(i);
                rb[0].setTextColor(Color.rgb(255, 153, 158));
                rb[1].setTextColor(Color.BLACK);
                rb[2].setTextColor(Color.BLACK);
                rb[3].setTextColor(Color.BLACK);
                break;

            case R.id.home_rb2:
                showfragment(i);
                rb[1].setTextColor(Color.rgb(255, 153, 158));
                rb[0].setTextColor(Color.BLACK);
                rb[2].setTextColor(Color.BLACK);
                rb[3].setTextColor(Color.BLACK);
                break;

            case R.id.home_rb3:
                showfragment(i);
                rb[2].setTextColor(Color.rgb(255, 153, 158));
                rb[1].setTextColor(Color.BLACK);
                rb[0].setTextColor(Color.BLACK);
                rb[3].setTextColor(Color.BLACK);
                break;

            case R.id.home_rb4:
                showfragment(i);
                rb[3].setTextColor(Color.rgb(255, 153, 158));
                rb[1].setTextColor(Color.BLACK);
                rb[2].setTextColor(Color.BLACK);
                rb[0].setTextColor(Color.BLACK);
                break;

            default:
                break;
        }
    }

    private void showfragment(int i) {

        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

        for (int i1 = 0; i1 < rg.getChildCount(); i1++) {

            if (rb[i1].getId() == i) {












                if (fragmentArrayList.get(i1).isAdded()) {
                    fragmentTransaction.hide(fragmentArrayList.get(num)).show(fragmentArrayList.get(i1)).commit();
                } else {
                    fragmentTransaction.hide(fragmentArrayList.get(num)).add(R.id.home_relativeLayout, fragmentArrayList.get(i1)).commit();
                }
                num = i1;
            }
        }
    }
}
