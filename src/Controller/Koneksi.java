package Controller;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection koneksi;
    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                Driver driver = new Driver();
                DriverManager.registerDriver(driver);
                String url = "jdbc:mysql://localhost:3306/sitravelku_fiks";
                String user = "root";
                String pass = "";
                
                koneksi = DriverManager.getConnection(url, user, pass);
                System.out.println("Koneksi Sukses");
            } catch (SQLException e) {
                System.out.println("Koneksi Gagal " + e);
            }
        }
        return koneksi;
    }
}
