
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Penjualan extends javax.swing.JFrame {

    /**
     * Creates new form Penjualan
     */
    public Penjualan() {
        initComponents();
        load_table();
    }

    UbahDataPenjualan jtRowData = new UbahDataPenjualan();
    
    private void load_table(){
        //membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Penjualan");
        model.addColumn("Nama Produk");
        model.addColumn("Waktu");
        model.addColumn("Jumlah");
        model.addColumn("Total Harga");
        model.addColumn("Nama Karyawan");

        //menampilkan data database kedalam tabel
        try {
            String sql = "SELECT penjualan.kd_penjualan, produk.nama_produk, penjualan.waktu, detail_penjualan.jumlah, "
                    + "detail_penjualan.jumlah*produk.harga_jual AS total_harga, karyawan.nama "
                    + "FROM detail_penjualan JOIN produk ON detail_penjualan.kd_produk=produk.kd_produk "
                    + "JOIN penjualan ON detail_penjualan.kd_penjualan=penjualan.kd_penjualan "
                    + "JOIN karyawan on penjualan.kd_karyawan=karyawan.kd_karyawan ORDER BY kd_penjualan asc";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),
                    res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5),
                res.getString(6)});
            }
            
            jTablepenjualan.setModel(model);
        } catch (Exception e){}
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
        lbl_logout = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_dashboard = new javax.swing.JLabel();
        lbl_produk = new javax.swing.JLabel();
        lbl_penjualan = new javax.swing.JLabel();
        lbl_pembelian = new javax.swing.JLabel();
        lbl_karyawan = new javax.swing.JLabel();
        lbl_laporan = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablepenjualan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(1380, 100));

        lbl_logout.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logout.setText("LOGOUT");
        lbl_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_logoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(1275, Short.MAX_VALUE)
                .addComponent(lbl_logout)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(lbl_logout)
                .addGap(42, 42, 42))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(170, 630));

        lbl_dashboard.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lbl_dashboard.setForeground(new java.awt.Color(0, 153, 153));
        lbl_dashboard.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\dashboard2.PNG")); // NOI18N
        lbl_dashboard.setText("DASHBOARD");
        lbl_dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dashboardMouseClicked(evt);
            }
        });

        lbl_produk.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lbl_produk.setForeground(new java.awt.Color(0, 153, 153));
        lbl_produk.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\produk2.png")); // NOI18N
        lbl_produk.setText("PRODUK");
        lbl_produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_produkMouseClicked(evt);
            }
        });

        lbl_penjualan.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lbl_penjualan.setForeground(new java.awt.Color(102, 102, 102));
        lbl_penjualan.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\penjualan.png")); // NOI18N
        lbl_penjualan.setText("PENJUALAN");

        lbl_pembelian.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lbl_pembelian.setForeground(new java.awt.Color(0, 153, 153));
        lbl_pembelian.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\pembelian2.png")); // NOI18N
        lbl_pembelian.setText("PEMBELIAN");
        lbl_pembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_pembelianMouseClicked(evt);
            }
        });

        lbl_karyawan.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lbl_karyawan.setForeground(new java.awt.Color(0, 153, 153));
        lbl_karyawan.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\karyawan2.png")); // NOI18N
        lbl_karyawan.setText("KARYAWAN");
        lbl_karyawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_karyawanMouseClicked(evt);
            }
        });

        lbl_laporan.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lbl_laporan.setForeground(new java.awt.Color(0, 153, 153));
        lbl_laporan.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\laporan2.png")); // NOI18N
        lbl_laporan.setText("LAPORAN");
        lbl_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_laporanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_laporan)
                    .addComponent(lbl_karyawan)
                    .addComponent(lbl_pembelian)
                    .addComponent(lbl_penjualan)
                    .addComponent(lbl_produk)
                    .addComponent(lbl_dashboard))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lbl_dashboard)
                .addGap(45, 45, 45)
                .addComponent(lbl_produk)
                .addGap(45, 45, 45)
                .addComponent(lbl_penjualan)
                .addGap(45, 45, 45)
                .addComponent(lbl_pembelian)
                .addGap(45, 45, 45)
                .addComponent(lbl_karyawan)
                .addGap(45, 45, 45)
                .addComponent(lbl_laporan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 107, -1, 620));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 50));

        btn_tambah.setBackground(new java.awt.Color(0, 102, 102));
        btn_tambah.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("TAMBAH DATA");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(new java.awt.Color(255, 0, 51));
        btn_hapus.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_ubah.setBackground(new java.awt.Color(0, 153, 255));
        btn_ubah.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        btn_ubah.setForeground(new java.awt.Color(255, 255, 255));
        btn_ubah.setText("UBAH");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btn_tambah)
                .addGap(81, 81, 81)
                .addComponent(btn_hapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(btn_ubah)
                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah)
                    .addComponent(btn_hapus)
                    .addComponent(btn_ubah))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, -1, -1));

        jTablepenjualan.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTablepenjualan.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablepenjualan.setRowHeight(30);
        jTablepenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablepenjualanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablepenjualan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 1170, 470));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\Project Akhir semester 1\\ICON\\4.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 730));

        setSize(new java.awt.Dimension(1398, 777));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dashboardMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_lbl_dashboardMouseClicked

    private void lbl_produkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_produkMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Produk().setVisible(true);
    }//GEN-LAST:event_lbl_produkMouseClicked

    private void lbl_pembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_pembelianMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Pembelian().setVisible(true);
    }//GEN-LAST:event_lbl_pembelianMouseClicked

    private void lbl_karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_karyawanMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Karyawan().setVisible(true);
    }//GEN-LAST:event_lbl_karyawanMouseClicked

    private void lbl_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_laporanMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Laporan().setVisible(true);
    }//GEN-LAST:event_lbl_laporanMouseClicked

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new TambahDataPenjualan().setVisible(true);
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        int index = jTablepenjualan.getSelectedRow();
        TableModel model = jTablepenjualan.getModel();
        String kd_penjualan = model.getValueAt(index, 0).toString();
        String nama_produk = model.getValueAt(index, 1).toString();
        String jumlah = model.getValueAt(index, 3).toString();
        
        this.setVisible(false);
        jtRowData.setVisible(true);
        jtRowData.pack();
        jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        jtRowData.txt_kdPenjualan.setText(kd_penjualan);
        jtRowData.txt_kdPenjualan.disable();
        jtRowData.txt_nama.setText(nama_produk);
        jtRowData.txt_jumlah.setText(jumlah);
