package com.example.mysocialuni;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventFragment extends Fragment {

    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<EventModel> eventList;

    public EventFragment() {
        // Zorunlu boş yapıcı
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        eventList = new ArrayList<>();
        eventList.add(new EventModel("18", "Mart", "Finans ve Stratejide Liderlik", "Endüstri Mühendisliği Kulübü   14.00 - 15.00"));
        eventList.add(new EventModel("22", "Mart", "Yapay Zeka ve Geleceği", "IEEE İSTUN   16.00 - 17.00"));
        eventList.add(new EventModel("5", "Nisan", "Kariyer Sohbetleri", "Girişimcilik Kulübü   13.00 - 14.30"));
        eventList.add(new EventModel("23", "Haziran", "İstech 2025", "IEEE İSTUN   16.00 - 17.00"));
        eventList.add(new EventModel("23", "Haziran", "İstech - 2025", "IEEE İSTUN   16.00 - 17.00"));
        eventList.add(new EventModel("5", "Nisan", "Kariyer Sohbetleri", "Girişimcilik Kulübü   13.00 - 14.30"));

        // Tarihe göre sırala
        Collections.sort(eventList);

        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);

        return view;
    }
}
