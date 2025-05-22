package com.example.mysocialuni;
public class ASKulüplerModel {
    private final int resimId;
    private final String kulupAdi;

    public ASKulüplerModel(int resimId, String kulupAdi) {
        this.resimId = resimId;
        this.kulupAdi = kulupAdi;
    }

    public int getResimId() {
        return resimId;
    }

    public String getKulupAdi() {
        return kulupAdi;
    }
}
