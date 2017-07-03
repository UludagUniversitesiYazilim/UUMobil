package com.example.berkay.uumobil;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public final class NotAdaptor extends BaseAdapter {

    private LayoutInflater myInflater;
    private List<Not> NotList;


    public NotAdaptor(Activity activity, List<Not> notList){
        myInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        NotList = notList;
    }
    @Override
    public int getCount() {
        return NotList.size();
    }

    @Override
    public Object getItem(int i) {
        return NotList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView;
        Not not;
        TextView dersAdi;
        TextView vizeNotu;
        TextView finalNotu;
        TextView sinifOrt;
        TextView harfNotu;

        itemView = myInflater.inflate(R.layout.mark_listview_layout, null);

        dersAdi = (TextView) itemView.findViewById(R.id.dersAdi);
        vizeNotu = (TextView) itemView.findViewById(R.id.vizeNotu);
        finalNotu = (TextView) itemView.findViewById(R.id.finalNotu);
        sinifOrt = (TextView) itemView.findViewById(R.id.sinOrt);
        harfNotu = (TextView) itemView.findViewById(R.id.harfNotu);

        not = NotList.get(i);

        dersAdi.setText(not.getDersAdi());
        vizeNotu.setText(Float.toString(not.getVizeNotu()));
        finalNotu.setText(Float.toString(not.getFinalNotu()));
        sinifOrt.setText("---");

        harfNotu.setText(not.getHarfNotu());

        return itemView;
    }
}
