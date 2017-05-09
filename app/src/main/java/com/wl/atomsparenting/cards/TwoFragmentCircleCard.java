package com.wl.atomsparenting.cards;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.wl.atomsparenting.R;
import com.wl.atomsparenting.adapter.SecondFragment_circle_ListAdapter;
import com.wl.atomsparenting.beans.BaseBean;
import com.wl.atomsparenting.contentprovider.Data;
import com.wl.atomsparenting.contentprovider.SQLiteColumn;
import com.wl.atomsparenting.domain.CircleBean;
import com.wl.atomsparenting.views.CursorListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/17.
 */

public class TwoFragmentCircleCard extends BaseCard {
    private String path = "content://com.wl.atomsparenting.contentprovider/atomsparentingtable";
    private ContentResolver resolver;

    private CursorListView listview;
    private ArrayList<CircleBean> list;
    private SecondFragment_circle_ListAdapter tql;

    public TwoFragmentCircleCard(@NonNull Context context) {
        super(context);
    }

    public TwoFragmentCircleCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getFindView() {
        return R.layout.twofragment_circle;
    }

    @Override
    protected void getMaterial() {
        listview = (CursorListView) mView.findViewById(R.id.twofragment_circle_listview);
        list = new ArrayList<>();
        tql = new SecondFragment_circle_ListAdapter(list, mContext);
        listview.setAdapter(tql);

    }

    @Override
    public void bindBean(BaseBean baseBean) {

//        RequestQueue mQueue = Volley.newRequestQueue(getContext());
//        MyStringRequest stringRequest = new MyStringRequest("http://192.168.23.1:8889/CircleBean",//"http://169.254.214.59:8889",
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.e("TwoFragmentCircleCard",response);
//                        try {
//                            list.clear();
//                            JSONArray jsonArray=new JSONArray(response);
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject jo=jsonArray.getJSONObject(i);
//                                String strListPicUrl=jo.getString("strListPicUrl");
//                                String strListTitle=jo.getString("strListTitle");
//                                String strListIntroduce=jo.getString("strListIntroduce");
//                                int intListPosts=jo.getInt("intListPosts");
//                                CircleBean circleBean=new CircleBean(strListPicUrl,strListTitle,intListPosts,strListIntroduce);
//                                list.add(circleBean);
//                            }
//
//                            tql.notifyDataSetChanged();
//
//                        }
//                        catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("TwoFragmentCircleCard", "onErrorResponse" + error.getMessage(), error);
//                    }
//                });
//
//        mQueue.add(stringRequest);















        resolver = getContext().getContentResolver();
//        SharedPreferences share = getContext().getSharedPreferences("config7", Context.MODE_PRIVATE + Context.MODE_APPEND);
//
//        boolean b = share.getBoolean("is_first", true);
//        if (b) {
//            RequestQueue mQueue = Volley.newRequestQueue(getContext());
//            MyStringRequest stringRequest = new MyStringRequest("http://169.254.214.59:8889/CircleBean",//"http://169.254.214.59:8889",
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            Log.e("CircleBean", response);
//
//                            ContentValues contentvalues = new ContentValues();
//                            contentvalues.put(SQLiteColumn.JSONSTRING, response);
//                            contentvalues.put(SQLiteColumn.RECORDTYPE, "CircleBean");
//                            resolver.insert(Uri.parse(path), contentvalues);
//                            JSONArray jsonArray = null;
//                            try {
//                                list.clear();
//                                jsonArray = new JSONArray(response);
//                                for (int i = 0; i < jsonArray.length(); i++) {
//                                    JSONObject jo=jsonArray.getJSONObject(i);
//                                    String strListPicUrl=jo.getString("strListPicUrl");
//                                    String strListTitle=jo.getString("strListTitle");
//                                    String strListIntroduce=jo.getString("strListIntroduce");
//                                    int intListPosts=jo.getInt("intListPosts");
//                                    CircleBean circleBean=new CircleBean(strListPicUrl,strListTitle,intListPosts,strListIntroduce);
//                                    list.add(circleBean);
//                                }
//
//                                tql.notifyDataSetChanged();
//
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
//                            Log.e("CircleBean", "onErrorResponse" + error.getMessage(), error);
//                        }
//                    });
//            stringRequest.setRetryPolicy(new DefaultRetryPolicy(
//                    (int) MyStringRequest.SOCKET_TIMEOUT, 0,
//                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//            mQueue.add(stringRequest);
          //  share.edit().putBoolean("is_first", false).commit();
//        } else {







        ArrayList<Data> dataArrayList = new ArrayList<>();
        Cursor cursor = resolver.query(Uri.parse(path), null, null, null, null);

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

                if (dataArrayList.get(j).getRecordType().equals("circleBeen")) {

                    JSONArray jsonArray = null;
                    try {
                        list.clear();
                        jsonArray = new JSONArray(dataArrayList.get(j).getJsonString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jo=jsonArray.getJSONObject(i);
                            String strListPicUrl=jo.getString("strListPicUrl");
                            String strListTitle=jo.getString("strListTitle");
                            String strListIntroduce=jo.getString("strListIntroduce");
                            int intListPosts=jo.getInt("intListPosts");
                            CircleBean circleBean=new CircleBean(strListPicUrl,strListTitle,intListPosts,strListIntroduce);
                            list.add(circleBean);
                        }

                        tql.notifyDataSetChanged();

                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }


        }






    }

}
