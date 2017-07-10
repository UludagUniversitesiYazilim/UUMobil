package com.example.berkay.uumobil.UU_Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.berkay.uumobil.R;
import com.example.berkay.uumobil.calendar.CalendarAdapter;
import com.example.berkay.uumobil.calendar.CalendarContent;

import java.util.ArrayList;
import java.util.List;


public final class CalendarFragment extends Fragment {

    List<CalendarContent> calendarPages = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.calendar_layout, container, false);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        calendarPages.add(0, new CalendarContent("Ilk Ekran", "Ilk Ekranimiz"));
        calendarPages.add(1, new CalendarContent("Ikinci Ekran", "Ikinci Ekranimiz"));

        ViewPager calendarPager = (ViewPager) getActivity().findViewById(R.id.akademikPages);
        calendarPager.setAdapter(new CalendarAdapter(getActivity(), calendarPages));

    }
}
