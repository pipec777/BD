package com.example.bd.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="pruebita.db";
    public String TABLE_CARRO="t_carro";

    public DBhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CARRO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "placa TEXT NOT NULL," +
                "modelo TEXT NOT NULL," +
                "color TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_CARRO);
        onCreate(sqLiteDatabase);

    }
}
