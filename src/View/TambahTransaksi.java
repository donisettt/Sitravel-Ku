/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import Controller.TransaksiController;
import Controller.TransaksiController.TiketWithKendaraan;
import Model.Kendaraan;
import Model.Transaksi;
import Model.Penumpang;
import Model.Tiket;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author ASUS
 */
public class TambahTransaksi extends javax.swing.JDialog {

    public void tambah_transaksi() {
        setVisible(true);
        setLocationRelativeTo(getParent());
    }
    
    public TambahTransaksi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        populateComboBoxPenumpang();
        populateComboBoxTiket();
        
        cb_KodePenumpang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fillPenumpangFields((String) cb_KodePenumpang.getSelectedItem());
            }
        });

        cb_KodeTiket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fillTiketFields((String) cb_KodeTiket.getSelectedItem());
            }
        });
    }
    
    private void populateComboBoxPenumpang() {
        TransaksiController controller = new TransaksiController();
        List<String> penumpangList = controller.getDataPenumpang();
        for (String penumpang : penumpangList) {
            cb_KodePenumpang.addItem(penumpang);
        }
    }

    private void populateComboBoxTiket() {
        TransaksiController controller = new TransaksiController();
        List<String> tiketList = controller.getDataTiket();
        for (String tiket : tiketList) {
            cb_KodeTiket.addItem(tiket);
        }
    }

    private void fillPenumpangFields(String kodePenumpang) {
        TransaksiController controller = new TransaksiController();
        Penumpang penumpang = controller.getPenumpangData(kodePenumpang);
        if (penumpang != null) {
            txtNamaPenumpang.setText(penumpang.getNama_penumpang());
            txtNoHP.setText(penumpang.getNo_hp());
            txtAlamat.setText(penumpang.getAlamat());
        } else {
            txtNamaPenumpang.setText("");
            txtNoHP.setText("");
            txtAlamat.setText("");
        }
    }

    private void fillTiketFields(String kodeTiket) {
        TransaksiController controller = new TransaksiController();
        TiketWithKendaraan data = controller.getTiketData(kodeTiket);
        if (data != null && data.getTiket() != null && data.getKendaraan() != null) {
            txtJurusan.setText(data.getTiket().getJurusan());
            txtNamaMobil.setText(data.getKendaraan().getTipe_kendaraan());
            txtHarga.setText(String.valueOf(data.getTiket().getHarga()));

            // validasi status kursi
            int stokKursi = data.getTiket().getStok_kursi();

            if (stokKursi == 0) {
                txtKursiStatus.setText("Kursi habis");
                txtKursiStatus.setForeground(Color.RED);
                txtKursiStatus.setEditable(false);
            } else if (stokKursi <= 5) {
                txtKursiStatus.setText("Sisa " + stokKursi + " kursi");
                txtKursiStatus.setForeground(Color.ORANGE);
            } else if (stokKursi > 10) {
                txtKursiStatus.setText("Tersedia");
                txtKursiStatus.setForeground(Color.GREEN);
            } else {
                JOptionPane.showMessageDialog(null, "Tidak ada tiket ditemukan");
            }

        } else {
            txtJurusan.setText("");
            txtNamaMobil.setText("");
            txtHarga.setText("");
            txtKursiStatus.setText("");
        }
    }
    
    // method untuk waktu
    private String Tampil_Jam() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
        return sdf.format(new java.util.Date());
    }

    
