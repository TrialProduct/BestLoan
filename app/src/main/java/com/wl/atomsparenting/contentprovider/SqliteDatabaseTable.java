package com.wl.atomsparenting.contentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by le on 2017/4/28.
 */

public class SqliteDatabaseTable {
    private static SqliteDatabaseTable databaseTable;
    private SqliteopenHelper sqliteopenHelper;

    private SqliteDatabaseTable(Context context){
        sqliteopenHelper = new SqliteopenHelper(context);
    }

    public static synchronized SqliteDatabaseTable getInstance(Context context){
        if (databaseTable == null) {
            databaseTable = new SqliteDatabaseTable(context);
        }

        return databaseTable;
    }

    //增
    public void addData(Data data){
        SQLiteDatabase database = null;

        try {
            database = sqliteopenHelper.getReadableDatabase();

            ContentValues contentValues=new ContentValues();
            contentValues.put(SQLiteColumn.RECORDTYPE,data.getRecordType());
            contentValues.put(SQLiteColumn.JSONSTRING,data.getJsonString());
            database.insert(SQLiteColumn.DATA_TABLE,null,contentValues);

        }catch (Exception e){

        }finally {
            sqliteopenHelper.closeSqliteDatabase(database);
        }
    }

    //查
    public ArrayList<Data> queryData(){
        ArrayList<Data> dataArrayList = new ArrayList<>();

        Cursor cursor = null;
        SQLiteDatabase database = null;
        try {
            database = sqliteopenHelper.getReadableDatabase();

            cursor = database.query(SQLiteColumn.DATA_TABLE,null,null,null,null,null,null);
            if (cursor!=null) {
                while (cursor.moveToNext()) {
                    String recordType = cursor.getString(cursor.getColumnIndex(SQLiteColumn.RECORDTYPE));
                    String JsonString = cursor.getString(cursor.getColumnIndex(SQLiteColumn.JSONSTRING));
                    Data data = new Data(recordType,JsonString);
                    dataArrayList.add(data);
                }
            }
        }catch (Exception e){

        }finally {
            sqliteopenHelper.closeCurAndSqlite(database,cursor);
        }

        return dataArrayList;
    }

    //删
    public boolean deleteData(String JsonString){
        SQLiteDatabase database = null;
        try {
            database = sqliteopenHelper.getReadableDatabase();

            int length = database.delete(SQLiteColumn.DATA_TABLE,"JsonString='"+JsonString+"'",null);
            if (length!=0) {
                return true;
            }
        }catch (Exception e){

        }finally {
            sqliteopenHelper.closeSqliteDatabase(database);
        }

        return false;
    }

    //改
    public boolean updateData(String recordType,String JsonString){
        SQLiteDatabase database = null;
        try {
            database = sqliteopenHelper.getReadableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(SQLiteColumn.RECORDTYPE,recordType);
            contentValues.put(SQLiteColumn.JSONSTRING,JsonString);
            int length = database.update(SQLiteColumn.DATA_TABLE,contentValues,"recordType='"+recordType+"'",null);
            if (length>0) {
                return true;
            }
        }catch (Exception e){

        }finally {
            sqliteopenHelper.closeSqliteDatabase(database);
        }

        return false;
    }

}
