import com.toedter.calendar.JCalendar;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammad Hapi
 */
public class FormPerhitunganHari extends javax.swing.JFrame {

    /**
     * Creates new form FormPerhitunganHari
     */
    public FormPerhitunganHari() {
        initComponents();
        // Sinkronisasi saat tanggal di JCalendar pertama dipilih
        calenderPertama.addPropertyChangeListener(evt -> {
            if ("calendar".equals(evt.getPropertyName())) {
                Calendar tanggal = calenderPertama.getCalendar();
                int bulanTerpilih = tanggal.get(Calendar.MONTH);
                int tahunTerpilih = tanggal.get(Calendar.YEAR);
                
                // Update jComboBox1 dan jSpinner1
                comboBoxBulan.setSelectedIndex(bulanTerpilih);
                spinnerTahun.setValue(tahunTerpilih);
                
                // Update informasi hari pertama dan terakhir
                updateInfoHari(tahunTerpilih, bulanTerpilih + 1);
            }
        });

        // Listener untuk sinkronisasi saat bulan di JComboBox dipilih
        comboBoxBulan.addActionListener(evt -> {
            int bulanTerpilih = comboBoxBulan.getSelectedIndex();
            Calendar tanggal = calenderPertama.getCalendar();
            tanggal.set(Calendar.MONTH, bulanTerpilih);
            calenderPertama.setCalendar(tanggal);
            updateInfoHari((Integer) spinnerTahun.getValue(), bulanTerpilih + 1);
        });

        // Listener untuk sinkronisasi saat tahun di JSpinner diubah
        spinnerTahun.addChangeListener(evt -> {
            int tahunTerpilih = (Integer) spinnerTahun.getValue();
            int bulanTerpilih = comboBoxBulan.getSelectedIndex() + 1;
            Calendar tanggal = calenderPertama.getCalendar();
            tanggal.set(Calendar.YEAR, tahunTerpilih);
            calenderPertama.setCalendar(tanggal);
            updateInfoHari(tahunTerpilih, bulanTerpilih);
        });

        // Event untuk tombol hitung selisih yang menggunakan jButton3
        buttonHitungSelisih.addActionListener(evt -> hitungSelisihHari());
    }

        // Method untuk menampilkan hari pertama dan terakhir dalam bulan
        private void updateInfoHari(int tahun, int bulan) {
            LocalDate tanggalTerakhir = LocalDate.of(tahun, bulan, 1);
            LocalDate tanggalPertama = tanggalTerakhir.withDayOfMonth(tanggalTerakhir.lengthOfMonth());
            
            textHariTerakhir.setText(tanggalPertama.getDayOfWeek().name());
            textHariPertama.setText(tanggalTerakhir.getDayOfWeek().name());
        }

