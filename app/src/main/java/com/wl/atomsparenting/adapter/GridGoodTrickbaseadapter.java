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
import com.wl.atomsparenting.domain.GriddoGoodTrick;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/10.
 */

public class GridGoodTrickbaseadapter extends BaseAdapter {
    private ArrayList<GriddoGoodTrick> list;
    private LayoutInflater inflater;
    private Context context;

    public GridGoodTrickbaseadapter(ArrayList<GriddoGoodTrick> list, Context context) {
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
            view = inflater.inflate(R.layout.main_goodtrick, null);
            vh.main_imgimg = (ImageView) view.findViewById(R.id.main_imgimg);
            vh.main_tvtitle = (TextView) view.findViewById(R.id.main_tvtitle);
            vh.main_tvtvpeple = (TextView) view.findViewById(R.id.main_tvtvpeple);
            vh.main_tvname = (TextView) view.findViewById(R.id.main_tvname);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        GriddoGoodTrick gm = list.get(i);
        Picasso.with(context)
                                        .load(gm.getImg())
                                        .config(Bitmap.Config.RGB_565)
                                        .fit().centerCrop()
                                        .into(vh.main_imgimg);
        vh.main_tvtitle.setText(gm.getTitle());
        vh.main_tvname.setText(gm.getName());
        vh.main_tvtvpeple.setText(gm.getNumber() + "人感兴趣");
        return view;
    }

    class ViewHolder {
        ImageView main_imgimg;
        TextView main_tvtitle, main_tvtvpeple,main_tvname;
    }
}
