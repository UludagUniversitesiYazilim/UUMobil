package com.example.berkay.uumobil.transcript;


public final class Course {
    private String harfNotu;
    private String dersAdi;
    private String dersKodu;
    private String akts;

    public Course(String dersKodu, String dersAdi,  String akts, String harfNotu) {
        this.harfNotu = harfNotu;
        this.dersAdi = dersAdi;
        this.dersKodu = dersKodu;
        this.akts = akts;

    }
    public String getHarfNotu() {
        return harfNotu;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public String getDersKodu() { return dersKodu;}

    public String getAkts() { return akts;}

}
