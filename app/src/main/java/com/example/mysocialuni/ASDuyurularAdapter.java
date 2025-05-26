package com.example.mysocialuni;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ASDuyurularAdapter extends RecyclerView.Adapter<ASDuyurularAdapter.DuyuruViewHolder> {

    private List<ASDuyurularModel> duyuruListesi;
    private Context context;

    public ASDuyurularAdapter(List<ASDuyurularModel> duyuruListesi, Context context) {
        this.duyuruListesi = duyuruListesi;
        this.context = context;
    }

    @NonNull
    @Override
    public DuyuruViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.as_duyurular_card, parent, false);
        return new DuyuruViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DuyuruViewHolder holder, int position) {
        ASDuyurularModel duyuru = duyuruListesi.get(position);
        holder.tvGun.setText(duyuru.getGun());
        holder.tvAy.setText(duyuru.getAy());
        holder.tvBaslik.setText(duyuru.getBaslik());
        // Açıklama kartta görünmüyor, o yüzden set edilmiyor
    }

    @Override
    public int getItemCount() {
        return duyuruListesi.size();
    }

    public static class DuyuruViewHolder extends RecyclerView.ViewHolder {
        TextView tvGun, tvAy, tvBaslik;

        public DuyuruViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGun = itemView.findViewById(R.id.tv_day);
            tvAy = itemView.findViewById(R.id.tv_month);
            tvBaslik = itemView.findViewById(R.id.tv_title);
        }
    }
}

