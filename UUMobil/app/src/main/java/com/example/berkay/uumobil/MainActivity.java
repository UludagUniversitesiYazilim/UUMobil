package com.example.berkay.uumobil;

import android.support.design.internal.NavigationMenu;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    LinearLayout homeTab;
    LinearLayout markTab;
    LinearLayout tabTimeTable;
    LinearLayout tabCalendar;
    LinearLayout tabFoodList;
    LinearLayout oncekiTab;
    View oncekiView;
    ListView notListView;
    DrawerLayout navigationView;
    Toolbar toolbar;

    List<Not> notlar = new ArrayList<>();
    List<CalendarContent> calendarPages = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillTabArray();
        oncekiTab = homeTab;
        oncekiView = findViewById(R.id.homeView);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (DrawerLayout) findViewById(R.id.m_drawerLayout);
        new ActionBarDrawerToggle(this, navigationView, toolbar, 0, 1).syncState();


        //Musvedde!!!!!!!!!!
        notlar.add(new Not("AA", "Matematik", 40, 70, 0));
        notlar.add(new Not("AB", "Algoritma", 40, 40, 100));
        notlar.add(new Not("CD", "Lineer Cebir", 20, 37, 80));
        notlar.add(new Not("CC", "Kimya", 19, 0, 0));
        notlar.add(new Not("AB", "Hukuka Giris", 79, 70, 0));
        notlar.add(new Not("FF", "Biyoloji", 100, 70, 0));
        notlar.add(new Not("CD", "Felsefe", 40, 10, 41));
        notlar.add(new Not("CC", "Ingilizce", 20, 90, 0));
        notlar.add(new Not("BC", "Edebiyat", 79, 70, 0));
        notlar.add(new Not("DD", "Mukavemet", 100, 70, 0));
        notlar.add(new Not("FF", "Almanca", 40, 10, 41));
        notlar.add(new Not("CC", "Mikrobiyoloji", 20, 90, 0));
        notlar.add(new Not("CC", "Ingilizce", 20, 90, 0));
        notlar.add(new Not("BC", "Edebiyat", 79, 70, 0));
        notlar.add(new Not("AA", "Matematik", 40, 70, 0));
        notlar.add(new Not("AB", "Algoritma", 40, 40, 100));
        notlar.add(new Not("CD", "Lineer Cebir", 20, 37, 80));
        notlar.add(new Not("CD", "Felsefe", 40, 10, 41));
        notlar.add(new Not("CC", "Ingilizce", 20, 90, 0));
        notlar.add(new Not("BC", "Edebiyat", 79, 70, 0));
        notlar.add(new Not("DD", "Mukavemet", 100, 70, 0));

        notListView = (ListView) findViewById(R.id.notlar);
        NotAdaptor adaptor = new NotAdaptor(this, notlar);
        notListView.setAdapter(adaptor);

        calendarPages.add(0, new CalendarContent("Ilk Ekran", "Ilk Ekranimiz"));
        calendarPages.add(1, new CalendarContent("Ikinci Ekran", "Ikinci Ekranimiz"));

        ViewPager calendarPager = (ViewPager) findViewById(R.id.akademikPages);
        calendarPager.setAdapter(new CalendarAdapter(this, calendarPages));
    }

    public void open_screen(View view){
        LinearLayout item = (LinearLayout) view;
        View mainView;

        oncekiTab.setBackgroundResource(R.color.colorPrimary);
        item.setBackgroundResource(R.color.colorAccent);
        oncekiTab = item;


        switch (view.getId()){
            case (R.id.menu_home):
                mainView = findViewById(R.id.homeView);
                break;
            case (R.id.menu_marks):
                mainView = findViewById(R.id.markView);
                break;
            case (R.id.menu_timetable):
                mainView = findViewById(R.id.timetableView);
                break;
            case (R.id.menu_calendar):
                mainView = findViewById(R.id.calendarView);
                break;
            case (R.id.menu_foodlist):
                mainView = findViewById(R.id.foodlistView);
                break;
            default:
                mainView = null;
        }

        oncekiView.setVisibility(View.INVISIBLE);
        assert mainView != null;
        mainView.setVisibility(View.VISIBLE);
        oncekiView = mainView;
    }

    private void fillTabArray(){

        homeTab = (LinearLayout) findViewById(R.id.menu_home);
        markTab = (LinearLayout) findViewById(R.id.menu_marks);
        tabTimeTable = (LinearLayout) findViewById(R.id.menu_timetable);
        tabCalendar = (LinearLayout) findViewById(R.id.menu_calendar);
        tabFoodList = (LinearLayout) findViewById(R.id.menu_foodlist);
    }

    public void open_screen(MenuItem item) {
        navigationView.closeDrawers();
    }
}
