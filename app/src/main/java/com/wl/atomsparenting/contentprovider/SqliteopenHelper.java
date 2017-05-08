package com.wl.atomsparenting.contentprovider;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by le on 2017/4/28.
 */

public class SqliteopenHelper extends SQLiteOpenHelper{
    public static final int VEISION = 1;
    public static final String SQLITE_NAME = "Atomsparenting";

    public SqliteopenHelper(Context context) {
        super(context, SQLITE_NAME, null, VEISION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createTable(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void createTable(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("create table atomsparentingtable(_id INTEGER primary key autoincrement,recordType text,JsonString text)");
    }

    public void closeCursor(Cursor cursor){
        if (cursor == null) {
            return;
        }
        cursor.close();
    }

    public void closeSqliteDatabase (SQLiteDatabase sqLiteDatabase){
        if (sqLiteDatabase == null) {
            return;
        }
        sqLiteDatabase.close();
    }

    public void closeCurAndSqlite(SQLiteDatabase sqLiteDatabase,Cursor cursor){
        closeCursor(cursor);
        closeSqliteDatabase(sqLiteDatabase);
    }
}
