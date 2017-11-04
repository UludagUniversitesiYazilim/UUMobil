package com.example.berkay.uumobil.UU_Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.berkay.uumobil.R;
import com.example.berkay.uumobil.calendar.CalendarAdapter;
import com.example.berkay.uumobil.calendar.CalendarContent;

import java.util.ArrayList;
import java.util.List;


public final class CalendarFragment extends Fragment {

    List<CalendarContent> calendarPages;

    public CalendarFragment(){
        calendarPages = new ArrayList<>();
        calendarPages.add(0, new CalendarContent("", "Ilk Ekranimiz"));
        Log.d("Tag", "Buraya Geldik");
        calendarPages.add(1, new CalendarContent("", "Ikinci Ekranimiz"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.calendar_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        calendarPages.get(0).setTitle(getString(R.string.calendar_first));
        calendarPages.get(1).setTitle(getString(R.string.calendar_second));

        ViewPager calendarPager = getActivity().findViewById(R.id.akademikPages);
        calendarPager.setAdapter(new CalendarAdapter(getActivity(), calendarPages));

    }
}
