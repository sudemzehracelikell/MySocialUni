package com.example.mysocialuni;

public class ASDuyurularModel {
    private String gun;
    private String ay;
    private String baslik;
    private String aciklama;

    public ASDuyurularModel(String gun, String ay, String baslik, String aciklama) {
        this.gun = gun;
        this.ay = ay;
        this.baslik = baslik;
        this.aciklama = aciklama;
    }

    public String getGun() {
        return gun;
    }

    public String getAy() {
        return ay;
    }

    public String getBaslik() {
        return baslik;
    }

    public String getAciklama() {
        return aciklama;
    }
}