//        new UbahDataPenjualan().setVisible(true);
    }//GEN-LAST:event_btn_ubahActionPerformed

    private void jTablepenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablepenjualanMouseClicked
        // TODO add your handling code here:
        int index = jTablepenjualan.getSelectedRow();
        TableModel model = jTablepenjualan.getModel();
        String kd_penjualan = model.getValueAt(index, 0).toString();
        String jumlah = model.getValueAt(index, 2).toString();
        String total_harga = model.getValueAt(index, 3).toString();
    }//GEN-LAST:event_jTablepenjualanMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
         try {
            int index = jTablepenjualan.getSelectedRow();
            TableModel model = jTablepenjualan.getModel();
            String kd_penjualan = model.getValueAt(index, 0).toString();
            String sql = "DELETE FROM penjualan WHERE kd_penjualan ='"+kd_penjualan+"'";
            String sql1 = "DELETE FROM detail_penjualan WHERE kd_penjualan ='"+kd_penjualan+"'";
            java.sql.Connection conn = (Connection)Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.PreparedStatement pst1 = conn.prepareStatement(sql1);
            pst.execute();
            pst1.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");

        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table();
        
    }//GEN-LAST:event_btn_hapusActionPerformed

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
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablepenjualan;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_karyawan;
    private javax.swing.JLabel lbl_laporan;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_pembelian;
    private javax.swing.JLabel lbl_penjualan;
    private javax.swing.JLabel lbl_produk;
    // End of variables declaration//GEN-END:variables
}
