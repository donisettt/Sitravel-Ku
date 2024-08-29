package Model;

/**
 *
 * @author ASUS
 */
public class DetailTransaksi {
    private int id;
    private int transaksi_id;
    private int tiket_id;
    private int jumlah_pesan;
    private int total_harga;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransaksi_id() {
        return transaksi_id;
    }

    public void setTransaksi_id(int transaksi_id) {
        this.transaksi_id = transaksi_id;
    }

    public int getTiket_id() {
        return tiket_id;
    }

    public void setTiket_id(int tiket_id) {
        this.tiket_id = tiket_id;
    }

    public int getJumlah_pesan() {
        return jumlah_pesan;
    }

    public void setJumlah_pesan(int jumlah_pesan) {
        this.jumlah_pesan = jumlah_pesan;
    }

    public int getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(int total_harga) {
        this.total_harga = total_harga;
    }
}
