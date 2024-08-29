import java.util.List;
import Model.Tiket;
import Controller.TiketController;

/**
 *
 * @author ASUS
 */
public class Cek_View_Tiket {
    public static void main(String[] args) {
        TiketController controller = new TiketController();
        List<Tiket> list = controller.TampilData();
        
        for(Tiket tiket : list) {
            System.out.println(tiket.getId());
            System.out.println(tiket.getKode_tiket());
            System.out.println(tiket.getHarga());
            System.out.println(tiket.getJurusan());
            System.out.println(tiket.getStok_kursi());
            System.out.println("=======================");
        }
    }
}
