// tidak dipakai untuk method login

package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Login;

/**
 *
 * @author ASUS
 */
public class LoginController {
    private Connection koneksi;
    
    public Login ceklogin(String username, String password) {
        koneksi = Koneksi.getKoneksi();
        PreparedStatement prepare = null;
        ResultSet result = null;
        Login login = null;
        
        try {
            String sql = "Select * from login where username = ? and password = md5(?)";
            prepare = koneksi.prepareStatement(sql);
            
            prepare.setString(1, username);
            prepare.setString(2, password);
            result = prepare.executeQuery();
            
            if(result.next()) {
                login = new Login();
                login.setId_user(result.getInt("id_user"));
                login.setUsername(result.getString("username"));
                login.setPassword(result.getString("password"));
                login.setNama(result.getString("nama"));
                login.setNo_hp(result.getString("no_hp"));
            }
            return login;
        } catch(SQLException ex) {
            System.out.println("Ada yang salah dengan query " + ex);
            return login;
        } finally {
            if(prepare != null) {
                try {
                    prepare.close();
                } catch(SQLException ex) {
                }
            }
            if(prepare != null) {
                try {
                    prepare.close();
                } catch(SQLException ex) {
                }
            }
        }
    }
}
