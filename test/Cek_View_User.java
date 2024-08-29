
import java.util.List;
import Model.Petugas;
import Controller.PetugasController;

public class Cek_View_User {
    public static void main(String[] args) {
        PetugasController controller = new PetugasController();
        List<Petugas> list = controller.TampilData();
        
        for (Petugas user : list) {
            System.out.println(user.getId());
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            System.out.println(user.getNama_petugas());
            System.out.println("======================");
        }
    }
}
