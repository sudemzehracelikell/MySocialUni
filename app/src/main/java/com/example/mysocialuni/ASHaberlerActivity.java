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
        haberList.add(new ASHaberlerModel("17", "Mayıs", "NEXTMED Öğrenci Sempozyumu'nda \"Tıbbın Geleceği\" Konuşuldu"));
        haberList.add(new ASHaberlerModel("16", "Mayıs", "DermoVision Kongresi’nde Eczacılık ve Kozmetik Sektörü Buluştu"));
        haberList.add(new ASHaberlerModel("14", "Mayıs", "Beyaz Önlük Töreniyle Geleceğin Eczacıları Mesleğe Adım Attı"));
        haberList.add(new ASHaberlerModel("13", "Mayıs", "Sağlık Bilimleri Fakültesi’nde Hemşirelik Öğrencilerinin Beyaz Önlük Coşkusu"));
        haberList.add(new ASHaberlerModel("10", "Mayıs", "Geleceğin Teknolojileri ve Girişimcilik Vizyonu ISTECH '25 Teknoloji Zirvesinde Buluştu"));
        haberList.add(new ASHaberlerModel("05", "Mayıs", "İSTÜN’lü Öğrencilerden TÜBİTAK Başarısı"));
        haberList.add(new ASHaberlerModel("03", "Mayıs", "II. Moleküler Biyoloji ve Genetik Günü Konferansında Bilimsel Gelişmeler Konuşuldu"));
        haberList.add(new ASHaberlerModel("02", "Mayıs", "II. PHARMİSTÜN Kongresi ile Eczacılık ve İlaç Sektöründeki İnovasyonlar Konuşuldu"));
        haberList.add(new ASHaberlerModel("22", "Nisan", "Sağlık Bilimleri Fakültesi Beslenme ve Diyetetik Bölümü Öğrencileri Beyaz Önlüklerini Giydi"));
        haberList.add(new ASHaberlerModel("22", "Nisan", "İSTÜN’de Beyaz Önlük Heyecanı: Fizyoterapist Adayları Beyaz Önlüklerini Giydi"));
        haberList.add(new ASHaberlerModel("21", "Nisan", "Diş Hekimliği Fakültesi Beyaz Önlük Giyme Töreni Düzenlendi"));
        haberList.add(new ASHaberlerModel("18", "Nisan", "“Fakültemde Bir Gün” ile Hazırlık Öğrencileri Bölümleriyle Buluşuyor"));


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
