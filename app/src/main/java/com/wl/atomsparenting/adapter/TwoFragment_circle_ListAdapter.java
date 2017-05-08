package com.wl.atomsparenting.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wl.atomsparenting.R;
import com.wl.atomsparenting.domain.CircleBean;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/14.
 */

public class TwoFragment_circle_ListAdapter extends BaseAdapter {
    private ArrayList<CircleBean> list;
    private Context context;
    private LayoutInflater inflater;

    public TwoFragment_circle_ListAdapter(ArrayList<CircleBean> list, Context context) {
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
        ViewHolder vh = null;
        if (view == null) {
            vh = new ViewHolder();
            view = inflater.inflate(R.layout.circleitem, null);
            vh.circle_roundCornerImageView = (ImageView) view.findViewById(R.id.circle_roundCornerImageView);
            vh.circle_title= (TextView) view.findViewById(R.id.circle_title);
            vh.circleposts= (TextView) view.findViewById(R.id.circleposts);
            vh.circleintroduce= (TextView) view.findViewById(R.id.circleintroduce);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        CircleBean circleBean=list.get(i);
        vh.circle_title.setText(circleBean.getStrListTitle());
        vh.circleposts.setText(circleBean.getIntListPosts()+"");
        vh.circleintroduce.setText(circleBean.getStrListIntroduce());

        Picasso.with(context)
                .load(circleBean.getStrListPicUrl())
                .config(Bitmap.Config.RGB_565)
                .fit().centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(vh.circle_roundCornerImageView);
        return view;
}

    class ViewHolder {
        ImageView circle_roundCornerImageView;
        TextView circle_title,circleposts,circleintroduce;
    }
}
