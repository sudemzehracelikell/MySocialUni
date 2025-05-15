package com.example.mysocialuni;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ASKulüplerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.as_kulupler_button);//D

        Button btnGeriDon = findViewById(R.id.geri_don_button);

        // Tıklanınca sayfayı kapat
        btnGeriDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Bu Activity'yi kapatır, bir önceki ekrana döner
            }
        });
    }
}

