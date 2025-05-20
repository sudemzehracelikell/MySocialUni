package com.example.mysocialuni;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Objects;

public class ProjectsFragment extends Fragment {

    private AppCompatActivity appCompatActivity;

    private ListView listViewProjects;
    private ArrayList<ProjectsItem> projectArrayList;

    private TextView textView_title;

    public ProjectsFragment() {
        // Zorunlu boş yapıcı
    }

    public void init(View view){
        textView_title = view.findViewById(R.id.profile_text);
        listViewProjects = view.findViewById(R.id.listview_projects);

        projectArrayList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // fragment_projects.xml dosyasını bağla
        return inflater.inflate(R.layout.fragment_projects, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appCompatActivity = (AppCompatActivity) getActivity();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
        textView_title.setTypeface(Typeface.createFromAsset(appCompatActivity.getAssets(), "fonts/yazı_tipi1.ttf"));

        String[] kullanicilar = {"rraeichp","yusufdeligoz","beyzanurbayır","lastvenush","karamanli"};
        String[] kullanicilar2 = {"yusufdeligoz","rraeichp","beyzanurbayır","lastvenush","karamanli"};
        String[] kullanicilar3 = {"lastvenush","rraeichp","yusufdeligoz","beyzanurbayır","karamanli"};

        projectArrayList.add(new ProjectsItem("Kelime Macerası - Dil Öğrenme ve Hikaye Tabanlı Oyun","Bu uygulama, kullanıcıların İngilizce veya başka bir dili öğrenirken hikaye tabanlı bir oyun oynamasını sağlar. Kullanıcılar bir karakter seçer ve interaktif bir hikaye boyunca ilerlerken doğru kelimeleri, seçerek bulmacaları çözer.",R.drawable.testbackground,kullanicilar));
        projectArrayList.add(new ProjectsItem("Kelime Macerası - Dil Öğrenme ve Hikaye Tabanlı Oyun","Bu uygulama, kullanıcıların İngilizce veya başka bir dili öğrenirken hikaye tabanlı bir oyun oynamasını sağlar. Kullanıcılar bir karakter seçer ve interaktif bir hikaye boyunca ilerlerken doğru kelimeleri, seçerek bulmacaları çözer.",R.drawable.testbackground2,kullanicilar2));
        projectArrayList.add(new ProjectsItem("Kelime Macerası - Dil Öğrenme ve Hikaye Tabanlı Oyun","Bu uygulama, kullanıcıların İngilizce veya başka bir dili öğrenirken hikaye tabanlı bir oyun oynamasını sağlar. Kullanıcılar bir karakter seçer ve interaktif bir hikaye boyunca ilerlerken doğru kelimeleri, seçerek bulmacaları çözer.",R.drawable.testbackground3,kullanicilar3));
        projectArrayList.add(new ProjectsItem("Kelime Macerası - Dil Öğrenme ve Hikaye Tabanlı Oyun","Bu uygulama, kullanıcıların İngilizce veya başka bir dili öğrenirken hikaye tabanlı bir oyun oynamasını sağlar. Kullanıcılar bir karakter seçer ve interaktif bir hikaye boyunca ilerlerken doğru kelimeleri, seçerek bulmacaları çözer.",R.drawable.testbackground2,kullanicilar2));
        projectArrayList.add(new ProjectsItem("Kelime Macerası - Dil Öğrenme ve Hikaye Tabanlı Oyun","Bu uygulama, kullanıcıların İngilizce veya başka bir dili öğrenirken hikaye tabanlı bir oyun oynamasını sağlar. Kullanıcılar bir karakter seçer ve interaktif bir hikaye boyunca ilerlerken doğru kelimeleri, seçerek bulmacaları çözer.",R.drawable.testbackground,kullanicilar));

        listViewProjects.setAdapter(new ProjectAdapter(projectArrayList,appCompatActivity));
    }
}
