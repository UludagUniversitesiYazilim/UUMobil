package com.example.berkay.uumobil.UU_Fragments;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.berkay.uumobil.DataOperations.ReadDB;
import com.example.berkay.uumobil.R;
import com.example.berkay.uumobil.results.Result;
import com.example.berkay.uumobil.results.ResultsAdapter;

import java.util.ArrayList;
import java.util.List;


public final class MarkFragment extends Fragment {
    List<Result> resultList;
    ListView markListView;
    ListAdapter adapter;

    public MarkFragment(){
        resultList = new ArrayList<>();

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mark_layout, container, false);
        (new getTexts()).execute();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private class getTexts extends AsyncTask<Object, Integer, ArrayList<Result>>{

        @Override
        protected ArrayList<Result> doInBackground(Object... objects) {
            ReadDB readDB = new ReadDB(getActivity());
            return readDB.readMarks();
        }

        @Override
        protected void onPostExecute(ArrayList<Result> results){
            resultList = results;
            markListView = getActivity().findViewById(R.id.marks);
            adapter = new ResultsAdapter(getActivity(), resultList);
            markListView.setAdapter(adapter);
        }
    }
}
