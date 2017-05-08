package com.wl.atomsparenting.cards;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.squareup.picasso.Picasso;
import com.wl.atomsparenting.R;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.contentprovider.Data;
import com.wl.atomsparenting.contentprovider.SQLiteColumn;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/17.
 */

public class RollPagerViewCard extends BaseCard {
    private String mpath = "content://com.wl.atomsparenting.contentprovider/atomsparentingtable";
    private ContentResolver mresolver;

    private RollPagerView mrollPV = null;
    private ArrayList<String> mlistRollpager;
    private RollPagerAdapter mroll;
    public RollPagerViewCard(@NonNull Context context) {
        super(context);
    }

    public RollPagerViewCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getFindView() {
        return R.layout.rollpagerviewcard;
    }

    @Override
    protected void getMaterial() {
        //轮播
        mrollPV = (RollPagerView) mView.findViewById(R.id.goodtrick_rollPV);
        //设置每个图片的切换时间
        mrollPV.setPlayDelay(3000);
        //设置图片切换动画时间
        mrollPV.setAnimationDurtion(500);
        //设置指示器:
        //rollPV.setHintView(new IconHintView());
        //rollPV.setHintView(new IconHintView(this,R.mipmap.ic_launcher,R.mipmap.ic_launcher));
        mrollPV.setHintView(new ColorPointHintView(mContext, getResources().getColor(R.color.colorrollpagerView), R.color.colorView));

        //设置每一个图片的点击事件
//        rollPV.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                Toast.makeText(SecondActivity.this, "点击了图片"+position, Toast.LENGTH_SHORT).show();
//
//            }
//        });
        //设置适配器
        mlistRollpager=new ArrayList<>();
        mroll=new RollPagerAdapter(mlistRollpager);
        mrollPV.setAdapter(mroll);
    }

    @Override
    public void bindBean(BaseBean baseBean) {


        mresolver = getContext().getContentResolver();



        ArrayList<Data> dataArrayList = new ArrayList<>();
        Cursor cursor = mresolver.query(Uri.parse(mpath), null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String recordType = cursor.getString(cursor.getColumnIndex(SQLiteColumn.RECORDTYPE));
                String jsonString = cursor.getString(cursor.getColumnIndex(SQLiteColumn.JSONSTRING));
                Data data = new Data(recordType, jsonString);
                dataArrayList.add(data);
                if (cursor == null) {
                    break;
                }
            }

            for (int j = 0; j < dataArrayList.size(); j++) {

                if (dataArrayList.get(j).getRecordType().equals("mainRollpagerBeen")) {

                    try {
                        mlistRollpager.clear();
                        JSONArray jsonArray=new JSONArray(dataArrayList.get(j).getJsonString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jo=jsonArray.getJSONObject(i);
                            String strPicUrl=jo.getString("strPicUrl");
                            mlistRollpager.add(strPicUrl);

                        }
                        mroll.notifyDataSetChanged();

                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }


        }




    }

    //适配器
    private class RollPagerAdapter extends StaticPagerAdapter {
        ArrayList<String> listRollpager;
        ImageView view;
        public RollPagerAdapter(ArrayList<String> listRollpager) {
            this.listRollpager = listRollpager;
        }


        @Override
        public View getView(ViewGroup container, int position) {


            //设置图片资源

                 view = new ImageView(container.getContext());
                Picasso.with(getContext())
                        .load(listRollpager.get(position))
                        .config(Bitmap.Config.RGB_565)
                        .fit().centerCrop()
                        .into(view);


            //设置高度和宽度
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            //设置拉伸方式
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);

            return view;
        }

        @Override
        public int getCount() {
            return listRollpager.size();
        }
    }
}
