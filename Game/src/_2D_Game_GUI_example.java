import javax.swing.*;
import java.awt.*;

// __2D_Game_GUI_example is a panel where the game takes place.
public class _2D_Game_GUI_example extends JPanel {
    public _2D_Game_GUI_example(){
        JPanel jpan = new JPanel();
        JButton button = new JButton("ANG?");
        jpan.add(button);
        super.add(jpan);
    }

}
