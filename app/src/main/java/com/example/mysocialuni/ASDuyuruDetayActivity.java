package com.example.mysocialuni;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ASDuyuruDetayActivity extends Activity {

    private TextView tvBaslik, tvAciklama, tvTarih;
    private Button btnVazgec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.as_duyuru_detail);

        tvBaslik = findViewById(R.id.tvBaslik);
        tvAciklama = findViewById(R.id.tvAciklama);
        tvTarih = findViewById(R.id.tvTarih);
        btnVazgec = findViewById(R.id.btnVazgec);

        Intent intent = getIntent();
        String baslik = intent.getStringExtra("baslik");
        String aciklama = intent.getStringExtra("aciklama");
        String tarih = intent.getStringExtra("tarih");

        tvBaslik.setText(baslik);
        tvAciklama.setText(aciklama);
        tvTarih.setText(tarih);

        btnVazgec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Ana sayfaya geri dön
            }
        });
    }
}
