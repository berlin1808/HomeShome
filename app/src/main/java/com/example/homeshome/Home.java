package com.example.homeshome;

public class Home {
    private final int id;
    private final String jbayar;
    private final double harga;
    private final String alamat;
    private final int ltanah;
    private final int lbangunan;
    private final int bkamar;
    private final int bkmandi;
    private final int bgarasi;
    private final String ket;
    private final String jhome;
    private final String gambar;

    public Home(int id, String jbayar, double harga, String alamat, int ltanah, int lbangunan, int bkamar, int bkmandi, int bgarasi, String ket, String jhome, String gambar) {
        this.id = id;
        this.jbayar = jbayar;
        this.harga = harga;
        this.alamat = alamat;
        this.ltanah = ltanah;
        this.lbangunan = lbangunan;
        this.bkamar = bkamar;
        this.bkmandi = bkmandi;
        this.bgarasi = bgarasi;
        this.ket = ket;
        this.jhome = jhome;
        this.gambar = gambar;
    }

    public int getId() {
        return id;
    }

    public String getJbayar() {
        return jbayar;
    }

    public double getHarga() {
        return harga;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getLtanah() {
        return ltanah;
    }

    public int getLbangunan() {
        return lbangunan;
    }

    public int getBkamar() {
        return bkamar;
    }

    public int getBkmandi() {
        return bkmandi;
    }

    public int getBgarasi() {
        return bgarasi;
    }

    public String getKet() {
        return ket;
    }

    public String getJhome() {
        return jhome;
    }

    public String getGambar() {
        return gambar;
    }
}
