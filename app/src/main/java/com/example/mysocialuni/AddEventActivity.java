package com.example.mysocialuni;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddEventActivity extends AppCompatActivity {

    private Spinner spinnerGun, spinnerAy, spinnerKulup, spinnerBaslangicSaat, spinnerBitisSaat;
    private EditText editTextBaslik, editTextAciklama;
    private Button btnKaydet, btnVazgec, btnResimSec;
    private ImageView imageView;
    private Uri imageUri; // Seçilen resmin URI'si

    private static final int PICK_IMAGE_REQUEST = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        // View tanımları
        spinnerGun = findViewById(R.id.spinnerGun);
        spinnerAy = findViewById(R.id.spinnerAy);
        spinnerKulup = findViewById(R.id.spinnerKulup);
        spinnerBaslangicSaat = findViewById(R.id.spinnerBaslangicSaat);
        spinnerBitisSaat = findViewById(R.id.spinnerBitisSaat);
        editTextBaslik = findViewById(R.id.editTextBaslik);
        editTextAciklama = findViewById(R.id.editTextAciklama);
        btnKaydet = findViewById(R.id.btnEtkinlikKaydet);
        btnVazgec = findViewById(R.id.btnVazgec);
        btnResimSec = findViewById(R.id.btnResimSec);
        imageView = findViewById(R.id.imageView);

        // Gün listesi (1-31)
        List<String> gunListesi = new ArrayList<>();
        for (int i = 1; i <= 31; i++) {
            gunListesi.add(String.valueOf(i));
        }

        // Ay listesi
        List<String> ayListesi = Arrays.asList("Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
                "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık");

        // Kulüp listesi icin
        List<String> kulupListesi = Arrays.asList("IEEE", "Müzik", "Dans", "Tiyatro", "Sinema",
                "Yazılım", "Robotik", "Girişimcilik", "Edebiyat", "Spor");

        // Saat listesi (30 dakikalık aralıklarla)
        List<String> saatListesi = new ArrayList<>();
        for (int hour = 8; hour <= 22; hour++) {
            saatListesi.add(String.format("%02d:00", hour));
            saatListesi.add(String.format("%02d:30", hour));
        }

        // Spinner adapter ayarları
        ArrayAdapter<String> gunAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, gunListesi);
        gunAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerGun.setAdapter(gunAdapter);

        ArrayAdapter<String> ayAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, ayListesi);
        ayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerAy.setAdapter(ayAdapter);

        ArrayAdapter<String> kulupAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, kulupListesi);
        kulupAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerKulup.setAdapter(kulupAdapter);

        ArrayAdapter<String> saatAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, saatListesi);
        saatAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerBaslangicSaat.setAdapter(saatAdapter);
        spinnerBitisSaat.setAdapter(saatAdapter);

        // Resim seçme butonu
        btnResimSec.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
        });

        // Kaydet butonu
        btnKaydet.setOnClickListener(v -> {
            String gun = spinnerGun.getSelectedItem().toString();
            String ay = spinnerAy.getSelectedItem().toString();
            String kulup = spinnerKulup.getSelectedItem().toString();
            String baslangicSaat = spinnerBaslangicSaat.getSelectedItem().toString();
            String bitisSaat = spinnerBitisSaat.getSelectedItem().toString();
            String baslik = editTextBaslik.getText().toString();
            String aciklama = editTextAciklama.getText().toString();
            String imagePath = (imageUri != null) ? imageUri.toString() : "";

            Intent resultIntent = new Intent();
            resultIntent.putExtra("gun", gun);
            resultIntent.putExtra("ay", ay);
            resultIntent.putExtra("kulup", kulup);
            resultIntent.putExtra("baslangic", baslangicSaat);
            resultIntent.putExtra("bitis", bitisSaat);
            resultIntent.putExtra("baslik", baslik);
            resultIntent.putExtra("aciklama", aciklama);
            resultIntent.putExtra("resim", imagePath);

            setResult(RESULT_OK, resultIntent);
            finish();
        });

        // Vazgeç butonu
        btnVazgec.setOnClickListener(v -> finish());
    }

    // Resim seçimi sonucu
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }
}
