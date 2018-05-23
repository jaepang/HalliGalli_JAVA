/*
    Studying with: "http://zetcode.com/tutorials/javagamestutorial/basics/"
*/
import javax.swing.*;

public class GUI extends JFrame {

    public GUI(){
        initUI();
    }

    private void initUI() {
        add(new _2D_Game_GUI_example());

        setSize(800, 600);

        setTitle("Donut");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
