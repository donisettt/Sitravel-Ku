package Model;

import com.stripbandunk.jwidget.annotation.TableColumn;

/**
 *
 * @author ASUS
 */
public class Kendaraan {
    @TableColumn (number = 1, name = "Id")
    private int id;
    @TableColumn (number = 2, name = "Supir Id")
    private int supir_id;
    @TableColumn (number = 3, name = "Nama Supir")
    private Supir supir;
    @TableColumn (number = 4, name = "Kode Kendaraan")
    private String kode_kendaraan;
    @TableColumn (number = 5, name = "Nomor Polisi")
    private String nomor_polisi;
    @TableColumn (number = 6, name = "Merk")
    private String merk;
    @TableColumn (number = 7, name = "Warna")
    private String warna;
    @TableColumn (number = 8, name = "Tipe Kendaraan")
    private String tipe_kendaraan;

    public Supir getSupir() {
        return supir;
    }

    public void setSupir(Supir supir) {
        this.supir = supir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupir_id() {
        return supir_id;
    }

    public void setSupir_id(int supir_id) {
        this.supir_id = supir_id;
    }

    public String getKode_kendaraan() {
        return kode_kendaraan;
    }

    public void setKode_kendaraan(String kode_kendaraan) {
        this.kode_kendaraan = kode_kendaraan;
    }

    public String getNomor_polisi() {
        return nomor_polisi;
    }

    public void setNomor_polisi(String nomor_polisi) {
        this.nomor_polisi = nomor_polisi;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getTipe_kendaraan() {
        return tipe_kendaraan;
    }

    public void setTipe_kendaraan(String tipe_kendaraan) {
        this.tipe_kendaraan = tipe_kendaraan;
    }
    
    @Override
    public String toString() {
        return tipe_kendaraan;
    }
}
