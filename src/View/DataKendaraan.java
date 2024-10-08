package View;

import com.stripbandunk.jwidget.JDynamicTable;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.awt.Component;
import java.util.List;
import Model.Kendaraan;
import Controller.KendaraanController;
import View.DataKendaraan;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author ASUS
 */
public class DataKendaraan extends javax.swing.JFrame {

    private DynamicTableModel<Kendaraan> tableModel;
    private JDynamicTable jDynamicTable;
    
    private void reload() {
        tableModel.clear();
        KendaraanController controller = new KendaraanController();
        List<Kendaraan> list = controller.TampilData();
        for(Kendaraan kendaraan : list) {
            tableModel.add(kendaraan);
        }
    }
    
    public DataKendaraan() {
        initComponents();
        tableModel = new DynamicTableModel<> (Kendaraan.class);
        jDynamicTable = new JDynamicTable(tableModel);
        jScrollPane1.setViewportView(jDynamicTable);
        reload();
        Tampil_Jam();
        
        // membuat logo icon
        Image icon = Toolkit.getDefaultToolkit().getImage("src/Image/logo_kc.png");
        setIconImage(icon);
    }
    
    public void Tampil_Jam(){
        ActionListener taskPerformer = new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent evt) {
            String nol_jam = "", nol_menit = "",nol_detik = "";
 
            java.util.Date dateTime = new java.util.Date();
            int nilai_jam = dateTime.getHours();
            int nilai_menit = dateTime.getMinutes();
            int nilai_detik = dateTime.getSeconds();
 
            if(nilai_jam <= 9) nol_jam= "0";
            if(nilai_menit <= 9) nol_menit= "0";
            if(nilai_detik <= 9) nol_detik= "0";
 
            String jam = nol_jam + Integer.toString(nilai_jam);
            String menit = nol_menit + Integer.toString(nilai_menit);
            String detik = nol_detik + Integer.toString(nilai_detik);
 
            jaammm.setText(jam+":"+menit+":"+detik+"");
            }
        };
    new Timer(1000, taskPerformer).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jaammm = new javax.swing.JLabel();
        BtnKembali = new javax.swing.JButton();
        BtnTambahData = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("EngraversGothic BT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Penumpang");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Data Kendaraan");

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel2.setFont(new java.awt.Font("EngraversGothic BT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Data Kendaraan");

        jLabel3.setFont(new java.awt.Font("STCaiyun", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TravelKu");

        jLabel4.setFont(new java.awt.Font("EngraversGothic BT", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Aplikasi Travel, By Kelompok 2 ");

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jaammm.setFont(new java.awt.Font("EngraversGothic BT", 1, 18)); // NOI18N
        jaammm.setForeground(new java.awt.Color(255, 255, 255));
        jaammm.setText("jLabel5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jaammm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jaammm)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        BtnKembali.setBackground(new java.awt.Color(51, 153, 255));
        BtnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back_icon-icons.com_65134 (1).png"))); // NOI18N
        BtnKembali.setBorder(null);
        BtnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKembaliActionPerformed(evt);
            }
        });

        BtnTambahData.setBackground(new java.awt.Color(0, 204, 0));
        BtnTambahData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnTambahData.setForeground(new java.awt.Color(255, 255, 255));
        BtnTambahData.setText("Tambah Data");
        BtnTambahData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahDataActionPerformed(evt);
            }
        });

        BtnEdit.setBackground(new java.awt.Color(204, 204, 0));
        BtnEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnEdit.setForeground(new java.awt.Color(255, 255, 255));
        BtnEdit.setText("Edit");
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });

        BtnHapus.setBackground(new java.awt.Color(255, 0, 0));
        BtnHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnHapus.setForeground(new java.awt.Color(255, 255, 255));
        BtnHapus.setText("Hapus");
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnKembali)))
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(BtnTambahData)
                .addGap(18, 18, 18)
                .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnKembali))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTambahData)
                    .addComponent(BtnEdit)
                    .addComponent(BtnHapus))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKembaliActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKembaliActionPerformed

    private void BtnTambahDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahDataActionPerformed
        TambahKendaraan tambah = new TambahKendaraan(this, true);
        tambah.tambah_kendaraan();
        reload();
    }//GEN-LAST:event_BtnTambahDataActionPerformed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        if (jDynamicTable.getSelectedRow() != -1) {
            int index = jDynamicTable.convertColumnIndexToModel(jDynamicTable.getSelectedRow());
            Kendaraan kendaraan = tableModel.get(index);
            UpdateKendaraan update_kendaraan = new UpdateKendaraan(this, true);
            update_kendaraan.update_Kendaraan(kendaraan);
            reload();
        } else {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data yang akan dirubah terlebih dahulu");
        }
    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        if (jDynamicTable.getSelectedRow() != -1) {
            if (JOptionPane.showConfirmDialog(this, "Anda yakin Akan Menghapus Data?", "Hapus Penumpang", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION);
            int index = jDynamicTable.convertColumnIndexToModel(jDynamicTable.getSelectedRow());
            Kendaraan kendaraan = tableModel.get(index);
            
            System.out.println(kendaraan.getId());
            KendaraanController controller = new KendaraanController();
            controller.Delete_Kendaraan(kendaraan.getId());
            reload();
            JOptionPane.showMessageDialog(this, "Penumpang berhasil dihapus!");
        } else {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data yang akan dirubah terlebih dahulu");
        }
    }//GEN-LAST:event_BtnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(DataKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataKendaraan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataKendaraan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnKembali;
    private javax.swing.JButton BtnTambahData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jaammm;
    // End of variables declaration//GEN-END:variables
}
