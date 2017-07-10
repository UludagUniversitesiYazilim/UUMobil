package com.example.berkay.uumobil.mark;


public final class Not {
    private String harfNotu;
    private String dersAdi;
    private String dersKodu;
    private float vizeNotu;
    private float finalNotu;
    private float donemNotu;
    private float butunlemeNotu;

    public Not(String dersAdi, String dersKodu) {
        dersAdi = dersAdi;
        dersKodu = dersKodu;

        this.harfNotu = null;
        this.vizeNotu = -1;
        this.finalNotu = -1;
        this.donemNotu = -1;
        this.butunlemeNotu = -1;
    }

    public Not(String harfNotu, String dersAdi, float vizeNotu, float finalNotu, float butunlemeNotu) {
        this.harfNotu = harfNotu;
        this.dersAdi = dersAdi;
        this.vizeNotu = vizeNotu;
        this.finalNotu = finalNotu;
        this.butunlemeNotu = butunlemeNotu;

        this.donemNotu = -1;
        this.dersKodu = null;
    }

    public void setHarfNotu(String harfNotu) {
        this.harfNotu = harfNotu;
    }

    public void setVizeNotu(float vizeNotu) {
        this.vizeNotu = vizeNotu;
    }

    public void setFinalNotu(float finalNotu) {
        this.finalNotu = finalNotu;
    }

    public void setDonemNotu(float donemNotu) {
        this.donemNotu = donemNotu;
    }

    public void setButunlemeNotu(float butunlemeNotu) {
        this.butunlemeNotu = butunlemeNotu;
    }

    public String getHarfNotu() {
        return harfNotu;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public float getVizeNotu() {
        return vizeNotu;
    }

    public float getFinalNotu() {
        return finalNotu;
    }

    public float getButunlemeNotu() {
        return butunlemeNotu;
    }
}
