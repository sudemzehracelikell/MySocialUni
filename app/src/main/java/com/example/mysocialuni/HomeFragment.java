package com.example.mysocialuni;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private Button profilButton;
    private Button etkinliklerButton;
    private Button akademikTakvimButton;
    private Button yemekhaneButton;
    private Button btnBasarılar;
    private Button btnKulüpler;
    private LinearLayout card_event1;
    private FrameLayout btnResimli1;
    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<EventModel> eventList;
    private Typeface tf1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        profilButton = view.findViewById(R.id.profil_button);
        etkinliklerButton = view.findViewById(R.id.btnEtkinlikler);
        akademikTakvimButton = view.findViewById(R.id.btnAkademikTakvim);
        yemekhaneButton = view.findViewById(R.id.btnYemekhane);
        btnResimli1 = view.findViewById(R.id.btnResimli1);
        card_event1 = view.findViewById(R.id.card_event);
        btnBasarılar = view.findViewById(R.id.btnBasarılar);
        btnKulüpler = view.findViewById(R.id.btnKulupler);


        tf1 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/yazı_tipi1.ttf");
        //text yazı tipi degıstırmek
        TextView homeText = view.findViewById(R.id.home_text);
        homeText.setTypeface(tf1);

        btnKulüpler.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASKulüplerActivity.class);
            startActivity(intent);
        });

        btnBasarılar.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASBaşarılarActivity.class);
            startActivity(intent);
        });

        card_event1.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASEtkinlikKarti1Activity.class);
            startActivity(intent);
        });

        etkinliklerButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASEtkinliklerActivity.class);
            startActivity(intent);
        });

        profilButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ProfileActivity.class);
            startActivity(intent);
        });

        akademikTakvimButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASAkademikTakvimActivity.class);
            startActivity(intent);
        });

        yemekhaneButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASYemekhaneActivity.class);
            startActivity(intent);
        });

        btnResimli1.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASBoşSayfaActivity.class);
            startActivity(intent);
        });

        recyclerView = view.findViewById(R.id.recyclerViewEventsHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        eventList = new ArrayList<>();
        eventList.add(new EventModel("22", "Mart", "Yapay Zeka ve Geleceği", "IEEE İSTUN   16.00 - 17.00"));
        eventList.add(new EventModel("5", "Nisan", "Kariyer Sohbetleri", "Girişimcilik Kulübü   13.00 - 14.30"));
        eventList.add(new EventModel("23","Haziran","İstech 2025","IEEE İSTUN   16.00 - 17.00"));

        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);

        return view;
    }
}
