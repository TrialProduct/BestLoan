package com.wl.atomsparenting.fragment;

import com.wl.atomsparenting.adapter.BaseListBeanAdapter;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.beans.RollPagerView2Bean;
import com.wl.atomsparenting.beans.ThirdSmallClassBean;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/17.
 */

public class ThreefragmentCursorfragment extends BaseListFragment {
    private ArrayList<BaseBean> beanArrayList;
    private BaseListBeanAdapter fourFragmentAdapter;

    @Override
    protected void sonStart() {
        beanArrayList = new ArrayList<>();
        ThirdSmallClassBean thirdSmallClassBean = new ThirdSmallClassBean();
        RollPagerView2Bean rollPagerView2Bean = new RollPagerView2Bean();
        beanArrayList.add(rollPagerView2Bean);


        beanArrayList.add(thirdSmallClassBean);
        BaseListBeanAdapter  fourFragmentAdapter= new BaseListBeanAdapter(beanArrayList, getContext());

        setadapter(fourFragmentAdapter);
    }
}
