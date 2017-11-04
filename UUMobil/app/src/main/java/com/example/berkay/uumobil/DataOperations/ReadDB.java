package com.example.berkay.uumobil.DataOperations;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.berkay.uumobil.results.Result;
import com.example.berkay.uumobil.transcript.Course;
import com.uumobilGet.FoodDatas.FoodMenu;

import java.util.ArrayList;

public final class ReadDB {
    private SQLiteDatabase db;

    public ReadDB(Context context) {
        db = new DBOpener(context).getReadableDatabase();
    }

    public FoodMenu[] readFoods(){

        FoodMenu[] foods = new FoodMenu[20];

        String[] columns = {DB_Tables.FOODLIST.getColumns()[1],
                DB_Tables.FOODLIST.getColumns()[2],
                DB_Tables.FOODLIST.getColumns()[3],
                DB_Tables.FOODLIST.getColumns()[4],
                DB_Tables.FOODLIST.getColumns()[5]};

        Cursor cur = db.query("FOODLIST", columns, null, null, null, null, null);

        int i = 0;
        while (cur.moveToNext()) {
            FoodMenu oneDay = new FoodMenu(cur.getString(0),cur.getString(1),
                    cur.getString(2), cur.getString(3), cur.getString(4));

            foods[i] = oneDay;
            i++;
        }

        cur.close();
        db.close();

        return foods;
    }

    public ArrayList<Result> readMarks(){
        ArrayList<Result> marks = new ArrayList<>();

        Cursor cursor = db.query(DB_Tables.RESULTS.getTableName(),
                DB_Tables.RESULTS.getColumns(),
                null, null, null, null, null);

        while (cursor.moveToNext()){
            Result result;
            String courseName = cursor.getString(0);
            String courseType = cursor.getString(1);
            String mark = cursor.getString(2);

            result = new Result(courseName, courseType, mark);

            marks.add(result);
        }


        cursor.close();
        db.close();

        return marks;
    }

    public String[] readHomeDatas(){
        String[] datas = new  String[6];
        final String[] columns = {DB_Tables.PERSONAL.getColumns()[1],
                DB_Tables.PERSONAL.getColumns()[2],
                DB_Tables.PERSONAL.getColumns()[3],
                DB_Tables.PERSONAL.getColumns()[4],
                DB_Tables.PERSONAL.getColumns()[5],
                DB_Tables.PERSONAL.getColumns()[6]};

        Cursor cursor = db.query(DB_Tables.PERSONAL.getTableName(),
                columns,
                null, null, null, null, null);

        cursor.moveToFirst();

        int i = 0;
        while (i < 6){
            datas[i] = cursor.getString(i);
            i++;
        }

        cursor.close();
        db.close();

        return datas;
    }

    public ArrayList<Course> readTranscript(){
        ArrayList<Course> marks = new ArrayList<>();

        Cursor cursor = db.query(DB_Tables.TRANSCRIPT.getTableName(),
                DB_Tables.TRANSCRIPT.getColumns(),
                null, null, null, null, null);

        while (cursor.moveToNext()){
            Course val = new Course(cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4));
            if (val.getDersKodu().equals("UU_Genel")){continue;}
            marks.add(val);
        }

        cursor.close();
        db.close();
        return marks;
    }

    public String[] readGano(){
        String[] values =  new String[2];
        String[] columns = {DB_Tables.TRANSCRIPT.getColumns()[3],
                            DB_Tables.TRANSCRIPT.getColumns()[4]};

        Cursor cursor = db.query(DB_Tables.TRANSCRIPT.getTableName(), columns,
                null, null, null, null, null);

        cursor.moveToLast();

        values[0] = cursor.getString(0);
        Log.i("readGano", values[0]);
        values[1] = cursor.getString(1);
        Log.i("readGano", values[1]);

        return values;
    }
}
