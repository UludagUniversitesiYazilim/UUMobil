package com.example.berkay.uumobil;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


final class NotAdaptor extends BaseAdapter {

    private LayoutInflater myInflater;
    private List<Not> NotList;


    NotAdaptor(Activity activity, List<Not> notList){
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

        dersAdi = itemView.findViewById(R.id.dersAdi);
        vizeNotu = itemView.findViewById(R.id.vizeNotu);
        finalNotu = itemView.findViewById(R.id.finalNotu);
        sinifOrt = itemView.findViewById(R.id.sinOrt);
        harfNotu = itemView.findViewById(R.id.harfNotu);

        not = NotList.get(i);

        dersAdi.setText(not.getDersAdi());
        vizeNotu.setText(Float.toString(not.getVizeNotu()));
        finalNotu.setText(Float.toString(not.getFinalNotu()));
        sinifOrt.setText("---");

        markColor(harfNotu, not.getHarfNotu());
        //harfNotu.setText(not.getHarfNotu());

        return itemView;
    }

    private void markColor(TextView view, String not){
        switch (not){
            case "AA":
                view.setText("AA");
                view.setBackgroundResource(R.color.cokBasari);
                break;

            case "AB":
                view.setText("AB");
                view.setBackgroundResource(R.color.basari);
                break;

            case "BB":
                view.setText("BB");
                view.setBackgroundResource(R.color.basari);
                break;
            case "BC":
                view.setText("BC");
                view.setBackgroundResource(R.color.basari);
                break;

            case "CC":
                view.setText("CC");
                view.setBackgroundResource(R.color.ortaBasari);
                break;

            case "CD":
                view.setText("CD");
                view.setBackgroundResource(R.color.basarisiz);
                break;

            case "DD":
                view.setText("DD");
                view.setBackgroundResource(R.color.basarisiz);
                break;

            case "DF":
                view.setText("DF");
                view.setBackgroundResource(R.color.basarisiz);
                break;

            case "FF":
                view.setText("FF");
                view.setBackgroundResource(R.color.cokBasarisiz);
                break;

            default:
                view.setText("Veri Yok");
                view.setBackgroundResource(R.color.colorPrimary);
                break;
        }
    }
}
