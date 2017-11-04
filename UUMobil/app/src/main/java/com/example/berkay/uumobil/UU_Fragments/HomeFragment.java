package com.example.berkay.uumobil.UU_Fragments;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.berkay.uumobil.DataOperations.ReadDB;
import com.example.berkay.uumobil.R;
public final class HomeFragment extends Fragment {
    View view;
    TextView name_tv;
    TextView number_tv;
    TextView period_tv;
    TextView unitName_tv;
    TextView statue_tv;
    TextView dateLogin_tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_layout, container, false);
        this.name_tv = view.findViewById(R.id.home_isim);
        this.number_tv = view.findViewById(R.id.home_okulNo);
        this.period_tv = view.findViewById(R.id.home_donem);
        this.unitName_tv = view.findViewById(R.id.home_bolum);
        this.statue_tv = view.findViewById(R.id.home_tip);
        this.dateLogin_tv = view.findViewById(R.id.home_kayit_tarihi);

        (new getTexts()).execute();

        return view;
    }

    private class getTexts extends AsyncTask<Object, Integer, String[]>{

        @Override
        protected String[] doInBackground(Object... objects) {
            ReadDB database = new ReadDB(getActivity());

            return database.readHomeDatas();
        }

        @Override
        protected void onPostExecute(String[] values) {
            int i = 0;
            TextView[] textViews = {name_tv, number_tv, period_tv,
                unitName_tv, statue_tv, dateLogin_tv};

            while (i<6){
                textViews[i].setText(values[i]);
                i++;
            }
        }
    }


}
