package com.example.mysocialuni;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeFragment extends Fragment {

    private Button profilButton;
    private Button akademikTakvimButton;
    private Button yemekhaneButton;
    private Button btnKulüpler;
    private FrameLayout btnResimli1;
    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<eventModel> eventList;
    private Typeface tf1;

    private AppCompatActivity appCompatActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appCompatActivity = (AppCompatActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        profilButton = view.findViewById(R.id.profil_button);
        akademikTakvimButton = view.findViewById(R.id.btnAkademikTakvim);
        yemekhaneButton = view.findViewById(R.id.btnYemekhane);
        btnResimli1 = view.findViewById(R.id.btnResimli1);
        btnKulüpler = view.findViewById(R.id.btnKulupler);

        tf1 = Typeface.createFromAsset(appCompatActivity.getAssets(), "fonts/yazı_tipi1.ttf");
        //text yazı tipi degıstırmek
        TextView homeText = view.findViewById(R.id.home_text);
        homeText.setTypeface(tf1);

        btnKulüpler.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASKulüplerActivity.class);
            startActivity(intent);
        });


        profilButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ProfileMenuActivity.class);
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
            Intent intent = new Intent(getActivity(), ASHaberlerActivity.class);
            startActivity(intent);
        });

        recyclerView = view.findViewById(R.id.recyclerViewEventsHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        eventList = new ArrayList<>();
        eventList.add(new eventModel("23", "Mayıs", "Doğadan Odaya: Koku Atölyesi", " ", "Etnobotanik Kulübü", "16:30", "18:00", R.drawable.as_etkinlikresim));
        eventList.add(new eventModel("22", "Mayıs", "İngilizce Hazırlık Birimi Kapanış Programı", " ", "İSTÜN", "12:30", "14:00", R.drawable.as_etkinlikresim));
        eventList.add(new eventModel("22", "Mayıs", "Yasla Tanışmak ve Film Analizi", " ", "Psikoloji Kulübü", "15:30", "17:30", R.drawable.as_etkinlikresim));
        eventList.add(new eventModel("22", "Mayıs", "TÜBİTAK 2209-A VE 2209-B ", " ", "İSTÜN", "14:00", "16:00", R.drawable.as_etkinlikresim));
        eventList.add(new eventModel("21", "Mayıs", "Sarajevo’da Mimarlık ve Fotoğraf  Söyleşi", " ", "Mimarlık ve Tasarim Kulübü", "11:00", "12:30", R.drawable.as_etkinlikresim));
        eventList.add(new eventModel("21", "Mayıs", "Profesyonel CV Hazırlama ve Mülakat Süreçleri", " ", " İSTÜN", "13:30", "15:30", R.drawable.as_etkinlikresim));
        eventList.add(new eventModel("20", "Mayıs", "Yüz Yogası Sağlıklı Ciltler 2", " ", "Yoga ve Sağlıklı Yaşam Kulübü", "12:30", "13:30", R.drawable.as_etkinlikresim));
        eventList.add(new eventModel("20", "Mayıs", "NEXTMED Öğrenci Sempozyumu ", " ", "Öğrenci Bilimsel Araştırma Kulübü", "8:30", "18:30", R.drawable.as_etkinlikresim));

        Collections.sort(eventList); // tarih sıralaması için

        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);

        return view;
    }
}