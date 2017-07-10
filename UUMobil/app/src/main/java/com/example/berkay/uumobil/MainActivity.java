package com.example.berkay.uumobil;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.berkay.uumobil.UU_Fragments.*;



public class MainActivity extends AppCompatActivity {
    LinearLayout homeTab;
    LinearLayout markTab;
    LinearLayout tabTimeTable;
    LinearLayout tabCalendar;
    LinearLayout tabFoodList;
    LinearLayout oncekiTab;
    View oncekiView;
    DrawerLayout navigationView;
    Toolbar toolbar;

    FragmentManager fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillTabArray();
        oncekiTab = homeTab;
        oncekiView = findViewById(R.id.homeView);

        fragments = getFragmentManager();
        FragmentTransaction transaction = fragments.beginTransaction();
        transaction.add(R.id.content, new HomeFragment(),"HomeFragment");
        transaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (DrawerLayout) findViewById(R.id.m_drawerLayout);
        new ActionBarDrawerToggle(this, navigationView, toolbar,
                R.string.navigaIsOpened, R.string.navigaIsClosed).syncState();

    }

    public void open_screen(View view){
        FragmentTransaction transaction = fragments.beginTransaction();
        LinearLayout item = (LinearLayout) view;

        oncekiTab.setBackgroundResource(R.color.colorPrimary);
        item.setBackgroundResource(R.color.colorAccent);
        oncekiTab = item;

        switch (view.getId()){
            case (R.id.menu_home):
                transaction.replace(R.id.content, new HomeFragment(), "HomeFragment");
                break;
            case (R.id.menu_marks):
                transaction.replace(R.id.content, new MarksFragment(), "MarksFragment");
                break;
            case (R.id.menu_timetable):
                transaction.replace(R.id.content, new TimeTableFragment(), "TimeTableFragment");
                break;
            case (R.id.menu_calendar):
                transaction.replace(R.id.content, new CalendarFragment(), "CalendarFragment");
                break;
            case (R.id.menu_foodlist):
                transaction.replace(R.id.content, new FoodListFragment(), "CalendarFragment");
                break;
        }
        transaction.commit();
    }

    private void fillTabArray(){

        homeTab = (LinearLayout) findViewById(R.id.menu_home);
        markTab = (LinearLayout) findViewById(R.id.menu_marks);
        tabTimeTable = (LinearLayout) findViewById(R.id.menu_timetable);
        tabCalendar = (LinearLayout) findViewById(R.id.menu_calendar);
        tabFoodList = (LinearLayout) findViewById(R.id.menu_foodlist);
    }

    public void open_screen(MenuItem item) {
        View selectedView;
        oncekiTab.setBackgroundResource(R.color.colorPrimary);

        switch (item.getItemId()){
            case (R.id.naviga_calendar):
                selectedView = findViewById(R.id.calendarView);
                break;
            case (R.id.naviga_food):
                selectedView = findViewById(R.id.foodlistView);
                break;
            case (R.id.naviga_calculator):
                selectedView = findViewById(R.id.ViewCalculator);
                break;
            case (R.id.naviga_ayarlar):
                selectedView = findViewById(R.id.ViewSettings);
                break;
            case (R.id.naviga_logOutButton):
                selectedView = oncekiView;
                this.finish();
                break;
            default:
                selectedView = oncekiView;
                break;
        }
        oncekiView.setVisibility(View.INVISIBLE);
        selectedView.setVisibility(View.VISIBLE);
        oncekiView = selectedView;

        navigationView.closeDrawers();
    }
}
