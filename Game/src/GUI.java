/*
    Studying with: "http://zetcode.com/tutorials/javagamestutorial/basics/"
*/
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI(){
        initUI();
    }

    private void initUI() {
        this.add(new _2D_Game_GUI_example());
        int width = 800, height = 600;

        setSize(width,height);

        setTitle("Halli-Galli");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
