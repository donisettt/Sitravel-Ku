package Model;

import com.stripbandunk.jwidget.annotation.TableColumn;

/**
 *
 * @author ASUS
 */
public class Transportasi {
    @TableColumn (number = 1, name = "Id")
    private int id;
    @TableColumn (number = 2, name = "Nama Transportasi")
    private String nama_transportasi;
    @TableColumn (number = 3, name = "Jenis Transportasi")
    private String jenis_transportasi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_transportasi() {
        return nama_transportasi;
    }

    public void setNama_transportasi(String nama_transportasi) {
        this.nama_transportasi = nama_transportasi;
    }

    public String getJenis_transportasi() {
        return jenis_transportasi;
    }

    public void setJenis_transportasi(String jenis_transportasi) {
        this.jenis_transportasi = jenis_transportasi;
    }
    
    // Override metode toString
    @Override
    public String toString() {
        return nama_transportasi;
    }
}
