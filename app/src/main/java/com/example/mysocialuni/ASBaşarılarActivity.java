package com.example.mysocialuni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ASBaşarılarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.as_basarilar_button);

        Button geriDonButton = findViewById(R.id.geri_don_button);
        geriDonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ana sayfaya dön
                Intent intent = new Intent(ASBaşarılarActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Profil sayfasını kapat
            }
        });
    }
}
