package com.wl.atomsparenting.fragment;

import com.wl.atomsparenting.adapter.BaseListBeanAdapter;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.beans.GridView2Bean;
import com.wl.atomsparenting.beans.SecondFragmentCircleBean;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/14.
 */

public class TwoFragment_Circle extends BaseListFragment {
    private ArrayList<BaseBean> beanArrayList;
    private BaseListBeanAdapter fourFragmentAdapter;

    @Override
    protected void sonStart() {
        beanArrayList = new ArrayList<>();
        GridView2Bean gridView2Bean = new GridView2Bean();
        beanArrayList.add(gridView2Bean);
        fourFragmentAdapter = new BaseListBeanAdapter(beanArrayList, getContext());
        setadapter(fourFragmentAdapter);

    }
}
