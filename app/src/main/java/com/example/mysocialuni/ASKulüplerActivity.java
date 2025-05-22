package com.example.mysocialuni;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ASKulüplerActivity extends AppCompatActivity {

    private LinearLayout meslekiContainer;
    private LinearLayout sosyalContainer;
    private LinearLayout sporContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.as_kulupler_button); // bu XML dosyasının adı

        Button btnGeriDon = findViewById(R.id.geri_don_button2);
        btnGeriDon.setOnClickListener(v -> finish());

        meslekiContainer = findViewById(R.id.linear_kartlar_container);
        sosyalContainer = findViewById(R.id.linear_kartlar_container2);
        sporContainer = findViewById(R.id.linear_kartlar_container3);


        // Örnek kulüp verisi
        List<ASKulüplerModel> kulupList = new ArrayList<>();
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_3bkalemileanatomikmodelleme, "3B Kalem ile Anatomik Modelleme Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_arge, "Ar-Ge Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_blockchain, "İSTÜN Blockchain Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_ceviri, "Çeviri Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_eczacilik, "Eczacılık Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_eczacilikogrencileribirligi, "Eczacılık Öğrencileri Birliği Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_endustrimuhednisligi, "Endüstri Mühendisliği Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_etnobotanik, "Etnobotanik Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_ftr, "Fizyoterapi ve Rehabilitasyon Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_gencyyd, "Genç Yeryüzü Doktorları Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_hemsirelik, "Hemşirelik Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_hesa, "HESA (Sağlıklı ve Sürdürülebilir Yaşam Kulübü)"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_huk, "Havacılık ve Uzay Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_iaeste, "İSTÜN IAESTE Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_ieee, "IEEE İstün Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_ilacendustrisi, "İlaç Endüstrisi Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_istudsa, "İSTUDSA Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_kimyamuhendisligi, "Kimya Mühendisliği Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_kontrolotomasyon, "Kontrol ve Otomasyon Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_makineteknoloji, "Makine Teknoloji Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_managment, "Management İSTÜN Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_mbg, "Moleküler Biyoloji ve Genetik Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_megatronik, "Megatronik Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_mimarlikkvetasarim, "Mimarlık ve Tasarım Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_ogrencibilimselarastirma, "Öğrenci Bilimsel Araştırma Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_pazarlama, "Pazarlama Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_psikoloji, "Psikoloji Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_robotik, "Robotik Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_teknofest, "Teknofest Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_tipogrencileri, "Tıp Öğrencileri Topluluğu Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_yapayzeka, "Yapay Zeka ve Devrim Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_abek, "Afet Bilinci Edinme Kulübü (ABEK)"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_dogalcehre, "Doğal Çehre Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_yogavesaglik, "Yoga ve Sağlıklı Yaşam Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_tiyatro, "Tiyatro Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_bilimkurguvefantastiktoplulugu, "Bilim Kurgu ve Fantastik Topluluğu Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_genctema, "Genç Tema Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_fotografcilik, "Fotoğrafçılık Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_gastronomi, "Gastronomi Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_gencyesilay, "Genç Kızılay Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_gezivekultur, "Gezi ve Kültür Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_girisimcilik, "Girişimcilik Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_dance, "IstunDance Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_kizilay, "Genç Kızılay Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_kultursanat, "Kültür ve Sanat Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_munazara, "İSTÜN Münazara Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_muzik, "Müzik Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_racing, "Racing Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_resim, "Resim Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_satranc, "Satranç ve Masa Oyunları Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_dogasporlari, "Doğa Sporları Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_kampcilikveoutdoor, "Kampçılık ve Outdoor Kulübü"));
        kulupList.add(new ASKulüplerModel(R.drawable.as_kulup_spor, "Spor Kulübü"));

        // Kartları ekle
        LayoutInflater inflater = LayoutInflater.from(this);

        for (int i = 0; i < kulupList.size(); i++) {
            ASKulüplerModel kulup = kulupList.get(i);
            View kartView = inflater.inflate(R.layout.as_kuluplerkarti, null);

            ImageView resim = kartView.findViewById(R.id.kulup_resmi);
            TextView adi = kartView.findViewById(R.id.kulup_adi);

            resim.setImageResource(kulup.getResimId());
            adi.setText(kulup.getKulupAdi());

            // Burada kartlara alt boşluk ekliyoruz (20px)
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.setMargins(0, 0, 0, 35); // Alt boşluk
            kartView.setLayoutParams(layoutParams);

            if (i < 31) {
                meslekiContainer.addView(kartView);
            } else if (i < 31 + 19) {
                sosyalContainer.addView(kartView);
            } else {
                sporContainer.addView(kartView);
            }
        }
    }
}
