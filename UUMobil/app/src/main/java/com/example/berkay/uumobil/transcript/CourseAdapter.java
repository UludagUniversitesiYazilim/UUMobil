package com.example.berkay.uumobil.transcript;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.berkay.uumobil.R;

import java.util.List;


final public class CourseAdapter extends BaseAdapter {

    private LayoutInflater myInflater;
    private List<Course> courseList;


    public CourseAdapter(Activity activity, List<Course> courseList){
        myInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.courseList = courseList;
    }
    @Override
    public int getCount() {
        return courseList.size();
    }

    @Override
    public Object getItem(int i) {
        return courseList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView;
        Course course;
        TextView dersAdi;
        TextView akts;
        TextView harfNotu;

        itemView = myInflater.inflate(R.layout.transkript_listview_layout, null);

        dersAdi = itemView.findViewById(R.id.transcript_courseName);
        akts = itemView.findViewById(R.id.transcript_akts);
        harfNotu = itemView.findViewById(R.id.transcript_point);

        course = courseList.get(i);

        dersAdi.setText(course.getDersKodu() + " - " +course.getDersAdi());
        akts.setText(course.getAkts());
        markColor(harfNotu, course.getHarfNotu());

        return itemView;
    }

    private void markColor(TextView view, String not){
        switch (not){
            case "AA":
                view.setText("AA");
                //view.setBackgroundColor(Color.GREEN);
                break;

            case "BA":
                view.setText("BA");
                //view.setBackgroundResource(R.color.basari);
                //view.setBackgroundColor(Color.GREEN);
                break;

            case "BB":
                view.setText("BB");
                //view.setBackgroundResource(R.color.basari);
                //view.setBackgroundColor(Color.GREEN);
                break;
            case "CB":
                view.setText("CB");
                //view.setBackgroundResource(R.color.basari);
                //view.setBackgroundColor(Color.GREEN);
                break;

            case "CC":
                view.setText("CC");
                //view.setBackgroundResource(R.color.ortaBasari);
                //view.setBackgroundColor(Color.GREEN);
                break;

            case "DC":
                view.setText("DC");
                //view.setBackgroundResource(R.color.basarisiz);
                //view.setBackgroundColor(Color.GREEN);
                break;

            case "DD":
                view.setText("DD");
                //view.setBackgroundResource(R.color.basarisiz);
                //view.setBackgroundColor(Color.GREEN);
                break;

            case "FD":
                view.setText("FD");
                //view.setBackgroundResource(R.color.basarisiz);
                //view.setBackgroundColor(Color.GREEN);
                break;

            case "FF":
                view.setText("FF");
                //view.setBackgroundResource(R.color.cokBasarisiz);
                //view.setBackgroundColor(Color.GREEN);
                break;

            default:
                view.setText(not);
                //view.setBackgroundResource(R.color.colorPrimary);
                //view.setBackgroundColor(Color.GREEN);
                break;
        }
    }
}
