package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Tiket;
import Model.Kendaraan;

/**
 *
 * @author ASUS
 */
public class TiketController {
    public Connection koneksi;
    
    public TiketController() {
        koneksi = Koneksi.getKoneksi();
    }
    
    // function tampil data
    public List<Tiket> TampilData() {
        PreparedStatement prepare = null;
        ResultSet result = null;
        
        List<Tiket> list = new ArrayList<>();
        
        try {
            String sql = "Select t.id, t.kode_tiket, k.tipe_kendaraan, t.jurusan, t.harga, t.stok_kursi "
                    + "FROM tiket t "
                    + "JOIN kendaraan k ON t.kendaraan_id = k.id";
            prepare = koneksi.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()) {
//                System.out.println("kode_tiket: " + result.getString("kode_tiket"));
//                System.out.println("harga: " + result.getInt("harga"));
//                System.out.println("nama_jurusan: " + result.getString("nama_jurusan"));
//                System.out.println("nama_transportasi: " + result.getString("nama_transportasi"));
//                System.out.println("=================================");
                
                Tiket tiket = new Tiket();
                tiket.setId(result.getInt("id"));
                tiket.setKode_tiket(result.getString("kode_tiket"));
                tiket.setHarga(result.getInt("harga"));
                tiket.setJurusan(result.getString("jurusan"));
                tiket.setStok_kursi(result.getInt("stok_kursi"));
            
                Kendaraan kendaraan = new Kendaraan();
                kendaraan.setTipe_kendaraan(result.getString("tipe_kendaraan"));
                tiket.setKendaraan(kendaraan); 
                list.add(tiket);
            }
            return list;
        } catch(SQLException e) {
            System.out.println("Kesalahan : " + e);
            return list;
        } finally {
            if (prepare != null) {
                try {
                    prepare.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }
    
    // method untuk tambah tiket
    public void Insert_Tiket(Tiket tiket) {
        PreparedStatement prepare =  null;
        
        try {
            String sql = "INSERT INTO tiket (id, kendaraan_id, kode_tiket, harga, jurusan, stok_kursi)" + "VALUES (null, ?, ?, ?, ?, ?)";
            prepare = koneksi.prepareStatement(sql);
            
            // Debug insert
            System.out.println("Kendaraan ID: " + tiket.getKendaraan_id());
            System.out.println("Kode Tiket: " + tiket.getKode_tiket());
            System.out.println("Harga: " + tiket.getHarga());
            System.out.println("======================");
            
            prepare.setInt(1, tiket.getKendaraan_id());
            prepare.setString(2, tiket.getKode_tiket());
            prepare.setInt(3, tiket.getHarga());
            prepare.setString(4, tiket.getJurusan());
            prepare.setInt(5, tiket.getStok_kursi());
            prepare.executeUpdate();
            System.out.println("Berhasil Menambahkan Tiket");
        } catch(SQLException ex) {
            System.out.println("Gagal Menambahkan Tiket");
            System.out.println("Kesalahan : " + ex);
        } finally {
            if(prepare != null) {
                try {
                    prepare.close();
                } catch(SQLException ex) {
                
                }
            }
        }
    }
    
    // function untuk edit user
    public void Update_Tiket(Tiket tiket) {
        PreparedStatement prepare = null;
        
        try {
            String sql = "UPDATE tiket set kendaraan_id = ?, kode_tiket = ?, harga = ?, jurusan = ?, stok_kursi = ? where id = ?";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setInt(1, tiket.getKendaraan_id());
            prepare.setString(2, tiket.getKode_tiket());
            prepare.setInt(3, tiket.getHarga());
            prepare.setString(4, tiket.getJurusan());
            prepare.setInt(5, tiket.getStok_kursi());
            prepare.setInt(6, tiket.getId());
            prepare.executeUpdate();
            System.out.println("Berhasil Update Tiket");
        } catch(SQLException ex) {
            System.out.println("Gagal Update Tiket");
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
    
    // function untuk menghapus data user
    public void Delete_Tiket(int id) {
        PreparedStatement prepare = null;
        
        try {
            String sql = "DELETE FROM tiket WHERE id = ?";
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
