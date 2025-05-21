package com.example.mysocialuni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddEventActivity extends AppCompatActivity {

    private Spinner spinnerGun, spinnerAy;
    private EditText editTextBaslik, editTextAciklama;
    private Button btnKaydet;
    private Button btnVazgec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        // View'ları tanımla
        spinnerGun = findViewById(R.id.spinnerGun);
        spinnerAy = findViewById(R.id.spinnerAy);
        editTextBaslik = findViewById(R.id.editTextBaslik);
        editTextAciklama = findViewById(R.id.editTextAciklama);
        btnKaydet = findViewById(R.id.btnEtkinlikKaydet);
        btnVazgec = findViewById(R.id.btnVazgec);



        // Gün listesi (1–31)
        List<String> gunListesi = new ArrayList<>();
        for (int i = 1; i <= 31; i++) {
            gunListesi.add(String.valueOf(i));
        }

        // Ay listesi
        List<String> ayListesi = Arrays.asList("Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
                "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık");

        // Özel adapter kullanımı (beyaz yazı rengi için özel layout)
        ArrayAdapter<String> gunAdapter = new ArrayAdapter<>(
                this,
                R.layout.spinner_item,          // spinner kapalı görünüm
                gunListesi
        );
        gunAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item); // açılır liste görünüm
        spinnerGun.setAdapter(gunAdapter);

        ArrayAdapter<String> ayAdapter = new ArrayAdapter<>(
                this,
                R.layout.spinner_item,
                ayListesi
        );
        ayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerAy.setAdapter(ayAdapter);

        // Kaydet butonu işlemleri
        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gun = spinnerGun.getSelectedItem().toString();
                String ay = spinnerAy.getSelectedItem().toString();
                String baslik = editTextBaslik.getText().toString();
                String aciklama = editTextAciklama.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("gun", gun);
                resultIntent.putExtra("ay", ay);
                resultIntent.putExtra("baslik", baslik);
                resultIntent.putExtra("aciklama", aciklama);

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        btnVazgec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
