package com.example.berkay.uumobil.foodDays;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.berkay.uumobil.R;
import com.example.berkay.uumobil.calendar.CalendarContent;
import com.uumobilGet.FoodDatas.FoodMenu;

import java.util.List;
import java.util.zip.Inflater;


public final class FoodListAdapter extends PagerAdapter {

    private List<FoodMenu> pages;
    private LayoutInflater foodListPageView;


    public FoodListAdapter(Context context, List<FoodMenu> pages){
        Context context1 = context;
        this.pages = pages;
        foodListPageView = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        View view = foodListPageView.inflate(R.layout.foodlist_sublayout, container, false );
        Log.i("TAG", "Bir tane yaptım");

        FoodMenu mMenu = pages.get(position);

        TextView title = view.findViewById(R.id.foodlistView_date);
        TextView ogle_1 = view.findViewById(R.id.ogle_yemek_1);
        TextView ogle_2 = view.findViewById(R.id.ogle_yemek_2);
        TextView ogle_3 = view.findViewById(R.id.ogle_yemek_3);
        TextView ogle_4 = view.findViewById(R.id.ogle_yemek_4);

        title.setText(mMenu.getDay());
        ogle_1.setText(mMenu.getCorba());
        ogle_2.setText(mMenu.getAnaYemek());
        ogle_3.setText(mMenu.getYardimciYemek());
        ogle_4.setText(mMenu.getYanOge());

        return view;
    }
}
