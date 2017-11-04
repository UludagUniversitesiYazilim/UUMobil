package com.example.berkay.uumobil.UU_Fragments;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.berkay.uumobil.DataOperations.ReadDB;
import com.example.berkay.uumobil.R;
import com.example.berkay.uumobil.foodDays.FoodListAdapter;
import com.uumobilGet.FoodDatas.FoodMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public final class FoodListFragment extends Fragment {
    View view;
    List<FoodMenu> foodList;
    FoodListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.foodlist_sublayout, container, false);

        (new getTexts()).execute();
        return view;
    }


    private class getTexts extends AsyncTask<String , Integer, FoodMenu[]>{

        @Override
        protected void onPreExecute() {


        }

        @Override
        protected FoodMenu[] doInBackground(String ... objects) {
            ReadDB rd = new ReadDB(getActivity());
            return rd.readFoods();
        }

        @Override
        protected void onPostExecute(FoodMenu[] foods) {
            foodList = Arrays.asList(foods);
            Log.i("DENEME", foodList.get(0).getAnaYemek());
            ViewPager pager = getActivity().findViewById(R.id.subfoodlist_pages);
            adapter = new FoodListAdapter(getActivity(), foodList);
            pager.setAdapter(adapter);
        }
    }
}
