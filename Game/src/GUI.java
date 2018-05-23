import javax.swing.*;

public class GUI extends JFrame {

    public GUI(){
        initUI();
    }

    private void initUI() {
        add(new _2D_Game_GUI_example());

        setSize(800, 600);

        setTitle("Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
