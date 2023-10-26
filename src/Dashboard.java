
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        load_table();
        load_table1();
        load_table2();
        load_table3();
    }

    private void load_table(){
        //menampilkan data database kedalam tabel
        try {
            String sql = "SELECT COUNT(*) FROM karyawan WHERE NOT kd_karyawan ='K555' AND NOT kd_karyawan = 'K666'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                jumlah_karyawan.setText(res.getString(1));
            }
            

        } catch (Exception e){}
    }
    
    private void load_table1(){
        //menampilkan data database kedalam tabel
        try {
            String sql1 = "SELECT COUNT(*) FROM detail_penjualan;";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql1);
            while(res.next()){
                jumlah_penjualan.setText(res.getString(1));
            }
            

        } catch (Exception e){}
    }
    
    private void load_table2(){
        //menampilkan data database kedalam tabel
        try {
            String sql1 = "SELECT COUNT(*) FROM produk;";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql1);
            while(res.next()){
                jumlah_produk.setText(res.getString(1));
            }
            

        } catch (Exception e){}
    }
    
    private void load_table3(){
        //menampilkan data database kedalam tabel
        try {
            String sql1 = "SELECT SUM(detail_penjualan.jumlah*produk.harga_jual) AS total_harga "
                    + "FROM detail_penjualan JOIN produk ON detail_penjualan.kd_produk=produk.kd_produk "
                    + "JOIN penjualan ON detail_penjualan.kd_penjualan=penjualan.kd_penjualan\n" +
"            ORDER BY total_harga;";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql1);
            while(res.next()){
                
                jumlah_pendapatan.setText("Rp."+res.getString(1));
            }
            

        } catch (Exception e){}
    }
    /**
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jumlah_karyawan = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jumlah_penjualan = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jumlah_produk = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jumlah_pendapatan = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(1380, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(1380, 100));

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
        lbl_dashboard.setForeground(new java.awt.Color(102, 102, 102));
        lbl_dashboard.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\dashboard.PNG")); // NOI18N
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
        lbl_penjualan.setForeground(new java.awt.Color(0, 153, 153));
        lbl_penjualan.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\penjualan2.png")); // NOI18N
        lbl_penjualan.setText("PENJUALAN");
        lbl_penjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_penjualanMouseClicked(evt);
            }
        });

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(lbl_produk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_penjualan, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(lbl_pembelian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_karyawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(165, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 107, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 200));

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\karyawan3.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("DAFTAR KARYAWAN");

        jumlah_karyawan.setFont(new java.awt.Font("Segoe UI Semibold", 1, 50)); // NOI18N
        jumlah_karyawan.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jumlah_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jumlah_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 200));

        jButton2.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\penjualan3.png")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("JUMLAH PENJUALAN");

        jumlah_penjualan.setFont(new java.awt.Font("Segoe UI Semibold", 1, 50)); // NOI18N
        jumlah_penjualan.setForeground(new java.awt.Color(0, 153, 153));
        jumlah_penjualan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jumlah_penjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jumlah_penjualan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(36, 36, 36))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, -1, 200));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 200));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("JUMLAH PRODUK");

        jumlah_produk.setFont(new java.awt.Font("Segoe UI Semibold", 1, 50)); // NOI18N
        jumlah_produk.setForeground(new java.awt.Color(0, 153, 153));

        jButton4.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\produk3.png")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jumlah_produk, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jumlah_produk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGap(36, 36, 36))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(300, 200));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("TOTAL PENDAPATAN");

        jumlah_pendapatan.setFont(new java.awt.Font("Segoe UI Semibold", 1, 50)); // NOI18N
        jumlah_pendapatan.setForeground(new java.awt.Color(0, 153, 153));

        jButton5.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\pendapatan3.png")); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jumlah_pendapatan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel6)
                .addGap(0, 198, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jumlah_pendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(36, 36, 36))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 430, 460, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\Project Akhir semester 1\\ICON\\4.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1380, 670));

        setSize(new java.awt.Dimension(1398, 777));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_produkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_produkMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Produk().setVisible(true);
    }//GEN-LAST:event_lbl_produkMouseClicked

    private void lbl_penjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_penjualanMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Penjualan().setVisible(true);
    }//GEN-LAST:event_lbl_penjualanMouseClicked

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

    private void lbl_dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dashboardMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_lbl_dashboardMouseClicked

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_lbl_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel jumlah_karyawan;
    private javax.swing.JLabel jumlah_pendapatan;
    private javax.swing.JLabel jumlah_penjualan;
    private javax.swing.JLabel jumlah_produk;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_karyawan;
    private javax.swing.JLabel lbl_laporan;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_pembelian;
    private javax.swing.JLabel lbl_penjualan;
    private javax.swing.JLabel lbl_produk;
    // End of variables declaration//GEN-END:variables
}
