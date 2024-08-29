package View;

import Controller.Koneksi;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

/**
 *
 * @author ASUS
 */
public class TransaksiData extends javax.swing.JFrame {

    /**
     * Creates new form TransaksiData
     */
    
    private DefaultTableModel model_penumpang;
    private DefaultTableModel model_tiket;
    private DefaultTableModel model_transaksi;
    
    public TransaksiData() {
        initComponents();
        model_penumpang = new DefaultTableModel();
        getDataPenumpang();
        
        model_tiket = new DefaultTableModel();
        getDataTiket();
        
        model_transaksi = new DefaultTableModel();
        data.setModel(model_transaksi);
        model_transaksi.addColumn("Kode Penumpang");
        model_transaksi.addColumn("Nama Penumpang");
        model_transaksi.addColumn("Kode Tiket");
        model_transaksi.addColumn("Jurusan");
        model_transaksi.addColumn("Harga");
        model_transaksi.addColumn("Tanggal Pesan");
        model_transaksi.addColumn("Tanggal Berangkat");
        model_transaksi.addColumn("Jumlah Beli");
        model_transaksi.addColumn("Total Harga");
        
        getDataTransaksi();
        Refresh();
    }
    
    // mengambil data penumpang dari database
    public void getDataPenumpang() {
        model_penumpang.getDataVector().removeAllElements();
        model_penumpang.fireTableDataChanged();
        
        try {
            String sql = "Select * from penumpang";
            Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Object[] obj = new Object[5];
                obj[0] = res.getString("kode_customer");
                obj[1] = res.getString("nama_penumpang");
                obj[2] = res.getString("jenis_kelamin");
                obj[3] = res.getString("no_hp");
                obj[4] = res.getString("alamat");
                
                model_penumpang.addRow(obj);
                cb_Penumpang.addItem((String) obj[0]);
            }
            
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    
    // mengambil data tiket dari database
    public void getDataTiket() {
        model_penumpang.getDataVector().removeAllElements();
        model_penumpang.fireTableDataChanged();
        
        try {
            String sql = "Select * from tiket";
            Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()) {
                Object[] obj = new Object[5];
                obj[0] = res.getString("transportasi_id");
                obj[1] = res.getString("kode_tiket");
                obj[2] = res.getString("jurusan");
                obj[3] = res.getString("harga");
                obj[4] = res.getString("stok_kursi");
                
                model_penumpang.addRow(obj);
                cb_Tiket.addItem((String) obj[1]);
            }
            
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }    
    }
    
