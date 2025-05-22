package com.example.mysocialuni;

import android.content.Context;
import android.content.Intent;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProjectRequestsAdapter extends RecyclerView.Adapter<ProjectRequestsAdapter.ViewHolder> {

    private Context context;
    private List<ProjectRequest> requestList;

    public ProjectRequestsAdapter(Context context, List<ProjectRequest> requestList) {
        this.context = context;
        this.requestList = requestList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_request, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProjectRequest request = requestList.get(position);

        holder.textName.setText(request.getName());
        holder.textProjectTitle.setText(request.getProjectTitle());
        holder.imageProfile.setImageResource(request.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, RequestDetailActivity.class);
            intent.putExtra("name", request.getName());
            intent.putExtra("email", request.getEmail());
            intent.putExtra("department", request.getDepartment());
            intent.putExtra("class", request.getClassYear());
            intent.putExtra("university", request.getUniversity());
            intent.putExtra("imageRes", request.getImageResId());
            intent.putExtra("cvRes", request.getCvResId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textProjectTitle;
        ImageView imageProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textProjectTitle = itemView.findViewById(R.id.textProjectTitle);
            imageProfile = itemView.findViewById(R.id.imageProfile);
        }
    }
}
