package com.example.mysocialuni;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Zorunlu boş yapıcı (fragment yöneticisi tarafından kullanılır)
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Fragment'ın görünümünü bağla
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
