package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Supir;

/**
 *
 * @author ASUS
 */
public class SupirController {
    public Connection koneksi;
    
    public SupirController() {
        koneksi = Koneksi.getKoneksi();
    }
    
    // method tampil data supir
    public List<Supir> TampilData() {
        PreparedStatement prepare = null;
        ResultSet result = null;
        
        List<Supir> list = new ArrayList<>();
        
        try {
            String sql = "Select * from supir";
            prepare = koneksi.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()) {
                Supir supir = new Supir();
                supir.setId(result.getInt("id"));
                supir.setKode_supir(result.getString("kode_supir"));
                supir.setNama_supir(result.getString("nama_supir"));
                supir.setNo_hp(result.getString("no_hp"));
                supir.setAlamat(result.getString("alamat"));
                list.add(supir);
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
    
    // method tambah supir
    public void Tambah_Supir(Supir supir) {
        PreparedStatement prepare = null;
        
        try {
            String sql = "INSERT INTO supir (id, kode_supir, nama_supir, no_hp, alamat)" + " VALUES (null, ?, ?, ?, ?)";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, supir.getKode_supir());
            prepare.setString(2, supir.getNama_supir());
            prepare.setString(3, supir.getNo_hp());
            prepare.setString(4, supir.getAlamat());
            prepare.executeUpdate();
            System.out.println("Berhasil menambah supir");
        } catch(SQLException ex) {
            System.out.println("Gagal menambah supir");
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
    
    // method update supir
    public void Update_Supir(Supir supir) {
        PreparedStatement prepare = null;
        
        try {
            String sql = "UPDATE supir set kode_supir = ?, nama_supir = ?, no_hp = ?, alamat = ? where id = ?";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, supir.getKode_supir());
            prepare.setString(2, supir.getNama_supir());
            prepare.setString(3, supir.getNo_hp());
            prepare.setString(4, supir.getAlamat());
            prepare.setInt(5, supir.getId());
            
            prepare.executeUpdate();
            System.out.println("Berhasil mengubah supir");
        } catch(SQLException ex) {
            System.out.println("Gagal mengubah supir");
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
    
    // function untuk menghapus data supir
    public void Delete_Supir(int id) {
        PreparedStatement prepare = null;
        
        try {
            String sql = "DELETE FROM supir WHERE id = ?";
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
