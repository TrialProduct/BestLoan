package com.wl.atomsparenting.cards;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wl.atomsparenting.R;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.contentprovider.Data;
import com.wl.atomsparenting.contentprovider.SQLiteColumn;
import com.wl.atomsparenting.views.RoundCornerImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/17.
 */

public class TarentoCard extends BaseCard {
    private String mpath = "content://com.wl.atomsparenting.contentprovider/atomsparentingtable";
    private ContentResolver mresolver;



    RoundCornerImageView mimg;
    TextView mtvname, mtvintroduce;
    public TarentoCard(@NonNull Context context) {
        super(context);
    }

    public TarentoCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getFindView() {
        return R.layout.tarentocard;
    }

    @Override
    protected void getMaterial() {
        mimg = (RoundCornerImageView) mView.findViewById(R.id.main_img_views);
        mtvname = (TextView) mView.findViewById(R.id.main_tv_name);
        mtvintroduce = (TextView) mView.findViewById(R.id.main_tv_introduce);

    }

    @Override
    public void bindBean(BaseBean baseBean) {


        mresolver = getContext().getContentResolver();


        ArrayList<Data> dataArrayList = new ArrayList<>();
        Cursor cursor = mresolver.query(Uri.parse(mpath),null,null,null,null);

        if (cursor!=null) {
            while (cursor.moveToNext()){
                String recordType = cursor.getString(cursor.getColumnIndex(SQLiteColumn.RECORDTYPE));
                String jsonString = cursor.getString(cursor.getColumnIndex(SQLiteColumn.JSONSTRING));
                Data data = new Data(recordType,jsonString);
                dataArrayList.add(data);
                if (cursor == null) {
                    break;
                }
            }

            for (int i = 0; i < dataArrayList.size(); i++) {

                if (dataArrayList.get(i).getRecordType().equals("superManBeen")) {

                    try {
                        JSONObject jo=new JSONObject(dataArrayList.get(i).getJsonString());
                        String strHeadPicUrl=jo.getString("strHeadPicUrl");
                        String strName=jo.getString("strName");
                        String strIntroduce=jo.getString("strIntroduce");

                        mtvname.setText(strName);
                        mtvintroduce.setText(strIntroduce);
                        Picasso.with(getContext())
                                .load(strHeadPicUrl)
                                .config(Bitmap.Config.RGB_565)
                                .fit().centerCrop()
                                .into(mimg);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }



        }

}
