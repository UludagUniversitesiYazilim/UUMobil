package com.example.berkay.uumobil;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.berkay.uumobil.DataOperations.BackgroundProcces;
import com.example.berkay.uumobil.UU_Fragments.*;


public class MainActivity extends AppCompatActivity {
    LinearLayout tabHome;
    LinearLayout tabTranscript;
    LinearLayout tabMark;
    LinearLayout tabTimeTable;
    LinearLayout tabMore;
    LinearLayout oncekiTab;
    DrawerLayout navigationView;

    FragmentManager fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillTabArray();
        oncekiTab = tabHome;

        navigationView = (DrawerLayout) findViewById(R.id.m_drawerLayout);

        fragments = getFragmentManager();
        FragmentTransaction transaction = fragments.beginTransaction();
        transaction.add(R.id.content, new HomeFragment(),"HomeFragment");
        transaction.commit();


        this.deleteDatabase("UU_Data");
        Intent intent = getIntent();
        BackgroundProcces bgP = new BackgroundProcces(this.getApplicationContext(),
                this,
                intent.getStringExtra("Username"),
                intent.getStringExtra("Password"));
        bgP.execute();


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
                transaction.replace(R.id.content, new MarkFragment(), "MarkFragment");
                break;
            case (R.id.menu_timetable):
                transaction.replace(R.id.content, new TimeTableFragment(), "TimeTableFragment");
                break;
            case (R.id.menu_transkript):
                transaction.replace(R.id.content, new TranscriptFragment(), "TranscriptFragment");
                break;
            case (R.id.menu_more):
                navigationView.openDrawer(Gravity.END); // TODO: Daha tatlısı yapılabilir!
                break;
        }
        transaction.commit();
    }

    public void open_screen(MenuItem item) {
        FragmentTransaction transaction = fragments.beginTransaction();

        switch (item.getItemId()){
            case (R.id.naviga_calendar):
                transaction.replace(R.id.content, new CalendarFragment(), "CalendarFragment");
                break;
            case (R.id.naviga_food):
                transaction.replace(R.id.content, new FoodListFragment(), "FoodListFragment");
                break;
            case (R.id.naviga_calculator):
                transaction.replace(R.id.content, new CalculatorFragment(), "CalculatorFragment");
                break;
            case (R.id.naviga_ayarlar):
                transaction.replace(R.id.content, new SettingsFragment(), "SettingsFragment");
                break;
            case (R.id.naviga_logOutButton):
                this.finish();
                break;
        }

        transaction.commit();
        navigationView.closeDrawers();
    }

    private void fillTabArray(){

        tabHome = (LinearLayout) findViewById(R.id.menu_home);
        tabTranscript = (LinearLayout) findViewById(R.id.menu_transkript);
        tabMark = (LinearLayout) findViewById(R.id.menu_marks);
        tabTimeTable = (LinearLayout) findViewById(R.id.menu_timetable);
        tabMore = (LinearLayout) findViewById(R.id.menu_more);
    }
}
