package com.example.btvd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    //khai bao cac tham so hang de tao database
    public static final String DBName="contact.db";
    public static final int DBVersion=1;
    public static final String TBName="tblContact";
    public static final String ID="id";
    public static final String ImgID = "imageID";
    public static  final  String Name="name";
    public static  final  String Phone="phone";

    public MyDBHelper(Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE "+ TBName + "(" + ID + " Integer Primary" + " Key Autoincrement," + ImgID + " Interger," + Name + " Text," + Phone +" Text);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //se duoc thuc hien khi phien ban Database duoc cap nhat
        //Xoa bang csdl va tao laij
        db.execSQL("DROP TABLE IF EXISTS " + TBName);
        onCreate(db);
    }
}
