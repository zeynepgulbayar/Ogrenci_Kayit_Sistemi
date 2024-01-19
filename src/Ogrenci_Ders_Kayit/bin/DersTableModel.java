package Ogrenci_Ders_Kayit.bin;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DersTableModel extends AbstractTableModel {
    private final List<Ders> dersListesi;
    private final String[] columns = {"Ders Kodu", "Ders Adı", "Ders Dönemi"};

    public DersTableModel(List<Ders> dersListesi) {
        this.dersListesi = dersListesi;
    }

    @Override
    public int getRowCount() {
        return dersListesi.size();
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
        Ders ders = dersListesi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ders.getDersKodu();
            case 1:
                return ders.getDersAd();
            case 2:
                return ders.getDersDonem();
            default:
                return null;
        }
    }
}
