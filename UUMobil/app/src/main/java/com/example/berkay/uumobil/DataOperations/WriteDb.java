package com.example.berkay.uumobil.DataOperations;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.uumobilGet.ConnectWebPersonal;
import com.uumobilGet.FoodDatas.FoodMenu;
import com.uumobilGet.FoodDatas.ParseFoodList;
import com.uumobilGet.PageLinks;
import com.uumobilGet.PersonalDatas.ParseHomeDatas;
import com.uumobilGet.PersonalDatas.ParseMarks;
import com.uumobilGet.PersonalDatas.ParseTranscript;

import org.jsoup.nodes.Document;

import java.util.ArrayList;

final class WriteDb {

    private SQLiteDatabase UU_data;
    private ConnectWebPersonal personalConnection;

    WriteDb(Context context) {
        UU_data = new DBOpener(context).getWritableDatabase();
    }

    void closeDB(){
        UU_data.close();
    }

    private void clearTable(DB_Tables table){
        UU_data.execSQL("DELETE FROM "+ table.getTableName());
    }

    void writeFoodList(){
        final String TAG = "WriteDB/writeFoodList";

        clearTable(DB_Tables.FOODLIST); // Deleting the table indexes on every usage!

        ParseFoodList foodList = new ParseFoodList(PageLinks.FOODLIST.getUrl());
        Document doc = foodList.getDoc();
        Log.i(TAG, "İnternet verileri başarıyla alındı.");

        String[] columns = DB_Tables.FOODLIST.getColumns();

        int i = 0;
        FoodMenu food;
        while (i < 5) { // 5 günlük veri alınacak.

            /*if (i >= 0 && i < 5) {
                food = foodList.getLunch(doc, i);
                values.put(columns[1], "lunch_normal");
            }else if ((i >= 5 && i < 10)){
                food = foodList.getLunchVegeterian(doc, i%5);
                values.put(columns[1], "lunch_vegeterian");
            }else if ((i >= 10 && i < 15)){
                food = foodList.getDinner(doc, i%5);
                values.put(columns[1], "dinner_normal");
            }else if ((i >= 15 && i < 20)){
                food = foodList.getDinnerVegeterian(doc, i%5);
                values.put(columns[1], "dinner_vegetarian");
            }else{
                food = foodList.getLunch(doc, i%5);
            }

            // Add foods and date.
            values.put(columns[2], food.getDay());
            values.put(columns[3], food.getCorba());
            values.put(columns[4], food.getAnaYemek());
            values.put(columns[5], food.getYardimciYemek());
            values.put(columns[6], food.getYanOge());*/

            clearTable(DB_Tables.FOODLIST);

            FoodMenu[] foods = {foodList.getLunch(doc, i), foodList.getLunchVegeterian(doc, i),
                    foodList.getDinner(doc, i), foodList.getDinnerVegeterian(doc, i)};
            int j = 0;
            while (j < 4){ // 4 veri alınacak!

                ContentValues values = new ContentValues();
                values.put(columns[1], foods[j].getDay());
                values.put(columns[2], foods[j].getCorba());
                values.put(columns[3], foods[j].getAnaYemek());
                values.put(columns[4], foods[j].getYardimciYemek());
                values.put(columns[5], foods[j].getYanOge());

                UU_data.insert(DB_Tables.FOODLIST.getTableName(), null, values);

                j++;
            }
            i++;
        }
        Log.i(TAG, "Veriler veritabanına yazdırıldı!");
    }

    void writeResults(ConnectWebPersonal connection){ // TODO: 2 bağlantı yapıyor.
        try {
            String TAG = "WriteDb/writeResults";

            clearTable(DB_Tables.RESULTS);

            ParseMarks Object = new ParseMarks(connection);
            Log.i(TAG, "Bağlantı sağlandı. Veriler alındı.");

            ArrayList<String[]> marks = Object.getMarks();
            Log.i(TAG, "Veriler alındı");

            int foo = 0;
            if (marks.size() == 0) {
                for (String[] mark : marks) {
                    ContentValues values = new ContentValues();
                    values.put(DB_Tables.RESULTS.getColumns()[0], mark[0].substring(1, mark[0].length())); // TODO: Bu işlem GetWebDatas'da yapılacak
                    values.put(DB_Tables.RESULTS.getColumns()[1], mark[1]);
                    values.put(DB_Tables.RESULTS.getColumns()[2], mark[2]);

                    UU_data.insert(DB_Tables.RESULTS.getTableName(), null, values);
                    foo++;
                }

                Log.i(TAG, foo + " not veritabanına eklendi.");
            }
        }catch (Exception e){ // TODO: Hata GetWebDatas'dan düzeltilmeli.
               Log.i("TAG", "Veriler alınmadı");
        }
    }

    void writePersonal(ConnectWebPersonal connection){
        final String TAG = "WriteDB/writePersonal";
        ParseHomeDatas personalInfo = new ParseHomeDatas(connection);
        Log.i(TAG, "Web bilgileri alındı.");

        ContentValues values = new ContentValues();

        values.put(DB_Tables.PERSONAL.getColumns()[1], personalInfo.getName());
        values.put(DB_Tables.PERSONAL.getColumns()[2], personalInfo.getNumber());
        values.put(DB_Tables.PERSONAL.getColumns()[3], personalInfo.getPeriod());
        values.put(DB_Tables.PERSONAL.getColumns()[4], personalInfo.getUnitName());
        values.put(DB_Tables.PERSONAL.getColumns()[5], personalInfo.getStatue());
        values.put(DB_Tables.PERSONAL.getColumns()[6], personalInfo.getDateLogin());


        clearTable(DB_Tables.PERSONAL);
        UU_data.insert(DB_Tables.PERSONAL.getTableName(), null, values);
        Log.i(TAG, "Bilgiler veritabanına eklendi");

    }

    void writeTranscript(ConnectWebPersonal connection){
        final String TAG = "WriteDB/writeTranscript";
        final String[] columns = DB_Tables.TRANSCRIPT.getColumns();
        ParseTranscript transcript = new ParseTranscript(connection);
        Log.i(TAG, "Transcript Bilgileri Alındı.");

        ArrayList<String[]> markList = transcript.getLessons();

        for (String[] lesson : markList){
            ContentValues values = new ContentValues();

            values.put(columns[1], lesson[0]); // Ders Kodu
            values.put(columns[2], lesson[1]); // Ders Adı
            values.put(columns[3], lesson[2]); // Kredi
            values.put(columns[4], lesson[3]); // Not

            UU_data.insert(DB_Tables.TRANSCRIPT.getTableName(), null, values);
            Log.i(TAG, lesson[0] + " - " + lesson[1] + " verisi alındı!");
        }

        ContentValues values = new ContentValues();

        values.put(columns[1], "UU_Genel"); // Ders Kodu
        values.put(columns[2], "genel"); // Ders Adı
        values.put(columns[3], transcript.getAvrg()[0]); // Kredi
        values.put(columns[4], transcript.getAvrg()[1]); // Not

        UU_data.insert(DB_Tables.TRANSCRIPT.getTableName(), null, values);

        Log.i(TAG, "Tüm veriler yazıldı.");

    }


}
