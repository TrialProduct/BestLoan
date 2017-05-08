package com.wl.atomsparenting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wl.atomsparenting.R;
import com.wl.atomsparenting.domain.Griddomain;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/8.
 */

public class OptionAdapter extends BaseAdapter {
    private ArrayList<Griddomain> mArrayList;
    private LayoutInflater inflater;
    private Context mContext;

    public OptionAdapter(ArrayList<Griddomain> mArrayList, Context mContext) {
        this.mArrayList = mArrayList;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return mArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        
        ViewHoder vh = null;
        
        if (view == null) {
            
            vh = new ViewHoder();
            
            view = inflater.inflate(R.layout.mainoption, null);
            vh.ivOption = (ImageView) view.findViewById(R.id.ivOption);
            vh.mTvOptionTitle = (TextView) view.findViewById(R.id.mTvOptionTitle);
            
            view.setTag(vh);
            
        } else {
            
            vh = (ViewHoder) view.getTag();
            
        }
        
        Griddomain gd = mArrayList.get(i);
        vh.ivOption.setImageResource(gd.getImg());
        vh.mTvOptionTitle.setText(gd.getName());
        
        return view;
    }

    class ViewHoder {
        ImageView ivOption;
        TextView mTvOptionTitle;
    }
}
