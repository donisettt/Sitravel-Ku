import java.util.List;
import Model.Transaksi;
import Controller.TransaksiController;

/**
 *
 * @author ASUS
 */
public class Cek_View_Transaksi {
    public static void main(String[] args) {
        TransaksiController controller = new TransaksiController();
        List<Transaksi> list = controller.TampilData();
        
        for(Transaksi transaksi : list) {
            System.out.println(transaksi.getKode_customer());
            System.out.println(transaksi.getPenumpang());
            System.out.println(transaksi.getKode_tiket());
            System.out.println(transaksi.getTiket());
            System.out.println(transaksi.getTanggal_pesan());
            System.out.println(transaksi.getTanggal_berangkat());
            System.out.println(transaksi.getJml_beli());
            System.out.println(transaksi.getTotal_harga());
            System.out.println("========================");
        }
    }
}
