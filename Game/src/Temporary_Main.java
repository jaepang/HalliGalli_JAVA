import java.awt.*;

public class Temporary_Main {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI ex = new GUI();
            ex.setVisible(true);
        });
    }
}
