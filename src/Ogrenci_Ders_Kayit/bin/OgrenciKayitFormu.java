package Ogrenci_Ders_Kayit.bin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;

public class OgrenciKayitFormu extends JFrame {
    private List<Ogrenci> ogrenciListesi;
    private List<Ders> dersListesi;

    public OgrenciKayitFormu(List<Ogrenci> ogrenciListesi, List<Ders> dersListesi) {
        this.ogrenciListesi = ogrenciListesi;
        this.dersListesi = dersListesi;

        JLabel ogrenciNoLabel = new JLabel("Öğrenci No:");
        JTextField ogrenciNoField = new JTextField(15);

        JLabel ogrenciAdLabel = new JLabel("Öğrenci Adı:");
        JTextField ogrenciAdField = new JTextField(15);

        JLabel ogrenciSoyadLabel = new JLabel("Öğrenci Soyadı:");
        JTextField ogrenciSoyadField = new JTextField(15);

        JLabel ogrenciBolumLabel = new JLabel("Öğrenci Bölümü:");
        JTextField ogrenciBolumField = new JTextField(15);

        JLabel ogrenciDerslerLabel = new JLabel("Öğrenci Dersleri:");
        JComboBox<String> ogrenciDerslerComboBox = new JComboBox<>();
        dersListesi = readDerslerFromJSON("dersler.json");
        for (Ders ders : dersListesi) {
            ogrenciDerslerComboBox.addItem(ders.getDersAd());
        }

        JButton kaydetButton = new JButton("Kaydet");
        List<Ders> finalDersListesi = dersListesi;
        kaydetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ogrenciNo = ogrenciNoField.getText().trim();
                String ogrenciAd = ogrenciAdField.getText().trim();
                String ogrenciSoyad = ogrenciSoyadField.getText().trim();
                String ogrenciBolum = ogrenciBolumField.getText().trim();

                if (ogrenciNo.isEmpty() || ogrenciAd.isEmpty() || ogrenciSoyad.isEmpty() || ogrenciBolum.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen bilgileri eksiksiz doldurunuz.", "Hata", JOptionPane.ERROR_MESSAGE);
                } else {
                    Ogrenci yeniOgrenci = new Ogrenci(Integer.parseInt(ogrenciNo),
                            ogrenciAd,
                            ogrenciSoyad,
                            ogrenciBolum,
                            new ArrayList<>());

                    int selectedIndex = ogrenciDerslerComboBox.getSelectedIndex();
                    Ders secilenDers = finalDersListesi.get(selectedIndex);
                    yeniOgrenci.getOgrenciDersler().add(secilenDers);

                    ogrenciListesi.add(yeniOgrenci);

                    writeOgrencilerToJSON("ogrenciler.json", ogrenciListesi); // Tüm öğrenci listesini JSON dosyasına yaz
                    System.out.println("Öğrenci kaydedildi: " + yeniOgrenci.getOgrenciAd());
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(6,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.add(ogrenciNoLabel);
        panel.add(ogrenciNoField);
        panel.add(ogrenciAdLabel);
        panel.add(ogrenciAdField);
        panel.add(ogrenciSoyadLabel);
        panel.add(ogrenciSoyadField);
        panel.add(ogrenciBolumLabel);
        panel.add(ogrenciBolumField);
        panel.add(ogrenciDerslerLabel);
        panel.add(ogrenciDerslerComboBox);
        panel.add(new JLabel());
        panel.add(kaydetButton);

        this.add(panel);
        this.setSize(350, 300);
        this.setTitle("Öğrenci Kayıt Formu");
        this.setLocationRelativeTo(null); // Ekranın ortasında açılmasını sağlar
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private List<Ders> readDerslerFromJSON(String dosyaAdi) {
        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            Gson gson = new Gson();
            java.lang.reflect.Type type = new TypeToken<List<Ders>>() {}.getType();
            return gson.fromJson(br, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void writeOgrencilerToJSON(String dosyaAdi, List<Ogrenci> ogrenciListesi) {
        try (FileWriter writer = new FileWriter(dosyaAdi)) {
            Gson gson = new Gson();
            gson.toJson(ogrenciListesi, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
