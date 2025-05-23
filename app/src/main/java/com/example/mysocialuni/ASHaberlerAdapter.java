package com.example.mysocialuni;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ASHaberlerAdapter extends RecyclerView.Adapter<ASHaberlerAdapter.ViewHolder> {

    private Context context;
    private List<ASHaberlerModel> haberList;

    public ASHaberlerAdapter(Context context, List<ASHaberlerModel> haberList) {
        this.context = context;
        this.haberList = haberList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.as_haberler_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ASHaberlerModel haber = haberList.get(position);
        holder.tvDay.setText(haber.getDay());
        holder.tvMonth.setText(haber.getMonth());
        holder.tvTitle.setText(haber.getTitle());
    }

    @Override
    public int getItemCount() {
        return haberList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDay, tvMonth, tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.tv_news_day);
            tvMonth = itemView.findViewById(R.id.tv_news_month);
            tvTitle = itemView.findViewById(R.id.tv_news_title);
        }
    }
}
