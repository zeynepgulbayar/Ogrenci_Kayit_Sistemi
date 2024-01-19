
package Ogrenci_Ders_Kayit.bin;

/*
import java.io.Serializable;
import java.util.List;

public class Ogrenci implements Serializable {
    private int ogrenciNo;
    private String ogrenciAd;
    private String ogrenciSoyad;
    private String ogrenciBolum;
    private List<Ders> ogrenciDersler;

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(int ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getOgrenciAd() {
        return ogrenciAd;
    }

    public void setOgrenciAd(String ogrenciAd) {
        this.ogrenciAd = ogrenciAd;
    }

    public String getOgrenciSoyad() {
        return ogrenciSoyad;
    }

    public void setOgrenciSoyad(String ogrenciSoyad) {
        this.ogrenciSoyad = ogrenciSoyad;
    }

    public String getOgrenciBolum() {
        return ogrenciBolum;
    }

    public void setOgrenciBolum(String ogrenciBolum) {
        this.ogrenciBolum = ogrenciBolum;
    }

    public List<Ders> getOgrenciDersler() {
        return ogrenciDersler;
    }

    public void setOgrenciDersler(List<Ders> ogrenciDersler) {
        this.ogrenciDersler = ogrenciDersler;
    }
}
*/


import java.util.ArrayList;
import java.util.List;

public class Ogrenci {
    private int ogrenciNo;
    private String ogrenciAd;
    private String ogrenciSoyad;
    private String ogrenciBolum;
    private List<Ders> ogrenciDersler;

    public Ogrenci(int ogrenciNo, String ogrenciAd, String ogrenciSoyad, String ogrenciBolum, List<Ders> ogrenciDersler) {
        this.ogrenciNo = ogrenciNo;
        this.ogrenciAd = ogrenciAd;
        this.ogrenciSoyad = ogrenciSoyad;
        this.ogrenciBolum = ogrenciBolum;
        this.ogrenciDersler = ogrenciDersler;
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(int ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getOgrenciAd() {
        return ogrenciAd;
    }

    public void setOgrenciAd(String ogrenciAd) {
        this.ogrenciAd = ogrenciAd;
    }

    public String getOgrenciSoyad() {
        return ogrenciSoyad;
    }

    public void setOgrenciSoyad(String ogrenciSoyad) {
        this.ogrenciSoyad = ogrenciSoyad;
    }

    public String getOgrenciBolum() {
        return ogrenciBolum;
    }

    public void setOgrenciBolum(String ogrenciBolum) {
        this.ogrenciBolum = ogrenciBolum;
    }

    public List<Ders> getOgrenciDersler() {
        return ogrenciDersler;
    }

    public void setOgrenciDersler(List<Ders> ogrenciDersler) {
        this.ogrenciDersler = ogrenciDersler;
    }
}
