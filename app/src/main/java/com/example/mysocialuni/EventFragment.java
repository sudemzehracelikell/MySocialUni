package com.example.mysocialuni;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Intent;


public class EventFragment extends Fragment {

    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<eventModel> eventList;
    private Typeface tf2;


    public EventFragment() {
        // Zorunlu boş yapıcı
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout'u bağla
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        tf2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/yazı_tipi1.ttf");
        //text yazı tipi degıstırmek
        TextView homeText = view.findViewById(R.id.event_text);
        homeText.setTypeface(tf2);

        // RecyclerView başlat
        recyclerView = view.findViewById(R.id.recyclerViewEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Button etkinlikEkleButton = view.findViewById(R.id.etkinlikekle_button);
        etkinlikEkleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Yeni activity'e geçiş
                Intent intent = new Intent(getActivity(), AddEventActivity.class);
                startActivity(intent);
            }
        });
        etkinlikEkleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddEventActivity.class);
                startActivityForResult(intent, 100); // 100 kodunu kendimiz belirliyoruz
            }
        });



        // Örnek veriler
        eventList = new ArrayList<>();
        eventList.add(new eventModel("18", "Mart", "Finans ve Stratejide Liderlik", "Endüstri Mühendisliği kulübü   14.00 - 15.00"));
        eventList.add(new eventModel("22", "Mart", "Yapay Zeka ve Geleceği", "IEEE İSTUN   16.00 - 17.00"));
        eventList.add(new eventModel("5", "Nisan", "Kariyer Sohbetleri", "Girişimcilik Kulübü   13.00 - 14.30"));
        eventList.add(new eventModel("23","Haziran","İstech 2025","IEEE İSTUN   16.00 - 17.00"));
        eventList.add(new eventModel("23","Haziran","İstech - 2025","IEEE İSTUN   16.00 - 17.00"));
        eventList.add(new eventModel("5", "Nisan", "Kariyer Sohbetleri", "Girişimcilik Kulübü   13.00 - 14.30"));
        eventList.add(new eventModel("3", "Nisan", "Kariyer Sohbetleri", "Girişimcilik Kulübü   13.00 - 14.30"));
        eventList.add(new eventModel("5", "Nisan", "Kariyer Sohbetleri", "Girişimcilik Kulübü   13.00 - 14.30"));
        eventList.add(new eventModel("9", "Nisan", "Kariyer Sohbetleri", "Girişimcilik Kulübü   13.00 - 14.30"));
        // Daha fazlasını ekleyebilirsin

        Collections.sort(eventList);

        // Adapter tanımla
        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);

        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == getActivity().RESULT_OK) {
            String gun = data.getStringExtra("gun");
            String ay = data.getStringExtra("ay");
            String baslik = data.getStringExtra("baslik");
            String aciklama = data.getStringExtra("aciklama");

            // Yeni etkinliği listeye ekle
            eventModel yeniEtkinlik = new eventModel(gun, ay, baslik, aciklama);
            eventList.add(yeniEtkinlik);
            Collections.sort(eventList); // tarih sıralaması için
            eventAdapter.notifyDataSetChanged();
        }
    }

}
