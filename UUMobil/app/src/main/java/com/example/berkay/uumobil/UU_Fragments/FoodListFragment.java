package com.example.berkay.uumobil.UU_Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.berkay.uumobil.R;


public final class FoodListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.foodlist_layout, container, false);
        return view;
    }
}
