package com.example.mysocialuni;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EventDetailActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        Button btnVazgec = findViewById(R.id.btnVazgec);
        TextView textGun = findViewById(R.id.textDetayGun);
        TextView textAy = findViewById(R.id.textDetayAy);
        TextView textBaslik = findViewById(R.id.textDetayBaslik);
        TextView textAciklama = findViewById(R.id.textDetayAciklama);

        btnVazgec.setOnClickListener(v -> finish());

        // Intent ile gelen verileri al
        String gun = getIntent().getStringExtra("gun");
        String ay = getIntent().getStringExtra("ay");
        String baslik = getIntent().getStringExtra("baslik");
        String aciklama = getIntent().getStringExtra("aciklama");

        // Ekrana yazdır
        textGun.setText(gun);
        textAy.setText(ay);
        textBaslik.setText(baslik);
        textAciklama.setText(aciklama);
    }
}
