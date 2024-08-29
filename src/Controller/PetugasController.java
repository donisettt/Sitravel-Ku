package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Petugas;

public class PetugasController {
    public Connection koneksi;
    
    public PetugasController() {
        koneksi = Koneksi.getKoneksi();
    }
    
    // function untuk menampilkan data
    public List<Petugas> TampilData() {
        PreparedStatement prepare = null;
        ResultSet result = null;
        
        List<Petugas> list = new ArrayList<>();
        
        try {
            String Sql = "Select * from petugas";
            prepare = koneksi.prepareStatement(Sql);
            result = prepare.executeQuery();
            
            while(result.next()) {
                Petugas petugas = new Petugas();
                petugas.setId(result.getInt("id"));
                petugas.setUsername(result.getString("username"));
                petugas.setPassword(result.getString("password"));
                petugas.setNama_petugas(result.getString("nama_petugas"));
                list.add(petugas);
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
    
    // function insert petugas
    public void Insert_Petugas(Petugas petugas) {
        PreparedStatement prepare = null;
        
        try {
            String sql = "INSERT INTO petugas (id, username, password, nama_petugas)" + "VALUES (null, ?, md5(?), ?)";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, petugas.getUsername());
            prepare.setString(2, petugas.getPassword());
            prepare.setString(3, petugas.getNama_petugas());
            prepare.executeUpdate();
            System.out.println("Berhasil Insert Data");
        } catch(SQLException e) {
            System.out.println("Gagal Menambahkan Data!");
            System.out.println("Kesalahan : " + e);
        } finally {
            if (prepare != null) {
                try{
                    prepare.close();
                } catch (SQLException e) {
                    System.out.println("Ada Kesalahan : " + e);
                }
            }
        }
    }
    
    // function untuk edit petugas
    public void Update_Petugas(Petugas petugas) {
        PreparedStatement prepare = null;
        
        try {
            String sql = "UPDATE petugas set username = ?, password = md5(?), nama_petugas = ? where id = ?";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, petugas.getUsername());
            prepare.setString(2, petugas.getPassword());
            prepare.setString(3, petugas.getNama_petugas());
            prepare.setInt(4, petugas.getId());
            prepare.executeUpdate();
            System.out.println("Berhasil Update Petugas");
        } catch(SQLException ex) {
            System.out.println("Gagal Update Petugas");
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
    
    // function untuk menghapus data petugas
    public void Delete_Petugas(int id) {
        PreparedStatement prepare = null;
        
        try {
            String sql = "DELETE FROM petugas WHERE id = ?";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setInt(1, id);
            prepare.executeUpdate();
            System.out.println("Berhasil Delete Petugas");
        } catch(SQLException ex) {
            System.out.println("Gagal Menghapus Petugas");
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
