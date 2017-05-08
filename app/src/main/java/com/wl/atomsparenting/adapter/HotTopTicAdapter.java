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

public class HotTopTicAdapter extends BaseAdapter {
    private ArrayList<HotTopticBean> mArrayList;
    private LayoutInflater inflater;
    private Context mContext;

    public HotTopTicAdapter(ArrayList<HotTopticBean> mArrayList, Context mContext) {

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

            view = inflater.inflate(R.layout.ivhottoptic, null);
            vh.ivHotToptic = (ImageView) view.findViewById(R.id.ivHotToptic);
            vh.mTvHotTopticTitle = (TextView) view.findViewById(R.id.mTvHotTopticTitle);
            vh.mTvHotTopticLike = (TextView) view.findViewById(R.id.mTvHotTopticLike);
            vh.mTvHotTopticAssess = (TextView) view.findViewById(R.id.mTvHotTopticAssess);
            view.setTag(vh);

        } else {

            vh = (ViewHoder) view.getTag();

        }

        HotTopticBean hotTopticBean=mArrayList.get(i);

        vh.mTvHotTopticTitle.setText(hotTopticBean.getStrIntroduce());
        vh.mTvHotTopticLike.setText(hotTopticBean.getIntLike()+"");
        vh.mTvHotTopticAssess.setText(hotTopticBean.getIntAssess()+"");
        Picasso.with(mContext)
                .load(hotTopticBean.getStrBackPicUrl())
                .config(Bitmap.Config.RGB_565)
                .fit().centerCrop()
                .error(R.mipmap.ic_launcher)
                .into(vh.ivHotToptic);

        return view;
    }

    class ViewHoder {

        ImageView ivHotToptic;
        TextView mTvHotTopticTitle, mTvHotTopticLike, mTvHotTopticAssess;

    }
}
