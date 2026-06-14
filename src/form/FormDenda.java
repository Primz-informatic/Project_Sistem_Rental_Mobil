
package form;
import koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormDenda extends javax.swing.JFrame {
Connection conn = Koneksi.getKoneksi();
DefaultTableModel model;
    
    public FormDenda() {
    initComponents();
    tampilData();
    loadTransaksi();
    }
    private void loadTransaksi() {

    try {

        cbTransaksi.removeAllItems();

        String sql =
        "SELECT id_transaksi FROM tb_transaksi";

        Statement st =
        conn.createStatement();

        ResultSet rs =
        st.executeQuery(sql);

        while(rs.next()) {

            cbTransaksi.addItem(
            rs.getString("id_transaksi"));

        }

    } catch(Exception e) {

        JOptionPane.showMessageDialog(null,e);

    }

}
    private void tampilData() {

    model = new DefaultTableModel();

    model.addColumn("ID Denda");
    model.addColumn("ID Transaksi");
    model.addColumn("Jenis Denda");
    model.addColumn("Jumlah Denda");
    model.addColumn("Keterangan");
    model.addColumn("Status Bayar");

    try {

        String sql =
        "SELECT * FROM tb_denda";

        Statement st =
        conn.createStatement();

        ResultSet rs =
        st.executeQuery(sql);

        while(rs.next()) {

            model.addRow(new Object[]{

                rs.getString("id_denda"),
                rs.getString("id_transaksi"),
                rs.getString("jenis_denda"),
                rs.getString("jumlah_denda"),
                rs.getString("keterangan"),
                rs.getString("status_bayar")

            });

        }

        tblDenda.setModel(model);

    } catch(Exception e) {

        JOptionPane.showMessageDialog(null,e);

    }

}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTransaksi = new javax.swing.JLabel();
        lblJenisDenda = new javax.swing.JLabel();
        lblJumlahDenda = new javax.swing.JLabel();
        lblKeterangan = new javax.swing.JLabel();
        lblStatusBayar = new javax.swing.JLabel();
        cbTransaksi = new javax.swing.JComboBox<>();
        cbJenisDenda = new javax.swing.JComboBox<>();
        txtJumlahDenda = new javax.swing.JTextField();
        txtKeterangan = new javax.swing.JTextField();
        cbStatusBayar = new javax.swing.JComboBox<>();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDenda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setText("DENDA");

        lblTransaksi.setText("ID Transaksi   ");

        lblJenisDenda.setText("Jenis Denda");

        lblJumlahDenda.setText("jumlah Denda ");

        lblKeterangan.setText("Keterangan ");

        lblStatusBayar.setText("Status Bayar ");

        cbTransaksi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbJenisDenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Terlambat", "Kerusakan", "Kehilangan" }));
        cbJenisDenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJenisDendaActionPerformed(evt);
            }
        });

        txtKeterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeteranganActionPerformed(evt);
            }
        });

        cbStatusBayar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum Lunas", "Lunas" }));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblJenisDenda, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblJumlahDenda, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKeterangan)
                            .addComponent(lblStatusBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTransaksi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbJenisDenda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtJumlahDenda)
                            .addComponent(txtKeterangan)
                            .addComponent(cbStatusBayar, 0, 229, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTransaksi)
                            .addComponent(cbTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJenisDenda)
                            .addComponent(cbJenisDenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJumlahDenda)
                            .addComponent(txtJumlahDenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKeterangan)
                            .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatusBayar)
                            .addComponent(cbStatusBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        tblDenda.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDenda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbJenisDendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJenisDendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJenisDendaActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {

    String sql =
    "INSERT INTO tb_denda(id_transaksi,jenis_denda,jumlah_denda,keterangan,status_bayar) VALUES(?,?,?,?,?)";

    PreparedStatement pst =
    conn.prepareStatement(sql);

    pst.setString(1,
    cbTransaksi.getSelectedItem().toString());

    pst.setString(2,
    cbJenisDenda.getSelectedItem().toString());

    pst.setString(3,
    txtJumlahDenda.getText());

    pst.setString(4,
    txtKeterangan.getText());

    pst.setString(5,
    cbStatusBayar.getSelectedItem().toString());

    pst.executeUpdate();
    
    JOptionPane.showMessageDialog(
    null,
    "Data Berhasil Disimpan");

    tampilData();

} catch(Exception e) {

    JOptionPane.showMessageDialog(
    null,
    e.getMessage());

}
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
    int baris = tblDenda.getSelectedRow();

    String id =
            tblDenda.getValueAt(baris,0)
            .toString();

    try {

        String sql =
        "UPDATE tb_denda SET "
        + "id_transaksi=?,"
        + "jenis_denda=?,"
        + "jumlah_denda=?,"
        + "keterangan=?,"
        + "status_bayar=? "
        + "WHERE id_denda=?";

        PreparedStatement pst =
        conn.prepareStatement(sql);

        pst.setString(1,
                cbTransaksi.getSelectedItem().toString());

        pst.setString(2,
                cbJenisDenda.getSelectedItem().toString());

        pst.setString(3,
                txtJumlahDenda.getText());

        pst.setString(4,
                txtKeterangan.getText());

        pst.setString(5,
               cbStatusBayar
.getSelectedItem().toString());

        pst.setString(6,id);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(
                null,
                "Data Berhasil Diubah");

        tampilData();

    } catch(Exception e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage());

    }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
    int baris = tblDenda.getSelectedRow();

    String id =
            tblDenda.getValueAt(baris,0)
            .toString();

    try {

        String sql =
        "DELETE FROM tb_denda WHERE id_denda=?";

        PreparedStatement pst =
        conn.prepareStatement(sql);

        pst.setString(1,id);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(
                null,
                "Data Berhasil Dihapus");

        tampilData();

    } catch(Exception e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage());

    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblDendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDendaMouseClicked
        // TODO add your handling code here:
        int baris =
        tblDenda.getSelectedRow();

        cbTransaksi.setSelectedItem(
            model.getValueAt(baris,1).toString());

        cbJenisDenda.setSelectedItem(
            model.getValueAt(baris,2).toString());

        txtJumlahDenda.setText(
            model.getValueAt(baris,3).toString());

       txtKeterangan.setText(
            model.getValueAt(baris,4).toString());

        cbStatusBayar.setSelectedItem(
            model.getValueAt(baris,5).toString());
    }//GEN-LAST:event_tblDendaMouseClicked

    private void txtKeteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeteranganActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cbJenisDenda;
    private javax.swing.JComboBox<String> cbStatusBayar;
    private javax.swing.JComboBox<String> cbTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJenisDenda;
    private javax.swing.JLabel lblJumlahDenda;
    private javax.swing.JLabel lblKeterangan;
    private javax.swing.JLabel lblStatusBayar;
    private javax.swing.JLabel lblTransaksi;
    private javax.swing.JTable tblDenda;
    private javax.swing.JTextField txtJumlahDenda;
    private javax.swing.JTextField txtKeterangan;
    // End of variables declaration//GEN-END:variables
}
