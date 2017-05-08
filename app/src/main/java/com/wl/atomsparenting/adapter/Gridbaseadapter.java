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

public class Gridbaseadapter extends BaseAdapter {
    private ArrayList<Griddomain> list;
    private LayoutInflater inflater;
    private Context context;

    public Gridbaseadapter(ArrayList<Griddomain> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
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
            view = inflater.inflate(R.layout.main_gridview, null);
            vh.main_gridview_img = (ImageView) view.findViewById(R.id.main_gridview_img);
            vh.main_gridview_tv = (TextView) view.findViewById(R.id.main_gridview_tv);
            view.setTag(vh);
        } else {
            vh = (ViewHoder) view.getTag();
        }
        Griddomain gd = list.get(i);
        vh.main_gridview_img.setImageResource(gd.getImg());
        vh.main_gridview_tv.setText(gd.getName());
        return view;
    }

    class ViewHoder {
        ImageView main_gridview_img;
        TextView main_gridview_tv;
    }
}
