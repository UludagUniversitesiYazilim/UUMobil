package com.example.berkay.uumobil.results;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.berkay.uumobil.R;

import java.util.List;

public final class ResultsAdapter extends BaseAdapter {

    private List<Result> results;
    private LayoutInflater inflater;

    public ResultsAdapter(Activity activity, List<Result> results){
        this.results = results;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.results.size();
    }

    @Override
    public Result getItem(int i) {
        return this.results.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View mView = inflater.inflate(R.layout.mark_listview_items, null);
        Result item = this.results.get(i);

        LinearLayout ll_root = mView.findViewById(R.id.marks_item_container);
        TextView tv_courseName = mView.findViewById(R.id.mark_content_courseName);
        TextView tv_examType = mView.findViewById(R.id.mark_content_examType);
        TextView tv_result = mView.findViewById(R.id.mark_content_result);

        tv_courseName.setText(item.getCourseName());
        tv_examType.setText(item.getExamType());
        tv_result.setText(item.getPoint());

        if (i%2 == 0){
            ll_root.setBackgroundResource(R.color.notAyırıcı);
        }

        return mView;
    }
}
