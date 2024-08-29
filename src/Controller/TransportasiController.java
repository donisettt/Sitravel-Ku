package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Transportasi;

/**
 *
 * @author ASUS
 */
public class TransportasiController {
    public Connection koneksi;
    
    public TransportasiController() {
        koneksi = Koneksi.getKoneksi();
    }
    
    // method untuk tampil data
    public List<Transportasi> TampilData() {
        PreparedStatement prepare = null;
        ResultSet result = null;
        
        List<Transportasi> list = new ArrayList<>();
        
        try {
            String sql = "Select * from transportasi";
            prepare = koneksi.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()) {
                Transportasi transportasi = new Transportasi();
                transportasi.setId(result.getInt("id"));
                transportasi.setNama_transportasi(result.getString("nama_transportasi"));
                transportasi.setJenis_transportasi(result.getString("jenis_transportasi"));
                list.add(transportasi);
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
                    System.out.println("Ada Kesalahan : " + ex);
                }
            }
            if(result != null) {
                try {
                    result.close();
                } catch(SQLException ex) {
                    System.out.println("Ada Kesalahan : " + ex);
                }
            }
        }
    }
    
    // method tambah transportasi
    public void Insert_Transportasi(Transportasi transportasi) {
        PreparedStatement prepare = null;
        
        try {
            String sql = "INSERT INTO transportasi (id, nama_transportasi, jenis_transportasi)" + "VALUES (null, ?, ?)";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, transportasi.getNama_transportasi());
            prepare.setString(2, transportasi.getJenis_transportasi());
            prepare.executeUpdate();
            System.out.println("Berhasil Tambah Transportasi");
        } catch(SQLException ex) {
            System.out.println("Gagal Tambah Transportasi");
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
    
    // method update transportasi
    public void Update_Transportasi(Transportasi transportasi) {
        PreparedStatement prepare = null;
        
        try {
            String sql = "UPDATE transportasi set nama_transportasi = ?, jenis_transportasi = ? where id = ?";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, transportasi.getNama_transportasi());
            prepare.setString(2, transportasi.getJenis_transportasi());
            prepare.setInt(3, transportasi.getId());
            prepare.executeUpdate();
            System.out.println("Berhasil Update Transportasi");
        } catch(SQLException ex) {
            System.out.println("Gagal Update Transportasi");
            System.out.println("Kesalahan : " + ex);
        } finally {
            if(prepare  != null) {
                try {
                    prepare.close();
                } catch(SQLException ex) {
                    System.out.println("Ada kesalahan : " + ex);
                }
            }
        }
    }
    
    // hapus data transportasi
    public void Hapus_Transportasi(int id) {
        PreparedStatement prepare = null;
        
        try {
            String sql = "DELETE FROM transportasi where id = ?";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setInt(1, id);
            prepare.executeUpdate();
            System.out.println("Berhasil Hapus Transportasi");
        } catch(SQLException ex) {
            System.out.println("Gagal Hapus Transportasi");
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
