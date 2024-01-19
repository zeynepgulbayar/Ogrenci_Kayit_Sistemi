package Ogrenci_Ders_Kayit.bin;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class OgrenciTableModel extends AbstractTableModel {
    private final List<Ogrenci> ogrenciListesi;
    private final String[] columns = {"Öğrenci No", "Adı", "Soyadı", "Bölümü", "Dersleri"};

    public OgrenciTableModel(List<Ogrenci> ogrenciListesi) {
        this.ogrenciListesi = ogrenciListesi;
    }

    @Override
    public int getRowCount() {
        return ogrenciListesi.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ogrenci ogrenci = ogrenciListesi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ogrenci.getOgrenciNo();
            case 1:
                return ogrenci.getOgrenciAd();
            case 2:
                return ogrenci.getOgrenciSoyad();
            case 3:
                return ogrenci.getOgrenciBolum();
            case 4:
                StringBuilder derslerString = new StringBuilder();
                for (Ders ders : ogrenci.getOgrenciDersler()) {
                    derslerString.append(ders.getDersAd()).append(", ");
                }
                return derslerString.toString();
            default:
                return null;
        }
    }
}
