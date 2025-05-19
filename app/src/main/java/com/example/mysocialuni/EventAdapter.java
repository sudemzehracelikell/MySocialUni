package com.example.mysocialuni;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<EventModel> eventList;

    public EventAdapter(List<EventModel> eventList) {
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
        EventModel event = eventList.get(position);
        holder.tvDay.setText(String.valueOf(event.day));
        holder.tvMonth.setText(event.getMonthName());
        holder.tvTitle.setText(event.title);
        holder.tvClubAndTime.setText(event.clubAndTime);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView tvDay, tvMonth, tvTitle, tvClubAndTime;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.tv_day);
            tvMonth = itemView.findViewById(R.id.tv_month);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvClubAndTime = itemView.findViewById(R.id.tv_club_and_time);
        }
    }
}