    // mengambil data tiket dari database
    public void getDataTransaksi() {
        model_transaksi.getDataVector().removeAllElements();
        model_transaksi.fireTableDataChanged();

        try {
            String sql = "SELECT penumpang.kode_customer, penumpang.nama_penumpang, tiket.kode_tiket, tiket.jurusan, tiket.harga, transaksi.tanggal_pesan, transaksi.tanggal_berangkat, transaksi.jml_beli, transaksi.total_harga " +
                         "FROM transaksi " +
                         "JOIN penumpang ON transaksi.kode_customer = penumpang.kode_customer " +
                         "JOIN tiket ON transaksi.kode_tiket = tiket.kode_tiket";
            java.sql.Connection con = Koneksi.getKoneksi();
            java.sql.Statement stat = con.createStatement();
            java.sql.ResultSet res = stat.executeQuery(sql);

            while (res.next()) {
                Object[] obj = new Object[9];
                obj[0] = res.getString("kode_customer");
                obj[1] = res.getString("nama_penumpang");
                obj[2] = res.getString("kode_tiket");
                obj[3] = res.getString("jurusan");
                obj[4] = res.getString("harga");
                obj[5] = res.getString("tanggal_pesan");
                obj[6] = res.getString("tanggal_berangkat");
                obj[7] = res.getString("jml_beli");
                obj[8] = res.getString("total_harga");

                model_transaksi.addRow(obj);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }    
    }
    
    public void Refresh() {
        txtNamaPenumpang.setText("");
        txtHarga.setText("");
        txtJumlahBeli.setText("");
        txtJurusan.setText("");
        txtNoHP.setText("");
        txtTotalHarga.setText("");
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
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        DatePesan = new com.toedter.calendar.JDateChooser();
        DateBerangkat = new com.toedter.calendar.JDateChooser();
        cb_Penumpang = new javax.swing.JComboBox<>();
        cb_Tiket = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtNamaPenumpang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNoHP = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtJurusan = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtJumlahBeli = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTotalHarga = new javax.swing.JTextField();
        btn_Simpan = new javax.swing.JButton();
        btn_Update = new javax.swing.JButton();
        btn_Hapus = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        data = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel3.setFont(new java.awt.Font("EngraversGothic BT", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Data Transaksi");

        jLabel1.setFont(new java.awt.Font("STCaiyun", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TravelKu");

        jLabel2.setFont(new java.awt.Font("EngraversGothic BT", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Aplikasi Travel, By Kelompok 2 ");

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back_icon-icons.com_65134 (1).png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10))
        );

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 153, 255))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tanggal Pesan :");

        jLabel5.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tanggal Berangkat :");

        jLabel6.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kode Penumpang :");

        jLabel7.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kode Tiket : ");

        cb_Penumpang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_PenumpangMouseClicked(evt);
            }
        });
        cb_Penumpang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cb_PenumpangKeyReleased(evt);
            }
        });

        cb_Tiket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_TiketMouseClicked(evt);
            }
        });
        cb_Tiket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cb_TiketKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nama Penumpang :");

        jLabel9.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nomor HP :");

        jLabel10.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Jurusan : ");

        jLabel11.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Harga :");

        jLabel12.setText("Jumlah Beli : ");

        txtJumlahBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJumlahBeliKeyReleased(evt);
            }
        });

        jLabel13.setText("Total Harga : ");

        btn_Simpan.setBackground(new java.awt.Color(0, 204, 0));
        btn_Simpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_Simpan.setText("Simpan");
        btn_Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SimpanActionPerformed(evt);
            }
        });

        btn_Update.setBackground(new java.awt.Color(204, 204, 0));
        btn_Update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Update.setForeground(new java.awt.Color(255, 255, 255));
        btn_Update.setText("Update");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });

        btn_Hapus.setBackground(new java.awt.Color(255, 0, 0));
        btn_Hapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_Hapus.setText("Hapus");

        btn_batal.setBackground(new java.awt.Color(255, 102, 0));
        btn_batal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setText("Batal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(60, 60, 60)
                        .addComponent(txtNoHP))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DatePesan, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_Penumpang, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtNamaPenumpang)))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_Tiket, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateBerangkat, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txtJurusan)
                    .addComponent(txtHarga))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtJumlahBeli))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_Hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_batal))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Simpan)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Update)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(DatePesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(DateBerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(txtJumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_Penumpang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(cb_Tiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNamaPenumpang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Simpan)
                    .addComponent(btn_Update))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Hapus)
                    .addComponent(btn_batal))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 153, 255))); // NOI18N

        data.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(data);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_PenumpangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_PenumpangMouseClicked
        // TODO add your handling code here:
        try {
            java.sql.Connection con = (Connection) Controller.Koneksi.getKoneksi();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("Select * from penumpang where kode_customer = '"+cb_Penumpang.getSelectedItem()+"'");
            
            if(sql.next()) {
                String nama = sql.getString("nama_penumpang");
                txtNamaPenumpang.setText(nama);
                String no_hp = sql.getString("no_hp");
                txtNoHP.setText(no_hp);
            }
            
        } catch(SQLException e) {
            System.out.println("Ada kesalahan : " + e);
        }
    }//GEN-LAST:event_cb_PenumpangMouseClicked

    private void cb_PenumpangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb_PenumpangKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_PenumpangKeyReleased

    private void cb_TiketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_TiketMouseClicked
        // TODO add your handling code here:
        try {
            java.sql.Connection con = (Connection) Controller.Koneksi.getKoneksi();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("Select * from tiket where kode_tiket = '"+cb_Tiket.getSelectedItem()+"'");
            
            if(sql.next()) {
                String jurusan = sql.getString("jurusan");
                txtJurusan.setText(jurusan);
                String harga = sql.getString("harga");
                txtHarga.setText(harga);
            }
            
        } catch(SQLException e) {
        
        }
    }//GEN-LAST:event_cb_TiketMouseClicked

    private void cb_TiketKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cb_TiketKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_TiketKeyReleased

    private void txtJumlahBeliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahBeliKeyReleased
        // TODO add your handling code here:
        Double harga_barang = Double.parseDouble(txtHarga.getText());
        Double jumlah_beli = Double.parseDouble(txtJumlahBeli.getText());
        Double total_beli = harga_barang * jumlah_beli;
        txtTotalHarga.setText(String.valueOf(total_beli));
    }//GEN-LAST:event_txtJumlahBeliKeyReleased

    private void btn_SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SimpanActionPerformed
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tgl_pesan = fm.format(DatePesan.getDate());
        String tgl_berangkat = fm.format(DateBerangkat.getDate());

        try {
            // Query untuk memasukkan data transaksi
            String sql = "INSERT INTO transaksi (id, kode_customer, kode_tiket, tanggal_pesan, tanggal_berangkat, jml_beli, total_harga) "
                       + "VALUES (null, ?, ?, ?, ?, ?, ?)";
            java.sql.Connection con = Koneksi.getKoneksi();
            java.sql.PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, (String) cb_Penumpang.getSelectedItem());
            stm.setString(2, (String) cb_Tiket.getSelectedItem());
            stm.setString(3, tgl_pesan);
            stm.setString(4, tgl_berangkat);
            stm.setInt(5, Integer.parseInt(txtJumlahBeli.getText()));
            stm.setDouble(6, Double.parseDouble(txtTotalHarga.getText()));

            // Query untuk mengambil stok kursi dari tiket
            String sql1 = "SELECT stok_kursi FROM tiket WHERE kode_tiket = ?";
            java.sql.PreparedStatement stm1 = con.prepareStatement(sql1);
            stm1.setString(1, (String) cb_Tiket.getSelectedItem());
            java.sql.ResultSet res1 = stm1.executeQuery();

            if (res1.next()) {
                int stok = res1.getInt("stok_kursi");
                int beli = Integer.parseInt(txtJumlahBeli.getText());
                int sisa = stok - beli;
                
                if (beli > stok) {
                    JOptionPane.showMessageDialog(null, "Pembelian melebihi stok");
                } else {
                    // Query untuk memperbarui stok kursi
                    String sql2 = "UPDATE tiket SET stok_kursi = ? WHERE kode_tiket = ?";
                    java.sql.PreparedStatement stm2 = con.prepareStatement(sql2);
                    stm2.setInt(1, sisa);
                    stm2.setString(2, (String) cb_Tiket.getSelectedItem());

                    // Eksekusi query
                    stm.executeUpdate();
                    stm2.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Transaksi berhasil dibuat", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    getDataTransaksi();
                    getDataTiket();
                    Refresh();
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Tiket tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("Ada kesalahan : " + ex);
            JOptionPane.showMessageDialog(null, "Transaksi gagal dibuat", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            System.out.println("Kesalahan format angka : " + ex);
            JOptionPane.showMessageDialog(null, "Jumlah beli atau total harga tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_SimpanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        
    }//GEN-LAST:event_btn_UpdateActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateBerangkat;
    private com.toedter.calendar.JDateChooser DatePesan;
    private javax.swing.JButton btn_Hapus;
    private javax.swing.JButton btn_Simpan;
    private javax.swing.JButton btn_Update;
    private javax.swing.JButton btn_batal;
    private javax.swing.JComboBox<String> cb_Penumpang;
    private javax.swing.JComboBox<String> cb_Tiket;
    private javax.swing.JTable data;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlahBeli;
    private javax.swing.JTextField txtJurusan;
    private javax.swing.JTextField txtNamaPenumpang;
    private javax.swing.JTextField txtNoHP;
    private javax.swing.JTextField txtTotalHarga;
    // End of variables declaration//GEN-END:variables
}
