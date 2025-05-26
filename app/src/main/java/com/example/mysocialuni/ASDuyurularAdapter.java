package com.example.mysocialuni;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ASDuyurularAdapter extends RecyclerView.Adapter<ASDuyurularAdapter.ViewHolder> {

    private List<ASDuyurularModel> duyuruList;
    private Context context;

    public ASDuyurularAdapter(List<ASDuyurularModel> duyuruList, Context context) {
        this.duyuruList = duyuruList;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView gunTextView, ayTextView, baslikTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            gunTextView = itemView.findViewById(R.id.duyuru_gun);
            ayTextView = itemView.findViewById(R.id.duyuru_ay);
            baslikTextView = itemView.findViewById(R.id.duyuru_baslik);
        }
    }

    @Override
    public ASDuyurularAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.as_duyurular_card, parent, false);
        return new ASDuyurularAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ASDuyurularAdapter.ViewHolder holder, int position) {
        ASDuyurularModel duyuru = duyuruList.get(position);
        holder.gunTextView.setText(duyuru.getGun());
        holder.ayTextView.setText(duyuru.getAy());
        holder.baslikTextView.setText(duyuru.getBaslik());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ASDuyuruDetayActivity.class);
            intent.putExtra("gun", duyuru.getGun());
            intent.putExtra("ay", duyuru.getAy());
            intent.putExtra("baslik", duyuru.getBaslik());
            intent.putExtra("aciklama", duyuru.getAciklama());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return duyuruList.size();
    }
}
