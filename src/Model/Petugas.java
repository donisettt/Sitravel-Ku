package Model;

import com.stripbandunk.jwidget.annotation.TableColumn;

public class Petugas {
    @TableColumn (number = 1, name = "Id")
    private int id;
    @TableColumn (number = 2, name = "Username")
    private String username;
    @TableColumn (number = 3, name = "Password")
    private String password;
    @TableColumn (number = 4, name = "Nama Petugas")
    private String nama_petugas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama_petugas() {
        return nama_petugas;
    }

    public void setNama_petugas(String nama_petugas) {
        this.nama_petugas = nama_petugas;
    }
}
