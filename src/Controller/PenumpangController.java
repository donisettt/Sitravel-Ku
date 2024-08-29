package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Penumpang;

/**
 *
 * @author ASUS
 */
public class PenumpangController {
    public Connection koneksi;
    
    public PenumpangController() {
        koneksi = Koneksi.getKoneksi();
    }
    
    // function untuk tampil data
    public List<Penumpang> TampilData() {
        PreparedStatement prepare = null;
        ResultSet result = null;
        
        List<Penumpang> list = new ArrayList<>();
        
        try {
            String Sql = "Select * from penumpang";
            prepare = koneksi.prepareStatement(Sql);
            result = prepare.executeQuery();
            
            while(result.next()) {
                Penumpang penumpang = new Penumpang();
                penumpang.setId(result.getInt("id"));
                penumpang.setKode_customer(result.getString("kode_customer"));
                penumpang.setNama_penumpang(result.getString("nama_penumpang"));
                penumpang.setJenis_kelamin(result.getString("jenis_kelamin"));
                penumpang.setNo_hp(result.getString("no_hp"));
                penumpang.setAlamat(result.getString("alamat"));
                list.add(penumpang);
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
    
    // method untuk tambah penumpang
    public void Tambah_Penumpang(Penumpang penumpang) {
        PreparedStatement prepare = null;
        ResultSet result = null;
        
        try {
            String sql = "INSERT INTO penumpang (id, kode_customer, nama_penumpang, jenis_kelamin, no_hp, alamat)" + "VALUES (null, ?, ?, ?, ?, ?)";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, penumpang.getKode_customer());
            prepare.setString(2, penumpang.getNama_penumpang());
            prepare.setString(3, penumpang.getJenis_kelamin());
            prepare.setString(4, penumpang.getNo_hp());
            prepare.setString(5, penumpang.getAlamat());
            prepare.executeUpdate();
            System.out.println("Berhasil Menambahkan Penumpang");
        } catch(SQLException ex) {
            System.out.println("Gagal Menambahkan Penumpang");
            System.out.println("Kesalahan : " + ex);
        } finally {
            if(prepare != null) {
                try {
                    prepare.close();
                } catch(SQLException ex) {
                    System.out.println("Ada kesalahan : " + ex);
                }
            }
        }
    }
    
    // method update penumpang
    public void Update_Penumpang(Penumpang penumpang) {
        PreparedStatement prepare = null;
        
        try {
            String sql = "UPDATE penumpang set kode_customer = ?, nama_penumpang = ?, jenis_kelamin = ?, no_hp = ?, alamat = ? where id = ?";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, penumpang.getKode_customer());
            prepare.setString(2, penumpang.getNama_penumpang());
            prepare.setString(3, penumpang.getJenis_kelamin());
            prepare.setString(4, penumpang.getNo_hp());
            prepare.setString(5, penumpang.getAlamat());
            prepare.setInt(6, penumpang.getId());
            prepare.executeUpdate();
            System.out.println("Berhasil Update Penumpang");
        } catch(SQLException ex) {
            System.out.println("Gagal Update Penumpang");
            System.out.println("Kesalahan : " + ex);
        } finally {
            if(prepare != null) {
                try {
                    prepare.close();
                } catch(SQLException ex) {
                    System.out.println("Ada kesalahan : " + ex);
                }
            }
        }
    }
    
    // method hapus penumpang
    public void Delete_Penumpang(int id) {
        PreparedStatement prepare = null;
        
        try {
            String sql = "DELETE FROM penumpang WHERE id = ?";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setInt(1, id);
            prepare.executeUpdate();
            System.out.println("Berhasil Menghapus Penumpang");
        } catch(SQLException ex) {
            System.out.println("Gagal Menghapus Penumpang");
            System.out.println("Kesalahan : " + ex);
        } finally {
            if(prepare != null) {
                try {
                    prepare.close();
                } catch(SQLException ex) {
                    System.out.println("Ada kesalahan : " + ex);
                }
            }
        }
    }
}
