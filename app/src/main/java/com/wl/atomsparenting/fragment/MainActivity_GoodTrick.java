package com.wl.atomsparenting.fragment;

import com.wl.atomsparenting.adapter.FourFragmentAdapter;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.beans.GridView1Bean;
import com.wl.atomsparenting.beans.GridView2Bean;
import com.wl.atomsparenting.beans.RollPagerViewBean;
import com.wl.atomsparenting.beans.TarentoBean;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/8.
 */

public class MainActivity_GoodTrick extends BaseListFragment {
    private ArrayList<BaseBean> beanArrayList;
    private FourFragmentAdapter fourFragmentAdapter;

    @Override
    protected void sonStart() {
        beanArrayList = new ArrayList<>();
        RollPagerViewBean rollPagerViewBean = new RollPagerViewBean();
        GridView1Bean gridView1Bean = new GridView1Bean();
        TarentoBean tarentoBean = new TarentoBean();
        GridView2Bean gridView2Bean = new GridView2Bean();
        beanArrayList.add(rollPagerViewBean);
        beanArrayList.add(gridView1Bean);
        beanArrayList.add(tarentoBean);
        beanArrayList.add(gridView2Bean);
        fourFragmentAdapter = new FourFragmentAdapter(beanArrayList, getContext());
        setadapter(fourFragmentAdapter);

    }
}
