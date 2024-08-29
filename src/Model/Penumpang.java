package Model;

import com.stripbandunk.jwidget.annotation.TableColumn;

/**
 *
 * @author ASUS
 */
public class Penumpang {
    @TableColumn (number = 1, name = "Id")
    private int id;
    @TableColumn (number = 2, name = "Kode Penumpang")
    private String kode_customer;
    @TableColumn (number = 3, name = "Nama Penumpang")
    private String nama_penumpang;
    @TableColumn (number = 4, name = "Jenis Kelamin")
    private String jenis_kelamin;
    @TableColumn (number = 5, name = "No HP")
    private String no_hp;
    @TableColumn (number = 6, name = "Alamat")
    private String alamat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKode_customer() {
        return kode_customer;
    }

    public void setKode_customer(String kode_customer) {
        this.kode_customer = kode_customer;
    }

    public String getNama_penumpang() {
        return nama_penumpang;
    }

    public void setNama_penumpang(String nama_penumpang) {
        this.nama_penumpang = nama_penumpang;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
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
    
    // Override metode toString
    @Override
    public String toString() {
        return nama_penumpang;
    }
}