//    public void Tampil_Jam(){
//        ActionListener taskPerformer = new ActionListener() {
//        @Override
//            public void actionPerformed(ActionEvent evt) {
//            String nol_jam = "", nol_menit = "",nol_detik = "";
// 
//            java.util.Date dateTime = new java.util.Date();
//            int nilai_jam = dateTime.getHours();
//            int nilai_menit = dateTime.getMinutes();
//            int nilai_detik = dateTime.getSeconds();
// 
//            if(nilai_jam <= 9) nol_jam= "0";
//            if(nilai_menit <= 9) nol_menit= "0";
//            if(nilai_detik <= 9) nol_detik= "0";
// 
//            String jam = nol_jam + Integer.toString(nilai_jam);
//            String menit = nol_menit + Integer.toString(nilai_menit);
//            String detik = nol_detik + Integer.toString(nilai_detik);
// 
//            JWaktu.setText(jam+":"+menit+":"+detik+"");
//            }
//        };
//    new Timer(1000, taskPerformer).start();
//    }


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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cb_KodePenumpang = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cb_KodeTiket = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNamaPenumpang = new javax.swing.JTextField();
        txtNoHP = new javax.swing.JTextField();
        txtJurusan = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtJumlahBeli = new javax.swing.JTextField();
        txtTotalHarga = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        DateTglBerangkat = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        DateTglPesan = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtUangPelanggan = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtKembalian = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtNamaMobil = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtKursiStatus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtStruk = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Tambah Transaksi");

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Humnst777 BT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("+Transaksi");

        jLabel2.setFont(new java.awt.Font("STCaiyun", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TravelKu");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Data Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kode Penumpang");

        cb_KodePenumpang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_KodePenumpangMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nama Penumpang");

        jLabel6.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("No HP");

        jLabel7.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kode Tiket");

        jLabel8.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Jurusan");

        jPanel4.setBackground(new java.awt.Color(255, 153, 0));

        jLabel12.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jumlah Beli");

        txtJumlahBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtJumlahBeliKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJumlahBeliKeyReleased(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 0, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Batal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 204, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Bayar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        DateTglBerangkat.setBackground(new java.awt.Color(51, 153, 255));

        jLabel10.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tanggal Pesan");

        DateTglPesan.setBackground(new java.awt.Color(51, 153, 255));

        jLabel11.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tanggal Berangkat");

        jLabel20.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Kembalian");

        jLabel13.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Uang Pelanggan");

        txtUangPelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUangPelangganKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Total Harga");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtUangPelanggan, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(DateTglBerangkat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                .addComponent(txtJumlahBeli, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)))
                    .addComponent(jLabel13))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(DateTglPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel20)
                                .addComponent(jLabel21)
                                .addComponent(txtTotalHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                .addComponent(txtKembalian)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DateTglBerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateTglPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUangPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(22, 22, 22))
        );

        jLabel19.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Nama Mobil");

        jLabel18.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Alamat");

        jLabel9.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Harga");

        jLabel14.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Status");

        txtStruk.setColumns(20);
        txtStruk.setRows(5);
        jScrollPane1.setViewportView(txtStruk);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(cb_KodeTiket, 0, 129, Short.MAX_VALUE)
                            .addComponent(cb_KodePenumpang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(txtNamaPenumpang, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtJurusan))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNoHP)
                            .addComponent(jLabel6)
                            .addComponent(jLabel19)
                            .addComponent(txtNamaMobil, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(txtKursiStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_KodePenumpang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPenumpang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel19)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_KodeTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKursiStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setForeground(new java.awt.Color(51, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/back_icon-icons.com_65134 (1).png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 153, 0));
        jLabel3.setFont(new java.awt.Font("Humnst777 BT", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("Aplikasi Travel, By Kelompok 2 ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 706, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtUangPelangganKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUangPelangganKeyReleased

    }//GEN-LAST:event_txtUangPelangganKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Transaksi transaksi = new Transaksi();

        // Ambil tanggal dari komponen date picker
        java.util.Date utilDatePesan = DateTglPesan.getDate();
        java.util.Date utilDateBerangkat = DateTglBerangkat.getDate();

        // Konversi java.util.Date ke java.sql.Date
        java.sql.Date sqlDatePesan = new java.sql.Date(utilDatePesan.getTime());
        java.sql.Date sqlDateBerangkat = new java.sql.Date(utilDateBerangkat.getTime());

        transaksi.setTanggal_pesan(sqlDatePesan);
        transaksi.setTanggal_berangkat(sqlDateBerangkat);
        transaksi.setKode_customer((String) cb_KodePenumpang.getSelectedItem());
        transaksi.setKode_tiket((String) cb_KodeTiket.getSelectedItem());

        // Validasi txtJumlahBeli
        String jumlahBeliText = txtJumlahBeli.getText();
        if (jumlahBeliText == null || jumlahBeliText.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jumlah beli tidak boleh kosong.");
            return;
        }
        try {
            transaksi.setJml_beli(Integer.parseInt(jumlahBeliText));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Jumlah beli harus berupa angka.");
            return;
        }

        // Validasi txtTotalHarga
        String totalHargaText = txtTotalHarga.getText();
        if (totalHargaText == null || totalHargaText.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Total harga tidak boleh kosong.");
            return;
        }
        try {
            transaksi.setTotal_harga((int) Double.parseDouble(totalHargaText));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Total harga harus berupa angka.");
            return;
        }

        // Validasi uang pelanggan
        String uangPelangganText = txtUangPelanggan.getText();
        if (uangPelangganText == null || uangPelangganText.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Uang pelanggan tidak boleh kosong.");
            return;
        }
        double uangPelanggan;
        try {
            uangPelanggan = Double.parseDouble(uangPelangganText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Uang pelanggan harus berupa angka.");
            return;
        }

        if (uangPelanggan < Double.parseDouble(totalHargaText)) {
            JOptionPane.showMessageDialog(this, "Uang pelanggan kurang.");
            return;
        } else {
            try {
                TransaksiController controller = new TransaksiController();
                controller.InsertData(transaksi);
                JOptionPane.showMessageDialog(this, "Berhasil tambah transaksi");
                
                // validasi kembalian
                Double uang_pelanggan = Double.parseDouble(txtUangPelanggan.getText());
                Double total_harga = Double.parseDouble(txtTotalHarga.getText());
                Double kembalian = uang_pelanggan - total_harga;
                txtKembalian.setText(String.valueOf(kembalian));
                
                // Format struk transaksi
                StringBuilder struk = new StringBuilder();
                struk.append("                  Si-TravelKu             \n");
                struk.append("     Jl. Susukan girang 11, Subang    \n");
                struk.append("         No. Telp 085757501928        \n");
                struk.append("----------------------------------------------\n");
                struk.append(Tampil_Jam()).append("\n");
                struk.append("----------------------------------------------\n");
                struk.append("Nama Penumpang : ").append(transaksi.getPenumpang()).append("\n");
                struk.append("Jurusan        : ").append(transaksi.getTiket()).append("\n");
                struk.append("Berangkat     : ").append(sqlDateBerangkat).append("\n");
                //struk.append("Tarif          : ").append(String.format("Rp %.2f", transaksi.getTotal_harga())).append("\n");
                struk.append("\n");
                struk.append("Ketentuan :                           \n");
                struk.append("Tiket harap dibawa pada saat \n");
                struk.append("jadwalpemberangkatan dan \n");
                struk.append("tidak boleh hilang \n");
                struk.append("---------------------------------------------\n");
                struk.append("                 TERIMA KASIH                \n");
                struk.append("---------------------------------------------\n");

                // Set struk ke txtStruk
                txtStruk.setText(struk.toString());
                
               // dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal tambah transaksi: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // Debugging output
        System.out.println("Data Transaksi: " + transaksi.toString());

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtJumlahBeliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahBeliKeyReleased
        // TODO add your handling code here:
        Double harga_barang = Double.parseDouble(txtHarga.getText());
        Double jumlah_beli = Double.parseDouble(txtJumlahBeli.getText());
        Double total_beli = harga_barang * jumlah_beli;
        txtTotalHarga.setText(String.valueOf(total_beli));
    }//GEN-LAST:event_txtJumlahBeliKeyReleased

    private void cb_KodePenumpangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_KodePenumpangMouseClicked
        Penumpang penumpang = new Penumpang();
        if (penumpang != null) {
            txtNamaPenumpang.setText(penumpang.getNama_penumpang());
            txtNoHP.setText(penumpang.getNo_hp());
            txtAlamat.setText(penumpang.getAlamat());
        } else {
            txtNamaPenumpang.setText("");
            txtNoHP.setText("");
            txtAlamat.setText("");
        }

        Tiket tiket = new Tiket();
        Kendaraan kendaraan = new Kendaraan();
        if (tiket != null) {
            txtJurusan.setText(tiket.getJurusan());
            txtNamaMobil.setText(kendaraan.getTipe_kendaraan());
            txtHarga.setText(String.valueOf(tiket.getHarga()));
        } else {
            txtJurusan.setText("");
            txtNamaMobil.setText("");
            txtHarga.setText("");
        }
    }//GEN-LAST:event_cb_KodePenumpangMouseClicked

    private void txtJumlahBeliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahBeliKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // cek inputan
            if(txtJumlahBeli.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Jumlah beli harus diisi");
            } else {
                txtUangPelanggan.requestFocus();
            }
        }
    }//GEN-LAST:event_txtJumlahBeliKeyPressed

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
            java.util.logging.Logger.getLogger(TambahTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TambahTransaksi dialog = new TambahTransaksi(new javax.swing.JFrame(), true);
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
    private com.toedter.calendar.JDateChooser DateTglBerangkat;
    private com.toedter.calendar.JDateChooser DateTglPesan;
    private javax.swing.JComboBox<String> cb_KodePenumpang;
    private javax.swing.JComboBox<String> cb_KodeTiket;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlahBeli;
    private javax.swing.JTextField txtJurusan;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtKursiStatus;
    private javax.swing.JTextField txtNamaMobil;
    private javax.swing.JTextField txtNamaPenumpang;
    private javax.swing.JTextField txtNoHP;
    private javax.swing.JTextArea txtStruk;
    private javax.swing.JTextField txtTotalHarga;
    private javax.swing.JTextField txtUangPelanggan;
    // End of variables declaration//GEN-END:variables

}
