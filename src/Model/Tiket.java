package Model;

import com.stripbandunk.jwidget.annotation.TableColumn;
/**
 *
 * @author ASUS
 */
public class Tiket {
    @TableColumn (number = 1, name = "Id")
    private int id;
    private int kendaraan_id;
    @TableColumn (number = 2, name = "Kode Tiket")
    private String kode_tiket;
    @TableColumn (number = 3, name = "Tipe Mobil")
    private Kendaraan kendaraan;
    @TableColumn (number = 4, name = "Jurusan")
    private String jurusan;
    @TableColumn (number = 5, name = "Harga")
    private int harga;
    @TableColumn (number = 6, name = "Stok Kursi")
    private int stok_kursi;

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public int getStok_kursi() {
        return stok_kursi;
    }

    public void setStok_kursi(int stok_kursi) {
        this.stok_kursi = stok_kursi;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKendaraan_id() {
        return kendaraan_id;
    }

    public void setKendaraan_id(int kendaraan_id) {
        this.kendaraan_id = kendaraan_id;
    }

    public String getKode_tiket() {
        return kode_tiket;
    }

    public void setKode_tiket(String kode_tiket) {
        this.kode_tiket = kode_tiket;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
