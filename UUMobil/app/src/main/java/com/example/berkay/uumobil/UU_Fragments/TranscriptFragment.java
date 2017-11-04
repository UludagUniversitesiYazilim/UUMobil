package com.example.berkay.uumobil.UU_Fragments;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.berkay.uumobil.DataOperations.ReadDB;
import com.example.berkay.uumobil.R;
import com.example.berkay.uumobil.results.Result;
import com.example.berkay.uumobil.results.ResultsAdapter;
import com.example.berkay.uumobil.transcript.Course;
import com.example.berkay.uumobil.transcript.CourseAdapter;

import java.util.ArrayList;
import java.util.List;


public final class TranscriptFragment extends Fragment {
    List<Course> notlar = new ArrayList<>();
    ListView notListView;
    View view;
    TextView ganoText;
    TextView genelKredi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.transkript_layout, container, false);
        ganoText = view.findViewById(R.id.transcript_gano);
        genelKredi = view.findViewById(R.id.transcript_general_credits);
        (new getTexts()).execute();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private class getTexts extends AsyncTask<Object, Integer, ArrayList<Course>> {
        String generalText_1;
        String generalText_2;

        @Override
        protected ArrayList<Course> doInBackground(Object... objects) {
            ReadDB readDB = new ReadDB(getActivity());
            generalText_1 = readDB.readGano()[1];
            generalText_2 = readDB.readGano()[0];
            return readDB.readTranscript();
        }

        @Override
        protected void onPostExecute(ArrayList<Course> results){
            notlar = results;
            notListView = getActivity().findViewById(R.id.transkript_list);
            CourseAdapter adaptor = new CourseAdapter(getActivity(), notlar);
            notListView.setAdapter(adaptor);
            ganoText.setText("Gano: " + generalText_1);
            genelKredi.setText("Akts: " + generalText_2);
        }
    }
}
