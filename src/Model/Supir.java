package Model;

import com.stripbandunk.jwidget.annotation.TableColumn;

/**
 *
 * @author ASUS
 */
public class Supir {
    @TableColumn (number = 1, name = "Id")
    private int id;
    @TableColumn (number = 2, name = "Kode Supir")
    private String kode_supir;
    @TableColumn (number = 3, name = "Nama Supir")
    private String nama_supir;
    @TableColumn (number = 4, name = "No HP")
    private String no_hp;
    @TableColumn (number = 5, name = "Jurusan")
    private String alamat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKode_supir() {
        return kode_supir;
    }

    public void setKode_supir(String kode_supir) {
        this.kode_supir = kode_supir;
    }

    public String getNama_supir() {
        return nama_supir;
    }

    public void setNama_supir(String nama_supir) {
        this.nama_supir = nama_supir;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    @Override
    public String toString() {
        return nama_supir;
    }
}
