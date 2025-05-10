package com.example.mysocialuni;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private Button profilButton;
    private Button etkinliklerButton;
    private Button akademikTakvimButton;
    private Button yemekhaneButton;
    private LinearLayout etkinlikKartlari;
    private FrameLayout btnResimli1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        profilButton = view.findViewById(R.id.profil_button);
        etkinliklerButton = view.findViewById(R.id.btnEtkinlikler);
        akademikTakvimButton = view.findViewById(R.id.btnAkademikTakvim);
        yemekhaneButton = view.findViewById(R.id.btnYemekhane);
        btnResimli1 = view.findViewById(R.id.btnResimli1);
        etkinlikKartlari = view.findViewById(R.id.EtkinlikKarti1);

        etkinlikKartlari.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASEtkinlikKarti1Activity.class);
            startActivity(intent);
        });

        etkinliklerButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASEtkinliklerActivity.class);
            startActivity(intent);
        });

        profilButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ASProfilActivity.class);
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
            Intent intent = new Intent(getActivity(), ASBoşSayfaActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
