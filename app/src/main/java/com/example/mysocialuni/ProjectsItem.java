package com.example.mysocialuni;

import java.io.Serializable;

public class ProjectsItem implements Serializable {
    private String title;
    private String desc;
    private int image;
    private String[] projectMembers;
    private int[] projectPhotos;

    public ProjectsItem(String title, String desc, int image, String[] projectMembers, int[] projectPhotos) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.projectMembers = projectMembers;
        this.projectPhotos = projectPhotos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String[] getProjectMembers() {
        return projectMembers;
    }

    public void setProjectMembers(String[] projectMembers) {
        this.projectMembers = projectMembers;
    }

    public int[] getProjectPhotos() {
        return projectPhotos;
    }

    public void setProjectPhotos(int[] projectPhotos) {
        this.projectPhotos = projectPhotos;
    }
}
