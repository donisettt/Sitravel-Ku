import java.util.List;
import Controller.PenumpangController;
import Model.Penumpang;

/**
 *
 * @author ASUS
 */
public class Cek_View_Penumpang {
    public static void main(String[] args) {
        PenumpangController controller = new PenumpangController();
        List<Penumpang> list = controller.TampilData();
        
        for(Penumpang penumpang : list) {
            System.out.println(penumpang.getId());
            System.out.println(penumpang.getNama_penumpang());
            System.out.println(penumpang.getJenis_kelamin());
            System.out.println(penumpang.getNo_hp());
            System.out.println(penumpang.getAlamat());
            System.out.println("===========================");
        }
    }
}
