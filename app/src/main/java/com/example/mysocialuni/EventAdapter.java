package com.example.mysocialuni;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.app.AlertDialog;
import android.widget.Toast;

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
        holder.tvClubAndTime.setText(event.clubName);

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

        // Uzun basınca özel dialog ile silme
        holder.itemView.setOnLongClickListener(v -> {
            Context context = v.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View dialogView = inflater.inflate(R.layout.dialog_delete_event, null);

            AlertDialog dialog = new AlertDialog.Builder(context)
                    .setView(dialogView)
                    .create();

            Button btnSil = dialogView.findViewById(R.id.btnSil);
            Button btnVazgec = dialogView.findViewById(R.id.btnVazgec);

            btnSil.setOnClickListener(view -> {
                eventList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, eventList.size());
                Toast.makeText(context, "Etkinlik silindi", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });

            btnVazgec.setOnClickListener(view -> dialog.dismiss());

            dialog.show();
            return true;
        });
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
