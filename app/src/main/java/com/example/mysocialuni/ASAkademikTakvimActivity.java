package com.example.mysocialuni;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ASAkademikTakvimActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.as_akademiktakvim_button);

        Button btnGeriDon = findViewById(R.id.geri_don_button2);
        btnGeriDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Ana sayfaya dön
            }
        });
    }
}
