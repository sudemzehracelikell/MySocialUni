package com.example.mysocialuni;

import java.util.HashMap;
import java.util.Map;

public class EventModel implements Comparable<EventModel> {
    public int day;
    public int month;
    public String title;
    public String clubAndTime;

    public EventModel(String day, String month, String title, String clubAndTime) {
        this.day = Integer.parseInt(day);
        this.month = convertMonthToNumber(month);
        this.title = title;
        this.clubAndTime = clubAndTime;
    }

    private int convertMonthToNumber(String monthName) {
        Map<String, Integer> monthMap = new HashMap<>();
        monthMap.put("Ocak", 1);
        monthMap.put("Şubat", 2);
        monthMap.put("Mart", 3);
        monthMap.put("Nisan", 4);
        monthMap.put("Mayıs", 5);
        monthMap.put("Haziran", 6);
        monthMap.put("Temmuz", 7);
        monthMap.put("Ağustos", 8);
        monthMap.put("Eylül", 9);
        monthMap.put("Ekim", 10);
        monthMap.put("Kasım", 11);
        monthMap.put("Aralık", 12);

        return monthMap.getOrDefault(monthName, 0); // Geçersiz ay ismi durumunda 0 döner
    }

    @Override
    public int compareTo(EventModel other) {
        if (this.month != other.month) {
            return Integer.compare(this.month, other.month);
        } else {
            return Integer.compare(this.day, other.day);
        }
    }

    public String getMonthName() {
        String[] monthNames = {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
        return (month >= 1 && month <= 12) ? monthNames[month] : "";
    }
}
