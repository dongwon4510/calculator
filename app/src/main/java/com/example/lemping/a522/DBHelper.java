package com.example.lemping.a522;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lemping on 2017-05-23.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE SIGN (id TEXT, pw TEXT);");
        db.execSQL("CREATE TABLE OP (output TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String id, String pw) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO SIGN VALUES ('" + id + "','" + pw + "');");
        db.close();
    }
    public void insert2(String output) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO OP VALUES ('" + output + "');");
        db.close();
    }

    public void delete(String output) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM OP WHERE '" + output + "';");
        db.close();
    }

    public String select() {
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM OP", null);
        while (cursor.moveToNext()) {
            result += cursor.getString(0)
                    + " " + "\n";
        }
        return result;
    }
}