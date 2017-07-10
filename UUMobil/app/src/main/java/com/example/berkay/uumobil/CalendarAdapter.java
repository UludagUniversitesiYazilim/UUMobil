package com.example.berkay.uumobil;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public final class CalendarAdapter extends PagerAdapter {

    private Context context;
    private List<CalendarContent> pages;
    LayoutInflater calendarPageView;


    public CalendarAdapter(Context context, List<CalendarContent> pages){
        this.context = context;
        this.pages = pages;
        calendarPageView = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // Bu metod her item icin calisir. (Dongu icindedir.)

        View view = calendarPageView.inflate(R.layout.subcalendar_layout, container, false);

        CalendarContent tempPage = pages.get(position);

        TextView titleText = view.findViewById(R.id.subcalendar_title);
        TextView contentText = view.findViewById(R.id.subcalendar_content);

        titleText.setText(tempPage.getTitle());
        contentText.setText((tempPage.getContent()));
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
