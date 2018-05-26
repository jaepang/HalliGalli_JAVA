import javax.swing.*;
import java.awt.*;

// __2D_Game_GUI_example is a panel where the game takes place.
public class _2D_Game_GUI_example extends JPanel {
    public _2D_Game_GUI_example(){
        JPanel jpan = new JPanel(new BorderLayout());
        jpan.setSize(800,600);
        JButton button1 = new JButton("ANG?");
        JButton button2 = new JButton("ANG??");
        JButton button3 = new JButton("ANG???");
        jpan.add(button1,BorderLayout.NORTH);
        jpan.add(button2,BorderLayout.CENTER);
        jpan.add(button3,BorderLayout.WEST);
        super.add(jpan);
    }

}
