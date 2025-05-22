package com.example.mysocialuni;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProjectRequestsActivity extends AppCompatActivity {

    RecyclerView recyclerRequests;
    ProjectRequestsAdapter adapter;
    List<ProjectRequest> requestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_requests);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());


        recyclerRequests = findViewById(R.id.recyclerRequests);
        recyclerRequests.setLayoutManager(new LinearLayoutManager(this));

        requestList = new ArrayList<>();
        requestList.add(new ProjectRequest(
                "Yusuf Deligöz",
                "yusufdeligoz@gmail.com",
                "Yazılım Mühendisliği",
                "2. Sınıf",
                "İstanbul Sağlık ve Teknoloji Üniversitesi",
                "Kelime Macerası - Dil Öğrenme ve Hikaye Tabanlı Oyun",
                R.drawable.profile1,
                R.drawable.sample_cv));

        requestList.add(new ProjectRequest(
                "Berat Serçe",
                "beratserce@gmail.com",
                "Bilgisayar Mühendisliği",
                "3. Sınıf",
                "Boğaziçi Üniversitesi",
                "Kelime Macerası - Dil Öğrenme ve Hikaye Tabanlı Oyun",
                R.drawable.profile2,
                R.drawable.sample_cv));

        requestList.add(new ProjectRequest(
                "İlknur Çelik",
                "ilknur@gmail.com",
                "Elektrik-Elektronik Mühendisliği",
                "1. Sınıf",
                "İTÜ",
                "Kelime Macerası - Dil Öğrenme ve Hikaye Tabanlı Oyun",
                R.drawable.profile3,
                R.drawable.sample_cv));

        requestList.add(new ProjectRequest(
                "Sudem Zehra Çelikel",
                "sudem@gmail.com",
                "Endüstri Mühendisliği",
                "4. Sınıf",
                "ODTÜ",
                "Kelime Macerası - Dil Öğrenme ve Hikaye Tabanlı Oyun",
                R.drawable.profile4,
                R.drawable.sample_cv));



        adapter = new ProjectRequestsAdapter(this, requestList);
        recyclerRequests.setAdapter(adapter);
    }
}
