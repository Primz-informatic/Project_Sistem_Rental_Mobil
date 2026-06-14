
package form.Laporan;

import form.*;
import koneksi.Koneksi;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;


public class FormLaporan1 extends javax.swing.JFrame {


    public FormLaporan1() {
        initComponents();
        setLocationRelativeTo(null);
    }
    

    private void tampilkanDataMobil() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Mobil");
        model.addColumn("No Plat");
        model.addColumn("Merk Mobil");
        model.addColumn("Warna");
        model.addColumn("Harga Sewa");
        model.addColumn("Status");

        try {
            String sql = "SELECT * FROM tb_mobil";
            Connection conn = Koneksi.getKoneksi();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_mobil"),
                    rs.getString("no_plat"),
                    rs.getString("merk_mobil"),
                    rs.getString("warna"),
                    rs.getString("harga_sewa"),
                    rs.getString("status")
                });
            }
            tblLaporan.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data mobil: " + e.getMessage());
        }
    }
    
    // Fungsi untuk memuat data Pelanggan ke dalam JTable
    private void tampilkanDataPelanggan() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pelanggan");
        model.addColumn("NIK");
        model.addColumn("Nama Pelanggan");
        model.addColumn("Alamat");
        model.addColumn("No HP");

        try {
            String sql = "SELECT * FROM tb_pelanggan";
            Connection conn = Koneksi.getKoneksi();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_pelanggan"),
                    rs.getString("nik"),
                    rs.getString("nama_pelanggan"),
                    rs.getString("alamat"),
                    rs.getString("no_hp")
                });
            }
            tblLaporan.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data pelanggan: " + e.getMessage());
        }
    }
    
    private void cariDataMobil(String kataKunci) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Mobil");
    model.addColumn("No Plat");
    model.addColumn("Merk Mobil");
    model.addColumn("Warna");
    model.addColumn("Harga Sewa");
    model.addColumn("Status");

    try {
        // Query SQL menggunakan LIKE untuk pencarian fleksibel
        String sql = "SELECT * FROM tb_mobil WHERE merk_mobil LIKE ? OR no_plat LIKE ?";
        Connection conn = Koneksi.getKoneksi();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + kataKunci + "%");
        pst.setString(2, "%" + kataKunci + "%");
        
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("id_mobil"),
                rs.getString("no_plat"),
                rs.getString("merk_mobil"),
                rs.getString("warna"),
                rs.getString("harga_sewa"),
                rs.getString("status")
            });
        }
        tblLaporan.setModel(model);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal mencari data mobil: " + e.getMessage());
    }
}
    
    // Fungsi untuk mencari data Pelanggan berdasarkan Nama atau NIK
private void cariDataPelanggan(String kataKunci) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Pelanggan");
    model.addColumn("NIK");
    model.addColumn("Nama Pelanggan");
    model.addColumn("Alamat");
    model.addColumn("No HP");

    try {
        String sql = "SELECT * FROM tb_pelanggan WHERE nama_pelanggan LIKE ? OR nik LIKE ?";
        Connection conn = Koneksi.getKoneksi();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + kataKunci + "%");
        pst.setString(2, "%" + kataKunci + "%");
        
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("id_pelanggan"),
                rs.getString("nik"),
                rs.getString("nama_pelanggan"),
                rs.getString("alamat"),
                rs.getString("no_hp")
            });
        }
        tblLaporan.setModel(model);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal mencari data pelanggan: " + e.getMessage());
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbJenisLaporan = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaporan = new javax.swing.JTable();
        btnCetak = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pusat Cetak Laporan Sistem Rental");

        jLabel2.setText("Jenis Laporan :");

        cbJenisLaporan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Laporan --", "Data Mobil", "Data Pelanggan" }));
        cbJenisLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJenisLaporanActionPerformed(evt);
            }
        });

        jLabel3.setText("Cari Data :");

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });

        tblLaporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblLaporan);

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbJenisLaporan, 0, 211, Short.MAX_VALUE)
                            .addComponent(txtCari))
                        .addGap(78, 78, 78)
                        .addComponent(btnCetak)
                        .addGap(18, 18, 18)
                        .addComponent(btnKembali))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbJenisLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCetak)
                    .addComponent(btnKembali))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbJenisLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJenisLaporanActionPerformed
        String pilihan = cbJenisLaporan.getSelectedItem().toString();
        
        if (pilihan.equals("Data Mobil")) {
            tampilkanDataMobil();
        } else if (pilihan.equals("Data Pelanggan")) {
            tampilkanDataPelanggan();
        } else {
            // Jika memilih "-- Pilih Laporan --", kosongkan tabel
            tblLaporan.setModel(new DefaultTableModel());
        }
    }//GEN-LAST:event_cbJenisLaporanActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
       String pilihan = cbJenisLaporan.getSelectedItem().toString();
        
        // Validasi jika user belum memilih jenis laporan
        if (pilihan.equals("-- Pilih Laporan --")) {
            JOptionPane.showMessageDialog(null, "Silakan pilih jenis laporan yang ingin dicetak terlebih dahulu!");
            return;
        }
        // Mengatur judul dokumen cetak berdasarkan pilihan di ComboBox
        String judulLaporan = "LAPORAN " + pilihan.toUpperCase();
        
        MessageFormat header = new MessageFormat(judulLaporan);
        MessageFormat footer = new MessageFormat("Halaman {0,number,integer}");
        
        try {
            // Cetak data dari tblLaporan yang saat ini sedang tampil
            tblLaporan.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            JOptionPane.showMessageDialog(null, "Proses cetak " + pilihan + " berhasil!");
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "Gagal mencetak: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose(); // Menutup form laporan
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLaporan1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnKembali;
    private javax.swing.JComboBox<String> cbJenisLaporan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLaporan;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
