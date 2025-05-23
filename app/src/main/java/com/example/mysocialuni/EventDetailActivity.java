package com.example.mysocialuni;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EventDetailActivity extends AppCompatActivity {

    private TextView tvBaslik, tvGun, tvAy, tvAciklama, tvKulup, tvSaat;
    private ImageView ivEtkinlikResmi;
    private Button btnVazgec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        // View'ları bağla
        tvBaslik = findViewById(R.id.tvBaslik);
        tvGun = findViewById(R.id.tvGun);
        tvAy = findViewById(R.id.tvAy);
        tvAciklama = findViewById(R.id.tvAciklama);
        tvKulup = findViewById(R.id.tvKulup);
        tvSaat = findViewById(R.id.tvSaat);
        ivEtkinlikResmi = findViewById(R.id.ivEtkinlikResmi);
        btnVazgec = findViewById(R.id.btnVazgec);

        // Intent ile gelen veriler
        String baslik = getIntent().getStringExtra("baslik");
        String gun = getIntent().getStringExtra("gun");
        String ay = getIntent().getStringExtra("ay");
        String aciklama = getIntent().getStringExtra("aciklama");
        String kulup = getIntent().getStringExtra("kulup");
        String saatBaslangic = getIntent().getStringExtra("saatBaslangic");
        String saatBitis = getIntent().getStringExtra("saatBitis");
        int resimId = getIntent().getIntExtra("resimId", R.drawable.as_etkinliklerkart_background);

        // View'lara verileri yaz
        tvBaslik.setText(baslik);
        tvGun.setText(gun);
        tvAy.setText(ay);
        tvAciklama.setText(aciklama);
        tvKulup.setText("Bu etkinlik " + kulup + " tarafından düzenlenmektedir.");
        tvSaat.setText(saatBaslangic + " | " + saatBitis);
        ivEtkinlikResmi.setImageResource(resimId);

        // Vazgeç butonu işlevi
        btnVazgec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Aktiviteyi kapatır
            }
        });
    }
}
