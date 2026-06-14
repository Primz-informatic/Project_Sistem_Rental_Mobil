package form;
import koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormSewa extends javax.swing.JFrame {

Connection conn = Koneksi.getKoneksi();
DefaultTableModel model;

public FormSewa() {
    initComponents();

    tampilData();
    loadTransaksi();
    loadMobil();
    txtLamaSewa.setEditable(false);
    txtHargaSewa.setEditable(false);
    txtSubTotal.setEditable(false);
}

private void tampilData() {

model = new DefaultTableModel();

model.addColumn("ID Sewa");
model.addColumn("Pelanggan");
model.addColumn("Mobil");
model.addColumn("Lama Sewa");
model.addColumn("Sub Total");

    try {

String sql =
"SELECT s.id_sewa, "
+ "p.nama_pelanggan, "
+ "m.merk_mobil, "
+ "s.lama_sewa, "
+ "s.sub_total "
+ "FROM tb_sewa s "
+ "JOIN tb_transaksi t "
+ "ON s.id_transaksi = t.id_transaksi "
+ "JOIN tb_pelanggan p "
+ "ON t.id_pelanggan = p.id_pelanggan "
+ "JOIN tb_mobil m "
+ "ON s.id_mobil = m.id_mobil";

        Statement st =
        conn.createStatement();

        ResultSet rs =
        st.executeQuery(sql);

        while(rs.next()) {
        model.addRow(new Object[]{

        rs.getString("id_sewa"),
        rs.getString("nama_pelanggan"),
        rs.getString("merk_mobil"),
        rs.getString("lama_sewa"),
        rs.getString("sub_total")

    });
        }

        tblSewa.setModel(model);

    } catch(Exception e) {

        JOptionPane.showMessageDialog(null,e);

    }

}


private void loadTransaksi() {

    try {

        cbTransaksi.removeAllItems();

        String sql =
        "SELECT DISTINCT p.nama_pelanggan " +
        "FROM tb_transaksi t " +
        "JOIN tb_pelanggan p " +
        "ON t.id_pelanggan = p.id_pelanggan";

        Statement st =
        conn.createStatement();

        ResultSet rs =
        st.executeQuery(sql);

        while(rs.next()){

            cbTransaksi.addItem(
            rs.getString("nama_pelanggan"));

        }

    }catch(Exception e){

        JOptionPane.showMessageDialog(
        null,
        e.getMessage());

    }

}

private void loadMobil() {

    try {

        cbMobil.removeAllItems();

    String sql =
    "SELECT merk_mobil FROM tb_mobil";

        Statement st =
        conn.createStatement();

        ResultSet rs =
        st.executeQuery(sql);

        while(rs.next()) {

            cbMobil.addItem(
            rs.getString("merk_mobil"));

        }

    } catch(Exception e) {

        JOptionPane.showMessageDialog(null,e);

    }
}   

private void hitungSubTotal(){

    try{

        int harga =
        Integer.parseInt(
        txtHargaSewa.getText());

        int lama =
        Integer.parseInt(
        txtLamaSewa.getText());

        int subtotal =
        harga * lama;

        txtSubTotal.setText(
        String.valueOf(subtotal));

    }catch(Exception e){

    }

}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbTransaksi = new javax.swing.JComboBox<>();
        cbMobil = new javax.swing.JComboBox<>();
        txtSubTotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtHargaSewa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLamaSewa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSewa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 0));

        jLabel1.setText("SEWA");

        jLabel2.setText("ID Transaksi");

        jLabel3.setText("Mobil");

        jLabel4.setText("Sub Total");

        cbTransaksi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTransaksi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTransaksiItemStateChanged(evt);
            }
        });

        cbMobil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMobil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMobilItemStateChanged(evt);
            }
        });
        cbMobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMobilActionPerformed(evt);
            }
        });

        txtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalActionPerformed(evt);
            }
        });

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Harga Sewa");

        jLabel6.setText("Lama Sewa ");

        txtLamaSewa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLamaSewaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtLamaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton2)))
                            .addComponent(txtHargaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(93, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtHargaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtLamaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        tblSewa.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSewaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSewa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

    int baris =
    tblSewa.getSelectedRow();

    String id =
    tblSewa.getValueAt(baris,0)
    .toString();

    try {

        String sql =
        "DELETE FROM tb_sewa WHERE id_sewa=?";

        PreparedStatement pst =
        conn.prepareStatement(sql);

        pst.setString(1,id);

        pst.executeUpdate();

        JOptionPane.showMessageDialog(
        null,
        "Data Berhasil Dihapus");
        txtHargaSewa.setText("");
        txtLamaSewa.setText("");
        txtSubTotal.setText("");

        tampilData();

    } catch(Exception e) {

        JOptionPane.showMessageDialog(
        null,
        e.getMessage());

    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
    if(cbTransaksi.getSelectedItem() == null){
    JOptionPane.showMessageDialog(
        null,
        "Pilih transaksi terlebih dahulu");
    return;
}

if(cbMobil.getSelectedItem() == null){
    JOptionPane.showMessageDialog(
        null,
        "Pilih mobil terlebih dahulu");
    return;
}
    try {

        // Cari ID Mobil berdasarkan merk yang dipilih
        String idMobil = "";

        String cari =
        "SELECT id_mobil FROM tb_mobil WHERE merk_mobil=?";

        PreparedStatement pstCari =
        conn.prepareStatement(cari);

        pstCari.setString(
        1,
        cbMobil.getSelectedItem().toString());

        ResultSet rs =
        pstCari.executeQuery();

        if(rs.next()) {

            idMobil =
            rs.getString("id_mobil");

        }
        
        String idTransaksi = "";

String cariTransaksi =
"SELECT t.id_transaksi " +
"FROM tb_transaksi t " +
"JOIN tb_pelanggan p " +
"ON t.id_pelanggan = p.id_pelanggan " +
"WHERE p.nama_pelanggan=?";

PreparedStatement pstTransaksi =
conn.prepareStatement(cariTransaksi);

pstTransaksi.setString(
1,
cbTransaksi.getSelectedItem().toString());

ResultSet rsTransaksi =
pstTransaksi.executeQuery();

if(rsTransaksi.next()){

    idTransaksi =
    rsTransaksi.getString("id_transaksi");

}

        // Simpan ke tb_sewa
        String sql =
            "INSERT INTO tb_sewa(id_transaksi,id_mobil,lama_sewa,sub_total) VALUES(?,?,?,?)";

        PreparedStatement pst =
        conn.prepareStatement(sql);

        pst.setString(1,
        idTransaksi);

        pst.setString(2,
        idMobil);

        pst.setString(3,
        txtLamaSewa.getText());

        pst.setString(4,
            txtSubTotal.getText());

        pst.executeUpdate();
        String updateTransaksi =
        "UPDATE tb_transaksi SET total_bayar=? WHERE id_transaksi=?";

PreparedStatement pstUpdateTransaksi =
conn.prepareStatement(updateTransaksi);

pstUpdateTransaksi.setString(
1,
txtSubTotal.getText());

pstUpdateTransaksi.setString(
2,
idTransaksi);

pstUpdateTransaksi.executeUpdate();
        // Update status mobil
        String update =
        "UPDATE tb_mobil SET status='Disewa' WHERE id_mobil=?";

        PreparedStatement pstUpdate =
        conn.prepareStatement(update);

        pstUpdate.setString(
        1,
        idMobil);

        pstUpdate.executeUpdate();

        JOptionPane.showMessageDialog(
        null,
        "Data Berhasil Disimpan");
        txtHargaSewa.setText("");
        txtLamaSewa.setText("");
        txtSubTotal.setText("");

        tampilData();
        loadMobil();

    } catch(Exception e) {

        JOptionPane.showMessageDialog(
        null,
        e.getMessage());

    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

    int baris = tblSewa.getSelectedRow();

    String id =
    tblSewa.getValueAt(baris,0).toString();

    try {

        String idMobil = "";

        String cari =
        "SELECT id_mobil FROM tb_mobil WHERE merk_mobil=?";

        PreparedStatement pstCari =
        conn.prepareStatement(cari);

        pstCari.setString(
        1,
        cbMobil.getSelectedItem().toString());

        ResultSet rsMobil =
        pstCari.executeQuery();

        if(rsMobil.next()){

            idMobil =
            rsMobil.getString("id_mobil");

        }
        String idTransaksi = "";

String cariTransaksi =
"SELECT t.id_transaksi " +
"FROM tb_transaksi t " +
"JOIN tb_pelanggan p " +
"ON t.id_pelanggan = p.id_pelanggan " +
"WHERE p.nama_pelanggan=?";

PreparedStatement pstTransaksi =
conn.prepareStatement(cariTransaksi);

pstTransaksi.setString(
1,
cbTransaksi.getSelectedItem().toString());

ResultSet rsTransaksi =
pstTransaksi.executeQuery();

if(rsTransaksi.next()){

    idTransaksi =
    rsTransaksi.getString("id_transaksi");

}

        String sql =
        "UPDATE tb_sewa SET "
        + "id_transaksi=?,"
        + "id_mobil=?,"
        + "lama_sewa=?,"
        + "sub_total=? "
        + "WHERE id_sewa=?";

        PreparedStatement pst =
        conn.prepareStatement(sql);

pst.setString(
1,
idTransaksi);

        pst.setString(
        2,
        idMobil);

        pst.setString(
        3,
        txtLamaSewa.getText());

        pst.setString(
        4,
        txtSubTotal.getText());

        pst.setString(
        5,
        id);

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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblSewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSewaMouseClicked

    int baris =
    tblSewa.getSelectedRow();

    cbTransaksi.setSelectedItem(
    model.getValueAt(baris,1).toString());

    cbMobil.setSelectedItem(
    model.getValueAt(baris,2).toString());

    txtLamaSewa.setText(
    model.getValueAt(baris,3).toString());

    txtSubTotal.setText(
    model.getValueAt(baris,4).toString());
    }//GEN-LAST:event_tblSewaMouseClicked

    private void cbMobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMobilActionPerformed

    private void cbMobilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMobilItemStateChanged

    if(cbMobil.getSelectedItem() == null){
        return;
    }

    try {

        String sql =
        "SELECT harga_sewa FROM tb_mobil WHERE merk_mobil=?";

        PreparedStatement pst =
        conn.prepareStatement(sql);

        pst.setString(
        1,
        cbMobil.getSelectedItem().toString());

        ResultSet rs =
        pst.executeQuery();

        if(rs.next()) {

            txtHargaSewa.setText(
            rs.getString("harga_sewa"));
            
            hitungSubTotal();

        }

    } catch(Exception e) {

        JOptionPane.showMessageDialog(
        null,
        e.getMessage());

    }
    }//GEN-LAST:event_cbMobilItemStateChanged

    private void txtLamaSewaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLamaSewaKeyReleased
        // TODO add your handling code here:

    try {

        int harga =
        Integer.parseInt(
        txtHargaSewa.getText());

        int lama =
        Integer.parseInt(
        txtLamaSewa.getText());

        int subtotal =
        harga * lama;

        txtSubTotal.setText(
        String.valueOf(subtotal));

    } catch(Exception e) {

    }
    }//GEN-LAST:event_txtLamaSewaKeyReleased

    private void txtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalActionPerformed

    private void cbTransaksiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTransaksiItemStateChanged
        // TODO add your handling code here:
        if(cbTransaksi.getSelectedItem()==null){
    return;
}

try{

String sql =
"SELECT t.lama_sewa " +
"FROM tb_transaksi t " +
"JOIN tb_pelanggan p " +
"ON t.id_pelanggan = p.id_pelanggan " +
"WHERE p.nama_pelanggan=?";

    PreparedStatement pst =
    conn.prepareStatement(sql);

    pst.setString(
    1,
    cbTransaksi.getSelectedItem().toString());

    ResultSet rs =
    pst.executeQuery();

    if(rs.next()){

        txtLamaSewa.setText(
        rs.getString("lama_sewa"));
        
        hitungSubTotal();

    }

}catch(Exception e){

    JOptionPane.showMessageDialog(
    null,
    e.getMessage());

}
    }//GEN-LAST:event_cbTransaksiItemStateChanged


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSewa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbMobil;
    private javax.swing.JComboBox<String> cbTransaksi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSewa;
    private javax.swing.JTextField txtHargaSewa;
    private javax.swing.JTextField txtLamaSewa;
    private javax.swing.JTextField txtSubTotal;
    // End of variables declaration//GEN-END:variables
}
