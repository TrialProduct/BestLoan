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
import com.wl.atomsparenting.domain.MicroBean;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/14.
 */

public class ThridListViewItem extends BaseAdapter {
    private ArrayList<MicroBean> list;
    private LayoutInflater inflater;
    private Context context;

    public ThridListViewItem(ArrayList<MicroBean> list, Context context) {
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
            view = inflater.inflate(R.layout.thrid_recyclerview_item, null);
            vh.thrid_item_img = (ImageView) view.findViewById(R.id.thrid_item_img);
            vh.thrid_item_title= (TextView) view.findViewById(R.id.thrid_item_title);
            vh.thrid_item_time= (TextView) view.findViewById(R.id.thrid_item_time);
            vh.thrid_item_money= (TextView) view.findViewById(R.id.thrid_item_money);
            vh.thrid_item_pep= (TextView) view.findViewById(R.id.thrid_item_pep);

            view.setTag(vh);

        } else {

            vh = (ViewHoder) view.getTag();
        }

        MicroBean microBean=list.get(i);
        vh.thrid_item_title.setText(microBean.getStrListTitle());
        vh.thrid_item_time.setText(microBean.getStrDate());
        vh.thrid_item_money.setText("¥ "+microBean.getIntPrice()+".00");
        vh.thrid_item_pep.setText(microBean.getIntAssess()+"人学过");

        Picasso.with(context)
                .load(microBean.getStrListPicUrl())
                .config(Bitmap.Config.RGB_565)
                .fit().centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(vh.thrid_item_img);

        return view;
    }

    class ViewHoder {
        ImageView thrid_item_img;
        TextView thrid_item_title,thrid_item_time,thrid_item_money,thrid_item_pep;

    }
}
