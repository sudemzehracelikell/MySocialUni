package com.example.mysocialuni;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventFragment extends Fragment {

    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<eventModel> eventList;
    private Typeface tf2;

    public EventFragment() {
        // Zorunlu boş constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        tf2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/yazı_tipi1.ttf");
        TextView homeText = view.findViewById(R.id.event_text);
        homeText.setTypeface(tf2);

        recyclerView = view.findViewById(R.id.recyclerViewEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Button etkinlikEkleButton = view.findViewById(R.id.etkinlikekle_button);
        etkinlikEkleButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), AddEventActivity.class);
            startActivityForResult(intent, 100); // 100 bizim tanımladığımız istek kodu
        });

        // Örnek etkinlikler
        eventList = new ArrayList<>();
        eventList.add(new eventModel("18", "Mart", "Finans ve Stratejide Liderlik", "Etkinlik finansal stratejiler üzerine.", "Endüstri Mühendisliği Kulübü", "14:00", "15:00", R.drawable.as_etkinlikresim));
        eventList.add(new eventModel("22", "Mart", "Yapay Zeka ve Geleceği", "Yapay zekanın geleceği üzerine konuşmalar.", "IEEE İSTÜN", "16:00", "17:00", R.drawable.as_akademiktakvim2));
        eventList.add(new eventModel("5", "Nisan", "Kariyer Sohbetleri", "Girişimcilik hikayeleri.", "Girişimcilik Kulübü", "13:00", "14:30", R.drawable.as_etkinlikresim));
        eventList.add(new eventModel("23", "Haziran", "İstech 2025", "Teknoloji fuarı etkinliği.", "IEEE İSTÜN", "16:00", "17:00", R.drawable.as_akademiktakvim2));

        Collections.sort(eventList);

        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == getActivity().RESULT_OK && data != null) {
            String gun = data.getStringExtra("gun");
            String ay = data.getStringExtra("ay");
            String baslik = data.getStringExtra("baslik");
            String aciklama = data.getStringExtra("aciklama");
            String kulup = data.getStringExtra("kulup");
            String baslangic = data.getStringExtra("baslangic");
            String bitis = data.getStringExtra("bitis");
            int resim = data.getIntExtra("resim", R.drawable.as_etkinliklerkart_background); // default resim

            eventModel yeniEtkinlik = new eventModel(gun, ay, baslik, aciklama, kulup, baslangic, bitis, resim);
            eventList.add(yeniEtkinlik);
            Collections.sort(eventList);
            eventAdapter.notifyDataSetChanged();
        }
    }
}
