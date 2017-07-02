package com.example.berkay.uumobil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    ImageView homeTab;
    ImageView markTab;
    ImageView tabTimeTable;
    ImageView tabCalendar;
    ImageView tabFoodList;
    ImageView tabLogOut;
    ImageView oncekiTab;
    View oncekiView;

    ImageView[] tabArray = new ImageView[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillTabArray();
        oncekiTab = homeTab;
        oncekiView = findViewById(R.id.homeView);
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
        mainView.setVisibility(View.VISIBLE);
        oncekiView = mainView;

    }

    public void inviseThemAll(){
        findViewById(R.id.homeView).setVisibility(View.INVISIBLE);
        findViewById(R.id.markView).setVisibility(View.INVISIBLE);
        findViewById(R.id.timetableView).setVisibility(View.INVISIBLE);
        findViewById(R.id.calendarView).setVisibility(View.INVISIBLE);
        findViewById(R.id.foodlistView).setVisibility(View.INVISIBLE);
    }

    private ImageView[] fillTabArray(){

        homeTab = (ImageView) findViewById(R.id.menu_home);
        tabArray[0] = homeTab;
        markTab = (ImageView) findViewById(R.id.menu_marks);
        tabArray[1] = markTab;
        tabTimeTable = (ImageView) findViewById(R.id.menu_timetable);
        tabArray[2] = tabTimeTable;
        tabCalendar = (ImageView) findViewById(R.id.menu_calender);
        tabArray[3] = tabCalendar;
        tabFoodList = (ImageView) findViewById(R.id.menu_foodlist);
        tabArray[4] = tabFoodList;
        tabLogOut = (ImageView) findViewById(R.id.menu_logout);
        tabArray[5] = tabLogOut;

        return tabArray;
    }

}
