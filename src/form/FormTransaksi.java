package form;

import koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

public class FormTransaksi extends javax.swing.JFrame {
Connection conn = Koneksi.getKoneksi();
DefaultTableModel model;


    public FormTransaksi() {
        initComponents();
        tampilData();
        loadPelanggan();
        txtLamaSewa.setEditable(false);
    }
    private void hitungLamaSewa(){

    try{

        Date tglSewa =
        dcTanggalSewa.getDate();

        Date tglKembali =
        dcTanggalKembali.getDate();

        if(tglSewa == null || tglKembali == null){
            return;
        }

        long selisih =
        tglKembali.getTime()
        - tglSewa.getTime();

        long hari =
        TimeUnit.DAYS.convert(
        selisih,
        TimeUnit.MILLISECONDS);

        txtLamaSewa.setText(
        String.valueOf(hari));
 
    }catch(Exception e){

    }

}
    
    private void tampilData() {
    model = new DefaultTableModel();
model.addColumn("ID Transaksi");
model.addColumn("Nama Pelanggan");
model.addColumn("Tanggal Sewa");
model.addColumn("Tanggal Kembali");
model.addColumn("Lama Sewa");

    try {

       String sql =
    "SELECT t.id_transaksi, "
    + "p.nama_pelanggan, "
    + "t.tanggal_sewa, "
    + "t.tanggal_kembali, "
    +  "t.lama_sewa "
    + "FROM tb_transaksi t "
    + "JOIN tb_pelanggan p "
    + "ON t.id_pelanggan = p.id_pelanggan";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
       

        while(rs.next()) {

model.addRow(new Object[]{
    rs.getString("id_transaksi"),
    rs.getString("nama_pelanggan"),
    rs.getString("tanggal_sewa"),
    rs.getString("tanggal_kembali"),
    rs.getString("lama_sewa"),
});
    

        }

        jTable1.setModel(model);
    } catch(Exception e) {

        JOptionPane.showMessageDialog(null,e);

    }

}
    private void loadPelanggan() {

    try {

        cbPelanggan.removeAllItems();

        String sql = "SELECT * FROM tb_pelanggan";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {

            cbPelanggan.addItem(
                rs.getString("nama_pelanggan"));

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, e.getMessage());

    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbPelanggan = new javax.swing.JComboBox<>();
        dcTanggalSewa = new com.toedter.calendar.JDateChooser();
        dcTanggalKembali = new com.toedter.calendar.JDateChooser();
        txtLamaSewa = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBackground(new java.awt.Color(0, 204, 51));

        jLabel1.setText("INPUT TRANSAKSI");

        jLabel2.setText("Pelanggan");

        jLabel3.setText("Tanggal Sewa");

        jLabel4.setText("Tanggal Kembali");

        jLabel5.setText("Lama Sewa");

        cbPelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dcTanggalSewa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcTanggalSewaPropertyChange(evt);
            }
        });

        dcTanggalKembali.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcTanggalKembaliPropertyChange(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jScrollPane1Layout = new javax.swing.GroupLayout(jScrollPane1);
        jScrollPane1.setLayout(jScrollPane1Layout);
        jScrollPane1Layout.setHorizontalGroup(
            jScrollPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jScrollPane1Layout.createSequentialGroup()
                .addGroup(jScrollPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jScrollPane1Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jScrollPane1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jScrollPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jScrollPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbPelanggan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcTanggalSewa, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(dcTanggalKembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLamaSewa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnSimpan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jScrollPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus))
                .addGap(43, 43, 43))
        );
        jScrollPane1Layout.setVerticalGroup(
            jScrollPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jScrollPane1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jScrollPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(cbPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jScrollPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(dcTanggalSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jScrollPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(dcTanggalKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jScrollPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtLamaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jScrollPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jScrollPane1Layout.createSequentialGroup()
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
if(dcTanggalSewa.getDate() == null){
    JOptionPane.showMessageDialog(
    null,
    "Pilih tanggal sewa terlebih dahulu");
    return;
}

if(dcTanggalKembali.getDate() == null){
    JOptionPane.showMessageDialog(
    null,
    "Pilih tanggal kembali terlebih dahulu");
    return;
}
    try {

        String pelanggan =
                cbPelanggan.getSelectedItem().toString();

        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd");

        String tglSewa =
                sdf.format(dcTanggalSewa.getDate());

        String tglKembali =
                sdf.format(dcTanggalKembali.getDate());

        String lama =
                txtLamaSewa.getText();

      String idPelanggan = "";

String cari =
"SELECT id_pelanggan FROM tb_pelanggan WHERE nama_pelanggan=?";

PreparedStatement pstCari =
conn.prepareStatement(cari);

pstCari.setString(
1,
cbPelanggan.getSelectedItem().toString());

ResultSet rs =
pstCari.executeQuery();

if(rs.next()){

    idPelanggan =
    rs.getString("id_pelanggan");

}

        String sql =
        "INSERT INTO tb_transaksi(id_pelanggan,tanggal_sewa,tanggal_kembali,lama_sewa, total_bayar) VALUES (?,?,?,?,?)";

        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, idPelanggan);
        pst.setString(2, tglSewa);
        pst.setString(3, tglKembali);
        pst.setString(4, lama);
        pst.setInt(5,0);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(
                null,
                "Data Berhasil Disimpan");

        tampilData();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage());

    }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:

   int baris = jTable1.getSelectedRow();

    String id =jTable1.getValueAt(baris, 0).toString();
    

    try {

        String idPelanggan = "";

String cari =
"SELECT id_pelanggan FROM tb_pelanggan WHERE nama_pelanggan=?";

PreparedStatement pstCari =
conn.prepareStatement(cari);

pstCari.setString(
1,
cbPelanggan.getSelectedItem().toString());

ResultSet rs =
pstCari.executeQuery();

if(rs.next()){

    idPelanggan =
    rs.getString("id_pelanggan");

}
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd");

        String sql =
        "UPDATE tb_transaksi SET "
        + "id_pelanggan=?,"
        + "tanggal_sewa=?,"
        + "tanggal_kembali=?,"
        + "lama_sewa=?"
        + "WHERE id_transaksi=?";

        PreparedStatement pst =
                conn.prepareStatement(sql);

        
        pst.setString(
        1,
        idPelanggan);

        pst.setString(2,
                sdf.format( dcTanggalSewa.getDate()));

        pst.setString(3,
                sdf.format( dcTanggalKembali.getDate()));

        pst.setString(4,txtLamaSewa.getText());

        pst.setString(5,id);


        pst.executeUpdate();
        

        JOptionPane.showMessageDialog(
                null,
                "Data Berhasil Diubah");

        tampilData();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage());

    }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
    int baris =
            jTable1.getSelectedRow();

    String id =
            jTable1.getValueAt(baris, 0)
                    .toString();

    try {

        String sql =
        "DELETE FROM tb_transaksi WHERE id_transaksi=?";

        PreparedStatement pst =
                conn.prepareStatement(sql);

        pst.setString(1, id);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(
                null,
                "Data Berhasil Dihapus");

        tampilData();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage());

    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    int baris = jTable1.getSelectedRow();

    cbPelanggan.setSelectedItem(
    model.getValueAt(baris,1).toString());

    try{

        SimpleDateFormat sdf =
        new SimpleDateFormat("yyyy-MM-dd");

        dcTanggalSewa.setDate(
        sdf.parse(
        model.getValueAt(baris,2).toString()));

        dcTanggalKembali.setDate(
        sdf.parse(
        model.getValueAt(baris,3).toString()));

    }catch(Exception e){

        JOptionPane.showMessageDialog(
        null,
        e.getMessage());

    }

    txtLamaSewa.setText(
    model.getValueAt(baris,4).toString());


    }//GEN-LAST:event_jTable1MouseClicked

    private void dcTanggalSewaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcTanggalSewaPropertyChange
        // TODO add your handling code here:
    hitungLamaSewa();
    }//GEN-LAST:event_dcTanggalSewaPropertyChange

    private void dcTanggalKembaliPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcTanggalKembaliPropertyChange
        // TODO add your handling code here:
        hitungLamaSewa();
    }//GEN-LAST:event_dcTanggalKembaliPropertyChange


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
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cbPelanggan;
    private com.toedter.calendar.JDateChooser dcTanggalKembali;
    private com.toedter.calendar.JDateChooser dcTanggalSewa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtLamaSewa;
    // End of variables declaration//GEN-END:variables
}
