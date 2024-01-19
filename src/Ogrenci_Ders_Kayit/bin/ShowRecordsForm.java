/*

package Ogrenci_Ders_Kayit.bin;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class ShowRecordsForm extends JFrame {
    private final List<Ders> dersListesi;
    private final List<Ogrenci> ogrenciListesi;
    private final DefaultTableModel dersTableModel;
    private final DefaultTableModel ogrenciTableModel;

    public ShowRecordsForm(List<Ders> dersListesi, List<Ogrenci> ogrenciListesi) {
        this.dersListesi = dersListesi;
        this.ogrenciListesi = ogrenciListesi;

        String[] dersColumnNames = {"Ders Kodu", "Ders Adı", "Ders Dönemi"};
        dersTableModel = new DefaultTableModel(dersColumnNames, 0);
        for (Ders ders : dersListesi) {
            Object[] row = {ders.getDersKodu(), ders.getDersAd(), ders.getDersDonem()};
            dersTableModel.addRow(row);
        }

        String[] ogrenciColumnNames = {"Öğrenci No", "Adı", "Soyadı", "Bölümü", "Dersleri"};
        ogrenciTableModel = new DefaultTableModel(ogrenciColumnNames, 0);
        for (Ogrenci ogrenci : ogrenciListesi) {
            StringBuilder dersler = new StringBuilder();
            for (Ders ders : ogrenci.getOgrenciDersler()) {
                dersler.append(ders.getDersAd()).append(", ");
            }
            Object[] row = {ogrenci.getOgrenciNo(), ogrenci.getOgrenciAd(), ogrenci.getOgrenciSoyad(), ogrenci.getOgrenciBolum(), dersler.toString()};
            ogrenciTableModel.addRow(row);
        }

        JTabbedPane tabbedPane = new JTabbedPane();
        JTable dersTable = new JTable(dersTableModel);
        JTable ogrenciTable = new JTable(ogrenciTableModel);
        tabbedPane.addTab("Dersler", new JScrollPane(dersTable));
        tabbedPane.addTab("Öğrenciler", new JScrollPane(ogrenciTable));

        add(tabbedPane);
        setTitle("Kayıtları Göster");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        List<Ders> dersListesi = createDersListesi();
        List<Ogrenci> ogrenciListesi = createOgrenciListesi();

        SwingUtilities.invokeLater(() -> {
            ShowRecordsForm showRecordsForm = new ShowRecordsForm(dersListesi, ogrenciListesi);
        });
    }

    private static List<Ders> createDersListesi() {
        List<Ders> dersListesi = new ArrayList<>();
        // Ders listesinin oluşturulması
        dersListesi.add(new Ders("Matematik", "MAT101"));
        dersListesi.add(new Ders("Fizik", "FIZ101"));
        return dersListesi;
    }

    private static List<Ogrenci> createOgrenciListesi() {
        List<Ogrenci> ogrenciListesi = new ArrayList<>();
        // Öğrenci listesinin oluşturulması
        return ogrenciListesi;
    }
}
*/
/*
package Ogrenci_Ders_Kayit.bin;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ShowRecordsForm extends JFrame {

    private JTable table;

    public ShowRecordsForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Kayıtlar");

        // Dersler tablosu
        String[] dersColumnNames = {"Ders Kodu", "Ders Adı", "Ders Dönemi"};
        DefaultTableModel dersModel = new DefaultTableModel(dersColumnNames, 0);
        JTable dersTable = new JTable(dersModel);

        // Öğrenciler tablosu
        String[] ogrenciColumnNames = {"Öğrenci No", "Adı", "Soyadı", "Bölümü", "Dersleri"};
        DefaultTableModel ogrenciModel = new DefaultTableModel(ogrenciColumnNames, 0);
        JTable ogrenciTable = new JTable(ogrenciModel);

        // Dersleri ve öğrencileri dosyalardan oku
        List<Ders> dersListesi = readDerslerFromJSON("dersler.json");
        List<Ogrenci> ogrenciListesi = readOgrencilerFromJSON("ogrenciler.json");

        // Dersleri tabloya ekle
        if (dersListesi != null) {
            for (Ders ders : dersListesi) {
                dersModel.addRow(new Object[]{ders.getDersKodu(), ders.getDersAd(), ders.getDersDonem()});
            }
        }

        // Öğrencileri tabloya ekle
        if (ogrenciListesi != null) {
            for (Ogrenci ogrenci : ogrenciListesi) {
                String dersler = "";
                for (Ders ders : ogrenci.getOgrenciDersler()) {
                    dersler += ders.getDersAd() + ", ";
                }
                ogrenciModel.addRow(new Object[]{ogrenci.getOgrenciNo(), ogrenci.getOgrenciAd(), ogrenci.getOgrenciSoyad(), ogrenci.getOgrenciBolum(), dersler});
            }
        }

        // Dersler tablosunu ekranın üst kısmına, Öğrenciler tablosunu ekranın alt kısmına ekle
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JScrollPane(dersTable));
        panel.add(new JScrollPane(ogrenciTable));
        add(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private List<Ders> readDerslerFromJSON(String dosyaAdi) {
        try (FileReader fileReader = new FileReader(dosyaAdi)) {
            Gson gson = new Gson();
            java.lang.reflect.Type dersListesiType = new TypeToken<List<Ders>>() {}.getType();
            return gson.fromJson(fileReader, dersListesiType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Ogrenci> readOgrencilerFromJSON(String dosyaAdi) {
        try (FileReader fileReader = new FileReader(dosyaAdi)) {
            Gson gson = new Gson();
            java.lang.reflect.Type ogrenciListesiType = new TypeToken<List<Ogrenci>>() {}.getType();
            return gson.fromJson(fileReader, ogrenciListesiType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShowRecordsForm::new);
    }
}
*/
package Ogrenci_Ders_Kayit.bin;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ShowRecordsForm extends JFrame {

    public ShowRecordsForm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Ders ve Öğrenci Listesi");

        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
        add(panel, BorderLayout.CENTER);

        // Dersler için JTable ve JScrollPane
        JPanel derslerPanel = new JPanel(new BorderLayout());
        derslerPanel.setBorder(BorderFactory.createTitledBorder("Dersler"));
        JTable derslerTable = new JTable();
        JScrollPane derslerScrollPane = new JScrollPane(derslerTable);
        derslerPanel.add(derslerScrollPane, BorderLayout.CENTER);
        panel.add(derslerPanel);

        // Öğrenciler için JTable ve JScrollPane
        JPanel ogrencilerPanel = new JPanel(new BorderLayout());
        ogrencilerPanel.setBorder(BorderFactory.createTitledBorder("Öğrenciler"));
        JTable ogrencilerTable = new JTable();
        JScrollPane ogrencilerScrollPane = new JScrollPane(ogrencilerTable);
        ogrencilerPanel.add(ogrencilerScrollPane, BorderLayout.CENTER);
        panel.add(ogrencilerPanel);

        List<Ders> dersListesi = readDerslerFromJSON("dersler.json");
        if (dersListesi != null) {
            DersTableModel dersTableModel = new DersTableModel(dersListesi);
            derslerTable.setModel(dersTableModel);
        }

        List<Ogrenci> ogrenciListesi = readOgrencilerFromJSON("ogrenciler.json");
        if (ogrenciListesi != null) {
            OgrenciTableModel ogrenciTableModel = new OgrenciTableModel(ogrenciListesi);
            ogrencilerTable.setModel(ogrenciTableModel);
        }

        pack();
        setLocationRelativeTo(null); // Ekranın ortasında açılmasını sağlar
        setVisible(true);
    }

    private List<Ders> readDerslerFromJSON(String dosyaAdi) {
        try (FileReader fileReader = new FileReader(dosyaAdi)) {
            Gson gson = new Gson();
            java.lang.reflect.Type dersListesiType = new TypeToken<List<Ders>>() {}.getType();
            return gson.fromJson(fileReader, dersListesiType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Ogrenci> readOgrencilerFromJSON(String dosyaAdi) {
        try (FileReader fileReader = new FileReader(dosyaAdi)) {
            Gson gson = new Gson();
            java.lang.reflect.Type ogrenciListesiType = new TypeToken<List<Ogrenci>>() {}.getType();
            return gson.fromJson(fileReader, ogrenciListesiType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShowRecordsForm());
    }
}
