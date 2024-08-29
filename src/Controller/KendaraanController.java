package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Kendaraan;
import Model.Supir;

/**
 *
 * @author ASUS
 */
public class KendaraanController {
    public Connection koneksi;
    
    public KendaraanController() {
        koneksi = Koneksi.getKoneksi();
    }
    
    // method tampil data kendaraan
    public List<Kendaraan> TampilData() {
        PreparedStatement prepare = null;
        ResultSet result = null;
        
        List<Kendaraan> list = new ArrayList<>();
        
        try {
            String sql = "SELECT k.id, k.supir_id, s.nama_supir, k.kode_kendaraan, k.nomor_polisi, k.merk, k.warna, k.tipe_kendaraan "
           + "FROM kendaraan k "
           + "JOIN supir s ON k.supir_id = s.id";
        prepare = koneksi.prepareStatement(sql);
        result = prepare.executeQuery();

            
            while(result.next()) {
                Kendaraan kendaraan = new Kendaraan();
                kendaraan.setId(result.getInt("id"));
                kendaraan.setSupir_id(result.getInt("supir_id"));
                
                Supir supir = new Supir();
                supir.setNama_supir(result.getString("nama_supir"));
                kendaraan.setSupir(supir);
                        
                
                kendaraan.setKode_kendaraan(result.getString("kode_kendaraan"));
                kendaraan.setNomor_polisi(result.getString("nomor_polisi"));
                kendaraan.setMerk(result.getString("merk"));
                kendaraan.setWarna(result.getString("warna"));
                kendaraan.setTipe_kendaraan(result.getString("tipe_kendaraan"));
                list.add(kendaraan);
            }
            return list;
        } catch(SQLException ex) {
            System.out.println("Kesalahan : " + ex);
            return list;
        } finally {
            if(prepare != null) {
                try {
                    prepare.close();
                } catch(SQLException ex) {
                    System.out.println("Kesalahan : " + ex);
                }
            }
            if(result != null) {
                try {
                    result.close();
                } catch(SQLException ex) {
                    System.out.println("Kesalahan : " + ex);
                }
            }
        }
    }
    
    // method tambah kendaraan
    public void Tambah_Kendaraan(Kendaraan kendaraan) {
        PreparedStatement prepare = null;

        try {
            String sql = "INSERT INTO kendaraan (supir_id, kode_kendaraan, nomor_polisi, merk, warna, tipe_kendaraan) "
                       + "VALUES (?, ?, ?, ?, ?, ?)";
            prepare = koneksi.prepareStatement(sql);

            prepare.setInt(1, kendaraan.getSupir_id());
            prepare.setString(2, kendaraan.getKode_kendaraan());
            prepare.setString(3, kendaraan.getNomor_polisi());
            prepare.setString(4, kendaraan.getMerk());
            prepare.setString(5, kendaraan.getWarna());
            prepare.setString(6, kendaraan.getTipe_kendaraan());

            System.out.println("SQL: " + prepare.toString());  // Print SQL statement for debugging

            prepare.executeUpdate();
            System.out.println("Berhasil Menambahkan Kendaraan");
        } catch(SQLException ex) {
            System.out.println("Gagal Menambah Kendaraan");
            System.out.println("Kesalahan : " + ex);
        } finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch(SQLException ex) {
                    System.out.println("Ada kesalahan saat menutup PreparedStatement: " + ex);
                }
            }
        }
    }
    
    public boolean isSupirExist(int supir_id) {
        String sql = "SELECT COUNT(*) FROM supir WHERE id = ?";
        try (PreparedStatement prepare = koneksi.prepareStatement(sql)) {
            prepare.setInt(1, supir_id);
            try (ResultSet rs = prepare.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Kesalahan saat memeriksa Supir ID: " + ex);
        }
        return false;
    }

    
    // method update kendaraan
    public void Update_Kendaran(Kendaraan kendaran) {
        PreparedStatement prepare = null;

        try {
            if (!isSupirExist(kendaran.getSupir_id())) {
                System.out.println("Gagal Update Kendaraan: Supir ID tidak ditemukan");
                return;
            }

            String sql = "UPDATE kendaraan SET supir_id = ?, kode_kendaraan = ?, nomor_polisi = ?, merk = ?, warna = ?, tipe_kendaraan = ? WHERE id = ?";
            prepare = koneksi.prepareStatement(sql);

            prepare.setInt(1, kendaran.getSupir_id());
            prepare.setString(2, kendaran.getKode_kendaraan());
            prepare.setString(3, kendaran.getNomor_polisi());
            prepare.setString(4, kendaran.getMerk());
            prepare.setString(5, kendaran.getWarna());
            prepare.setString(6, kendaran.getTipe_kendaraan());
            prepare.setInt(7, kendaran.getId());

            prepare.executeUpdate();
            System.out.println("Berhasil Update Kendaraan");
        } catch (SQLException ex) {
            System.out.println("Gagal Update Kendaraan");
            System.out.println("Kesalahan : " + ex);
        } finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (SQLException ex) {
                    System.out.println("Ada kesalahan saat menutup PreparedStatement: " + ex);
                }
            }
        }
    }

    
    // function untuk menghapus data kendaraan
    public void Delete_Kendaraan(int id) {
        PreparedStatement prepare = null;
        
        try {
            String sql = "DELETE FROM kendaraan WHERE id = ?";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setInt(1, id);
            prepare.executeUpdate();
            System.out.println("Berhasil Delete Tiket");
        } catch(SQLException ex) {
            System.out.println("Gagal Menghapus Tiket");
            System.out.println("Kesalahan : " + ex);
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
