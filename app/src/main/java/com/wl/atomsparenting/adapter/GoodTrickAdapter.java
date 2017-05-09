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

public class GoodTrickAdapter extends BaseAdapter {
    private ArrayList<GriddoGoodTrick> mArrayList;
    private LayoutInflater inflater;
    private Context mContext;

    public GoodTrickAdapter(ArrayList<GriddoGoodTrick> mArrayList, Context mContext) {
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

        ViewHolder vh = null;

        if (view == null) {

            vh = new ViewHolder();

            view = inflater.inflate(R.layout.main_goodtrick, null);
            vh.ivGoodTrick = (ImageView) view.findViewById(R.id.ivGoodTrick);
            vh.mTvGoodTrickTitle = (TextView) view.findViewById(R.id.mTvGoodTrickTitle);
            vh.mTvGoodTrickPeple = (TextView) view.findViewById(R.id.mTvGoodTrickPeple);
            vh.mTvGoodTrickName = (TextView) view.findViewById(R.id.mTvGoodTrickName);

            view.setTag(vh);
        } else {

            vh = (ViewHolder) view.getTag();

        }

        GriddoGoodTrick gm = mArrayList.get(i);
        Picasso.with(mContext)
                                        .load(gm.getImg())
                                        .config(Bitmap.Config.RGB_565)
                                        .fit().centerCrop()
                                        .into(vh.ivGoodTrick);
        vh.mTvGoodTrickTitle.setText(gm.getTitle());
        vh.mTvGoodTrickName.setText(gm.getName());
        vh.mTvGoodTrickPeple.setText(gm.getNumber() + "人感兴趣");

        return view;
    }

    class ViewHolder {
        ImageView ivGoodTrick;
        TextView mTvGoodTrickTitle, mTvGoodTrickPeple, mTvGoodTrickName;
    }
}
