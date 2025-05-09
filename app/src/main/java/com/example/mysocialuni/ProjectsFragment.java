package com.example.mysocialuni;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class ProjectsFragment extends Fragment {

    public ProjectsFragment() {
        // Zorunlu boş yapıcı
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // fragment_projects.xml dosyasını bağla
        return inflater.inflate(R.layout.fragment_projects, container, false);
    }
}
