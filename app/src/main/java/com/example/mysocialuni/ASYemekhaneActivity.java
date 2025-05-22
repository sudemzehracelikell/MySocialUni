package com.example.mysocialuni;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ASYemekhaneActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ASYemekAdapter yemekAdapter;
    private List<ASYemekModel> yemekListesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.as_yemekhane_button);

        Button btnGeriDon = findViewById(R.id.geri_don_button);
        btnGeriDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView = findViewById(R.id.yemek_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        yemekListesi = new ArrayList<>();
        yemekListesi.add(new ASYemekModel("Pazartesi", "Mercimek\nTavuk\nPilav", "Tarhana\nDolma\nAyran"));
        yemekListesi.add(new ASYemekModel("Salı", "Ezogelin\nKarnıyarık\nPirinç", "Domates\nBulgur\nYoğurt"));
        yemekListesi.add(new ASYemekModel("Çarşamba", "Yayla\nKöfte\nMakarna", "Mercimek\nTavuk\nPilav"));
        yemekListesi.add(new ASYemekModel("Perşembe", "Domates\nEtli Patates\nBulgur", "Ezogelin\nKuru Fasulye\nPilav"));
        yemekListesi.add(new ASYemekModel("Cuma", "Tarhana\nTavuk\nMakarna", "Yayla\nKarnıyarık\nAyran"));

        yemekAdapter = new ASYemekAdapter(yemekListesi);
        recyclerView.setAdapter(yemekAdapter);
    }
}
