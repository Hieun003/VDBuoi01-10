package com.example.btvd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private MyDBHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;
    public DBManager(Context context){
        this.context=context;
    }
    public DBManager open(){
        dbHelper = new MyDBHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        dbHelper.close();
    }
//    public long insContact(Mycontact contact){
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(dbHelper.Name,contact.getName());
//        contentValues.put();
//    }
}
