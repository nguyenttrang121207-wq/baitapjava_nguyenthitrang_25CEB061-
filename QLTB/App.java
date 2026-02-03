package QLTB;
import javax.swing.UIManager;

public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainView view = new MainView();
        BanhDAO dao = new BanhDAO();
        BakeryController ctrl = new BakeryController(view, dao);
        view.setVisible(true);
    }
}