package com.example.berkay.uumobil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ImageView homeTab;
    ImageView markTab;
    ImageView tabTimeTable;
    ImageView tabCalendar;
    ImageView tabFoodList;
    ImageView tabLogOut;
    ImageView oncekiTab;
    View oncekiView;
    ListView notListView;

    List<Not> notlar=new ArrayList<Not>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillTabArray();
        oncekiTab = homeTab;
        oncekiView = findViewById(R.id.homeView);

        notlar.add(new Not("AA", "Matematik", 40, 70, 0));
        notlar.add(new Not("BA", "Algoritma", 40, 40, 100));
        notlar.add(new Not("CD", "Lineer Cebir", 20, 37, 80));
        notlar.add(new Not("CC", "Kimya", 19, 0, 0));
        notlar.add(new Not("BA", "Hukuka Giris", 79, 70, 0));
        notlar.add(new Not("FF", "Biyoloji", 100, 70, 0));
        notlar.add(new Not("DC", "Felsefe", 40, 10, 41));
        notlar.add(new Not("CC", "Ingilizce", 20, 90, 0));

        notListView = (ListView) findViewById(R.id.notlar);
        NotAdaptor adaptor = new NotAdaptor(this, notlar);
        notListView.setAdapter(adaptor);

    }

    public void open_screen(View view){
        ImageView item = (ImageView) view;
        View mainView;

        oncekiTab.setBackgroundResource(R.color.colorPrimary);
        item.setBackgroundResource(R.color.colorAccent);
        oncekiTab = item;


        switch (item.getId()){

            case (R.id.menu_home):
                mainView = findViewById(R.id.homeView);
                break;

            case (R.id.menu_marks):
                mainView = findViewById(R.id.markView);
                break;

            case (R.id.menu_timetable):
                mainView = findViewById(R.id.timetableView);
                break;

            case (R.id.menu_calender):
                mainView = findViewById(R.id.calendarView);
                break;

            case (R.id.menu_foodlist):
                mainView = findViewById(R.id.foodlistView);
                break;

            case (R.id.menu_logout):
                finish();
                return;

            default:
                mainView = null;
        }

        oncekiView.setVisibility(View.INVISIBLE);
        assert mainView != null;
        mainView.setVisibility(View.VISIBLE);
        oncekiView = mainView;

    }

    private void fillTabArray(){

        homeTab = (ImageView) findViewById(R.id.menu_home);
        markTab = (ImageView) findViewById(R.id.menu_marks);
        tabTimeTable = (ImageView) findViewById(R.id.menu_timetable);
        tabCalendar = (ImageView) findViewById(R.id.menu_calender);
        tabFoodList = (ImageView) findViewById(R.id.menu_foodlist);
        tabLogOut = (ImageView) findViewById(R.id.menu_logout);

    }

}
