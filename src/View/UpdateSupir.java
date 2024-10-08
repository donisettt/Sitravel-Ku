package View;

import Controller.SupirController;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import Model.Supir;

/**
 *
 * @author ASUS
 */
public class UpdateSupir extends javax.swing.JDialog {

    public static Supir supir;
    
    public void update_Supir(Supir supir) {
        this.supir = supir;
        txtId.setText(Integer.toString(supir.getId()));
        txtKodeSupir.setText(supir.getKode_supir());
        txtNamaSupir.setText(supir.getNama_supir());
        txtNoHp.setText(supir.getNo_hp());
        txtAlamat.setText(supir.getAlamat());
        setVisible(true);
        setLocationRelativeTo(getParent());
    }
    
    public UpdateSupir(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNamaSupir = new javax.swing.JTextField();
        txtKodeSupir = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtNoHp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        BtnBatal = new javax.swing.JButton();
        BtnSimpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Update Supir");

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Humnst777 BT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Update Supir");

        jLabel2.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id");

        jLabel3.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Kode Supir");

        jLabel4.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Supir");

        jLabel5.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No Hp");

        jLabel7.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Alamat");

        txtNamaSupir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaSupirKeyPressed(evt);
            }
        });

        txtKodeSupir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKodeSupirKeyPressed(evt);
            }
        });

        txtId.setEnabled(false);
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });

        txtNoHp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoHpKeyPressed(evt);
            }
        });

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        txtAlamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAlamatKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtAlamat);

        BtnBatal.setBackground(new java.awt.Color(255, 0, 0));
        BtnBatal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnBatal.setForeground(new java.awt.Color(255, 255, 255));
        BtnBatal.setText("Batal");
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });

        BtnSimpan.setBackground(new java.awt.Color(0, 204, 0));
        BtnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BtnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        BtnSimpan.setText("Simpan");
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNamaSupir)
                            .addComponent(txtKodeSupir)
                            .addComponent(txtId)
                            .addComponent(txtNoHp)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKodeSupir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNamaSupir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBatal)
                    .addComponent(BtnSimpan))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        txtKodeSupir.requestFocus();
    }//GEN-LAST:event_txtIdKeyPressed

    private void txtKodeSupirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeSupirKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // cek inputan
            if(txtKodeSupir.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Kode supir tidak boleh kosong", "warning", JOptionPane.WARNING_MESSAGE);
            } else {
                txtNamaSupir.requestFocus();
            }
        }
    }//GEN-LAST:event_txtKodeSupirKeyPressed

    private void txtNamaSupirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaSupirKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // cek inputan
            if(txtNamaSupir.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nama supir tidak boleh kosong", "warning", JOptionPane.WARNING_MESSAGE);
            } else {
                txtNoHp.requestFocus();
            }
        }
    }//GEN-LAST:event_txtNamaSupirKeyPressed

    private void txtNoHpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoHpKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // cek inputan
            if(txtNoHp.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No HP tidak boleh kosong", "warning", JOptionPane.WARNING_MESSAGE);
            } else {
                txtAlamat.requestFocus();
            }
        }
    }//GEN-LAST:event_txtNoHpKeyPressed

    private void txtAlamatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlamatKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // cek inputan
            if(txtAlamat.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Alamat tidak boleh kosong", "warning", JOptionPane.WARNING_MESSAGE);
            } else {
                BtnSimpan.doClick();
            }
        }
    }//GEN-LAST:event_txtAlamatKeyPressed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        dispose();
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        this.supir = supir;
        supir.setKode_supir(txtKodeSupir.getText());
        supir.setNama_supir(txtNamaSupir.getText());
        supir.setNo_hp(txtNoHp.getText());
        supir.setAlamat(txtAlamat.getText());
        
        SupirController controller = new SupirController();
        controller.Update_Supir(supir);
        dispose();
        JOptionPane.showMessageDialog(this, "Tiket Berhasil Di Update!");
    }//GEN-LAST:event_BtnSimpanActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateSupir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateSupir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateSupir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateSupir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UpdateSupir dialog = new UpdateSupir(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBatal;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtKodeSupir;
    private javax.swing.JTextField txtNamaSupir;
    private javax.swing.JTextField txtNoHp;
    // End of variables declaration//GEN-END:variables
}
