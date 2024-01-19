

package Ogrenci_Ders_Kayit.bin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class ProjeMenuFormu extends JFrame {
    private List<Ders> dersListesi;
    private List<Ogrenci> ogrenciListesi;

    public ProjeMenuFormu(List<Ders> dersListesi, List<Ogrenci> ogrenciListesi) {
        this.dersListesi = dersListesi;
        this.ogrenciListesi = ogrenciListesi;

        JButton dersKayitButton = new JButton("Ders Kayıt Formu");
        dersKayitButton.addActionListener(e -> {
            DersKayitFormu dersKayitFormu = new DersKayitFormu();
            dersKayitFormu.setVisible(true);
        });

        JButton ogrenciKayitButton = new JButton("Öğrenci Kayıt Formu");
        ogrenciKayitButton.addActionListener(e -> {
            OgrenciKayitFormu ogrenciKayitFormu = new OgrenciKayitFormu(ogrenciListesi, dersListesi);
            ogrenciKayitFormu.setVisible(true);
        });
        JButton showRecordsButton = new JButton("Verileri Göster");
        showRecordsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ShowRecordsForm showRecordsForm = new ShowRecordsForm();
                showRecordsForm.setVisible(true);
            }
        });
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(dersKayitButton);
        panel.add(ogrenciKayitButton);
        panel.add(showRecordsButton);

        add(panel);
        setSize(300, 200);
        setTitle("Proje Menü Formu");
        setLocationRelativeTo(null); // Ekranın ortasında açılmasını sağlar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        List<Ders> dersListesi = createDersListesi();
        List<Ogrenci> ogrenciListesi = new ArrayList<>();

        SwingUtilities.invokeLater(() -> {
            ProjeMenuFormu projeMenuFormu = new ProjeMenuFormu(dersListesi, ogrenciListesi);
        });
    }

    private static List<Ders> createDersListesi() {
        List<Ders> dersListesi = new ArrayList<>();
        // Ders listesinin oluşturulması
        dersListesi.add(new Ders("Matematik", "MAT101"));
        dersListesi.add(new Ders("Fizik", "FIZ101"));
        return dersListesi;
    }
}
