package com.example.mysocialuni;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ASKulüplerAdapter extends RecyclerView.Adapter<ASKulüplerAdapter.KulupViewHolder> {

    private final List<ASKulüplerModel> kulupList;

    public ASKulüplerAdapter(List<ASKulüplerModel> kulupList) {
        this.kulupList = kulupList;
    }

    @NonNull
    @Override
    public KulupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.as_kuluplerkarti, parent, false);
        return new KulupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KulupViewHolder holder, int position) {
        ASKulüplerModel item = kulupList.get(position);
        holder.kulupAdi.setText(item.getKulupAdi());
        holder.kulupResmi.setImageResource(item.getResimId());
    }

    @Override
    public int getItemCount() {
        return kulupList.size();
    }

    public static class KulupViewHolder extends RecyclerView.ViewHolder {
        ImageView kulupResmi;
        TextView kulupAdi;

        public KulupViewHolder(@NonNull View itemView) {
            super(itemView);
            kulupResmi = itemView.findViewById(R.id.kulup_resmi);
            kulupAdi = itemView.findViewById(R.id.kulup_adi);
        }
    }
}
