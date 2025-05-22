package com.example.mysocialuni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ProjectAdapter extends BaseAdapter {

    private ArrayList<ProjectsItem> projectList;
    private LayoutInflater inflater;
    private Context context;

    public ProjectAdapter(ArrayList<ProjectsItem> projectList, Context context) {
        this.projectList = projectList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return projectList.size();
    }

    @Override
    public Object getItem(int position) {
        return projectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "SetTextI18n"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.listview_projectsitem, parent, false);

        ProjectsItem project = projectList.get(position);

        ConstraintLayout constraintLayout = convertView.findViewById(R.id.layout_inListViewProjects);

        TextView textView_titleProject = convertView.findViewById(R.id.textView_titleProject);
        TextView textView_descProject = convertView.findViewById(R.id.textView_descProject);
        TextView textView_titleAllMembers = convertView.findViewById(R.id.textView_titleAllMembers);
        ImageView imageView_profilePhotoFromMembers = convertView.findViewById(R.id.imageView_profilePhotoFromMembers);

        textView_titleProject.setText(project.getTitle());
        textView_descProject.setText(project.getDesc());
        textView_titleAllMembers.setText(project.getProjectMembers()[0] + " ve " + (project.getProjectMembers().length - 1) + " kişi");

        imageView_profilePhotoFromMembers.setImageResource(R.drawable.testprofilepicture);

        //int imageyi, drawable'a çeviriyoruz
        Drawable image = ContextCompat.getDrawable(context, project.getImage());
        constraintLayout.setBackground(image);

        return convertView;
    }
}
