package com.example.mysocialuni;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ASYemekAdapter extends RecyclerView.Adapter<ASYemekAdapter.YemekViewHolder> {

    private List<ASYemekModel> yemekListesi;

    public ASYemekAdapter(List<ASYemekModel> yemekListesi) {
        this.yemekListesi = yemekListesi;
    }

    @NonNull
    @Override
    public YemekViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.as_yemek_card, parent, false);
        return new YemekViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YemekViewHolder holder, int position) {
        ASYemekModel yemek = yemekListesi.get(position);

        holder.gunText.setText(yemek.getGun());

        String[] ogleYemegi = yemek.getOgleYemegi().split("\n");
        holder.corbaText.setText(ogleYemegi.length > 0 ? ogleYemegi[0] : "");
        holder.anaYemekText.setText(ogleYemegi.length > 1 ? ogleYemegi[1] : "");
        holder.tatliText.setText(ogleYemegi.length > 2 ? ogleYemegi[2] : "");

        String[] aksamYemegi = yemek.getAksamYemegi().split("\n");
        holder.corbaText2.setText(aksamYemegi.length > 0 ? aksamYemegi[0] : "");
        holder.anaYemekText2.setText(aksamYemegi.length > 1 ? aksamYemegi[1] : "");
        holder.tatliText2.setText(aksamYemegi.length > 2 ? aksamYemegi[2] : "");
    }

    @Override
    public int getItemCount() {
        return yemekListesi.size();
    }

    public static class YemekViewHolder extends RecyclerView.ViewHolder {
        TextView gunText, corbaText, anaYemekText, tatliText;
        TextView corbaText2, anaYemekText2, tatliText2;

        public YemekViewHolder(@NonNull View itemView) {
            super(itemView);
            gunText = itemView.findViewById(R.id.gun_text);
            corbaText = itemView.findViewById(R.id.corba_text);
            anaYemekText = itemView.findViewById(R.id.ana_yemek_text);
            tatliText = itemView.findViewById(R.id.tatli_text);
            corbaText2 = itemView.findViewById(R.id.corba_text_2);
            anaYemekText2 = itemView.findViewById(R.id.ana_yemek_text_2);
            tatliText2 = itemView.findViewById(R.id.tatli_text_2);
        }
    }
}
