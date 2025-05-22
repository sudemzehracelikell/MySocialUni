package com.example.mysocialuni;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<eventModel> eventList;

    public EventAdapter(List<eventModel> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        eventModel event = eventList.get(position);
        holder.tvDay.setText(String.valueOf(event.day));
        holder.tvMonth.setText(event.getMonthName());
        holder.tvTitle.setText(event.title);
        holder.tvClubAndTime.setText(event.getClubAndTime());
        //holder.ivEvent.setImageResource(event.imageResId);

        // Detay sayfasına geçiş
        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, EventDetailActivity.class);
            intent.putExtra("gun", String.valueOf(event.day));
            intent.putExtra("ay", event.getMonthName());
            intent.putExtra("baslik", event.title);
            intent.putExtra("aciklama", event.description);
            intent.putExtra("kulup", event.clubName);
            intent.putExtra("saatBaslangic", event.startTime);
            intent.putExtra("saatBitis", event.endTime);
            intent.putExtra("resimId", event.imageResId);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView tvDay, tvMonth, tvTitle, tvClubAndTime;
        //ImageView ivEvent;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.tv_day);
            tvMonth = itemView.findViewById(R.id.tv_month);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvClubAndTime = itemView.findViewById(R.id.tv_club_and_time);
            //ivEvent = itemView.findViewById(R.id.iv_event); // XML içinde bu ID'ye sahip olmalı
        }
    }
}
