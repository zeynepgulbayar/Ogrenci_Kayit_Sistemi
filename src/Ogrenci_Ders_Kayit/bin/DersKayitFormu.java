package Ogrenci_Ders_Kayit.bin;


/*

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class DersKayitFormu extends JFrame {
    private List<Ders> dersListesi = new ArrayList<>();

    public DersKayitFormu(List<Ders> dersListesi) {
        JLabel dersKoduLabel = new JLabel("Ders Kodu:");
        JTextField dersKoduField = new JTextField(15);

        JLabel dersAdLabel = new JLabel("Ders Adı:");
        JTextField dersAdField = new JTextField(15);

        JLabel dersDonemLabel = new JLabel("Ders Dönemi:");
        JTextField dersDonemField = new JTextField(15);

        JButton kaydetButton = new JButton("Kaydet");
        kaydetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ders yeniDers = new Ders();
                yeniDers.setDersKodu(dersKoduField.getText());
                yeniDers.setDersAd(dersAdField.getText());
                yeniDers.setDersDonem(dersDonemField.getText());

                DersKayitFormu.this.dersListesi.add(yeniDers);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(DersKayitFormu.this.dersListesi);

                try (FileWriter fileWriter = new FileWriter("dersler.json")) {
                    fileWriter.write(json);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
                */
/*try {
                    FileOutputStream fileOut = new FileOutputStream("dersler.ser");
                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                    objectOut.writeObject(DersKayitFormu.this.dersListesi);
                    objectOut.close();
                    fileOut.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }*//*


        });

        JPanel panel = new JPanel();
        panel.add(dersKoduLabel);
        panel.add(dersKoduField);
        panel.add(dersAdLabel);
        panel.add(dersAdField);
        panel.add(dersDonemLabel);
        panel.add(dersDonemField);
        panel.add(kaydetButton);

        this.add(panel);
        this.setSize(300, 200);
        this.setTitle("Ders Kayıt Formu");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class DersKayitFormu extends JFrame {
    private List<Ders> dersListesi = new ArrayList<>();

    public DersKayitFormu() {
        JLabel dersKoduLabel = new JLabel("Ders Kodu:");
        JTextField dersKoduField = new JTextField(15);

        JLabel dersAdLabel = new JLabel("Ders Adı:");
        JTextField dersAdField = new JTextField(15);

        JLabel dersDonemLabel = new JLabel("Ders Dönemi:");
        JTextField dersDonemField = new JTextField(15);

        JButton kaydetButton = new JButton("Kaydet");
        kaydetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Ders yeniDers = new Ders();
                yeniDers.setDersKodu(dersKoduField.getText());
                yeniDers.setDersAd(dersAdField.getText());
                yeniDers.setDersDonem(dersDonemField.getText());

                // Mevcut ders listesini dosyadan oku
                dersListesi = readDerslerFromJSON("dersler.json");

                // Yeni dersi mevcut listeye ekle
                dersListesi.add(yeniDers);

                // Yeni ders listesini dosyaya yaz
                writeDerslerToJSON("dersler.json", dersListesi);
                JOptionPane.showMessageDialog(null, "Ders kaydedildi: " + yeniDers.getDersAd(), "Başarılı", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        JPanel panel = new JPanel(new GridLayout(4,2,10,10));
        panel.setBorder((BorderFactory.createEmptyBorder(10,10,10,10)));
        panel.add(dersKoduLabel);
        panel.add(dersKoduField);
        panel.add(dersAdLabel);
        panel.add(dersAdField);
        panel.add(dersDonemLabel);
        panel.add(dersDonemField);
        panel.add(new JLabel());
        panel.add(kaydetButton);

        this.add(panel);
        this.setSize(300, 200);
        this.setTitle("Ders Kayıt Formu");
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
            return new ArrayList<>(); // Eğer dosya yoksa yeni bir liste döndür
        }
    }

    private void writeDerslerToJSON(String dosyaAdi, List<Ders> dersListesi) {
        try (FileWriter fileWriter = new FileWriter(dosyaAdi)) {
            Gson gson = new Gson();
            gson.toJson(dersListesi, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
