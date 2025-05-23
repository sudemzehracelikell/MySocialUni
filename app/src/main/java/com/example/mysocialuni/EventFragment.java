package com.example.mysocialuni;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventFragment extends Fragment {

    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<eventModel> eventList;
    private Button profilButton;
    private Typeface tf2;

    public EventFragment() {
        // Zorunlu boş constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        profilButton = view.findViewById(R.id.profil_button);

        tf2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/yazı_tipi1.ttf");
        TextView homeText = view.findViewById(R.id.event_text);
        homeText.setTypeface(tf2);

        recyclerView = view.findViewById(R.id.recyclerViewEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Button etkinlikEkleButton = view.findViewById(R.id.etkinlikekle_button);
        etkinlikEkleButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), AddEventActivity.class);
            startActivityForResult(intent, 100); // 100 bizim tanımladığımız istek kodu
        });


        profilButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ProfileMenuActivity.class);
            startActivity(intent);
        });

        // Örnek etkinlikler
        eventList = new ArrayList<>();
        eventList.add(new eventModel("23", "Mayıs", "Doğadan Odaya: Koku Atölyesi",
                "Katılımcılar bu atölyede doğal aromalarla kendi koku karışımlarını oluşturma fırsatı bulacak. Etkinlikte bitki özleri, uçucu yağlar ve aromaterapi üzerine temel bilgiler paylaşılacak. Doğanın kokularını keşfetmek isteyenler için eşsiz bir deneyim sunuluyor. Atölye, duyusal farkındalığı artırmayı amaçlıyor. Etnobotanik Kulübü tarafından düzenlenmektedir.",
                "Etnobotanik Kulübü", "16:30", "18:00", R.drawable.dogadan_odaya));

        eventList.add(new eventModel("22", "Mayıs", "İngilizce Hazırlık Kapanış Programı",
                "Hazırlık öğrencileri için düzenlenen bu etkinlik, dönemin kapanışını keyifli bir şekilde kutlamayı hedefliyor. Programda öğrencilere sürpriz ödüller, müzik dinletileri ve eğlenceli aktiviteler sunulacak. Ayrıca öğretim elemanlarına teşekkürlerin iletileceği bir kapanış konuşması yapılacak. Etkinlik, hazırlık yılı boyunca kaynaşan öğrencilerin vedalaşmasına vesile olacak. İSTÜN organizasyonuyla gerçekleşmektedir.",
                "İSTÜN", "12:30", "14:00", R.drawable.inghazirlik));

        eventList.add(new eventModel("22", "Mayıs", "Yasla Tanışmak ve Film Analizi",
                "Etkinlikte, katılımcılar yaş kavramı üzerine derinlemesine düşünmeye davet ediliyor. Film gösteriminin ardından, yaşlanma, bireysel gelişim ve toplumsal algılar üzerine psikolojik bir analiz yapılacak. Açık tartışma formatında ilerleyen etkinlik, düşünsel etkileşimi teşvik ediyor. Psikoloji Kulübü tarafından organize edilen bu buluşma, farkındalık yaratmayı amaçlıyor.",
                "Psikoloji Kulübü", "15:30", "17:30", R.drawable.yaslatanismak));

        eventList.add(new eventModel("22", "Mayıs", "TÜBİTAK 2209-A VE 2209-B",
                "Bu etkinlikte, TÜBİTAK 2209-A ve 2209-B programlarının başvuru süreçleri ve detayları anlatılacak. Öğrenciler, proje yazımı ve destek almanın incelikleri hakkında bilgi edinebilecek. Daha önce destek almış öğrenciler deneyimlerini paylaşacak. Bilimsel araştırmalara ilgi duyan herkesin katılımına açıktır. Etkinlik İSTÜN koordinasyonunda gerçekleşecektir.",
                "İSTÜN", "14:00", "16:00", R.drawable.tubitak2209a));

        eventList.add(new eventModel("21", "Mayıs", "Sarajevo’da Mimarlık Söyleşisi",
                "Sarajevo’nun mimari dokusu ve kentin tarihsel gelişimi üzerine ilham verici bir söyleşi gerçekleşecek. Fotoğraf sanatıyla mimarinin birleştiği bu etkinlikte, mimari mekanların görsel dili tartışılacak. Konuk konuşmacı deneyimlerini paylaşarak genç mimarlara ilham verecek. Etkinlik, kültürel perspektif kazandırmayı hedefliyor. Mimarlık ve Tasarım Kulübü tarafından düzenlenmiştir.",
                "Mimarlık ve Tasarim Kulübü", "11:00", "12:30", R.drawable.sarav));

        eventList.add(new eventModel("21", "Mayıs", "CV Hazırlama ve Mülakat Süreçleri",
                "Kariyer yolculuğuna hazırlanan öğrenciler için pratik bilgiler sunan bir etkinliktir. CV oluşturmanın püf noktaları, doğru formatlama ve içerik planlaması anlatılacak. Mülakat teknikleri, beden dili ve özgüven üzerine de uygulamalı öneriler verilecek. Katılımcılar, kariyer hedeflerini destekleyecek ipuçlarıyla etkinlikten ayrılacak. İSTÜN Kariyer Merkezi katkısıyla gerçekleştirilmektedir.",
                "İSTÜN", "13:30", "15:30", R.drawable.procvhazirlama));

        eventList.add(new eventModel("20", "Mayıs", "Yüz Yogası Sağlıklı Ciltler 2",
                "Yüz kaslarını çalıştırarak sağlıklı ve genç bir görünüm elde etmeyi amaçlayan bir atölyedir. Katılımcılara yüz yogasının temel hareketleri gösterilecek ve birlikte uygulama yapılacaktır. Cilt sağlığına dair ipuçları ve doğal bakım önerileri de paylaşılacaktır. Etkinlik, beden-zihin bütünlüğünü destekleyen bir yaklaşımla sunulmaktadır. Yoga ve Sağlıklı Yaşam Kulübü ev sahipliğinde gerçekleşmektedir.",
                "Yoga ve Sağlıklı Yaşam Kulübü", "12:30", "13:30", R.drawable.yuzyogasi));

        eventList.add(new eventModel("20", "Mayıs", "NEXTMED Öğrenci Sempozyumu",
                "Tıp ve sağlık bilimleri alanındaki güncel araştırmaların paylaşıldığı öğrenci sempozyumudur. Etkinlikte çeşitli fakültelerden öğrenciler projelerini ve çalışmalarını sunacak. Alanında uzman konuşmacılar seminerler gerçekleştirecek. Bilimsel etkileşimi artırmayı ve iş birliği fırsatları yaratmayı amaçlamaktadır. Öğrenci Bilimsel Araştırma Kulübü tarafından organize edilmektedir.",
                "Öğrenci Bilimsel Araştırma Kulübü", "8:30", "18:30", R.drawable.nextmed));

        Collections.sort(eventList);

        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == getActivity().RESULT_OK && data != null) {
            String gun = data.getStringExtra("gun");
            String ay = data.getStringExtra("ay");
            String baslik = data.getStringExtra("baslik");
            String aciklama = data.getStringExtra("aciklama");
            String kulup = data.getStringExtra("kulup");
            String baslangic = data.getStringExtra("baslangic");
            String bitis = data.getStringExtra("bitis");
            int resim = data.getIntExtra("resim", R.drawable.as_etkinliklerkart_background); // default resim

            eventModel yeniEtkinlik = new eventModel(gun, ay, baslik, aciklama, kulup, baslangic, bitis, resim);
            eventList.add(yeniEtkinlik);
            Collections.sort(eventList);
            eventAdapter.notifyDataSetChanged();
        }
    }
}
