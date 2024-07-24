/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RSUD
 */
// AntrianLoket.java


// loketGui.java
package antrian.loket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class loketGui extends JFrame {
    private JTextField txtNomorAntrian;
    private JButton btnAmbilAntrian;
    private JLabel lblJam;
    private JLabel lblTanggal;
    private JLabel lblKeterangan;

    public loketGui() {
        initComponents();
    }

   private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Aplikasi Antrian Loket");
        getContentPane().setBackground(new Color(144, 238, 144)); // set backgroud color 



        txtNomorAntrian = new JTextField();
        txtNomorAntrian.setPreferredSize(new Dimension(10, 100));
        txtNomorAntrian.setFont(new Font("FontName", Font.PLAIN, 100));
        txtNomorAntrian.setHorizontalAlignment(JTextField.CENTER);
        txtNomorAntrian.setBackground(new Color(144, 238, 144));
        txtNomorAntrian.setBorder(null);
        txtNomorAntrian.setEditable(false);

        
        btnAmbilAntrian = new JButton("Ambil Antrian");
        btnAmbilAntrian.setBackground(new Color(0, 128, 0)); // Set button background 
        btnAmbilAntrian.setForeground(Color.WHITE); // Set text color 
        
        
        lblJam = new JLabel("Jam: ");
        lblJam.setForeground(new Color(0, 128, 0)); // Set text color 
        
        lblTanggal = new JLabel("Tanggal: ");
        lblTanggal.setForeground(new Color(0, 128, 0)); // Set text color 
        
        lblKeterangan = new JLabel("Keterangan: ");
        lblKeterangan.setForeground(new Color(0, 128, 0)); // Set text color 

        btnAmbilAntrian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ambilAntrianActionPerformed(e);
            }
        });

        JLabel lblRSUD = new JLabel("RSUD ADE M. DJOEN");
        lblRSUD.setFont(new Font("Arial", Font.BOLD, 16));
        lblRSUD.setForeground(new Color(0, 128, 0)); // Set label text color

        JLabel lblAlamat = new JLabel("Jl. Y.C. Oevang Oeray, No.1, Desa Sungai Ana, Kecamatan. Sintang, Kabupaten. Sintang, Kalimantan Barat");
        lblAlamat.setFont(new Font("Arial", Font.PLAIN, 14)); // 
        lblAlamat.setForeground(Color.BLACK); // Set text color 

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblRSUD)
                        .addComponent(lblAlamat) 
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(txtNomorAntrian)
                                .addComponent(btnAmbilAntrian)
                            )
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                
                                .addComponent(lblJam)
                                .addComponent(lblTanggal)
                                .addComponent(lblKeterangan))))
                        
                    .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblRSUD)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblAlamat) 
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNomorAntrian, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblJam))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTanggal))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblKeterangan))
                    .addComponent(btnAmbilAntrian)
                    .addContainerGap(30, Short.MAX_VALUE))
        );


        pack();
    }

    private void printText() {
        PrinterJob job = PrinterJob.getPrinterJob();

        Printable printable = new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                Graphics2D g2d = (Graphics2D) graphics.create();;
                Graphics2D antrian = (Graphics2D) graphics.create();;
                
                Font font = new Font("Arial", Font.PLAIN, 0);
                antrian.setFont(font);
                
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                int x = 100;
                int y = 100;
                g2d.drawString("RSUD ADE M. DJOEN", x, y);
                
                y += 20;
                g2d.drawString("Jl. Y.C. Oevang Oeray, No.1, Desa Sungai Ana, Kecamatan. Sintang, Kabupaten. Sintang, Kalimantan Barat", x, y);
                x += 100;
                y += 150;
                
                antrian.drawString(txtNomorAntrian.getText(), x, y);
                y += 30;
                
                g2d.drawString(lblJam.getText(), x, y);
                y += 20;
                
                g2d.drawString(lblTanggal.getText(), x, y);
                y += 20;

                g2d.drawString(lblKeterangan.getText(), x, y);
                y += 20;
               

                return Printable.PAGE_EXISTS;
            }
        };

        job.setPrintable(printable);

        try {
            job.print();
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(this, "SAMBUNGKAN KE PRINTER TERLEBIH DAHULU " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ambilAntrianActionPerformed(ActionEvent evt) {
        String nomorAntrian = AntrianLoket.ambilNomorAntrian();
        txtNomorAntrian.setText(nomorAntrian);

        String jamSekarang = java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        lblJam.setText("Jam: " + jamSekarang);

        Calendar calendar = new GregorianCalendar();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String hariIni = "";
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                hariIni = "Minggu";
                break;
            case Calendar.MONDAY:
                hariIni = "Senin";
                break;
            case Calendar.TUESDAY:
                hariIni = "Selasa";
                break;
            case Calendar.WEDNESDAY:
                hariIni = "Rabu";
                break;
            case Calendar.THURSDAY:
                hariIni = "Kamis";
                break;
            case Calendar.FRIDAY:
                hariIni = "Jumat";
                break;
            case Calendar.SATURDAY:
                hariIni = "Sabtu";
                break;
        }
        int tanggal = calendar.get(Calendar.DATE);
        int bulan = calendar.get(Calendar.MONTH) + 1;
        int tahun = calendar.get(Calendar.YEAR);
        String tanggalHariIni = String.format("%s, %d/%d/%d", hariIni, tanggal, bulan, tahun);
        lblTanggal.setText("Tanggal: " + tanggalHariIni);

        String keteranganAntrian = "Pemeriksaan Umum";
        lblKeterangan.setText("Keterangan: " + keteranganAntrian);

        printText();
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loketGui().setVisible(true);
            }
        });
    }
}
