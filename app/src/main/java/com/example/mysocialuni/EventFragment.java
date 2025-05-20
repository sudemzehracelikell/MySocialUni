package com.example.mysocialuni;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EventFragment extends Fragment {

    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<EventModel> eventList;
    private Typeface tf2;

    public EventFragment() {
        // Zorunlu boş yapıcı
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Layout'u bağla
        View view = inflater.inflate(R.layout.fragment_event, container, false);

        tf2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/yazı_tipi1.ttf");
        //text yazı tipi degıstırmek
        TextView homeText = view.findViewById(R.id.event_text);
        homeText.setTypeface(tf2);

        // RecyclerView başlat
        recyclerView = view.findViewById(R.id.recyclerViewEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Örnek veriler
        eventList = new ArrayList<>();
        eventList.add(new EventModel("18", "Mart", "Finans ve Stratejide Liderlik", "Endüstri Mühendisliği kulübü   14.00 - 15.00"));
        eventList.add(new EventModel("22", "Mart", "Yapay Zeka ve Geleceği", "IEEE İSTUN   16.00 - 17.00"));
        eventList.add(new EventModel("5", "Nisan", "Kariyer Sohbetleri", "Girişimcilik Kulübü   13.00 - 14.30"));
        eventList.add(new EventModel("23","Haziran","İstech 2025","IEEE İSTUN   16.00 - 17.00"));
        eventList.add(new EventModel("23","Haziran","İstech - 2025","IEEE İSTUN   16.00 - 17.00"));
        eventList.add(new EventModel("5", "Nisan", "Kariyer Sohbetleri", "Girişimcilik Kulübü   13.00 - 14.30"));
        eventList.add(new EventModel("5", "Nisan", "Kariyer Sohbetleri", "Girişimcilik Kulübü   13.00 - 14.30"));
        eventList.add(new EventModel("5", "Nisan", "Kariyer Sohbetleri", "Girişimcilik Kulübü   13.00 - 14.30"));
        eventList.add(new EventModel("5", "Nisan", "Kariyer Sohbetleri", "Girişimcilik Kulübü   13.00 - 14.30"));
        // Daha fazlasını ekleyebilirsin

        // Adapter tanımla
        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);

        return view;
    }
}
