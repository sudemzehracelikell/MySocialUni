package com.example.mysocialuni;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class EventFragment extends Fragment {

    public EventFragment() {
        // Zorunlu boş yapıcı
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // fragment_event.xml dosyasını bağla
        return inflater.inflate(R.layout.fragment_event, container, false);
    }
}
