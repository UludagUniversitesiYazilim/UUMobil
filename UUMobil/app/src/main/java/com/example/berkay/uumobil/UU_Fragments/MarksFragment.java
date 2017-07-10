package com.example.berkay.uumobil.UU_Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.berkay.uumobil.R;
import com.example.berkay.uumobil.mark.Not;
import com.example.berkay.uumobil.mark.NotAdaptor;

import java.util.ArrayList;
import java.util.List;


public final class MarksFragment extends Fragment {
    List<Not> notlar = new ArrayList<>();
    ListView notListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.not_layout, container, false);

        notlar.add(new Not("AA", "Matematik", 40, 70, 0));
        notlar.add(new Not("AB", "Algoritma", 40, 40, 100));
        notlar.add(new Not("CD", "Lineer Cebir", 20, 37, 80));
        notlar.add(new Not("CC", "Kimya", 19, 0, 0));
        notlar.add(new Not("AB", "Hukuka Giris", 79, 70, 0));
        notlar.add(new Not("FF", "Biyoloji", 100, 70, 0));
        notlar.add(new Not("CD", "Felsefe", 40, 10, 41));
        notlar.add(new Not("CC", "Ingilizce", 20, 90, 0));
        notlar.add(new Not("BC", "Edebiyat", 79, 70, 0));
        notlar.add(new Not("DD", "Mukavemet", 100, 70, 0));
        notlar.add(new Not("FF", "Almanca", 40, 10, 41));
        notlar.add(new Not("CC", "Mikrobiyoloji", 20, 90, 0));
        notlar.add(new Not("CC", "Ingilizce", 20, 90, 0));
        notlar.add(new Not("BC", "Edebiyat", 79, 70, 0));
        notlar.add(new Not("AA", "Matematik", 40, 70, 0));
        notlar.add(new Not("AB", "Algoritma", 40, 40, 100));
        notlar.add(new Not("CD", "Lineer Cebir", 20, 37, 80));
        notlar.add(new Not("CD", "Felsefe", 40, 10, 41));
        notlar.add(new Not("CC", "Ingilizce", 20, 90, 0));
        notlar.add(new Not("BC", "Edebiyat", 79, 70, 0));
        notlar.add(new Not("DD", "Mukavemet", 100, 70, 0));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        notListView = getActivity().findViewById(R.id.notlar);
        NotAdaptor adaptor = new NotAdaptor(getActivity(), notlar);
        notListView.setAdapter(adaptor);
    }
}
