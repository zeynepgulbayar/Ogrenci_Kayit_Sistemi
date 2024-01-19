package Ogrenci_Ders_Kayit.bin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Ders implements Serializable {
    private String dersKodu;
    private String dersAd;
    private String dersDonem;

    // Parametresiz constructor
    public Ders() {
        // Boş constructor
    }
    public Ders(String dersAd, String dersKodu) {
        this.dersAd = dersAd;
        this.dersKodu = dersKodu;
    }

    public String getDersKodu() {
        return dersKodu;
    }

    public void setDersKodu(String dersKodu) {
        this.dersKodu = dersKodu;
    }

    public String getDersAd() {
        return dersAd;
    }

    public void setDersAd(String dersAd) {
        this.dersAd = dersAd;
    }

    public String getDersDonem() {
        return dersDonem;
    }

    public void setDersDonem(String dersDonem) {
        this.dersDonem = dersDonem;
    }


    // Örnek bir ders listesi oluşturmak için kullanılabilir
    private static List<Ders> createDersListesi() {
        // Ders listesi oluşturulup geri döndürülebilir
        // Örnek olarak:
        List<Ders> dersListesi = new ArrayList<>();
        dersListesi.add(new Ders("Matematik", "MAT101"));
        dersListesi.add(new Ders("Fizik", "FIZ101"));
        // ... vb.
        return dersListesi;
        // return null; // Gerçek bir ders listesi döndürülmelidir
    }

}
