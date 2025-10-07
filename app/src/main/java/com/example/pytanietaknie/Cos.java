package com.example.pytanietaknie;

import java.util.ArrayList;

public class Cos {
    private int idobrazek;
    private String trescpytania;
    private boolean odpowiedz;
    private String podpowiedzi;
    private boolean czyOdpOk;

    public Cos(int idobrazek, String trescpytania, boolean odpowiedz, String podpowiedzi) {
        this.idobrazek = idobrazek;
        this.trescpytania = trescpytania;
        this.odpowiedz = odpowiedz;
        this.podpowiedzi = podpowiedzi;
        czyOdpOk = false;
    }

    public int getIdobrazek() {
        return idobrazek;
    }

    public String getTrescpytania() {
        return trescpytania;
    }

    public boolean isOdpowiedz() {
        return odpowiedz;
    }

    public String getPodpowiedzi() {
        return podpowiedzi;
    }

    public boolean isCzyOdpOk() {
        return czyOdpOk;
    }

    public void setCzyOdpOk(boolean czyOdpOk) {
        this.czyOdpOk = czyOdpOk;
    }
}
