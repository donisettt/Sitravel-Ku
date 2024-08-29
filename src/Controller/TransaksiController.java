package Controller;

import Model.Kendaraan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Transaksi;
import Model.Penumpang;
import Model.Tiket;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class TransaksiController {
    public Connection koneksi;
    
    public TransaksiController() {
        koneksi = Koneksi.getKoneksi();
    }
    
    // mengambil data penumpang dari database
    public List<String> getDataPenumpang() {
        List<String> penumpangList = new ArrayList<>();
        try {
            String sql = "SELECT kode_customer FROM penumpang";
            PreparedStatement prepare = koneksi.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();

            while (result.next()) {
                penumpangList.add(result.getString("kode_customer"));
            }
        } catch (SQLException ex) {
            System.out.println("Gagal mengambil data penumpang: " + ex);
        }
        return penumpangList;
    }

    public List<String> getDataTiket() {
        List<String> tiketList = new ArrayList<>();
        try {
            String sql = "SELECT kode_tiket FROM tiket";
            PreparedStatement prepare = koneksi.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();

            while (result.next()) {
                tiketList.add(result.getString("kode_tiket"));
            }
        } catch (SQLException ex) {
            System.out.println("Gagal mengambil data tiket: " + ex);
        }
        return tiketList;
    }
    
    public Penumpang getPenumpangData(String kodePenumpang) {
        Penumpang penumpang = null;
        try {
            String sql = "SELECT nama_penumpang, no_hp, alamat FROM penumpang WHERE kode_customer = ?";
            PreparedStatement prepare = koneksi.prepareStatement(sql);
            prepare.setString(1, kodePenumpang);
            ResultSet result = prepare.executeQuery();

            if (result.next()) {
                penumpang = new Penumpang();
                penumpang.setNama_penumpang(result.getString("nama_penumpang"));
                penumpang.setNo_hp(result.getString("no_hp"));
                penumpang.setAlamat(result.getString("alamat"));
            }
        } catch (SQLException ex) {
            System.out.println("Gagal mengambil data penumpang: " + ex);
        }
        return penumpang;
    }
    
    public class TiketWithKendaraan {
        private Tiket tiket;
        private Kendaraan kendaraan;

        // Getter dan Setter untuk tiket
        public Tiket getTiket() { return tiket; }
        public void setTiket(Tiket tiket) { this.tiket = tiket; }

        // Getter dan Setter untuk kendaraan
        public Kendaraan getKendaraan() { return kendaraan; }
        public void setKendaraan(Kendaraan kendaraan) { this.kendaraan = kendaraan; }
    }


    public TiketWithKendaraan getTiketData(String kodeTiket) {
        TiketWithKendaraan result = new TiketWithKendaraan();
        try {
            String sql = "SELECT t.harga, t.jurusan, t.stok_kursi, k.tipe_kendaraan "
                    + "FROM tiket t "
                    + "JOIN kendaraan k ON t.kendaraan_id = k.id WHERE kode_tiket = ?";
            PreparedStatement prepare = koneksi.prepareStatement(sql);
            prepare.setString(1, kodeTiket);
            ResultSet rs = prepare.executeQuery();

            if (rs.next()) {
                Tiket tiket = new Tiket();
                tiket.setJurusan(rs.getString("jurusan"));
                tiket.setHarga(rs.getInt("harga"));
                tiket.setStok_kursi(rs.getInt("stok_kursi"));

                Kendaraan kendaraan = new Kendaraan();
                kendaraan.setTipe_kendaraan(rs.getString("tipe_kendaraan"));

                result.setTiket(tiket);
                result.setKendaraan(kendaraan);
            }
        } catch (SQLException ex) {
            System.out.println("Gagal mengambil data tiket: " + ex);
        }
        return result;
    }

    
    // method tampil data
    public List<Transaksi> TampilData() {
        PreparedStatement prepare = null;
        ResultSet result = null;
        List<Transaksi> list = new ArrayList<>();

        try {
            if (koneksi == null) {
                System.out.println("Koneksi ke database gagal!");
                return list;
            }

            String sql = "SELECT tr.kode_customer, tr.kode_tiket, p.nama_penumpang, tr.tanggal_pesan, tr.tanggal_berangkat, tr.jml_beli, tr.total_harga "
                       + "FROM transaksi tr "
                       + "JOIN penumpang p ON tr.kode_customer = p.kode_customer";
            prepare = koneksi.prepareStatement(sql);
            result = prepare.executeQuery();

            while(result.next()) {
                // deklarasi untuk class transaksi
                Transaksi transaksi = new Transaksi();
                transaksi.setKode_customer(result.getString("kode_customer"));
                transaksi.setKode_tiket(result.getString("kode_tiket"));
                transaksi.setTanggal_pesan(result.getDate("tanggal_pesan"));
                transaksi.setTanggal_berangkat(result.getDate("tanggal_berangkat"));
                transaksi.setTotal_harga(result.getInt("total_harga"));
                transaksi.setJml_beli(result.getInt("jml_beli"));

                // deklarasi untuk class penumpang
                Penumpang penumpang = new Penumpang();
                penumpang.setNama_penumpang(result.getString("nama_penumpang"));
                transaksi.setPenumpang(penumpang); // jika perlu menyimpan penumpang di transaksi

                list.add(transaksi);
            }

            System.out.println("Jumlah data yang ditemukan: " + list.size());
            return list;
        } catch(SQLException ex) {
            System.out.println("Kesalahan : " + ex);
            return list;
        } finally {
            if(prepare != null) {
                try {
                    prepare.close();
                } catch(SQLException ex) {
                    System.out.println("Ada kesalahan : " + ex);
                }
            }
            if(result != null) {
                try {
                    result.close();
                } catch(SQLException ex) {
                    System.out.println("Ada kesalahan : " + ex);
                }
            }
        }
    }

    
    // method tambah transaksi
    public void InsertData(Transaksi transaksi) {
        PreparedStatement prepare = null;
        PreparedStatement stm1 = null;
        PreparedStatement stm2 = null;
        ResultSet res1 = null;

        try {
            // Insert transaksi
            String sql = "INSERT INTO transaksi (id, kode_customer, kode_tiket, tanggal_pesan, tanggal_berangkat, jml_beli, total_harga) "
                       + "VALUES (null, ?, ?, ?, ?, ?, ?)";
            prepare = koneksi.prepareStatement(sql);

            // Debug insert
            System.out.println("ID: " + transaksi.getId());
            System.out.println("Kode Customer: " + transaksi.getKode_customer());
            System.out.println("Kode Tiket: " + transaksi.getKode_tiket());
            System.out.println("Tanggal Pesan: " + transaksi.getTanggal_pesan());
            System.out.println("Tanggal Berangkat: " + transaksi.getTanggal_berangkat());
            System.out.println("Jumlah Beli: " + transaksi.getJml_beli());
            System.out.println("Total Harga: " + transaksi.getTotal_harga());
            System.out.println("======================");

            prepare.setString(1, transaksi.getKode_customer());
            prepare.setString(2, transaksi.getKode_tiket());
            prepare.setDate(3, new java.sql.Date(transaksi.getTanggal_pesan().getTime()));
            prepare.setDate(4, new java.sql.Date(transaksi.getTanggal_berangkat().getTime()));
            prepare.setInt(5, transaksi.getJml_beli());
            prepare.setDouble(6, transaksi.getTotal_harga());

            // Query untuk mengambil stok kursi dari tiket
            String sql1 = "SELECT stok_kursi FROM tiket WHERE kode_tiket = ?";
            stm1 = koneksi.prepareStatement(sql1);
            stm1.setString(1, transaksi.getKode_tiket());
            res1 = stm1.executeQuery();

            if (res1.next()) {
                int stok = res1.getInt("stok_kursi");
                int beli = transaksi.getJml_beli();
                int sisa = stok - beli;

                if (beli > stok) {
                    JOptionPane.showMessageDialog(null, "Pembelian melebihi stok");
                } else {
                    // Query untuk memperbarui stok kursi
                    String sql2 = "UPDATE tiket SET stok_kursi = ? WHERE kode_tiket = ?";
                    stm2 = koneksi.prepareStatement(sql2);
                    stm2.setInt(1, sisa);
                    stm2.setString(2, transaksi.getKode_tiket());

                    // Eksekusi query
                    prepare.executeUpdate();
                    stm2.executeUpdate();
                    System.out.println("Transaksi berhasil dibuat");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Tiket tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch(SQLException ex) {
            System.out.println("Gagal Membuat Transaksi");
            System.out.println("Kesalahan : " + ex);
        } finally {
            try {
                if (res1 != null) res1.close();
                if (stm1 != null) stm1.close();
                if (stm2 != null) stm2.close();
                if (prepare != null) prepare.close();
            } catch(SQLException ex) {
                System.out.println("Ada kesalahan saat menutup resources: " + ex);
            }
        }
    }

    
    // method hapus transaksi
    public void Delete_Transaksi(int id) {
        PreparedStatement prepare = null;
        
        try{
            String sql = "DELETE FROM transaksi WHERE id = ?";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setInt(1, id);
            prepare.executeUpdate();
            System.out.println("Berhasil Delete");
        } catch (SQLException ex) {
            System.out.println("Gagal Delete Dengan Error " + ex);
        } finally {
            if (prepare != null) {
                try{
                    prepare.close();
                } catch(SQLException ex) {
                    
                }
            } 
        }
    }
}