        // Method untuk menghitung selisih hari antara dua tanggal
        private void hitungSelisihHari() {
            // Validasi apakah kedua tanggal telah dipilih
            if (calenderPertama.getCalendar() == null || calenderKedua.getCalendar() == null) {
                textSelisihHari.setText("Harap pilih kedua tanggal untuk menghitung selisih.");
                return;
            }

            LocalDate tanggal1 = LocalDate.of(
                    calenderPertama.getCalendar().get(Calendar.YEAR),
                    calenderPertama.getCalendar().get(Calendar.MONTH) + 1,
                    calenderPertama.getCalendar().get(Calendar.DAY_OF_MONTH));
            LocalDate tanggal2 = LocalDate.of(
                    calenderKedua.getCalendar().get(Calendar.YEAR),
                    calenderKedua.getCalendar().get(Calendar.MONTH) + 1,
                    calenderKedua.getCalendar().get(Calendar.DAY_OF_MONTH));

            long selisih = ChronoUnit.DAYS.between(tanggal1, tanggal2);
            textSelisihHari.setText(Math.abs(selisih) + " hari");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxBulan = new javax.swing.JComboBox<>();
        spinnerTahun = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        textHariTerakhir = new javax.swing.JTextField();
        buttonHitung = new javax.swing.JButton();
        calenderPertama = new com.toedter.calendar.JCalendar();
        jLabel6 = new javax.swing.JLabel();
        textHariPertama = new javax.swing.JTextField();
        textSelisihHari = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaHasil = new javax.swing.JTextArea();
        calenderKedua = new com.toedter.calendar.JCalendar();
        buttonHitungSelisih = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("APLIKASI PERHITUNGAN HARI");

        jLabel2.setText("Pilih Bulan :");

        jLabel3.setText("Pilih Tahun :");

        jLabel4.setText("Pilih Bulan dan Tahun :");

        comboBoxBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        jLabel5.setText("Hari Terakhir :");

        textHariTerakhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHariTerakhirActionPerformed(evt);
            }
        });

        buttonHitung.setText("HITUNG");
        buttonHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHitungActionPerformed(evt);
            }
        });

        jLabel6.setText("Hari Pertama :");

        textHariPertama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHariPertamaActionPerformed(evt);
            }
        });

        jLabel7.setText("Selisih Hari :");

        jLabel8.setText("Hasil :");

        jLabel9.setText("Calendar Selisih Hari :");

        textAreaHasil.setColumns(20);
        textAreaHasil.setRows(5);
        jScrollPane1.setViewportView(textAreaHasil);

        buttonHitungSelisih.setText("HITUNG SELISIH");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(spinnerTahun)
                    .addComponent(comboBoxBulan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textHariTerakhir)
                    .addComponent(textHariPertama)
                    .addComponent(textSelisihHari, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calenderPertama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonHitung)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonHitungSelisih)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(calenderKedua, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboBoxBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spinnerTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calenderPertama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(calenderKedua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textHariPertama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textHariTerakhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textSelisihHari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonHitung)
                            .addComponent(buttonHitungSelisih))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textHariTerakhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHariTerakhirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHariTerakhirActionPerformed

    private void textHariPertamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHariPertamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHariPertamaActionPerformed

    private void buttonHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHitungActionPerformed
        hitungJumlahHari();
    }//GEN-LAST:event_buttonHitungActionPerformed

    private void hitungJumlahHari() {
        // Validasi apakah bulan dan tahun sudah dipilih
        if (comboBoxBulan.getSelectedIndex() == -1 || spinnerTahun.getValue() == null) {
            textAreaHasil.setText("Harap pilih bulan dan masukkan tahun yang valid.");
            return;
        }
        
        // Ambil tanggal dari JCalendar
        Calendar tanggal = calenderPertama.getCalendar();

        // Ambil bulan dan tahun dari tanggal
        int tahun = tanggal.get(Calendar.YEAR);
        int bulan = tanggal.get(Calendar.MONTH) + 1; // Calendar.MONTH dimulai dari 0

        // Menggunakan YearMonth untuk menghitung jumlah hari
        YearMonth yearMonth = YearMonth.of(tahun, bulan);
        int jumlahHari = yearMonth.lengthOfMonth();
        
        // Periksa apakah tahun kabisat
        String infoKabisat = tahunKabisat(tahun) ? " (Tahun Kabisat)" : "";

        // Nama bulan dalam bahasa Indonesia
        String[] namaBulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", 
                              "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        String namaBulanTerpilih = namaBulan[bulan - 1];

        // Tampilkan hasil di Label 4 dengan informasi bulan, tahun, dan kabisat jika berlaku
        textAreaHasil.setText("Jumlah hari di bulan " + namaBulanTerpilih + " tahun " + tahun + " adalah " + jumlahHari + " hari" + infoKabisat); 
    }
    
    private void tahunSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {
        hitungJumlahHari();
    }
    
    private boolean tahunKabisat(int tahun) {
        return (tahun % 4 == 0 && tahun % 100 != 0) || (tahun % 400 == 0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPerhitunganHari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPerhitunganHari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPerhitunganHari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPerhitunganHari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPerhitunganHari().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonHitung;
    private javax.swing.JButton buttonHitungSelisih;
    private com.toedter.calendar.JCalendar calenderKedua;
    private com.toedter.calendar.JCalendar calenderPertama;
    private javax.swing.JComboBox<String> comboBoxBulan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerTahun;
    private javax.swing.JTextArea textAreaHasil;
    private javax.swing.JTextField textHariPertama;
    private javax.swing.JTextField textHariTerakhir;
    private javax.swing.JTextField textSelisihHari;
    // End of variables declaration//GEN-END:variables
}
