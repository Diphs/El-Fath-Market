
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.sql.DriverManager;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Laporan extends javax.swing.JFrame {

    /**
     * Creates new form Laporan
     */
    public Laporan() {
        initComponents();
        String tampilan = "yyyy-MM-dd";
            
    }
    
    private void load_table(){
        //menampilkan data database kedalam tabel
        try {
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal=String.valueOf(fm.format(jDateChooser1.getDate()));
            String tanggal1=String.valueOf(fm.format(jDateChooser2.getDate()));
            String sql = "SELECT SUM(detail_penjualan.jumlah*produk.harga_jual) AS total_harga\n" +
            "FROM detail_penjualan JOIN produk ON detail_penjualan.kd_produk=produk.kd_produk "
                    + "JOIN penjualan ON detail_penjualan.kd_penjualan=penjualan.kd_penjualan\n" +
            "WHERE penjualan.waktu <= '"+tanggal1+ "' AND penjualan.waktu >= '"+tanggal+"'"+
            "ORDER BY total_harga" ;
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                jTextField1.setText("Rp."+res.getString(1));
            }
        } catch (Exception e){}
    }
    
    private void load_table1(){
        //menampilkan data database kedalam tabel
        try {
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal=String.valueOf(fm.format(jDateChooser1.getDate()));
            String tanggal1=String.valueOf(fm.format(jDateChooser2.getDate()));
            String sql = "SELECT Sum(jumlah*produk.harga_beli) AS total_harga" +
            " FROM detail_pembelian JOIN produk ON detail_pembelian.kd_produk=produk.kd_produk "
                    + "JOIN pembelian ON detail_pembelian.kd_pembelian=pembelian.kd_pembelian"+
            " WHERE pembelian.waktu >= '"+tanggal+ "' AND pembelian.waktu <= '"+tanggal1+"'"+
            " ORDER BY total_harga DESC";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                jTextField1.setText("Rp."+res.getString(1));
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablelaporan = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btn_cekPembelian = new javax.swing.JButton();
        btn_cekPenjualan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_cetakPembelian = new javax.swing.JButton();
        btn_cetakPenjualan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
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
        lbl_laporan.setForeground(new java.awt.Color(102, 102, 102));
        lbl_laporan.setIcon(new javax.swing.ImageIcon("D:\\Project5A\\laporan.png")); // NOI18N
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
                    .addComponent(lbl_dashboard)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbl_produk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_pembelian, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_laporan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_karyawan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_penjualan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

        jTablelaporan.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTablelaporan.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablelaporan.setRowHeight(30);
        jScrollPane1.setViewportView(jTablelaporan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 1160, 440));

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 230, -1));

        btn_cekPembelian.setBackground(new java.awt.Color(0, 102, 102));
        btn_cekPembelian.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        btn_cekPembelian.setForeground(new java.awt.Color(255, 255, 255));
        btn_cekPembelian.setText("CEK LAPORAN PEMBELIAN");
        btn_cekPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cekPembelianActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cekPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 160, -1, -1));

        btn_cekPenjualan.setBackground(new java.awt.Color(0, 102, 102));
        btn_cekPenjualan.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        btn_cekPenjualan.setForeground(new java.awt.Color(255, 255, 255));
        btn_cekPenjualan.setText("CEK LAPORAN PENJUALAN");
        btn_cekPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cekPenjualanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cekPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("  -");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 20, 20));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 280, 110));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 670, 280, 40));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Grand Total");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 680, 100, 20));

        btn_cetakPembelian.setBackground(new java.awt.Color(0, 102, 102));
        btn_cetakPembelian.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        btn_cetakPembelian.setForeground(new java.awt.Color(255, 255, 255));
        btn_cetakPembelian.setText("CETAK LAPORAN PEMBELIAN");
        btn_cetakPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakPembelianActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cetakPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 680, -1, -1));

        btn_cetakPenjualan.setBackground(new java.awt.Color(0, 102, 102));
        btn_cetakPenjualan.setFont(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        btn_cetakPenjualan.setForeground(new java.awt.Color(255, 255, 255));
        btn_cetakPenjualan.setText("CETAK LAPORAN PENJUALAN");
        btn_cetakPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakPenjualanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cetakPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 680, -1, -1));

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Filter Tanggal");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

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

    private void lbl_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_logoutMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_lbl_logoutMouseClicked

    private void lbl_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_laporanMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Laporan().setVisible(true);
    }//GEN-LAST:event_lbl_laporanMouseClicked

    private void btn_cekPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cekPenjualanActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Penjualan");
        model.addColumn("Nama Produk");
        model.addColumn("Waktu");
        model.addColumn("Jumlah");
        model.addColumn("Total Harga");

        //menampilkan data database kedalam tabel
        
        
        try {
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal=String.valueOf(fm.format(jDateChooser1.getDate()));
            String tanggal1=String.valueOf(fm.format(jDateChooser2.getDate()));
            String sql = "SELECT penjualan.kd_penjualan, produk.nama_produk, penjualan.waktu, "
                    + "detail_penjualan.jumlah, detail_penjualan.jumlah*produk.harga_jual AS total_harga\n" +
            "FROM detail_penjualan JOIN produk ON detail_penjualan.kd_produk=produk.kd_produk "
                    + "JOIN penjualan ON detail_penjualan.kd_penjualan=penjualan.kd_penjualan\n" +
            "WHERE penjualan.waktu <= '"+tanggal1+ "' AND penjualan.waktu >= '"+tanggal+"'"+
            "ORDER BY total_harga DESC";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),
                    res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5)});
            }
            
            jTablelaporan.setModel(model);
        } catch (Exception e){}
        load_table();
    }//GEN-LAST:event_btn_cekPenjualanActionPerformed

    private void btn_cekPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cekPembelianActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Pembelian");
        model.addColumn("Nama Produk");
        model.addColumn("Waktu");
        model.addColumn("Jumlah");
        model.addColumn("Total Harga");

        //menampilkan data database kedalam tabel
        try {
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal=String.valueOf(fm.format(jDateChooser1.getDate()));
            String tanggal1=String.valueOf(fm.format(jDateChooser2.getDate()));
            String sql = "SELECT pembelian.kd_pembelian, produk.nama_produk, pembelian.waktu, "
                    + "detail_pembelian.jumlah, detail_pembelian.jumlah*produk.harga_beli AS total_harga"+
            " FROM detail_pembelian JOIN produk ON detail_pembelian.kd_produk=produk.kd_produk "
                    + "JOIN pembelian ON detail_pembelian.kd_pembelian=pembelian.kd_pembelian"+
            " WHERE pembelian.waktu >= '"+tanggal+ "' AND pembelian.waktu <= '"+tanggal1+"'"+
            " ORDER BY total_harga DESC";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),
                    res.getString(2), res.getString(3),
                    res.getString(4), res.getString(5)});
            }
            
            jTablelaporan.setModel(model);
        } catch (Exception e){}
        load_table1();
    }//GEN-LAST:event_btn_cekPembelianActionPerformed

    private void btn_cetakPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakPembelianActionPerformed
        // TODO add your handling code here:
       try {
           String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal=String.valueOf(fm.format(jDateChooser1.getDate()));
            String tanggal1=String.valueOf(fm.format(jDateChooser2.getDate()));
            String NamaFile = "src\\laporanPembelian.jasper";

            HashMap parameter = new HashMap () ;
            parameter . put ("pTGL", tanggal) ;
            parameter . put ("pTGL1", tanggal1) ;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/toko","root","");
            File reportfile = new File (NamaFile) ;

            JasperReport jasperReport = (JasperReport) JRLoader. loadObject (reportfile. getPath () ) ;
            JasperPrint jasperPrint = JasperFillManager. fillReport (jasperReport, parameter, con) ;
            JasperViewer. viewReport (jasperPrint, false) ;
            JasperViewer. setDefaultLookAndFeelDecorated (true) ; ;
            
            } catch (Exception e) {
               
            }
    }//GEN-LAST:event_btn_cetakPembelianActionPerformed

    private void btn_cetakPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakPenjualanActionPerformed
        // TODO add your handling code here:
        try {
           String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal=String.valueOf(fm.format(jDateChooser1.getDate()));
            String tanggal1=String.valueOf(fm.format(jDateChooser2.getDate()));
            String NamaFile = "src\\laporanPenjualan.jasper";

            HashMap parameter = new HashMap () ;
            parameter . put ("pTGL", tanggal) ;
            parameter . put ("pTGL1", tanggal1) ;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/toko","root","");
            File reportfile = new File (NamaFile) ;

            JasperReport jasperReport = (JasperReport) JRLoader. loadObject (reportfile. getPath () ) ;
            JasperPrint jasperPrint = JasperFillManager. fillReport (jasperReport, parameter, con) ;
            JasperViewer. viewReport (jasperPrint, false) ;
            JasperViewer. setDefaultLookAndFeelDecorated (true) ; ;
            
            } catch (Exception e) {
               
            }
    }//GEN-LAST:event_btn_cetakPenjualanActionPerformed

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
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cekPembelian;
    private javax.swing.JButton btn_cekPenjualan;
    private javax.swing.JButton btn_cetakPembelian;
    private javax.swing.JButton btn_cetakPenjualan;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablelaporan;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_dashboard;
    private javax.swing.JLabel lbl_karyawan;
    private javax.swing.JLabel lbl_laporan;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JLabel lbl_pembelian;
    private javax.swing.JLabel lbl_penjualan;
    private javax.swing.JLabel lbl_produk;
    // End of variables declaration//GEN-END:variables
}
