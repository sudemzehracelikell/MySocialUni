package com.example.mysocialuni;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ASHaberlerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ASHaberlerAdapter adapter;
    private List<ASHaberlerModel> haberList;
    private Button geriDonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.as_haberler_button);

        geriDonButton = findViewById(R.id.geri_don_button);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        haberList = new ArrayList<>();
        haberList.add(new ASHaberlerModel("23", "Mayıs", "Yeni Teknoloji Haberi Yayında"));
        haberList.add(new ASHaberlerModel("18", "Mayıs", "Yapay Zeka Semineri Başladı"));
        haberList.add(new ASHaberlerModel("12", "Mayıs", "Kulüp Tanıtım Günleri"));

        adapter = new ASHaberlerAdapter(this, haberList);
        recyclerView.setAdapter(adapter);

        geriDonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Ana sayfaya dön
            }
        });
    }
}
