package com.example.mysocialuni;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private Button profilButton;
    private Button akademikTakvimButton;
    private Button yemekhaneButton;
    private Button btnKulüpler;
    private FrameLayout btnResimli2;
    private FrameLayout btnResimli1;
    private RecyclerView recyclerView;
    private Typeface tf1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        profilButton = view.findViewById(R.id.profil_button);
        akademikTakvimButton = view.findViewById(R.id.btnAkademikTakvim);
        yemekhaneButton = view.findViewById(R.id.btnYemekhane);
        btnResimli1 = view.findViewById(R.id.btnResimli1);
        btnKulüpler = view.findViewById(R.id.btnKulupler);
        btnResimli2 = view.findViewById(R.id.btnResimli2);

        tf1 = Typeface.createFromAsset(requireContext().getAssets(), "fonts/yazı_tipi1.ttf");
        TextView homeText = view.findViewById(R.id.home_text);
        homeText.setTypeface(tf1);

        btnKulüpler.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASKulüplerActivity.class);
            startActivity(intent);
        });

        btnResimli2.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASTanıtımActivity.class);
            startActivity(intent);
        });

        profilButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ProfileMenuActivity.class);
            startActivity(intent);
        });

        akademikTakvimButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASAkademikTakvimActivity.class);
            startActivity(intent);
        });

        yemekhaneButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASYemekhaneActivity.class);
            startActivity(intent);
        });

        btnResimli1.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASHaberlerActivity.class);
            startActivity(intent);
        });

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<ASDuyurularModel> duyurular = new ArrayList<>();
        duyurular.add(new ASDuyurularModel("28", "Mayıs", "Yeni Duyuru Eklendi", "Detaylı açıklama 1"));
        duyurular.add(new ASDuyurularModel("30", "Mayıs", "Final Haftası Yaklaşıyor", "Detaylı açıklama 2"));
        duyurular.add(new ASDuyurularModel("05", "Haziran", "Kapanış Töreni", "Detaylı açıklama 3"));

        ASDuyurularAdapter adapter = new ASDuyurularAdapter(duyurular, requireContext());

        recyclerView.setAdapter(adapter);

        return view;
    }
}
