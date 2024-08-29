package Model;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Transaksi {
    private int id;
    @TableColumn (number = 1, name = "Tanggal Pesan")
    private Date tanggal_pesan;
    @TableColumn (number = 2, name = "Tanggal Berangkat")
    private Date tanggal_berangkat;
    @TableColumn (number = 3, name = "Kode Penumpang")
    private String kode_customer;
    @TableColumn (number = 4, name = "Nama Penumpang")
    private Penumpang penumpang;
    @TableColumn (number = 5, name = "Kode Tiket")
    private String kode_tiket;
    @TableColumn (number = 6, name = "Jumlah Beli")
    private int jml_beli;
    @TableColumn (number = 7, name = "Total Harga")
    private int total_harga;  
    private Tiket tiket; 

    public Tiket getTiket() {
        return tiket;
    }

    public void setTiket(Tiket tiket) {
        this.tiket = tiket;
    }
    
    public int getJml_beli() {
        return jml_beli;
    }

    public void setJml_beli(int jml_beli) {
        this.jml_beli = jml_beli;
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }

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

    public String getKode_tiket() {
        return kode_tiket;
    }

    public void setKode_tiket(String kode_tiket) {
        this.kode_tiket = kode_tiket;
    }

    public Penumpang getPenumpang() {
        return penumpang;
    }

    public void setPenumpang(Penumpang penumpang) {
        this.penumpang = penumpang;
    }

    public Date getTanggal_pesan() {
        return tanggal_pesan;
    }

    public void setTanggal_pesan(Date tanggal_pesan) {
        this.tanggal_pesan = tanggal_pesan;
    }

    public Date getTanggal_berangkat() {
        return tanggal_berangkat;
    }

    public void setTanggal_berangkat(Date tanggal_berangkat) {
        this.tanggal_berangkat = tanggal_berangkat;
    }
    
}
