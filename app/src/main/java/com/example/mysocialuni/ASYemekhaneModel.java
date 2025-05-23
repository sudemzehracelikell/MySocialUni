package com.example.mysocialuni;

public class ASYemekhaneModel {
    private String gun;
    private String ogleYemegi;
    private String aksamYemegi;

    public ASYemekhaneModel(String gun, String ogleYemegi, String aksamYemegi) {
        this.gun = gun;
        this.ogleYemegi = ogleYemegi;
        this.aksamYemegi = aksamYemegi;
    }

    public String getGun() {
        return gun;
    }

    public String getOgleYemegi() {
        return ogleYemegi;
    }

    public String getAksamYemegi() {
        return aksamYemegi;
    }
}
