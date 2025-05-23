package com.example.mysocialuni;

public class ASHaberlerModel {
    private String day;
    private String month;
    private String title;

    public ASHaberlerModel(String day, String month, String title) {
        this.day = day;
        this.month = month;
        this.title = title;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getTitle() {
        return title;
    }
}
