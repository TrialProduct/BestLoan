package com.wl.atomsparenting.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.wl.atomsparenting.MD5.MD5Util;
import com.wl.atomsparenting.R;
import com.wl.atomsparenting.contentprovider.SQLiteColumn;
import com.wl.atomsparenting.contentprovider.SqliteDatabaseTable;
import com.wl.atomsparenting.contentprovider.SqliteReadDataUtil;
import com.wl.atomsparenting.views.MyStringRequest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by le on 2017/4/7.
 */

public class WelcomeActivity extends Activity {
    private String path = "content://com.wl.atomsparenting.contentprovider/atomsparentingtable";
    private ContentResolver resolver;
    private SqliteDatabaseTable databaseTable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomeactivity);
        databaseTable = SqliteDatabaseTable.getInstance(this);
        resolver = getContentResolver();
        //获取共享参数存储对象
        SharedPreferences sp = getSharedPreferences("count", Context.MODE_PRIVATE+Context.MODE_APPEND);

        //获取count文件下的appcount的值
        int i = sp.getInt("appcount",0);
        //获取编辑对象
        if (i==0)
        {

            initFirstData();
        }else {
            initUpdata();
        }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent mainIntent = new Intent(WelcomeActivity.this, HomeActivity.class);
                    WelcomeActivity.this.startActivity(mainIntent);

                    overridePendingTransition(R.anim.zoomout, R.anim.zoomin);

                    WelcomeActivity.this.finish();

                }
            }, 2500);
    }



    private void initFirstData() {
        RequestQueue mQueue = Volley.newRequestQueue(this);



        MyStringRequest stringRequest = new MyStringRequest("http://192.168.23.1:8889/AllData",//"http://169.254.214.59:8889",


                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("SQlite -- AllFirstData --",response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String circleBeen = jsonObject.getString("circleBeen");
                            String hotCoupBeen = jsonObject.getString("hotCoupBeen");
                            String hotTopticBeen = jsonObject.getString("hotTopticBeen");
                            String mainRollpagerBeen = jsonObject.getString("mainRollpagerBeen");
                            String microBeen = jsonObject.getString("microBeen");
                            String superManBeen = jsonObject.getString("superManBeen");
                            String mainRollpagermicroBeen = jsonObject.getString("mainRollpagermicroBeen");

                            ContentValues contentvalues = new ContentValues();
                            contentvalues.put(SQLiteColumn.JSONSTRING, response);
                            contentvalues.put(SQLiteColumn.RECORDTYPE, "allData");
                            resolver.insert(Uri.parse(path), contentvalues);

                            ContentValues contentvalues1 = new ContentValues();
                            contentvalues1.put(SQLiteColumn.JSONSTRING, circleBeen);
                            contentvalues1.put(SQLiteColumn.RECORDTYPE, "circleBeen");
                            resolver.insert(Uri.parse(path), contentvalues1);
                            Log.e("SQlite -- circleBeen --",circleBeen);
                            ContentValues contentvalues2 = new ContentValues();
                            contentvalues2.put(SQLiteColumn.JSONSTRING, hotCoupBeen);
                            contentvalues2.put(SQLiteColumn.RECORDTYPE, "hotCoupBeen");
                            resolver.insert(Uri.parse(path), contentvalues2);

                            ContentValues contentvalues3 = new ContentValues();
                            contentvalues3.put(SQLiteColumn.JSONSTRING, hotTopticBeen);
                            contentvalues3.put(SQLiteColumn.RECORDTYPE, "hotTopticBeen");
                            resolver.insert(Uri.parse(path), contentvalues3);

                            ContentValues contentvalues4 = new ContentValues();
                            contentvalues4.put(SQLiteColumn.JSONSTRING, mainRollpagerBeen);
                            contentvalues4.put(SQLiteColumn.RECORDTYPE, "mainRollpagerBeen");
                            resolver.insert(Uri.parse(path), contentvalues4);

                            ContentValues contentvalues5 = new ContentValues();
                            contentvalues5.put(SQLiteColumn.JSONSTRING, microBeen);
                            contentvalues5.put(SQLiteColumn.RECORDTYPE, "microBeen");
                            resolver.insert(Uri.parse(path), contentvalues5);

                            ContentValues contentvalues6 = new ContentValues();
                            contentvalues6.put(SQLiteColumn.JSONSTRING, superManBeen);
                            contentvalues6.put(SQLiteColumn.RECORDTYPE, "superManBeen");
                            resolver.insert(Uri.parse(path), contentvalues6);

                            ContentValues contentvalues7 = new ContentValues();
                            contentvalues7.put(SQLiteColumn.JSONSTRING, mainRollpagermicroBeen);
                            contentvalues7.put(SQLiteColumn.RECORDTYPE, "mainRollpagermicroBeen");
                            resolver.insert(Uri.parse(path), contentvalues7);
                            Log.e("SQlite -- mainRollpagermicroBeen --",mainRollpagermicroBeen);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("SQlite -- AllFirstData --", "onErrorResponse" + error.getMessage(), error);
                    }
                });


        mQueue.add(stringRequest);
    }


    private void initUpdata() {
        String str = SqliteReadDataUtil.getSqliteData("allData",resolver);
        String strMD5 = MD5Util.encrypt(str);
        RequestQueue mQueue = Volley.newRequestQueue(this);
        MyStringRequest stringRequest = new MyStringRequest("http://192.168.23.1:8889/AllData?MD5="+strMD5,//"http://169.254.214.59:8889",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("SQlite -- AllUpdataData --",response);

                        if (response == null) {
                            return;
                        }
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String circleBeen = jsonObject.getString("circleBeen");
                            String hotCoupBeen = jsonObject.getString("hotCoupBeen");
                            String hotTopticBeen = jsonObject.getString("hotTopticBeen");
                            String mainRollpagerBeen = jsonObject.getString("mainRollpagerBeen");
                            String microBeen = jsonObject.getString("microBeen");
                            String superManBeen = jsonObject.getString("superManBeen");
                            String mainRollpagermicroBeen = jsonObject.getString("mainRollpagermicroBeen");



                            databaseTable.updateData("circleBeen",circleBeen);
                            Log.e("SQlite -- circleBeen --",circleBeen);


                            databaseTable.updateData("hotCoupBeen",hotCoupBeen);



                            databaseTable.updateData("hotTopticBeen",hotTopticBeen);



                            databaseTable.updateData("mainRollpagerBeen",mainRollpagerBeen);



                            databaseTable.updateData("microBeen",microBeen);



                            databaseTable.updateData("superManBeen",superManBeen);



                            databaseTable.updateData("mainRollpagermicroBeen",mainRollpagermicroBeen);
                            Log.e("SQlite -- mainRollpagermicroBeen --",mainRollpagermicroBeen);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("SQlite -- AllUpdataData --", "onErrorResponse" + error.getMessage(), error);
                    }
                });


        mQueue.add(stringRequest);
    }


}
