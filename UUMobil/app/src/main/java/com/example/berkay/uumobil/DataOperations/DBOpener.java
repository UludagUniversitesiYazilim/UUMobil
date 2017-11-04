package com.example.berkay.uumobil.DataOperations;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


final class DBOpener extends SQLiteOpenHelper {
    private final static String dbName = "UU_Data";

    DBOpener(Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String TAG = "DBOpener/Oncreate";

        db.execSQL(DB_Tables.FOODLIST.getQuery());
        Log.i(TAG, "Yemek listesi tablosu oluştuturuldu");

        db.execSQL(DB_Tables.RESULTS.getQuery());
        Log.i(TAG, "Sonuçlar tablosu oluşturuldu");

        db.execSQL(DB_Tables.PERSONAL.getQuery());
        Log.i(TAG, "Kişi tablosu oluşturuldu");

        db.execSQL(DB_Tables.TRANSCRIPT.getQuery());
        Log.i(TAG, "Transkript tablosu oluşturuldu");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int version_1, int version_2) {
        Log.d("MESSAGE", "onUpgrade çalıştı");

    }
}
