package com.junianto.cobautsppb.model;

public class MenuModel {
    String namaMenu;
    int hargaMenu;
    String satuanMenu;
    int gambarMenu;

    public MenuModel(String namaMenu, int hargaMenu, String satuanMenu, int gambarMenu) {
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
        this.satuanMenu = satuanMenu;
        this.gambarMenu = gambarMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public int getHargaMenu() {
        return hargaMenu;
    }

    public void setHargaMenu(int hargaMenu) {
        this.hargaMenu = hargaMenu;
    }

    public String getSatuanMenu() {
        return satuanMenu;
    }

    public void setSatuanMenu(String satuanMenu) {
        this.satuanMenu = satuanMenu;
    }

    public int getGambarMenu() {
        return gambarMenu;
    }

    public void setGambarMenu(int gambarMenu) {
        this.gambarMenu = gambarMenu;
    }
}

