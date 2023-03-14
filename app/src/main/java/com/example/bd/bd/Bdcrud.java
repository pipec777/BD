package com.example.bd.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Bdcrud extends DBhelper{

    Context context;
    public Bdcrud(@Nullable Context context) {
        super(context);

        this.context = context;
    }

    public long insertardato(String placa , String modelo ,String color){

        long id =0;

        try {
            DBhelper database = new DBhelper(context);
            SQLiteDatabase db = database.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("placa", placa);
            values.put("modelo", modelo);
            values.put("color", color);

            id = db.insert(TABLE_CARRO, null,values);
        } catch (Exception ex){
            ex.toString();
        }
        return id ;
    }
}
