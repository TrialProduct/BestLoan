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
    private String path = "content://com.wl.atomsparenting.contentprovider/atomsparentingtable";
    private ContentResolver resolver;





    RoundCornerImageView main_img_views;
    TextView main_tv_name,main_tv_introduce;
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
        main_img_views= (RoundCornerImageView) mView.findViewById(R.id.main_img_views);
        main_tv_name= (TextView) mView.findViewById(R.id.main_tv_name);
        main_tv_introduce= (TextView) mView.findViewById(R.id.main_tv_introduce);

    }

    @Override
    public void bindBean(BaseBean baseBean) {

//        RequestQueue mQueue = Volley.newRequestQueue(getContext());
//        MyStringRequest stringRequest = new MyStringRequest("http://192.168.23.1:8889/SuperManBean",//"http://169.254.214.59:8889",
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.e("TarentoCard",response);
//                        try {
//                            JSONObject jo=new JSONObject(response);
//                            String strHeadPicUrl=jo.getString("strHeadPicUrl");
//                            String strName=jo.getString("strName");
//                            String strIntroduce=jo.getString("strIntroduce");
//
//                            main_tv_name.setText(strName);
//                            main_tv_introduce.setText(strIntroduce);
//                            Picasso.with(getContext())
//                                    .load(strHeadPicUrl)
//                                    .config(Bitmap.Config.RGB_565)
//                                    .fit().centerCrop()
//                                    .into(main_img_views);
//                        }
//                        catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("TarentoCard", "onErrorResponse" + error.getMessage(), error);
//                    }
//                });
//
//        mQueue.add(stringRequest);














        resolver = getContext().getContentResolver();
//        SharedPreferences share = getContext().getSharedPreferences("config4", Context.MODE_PRIVATE + Context.MODE_APPEND);
//
//        boolean b = share.getBoolean("is_first", true);
//        if (b) {
//            RequestQueue mQueue = Volley.newRequestQueue(getContext());
//            MyStringRequest stringRequest = new MyStringRequest("http://169.254.214.59:8889/SuperManBean",//"http://169.254.214.59:8889",
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            Log.e("SuperManBean",response);
//
//                            ContentValues contentvalues = new ContentValues();
//                            contentvalues.put(SQLiteColumn.JSONSTRING,response);
//                            contentvalues.put(SQLiteColumn.RECORDTYPE,"SuperManBean");
//                            resolver.insert(Uri.parse(path),contentvalues);
//                            try {
//                                JSONObject jo=new JSONObject(response);
//                                String strHeadPicUrl=jo.getString("strHeadPicUrl");
//                                String strName=jo.getString("strName");
//                                String strIntroduce=jo.getString("strIntroduce");
//
//                                main_tv_name.setText(strName);
//                                main_tv_introduce.setText(strIntroduce);
//                                Picasso.with(getContext())
//                                        .load(strHeadPicUrl)
//                                        .config(Bitmap.Config.RGB_565)
//                                        .fit().centerCrop()
//                                        .into(main_img_views);
//                            }
//                            catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Log.e("SuperManBean", "onErrorResponse" + error.getMessage(), error);
//                        }
//                    });
//            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
//                    (int) MyStringRequest.SOCKET_TIMEOUT, 0,
//                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//            mQueue.add(stringRequest);
     //       share.edit().putBoolean("is_first", false).commit();
//        }else {







        ArrayList<Data> dataArrayList = new ArrayList<>();
        Cursor cursor = resolver.query(Uri.parse(path),null,null,null,null);

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

                        main_tv_name.setText(strName);
                        main_tv_introduce.setText(strIntroduce);
                        Picasso.with(getContext())
                                .load(strHeadPicUrl)
                                .config(Bitmap.Config.RGB_565)
                                .fit().centerCrop()
                                .into(main_img_views);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }








        }

}
