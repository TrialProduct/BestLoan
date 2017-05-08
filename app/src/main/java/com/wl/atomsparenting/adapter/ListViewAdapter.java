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
import com.wl.atomsparenting.domain.HotTopticBean;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/12.
 */

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<HotTopticBean> list;
    private LayoutInflater inflater;
    private Context context;

    public ListViewAdapter(ArrayList<HotTopticBean> list, Context context) {
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
            view = inflater.inflate(R.layout.maintoptic_listview, null);
            vh.maingong_listimg = (ImageView) view.findViewById(R.id.maingong_listimg);
            vh.maingong_tv= (TextView) view.findViewById(R.id.maingong_tv);
            vh.tvlike= (TextView) view.findViewById(R.id.tvlike);
            vh.tvassess= (TextView) view.findViewById(R.id.tvassess);
            view.setTag(vh);
        } else {
            vh = (ViewHoder) view.getTag();
        }
        HotTopticBean hotTopticBean=list.get(i);
        vh.maingong_tv.setText(hotTopticBean.getStrIntroduce());
        vh.tvlike.setText(hotTopticBean.getIntLike()+"");
        vh.tvassess.setText(hotTopticBean.getIntAssess()+"");
        Picasso.with(context)
                .load(hotTopticBean.getStrBackPicUrl())
                .config(Bitmap.Config.RGB_565)
                .fit().centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(vh.maingong_listimg);

        return view;
    }

    class ViewHoder {
        ImageView maingong_listimg;
        TextView maingong_tv,tvlike,tvassess;

    }
}
