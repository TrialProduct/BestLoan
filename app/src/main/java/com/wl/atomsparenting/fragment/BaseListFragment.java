package com.wl.atomsparenting.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wl.atomsparenting.R;
import com.wl.atomsparenting.views.RefreshableView;


/**
 * Created by le on 2017/4/14.
 */

public abstract class BaseListFragment extends Fragment{
    protected RecyclerView recyclerview;


    RefreshableView refreshableView;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fourfragment,null);
        recyclerview = (RecyclerView) view.findViewById(R.id.baserecyclerview);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerview.setLayoutManager(manager);


        refreshableView = (RefreshableView) view.findViewById(R.id.refreshable_view);



        refreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {
                try {

                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refreshableView.finishRefreshing();
            }
        }, 0);
        sonStart();
        return view;
    }
    protected abstract void sonStart();
    public void setadapter(RecyclerView.Adapter adapter){
        if (adapter!=null) {
            recyclerview.setAdapter(adapter);
        }
    }




}
