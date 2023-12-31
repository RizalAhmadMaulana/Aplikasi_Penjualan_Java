package aplikasipenjualan;

import java.awt.BorderLayout;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import login.loginFrame;
import method.dataForAllFrame;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import panel.dataBarang.panelBarang;
import panel.supplier.panelSupplier;
import panel.transkasiPenjualan.panelTransaksiPenjualan;

public class FormMenuUtama extends dataForAllFrame {

    public FormMenuUtama() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        //setContent(new panelTabungan());
    }

    private void setContent(JPanel content) {
        getContentPane().setLayout(new BorderLayout());
        getContentPane().removeAll();
        add(content);
        content.setVisible(true);
        SwingUtilities.updateComponentTreeUI(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        mmm = new javax.swing.JMenu();
        menuLogout = new javax.swing.JMenuItem();
        mn = new javax.swing.JMenu();
        menuBarang = new javax.swing.JMenuItem();
        menuTransaksi = new javax.swing.JMenuItem();
        menuSupplier = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuLaporanTransaksi = new javax.swing.JMenuItem();
        menuLaporanDataBarang = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem3.setText("jMenuItem3");

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Judul");
        setMinimumSize(new java.awt.Dimension(1370, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mmm.setText("File");

        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        mmm.add(menuLogout);

        jMenuBar1.add(mmm);

        mn.setText("Data");

        menuBarang.setText("Barang");
        menuBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarangActionPerformed(evt);
            }
        });
        mn.add(menuBarang);

        menuTransaksi.setText("Transaksi");
        menuTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTransaksiActionPerformed(evt);
            }
        });
        mn.add(menuTransaksi);

        menuSupplier.setText("Supplier");
        menuSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSupplierActionPerformed(evt);
            }
        });
        mn.add(menuSupplier);

        jMenuBar1.add(mn);

        jMenu4.setText("Laporan");

        menuLaporanTransaksi.setText("Transaksi");
        menuLaporanTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLaporanTransaksiActionPerformed(evt);
            }
        });
        jMenu4.add(menuLaporanTransaksi);

        menuLaporanDataBarang.setText("Data Barang");
        menuLaporanDataBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLaporanDataBarangActionPerformed(evt);
            }
        });
        jMenu4.add(menuLaporanDataBarang);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarangActionPerformed
        setContent(new panelBarang());
    }//GEN-LAST:event_menuBarangActionPerformed

    private void menuTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTransaksiActionPerformed
        setContent(new panelTransaksiPenjualan());
    }//GEN-LAST:event_menuTransaksiActionPerformed

    private void menuSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSupplierActionPerformed
        setContent(new panelSupplier());
    }//GEN-LAST:event_menuSupplierActionPerformed

    private void menuLaporanTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLaporanTransaksiActionPerformed
        String user = "root";
        String pass = "";
        String host = "localhost";
        String db = "penjualan";
        String url;
        java.io.File dir1 = new java.io.File(".");
        String dirr;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            url = "jdbc:mysql://" + host + "/" + db + "?user=" + user + "&password=" + pass;
            conn = DriverManager.getConnection(url);

            stmt = conn.createStatement();

            dirr = dir1.getCanonicalPath() + "/src/panel/dataBarang/";
            JasperDesign disain = JRXmlLoader.load(dirr + "laporanTransaksi.jrxml");
            JasperReport nilaiLaporan = JasperCompileManager.compileReport(disain);

            rs = stmt.executeQuery(
                    "SELECT\n"
                    + "     dtpjl.`kode_barang` AS dtpjl_kode_barang,\n"
                    + "     dtpjl.`tanggal` AS dtpjl_tanggal,\n"
                    + "     dtpjl.`total_bayar` AS dtpjl_total_bayar,\n"
                    + "     dtpjl.`bayar` AS dtpjl_bayar,\n"
                    + "     dtpjl.`jumlah_beli` AS dtpjl_jumlah_beli,\n"
                    + "     dtpjl.`potongan` AS dtpjl_potongan\n"
                    + "FROM\n"
                    + "     `dtpjl` dtpjl\n");

            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(rs);
            JasperPrint cetak = JasperFillManager.fillReport(nilaiLaporan, new java.util.HashMap(), resultSetDataSource);
            JasperViewer.viewReport(cetak, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "\nGagal mencetak\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuLaporanTransaksiActionPerformed

    private void menuLaporanDataBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLaporanDataBarangActionPerformed
        String user = "root";
        String pass = "";
        String host = "localhost";
        String db = "penjualan";
        String url;
        java.io.File dir1 = new java.io.File(".");
        String dirr;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            url = "jdbc:mysql://" + host + "/" + db + "?user=" + user + "&password=" + pass;
            conn = DriverManager.getConnection(url);

            stmt = conn.createStatement();

            dirr = dir1.getCanonicalPath() + "/src/panel/dataBarang/";
            JasperDesign disain = JRXmlLoader.load(dirr + "laporanBarang.jrxml");
            JasperReport nilaiLaporan = JasperCompileManager.compileReport(disain);

            rs = stmt.executeQuery(
                    "SELECT\n"
                    + "     dtbrg.`kode_barang` AS dtbrg_kode_barang,\n"
                    + "     dtbrg.`nama_barang` AS dtbrg_nama_barang,\n"
                    + "     dtbrg.`jenis` AS dtbrg_jenis,\n"
                    + "     dtbrg.`jumlah` AS dtbrg_jumlah,\n"
                    + "     dtbrg.`pembelian` AS dtbrg_pembelian,\n"
                    + "     dtbrg.`penjualan` AS dtbrg_penjualan\n"
                    + "FROM\n"
                    + "     `dtbrg` dtbrg");

            JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(rs);
            JasperPrint cetak = JasperFillManager.fillReport(nilaiLaporan, new java.util.HashMap(), resultSetDataSource);
            JasperViewer.viewReport(cetak, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "\nGagal mencetak\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuLaporanDataBarangActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        this.dispose();
        new loginFrame().setVisible(true);
    }//GEN-LAST:event_menuLogoutActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem menuBarang;
    private javax.swing.JMenuItem menuLaporanDataBarang;
    private javax.swing.JMenuItem menuLaporanTransaksi;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenuItem menuSupplier;
    private javax.swing.JMenuItem menuTransaksi;
    private javax.swing.JMenu mmm;
    private javax.swing.JMenu mn;
    // End of variables declaration//GEN-END:variables
}
