import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private JLayeredPane panel = new JLayeredPane();
	public MainFrame() {
		int width, height;
		width = 800;
		height = 600;
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Halli-Galli");

		/*Create "Bell" bell Instance*/
		Bell bell = new Bell();
        panel.add(bell, new Integer(0), 0);

		/*Card Class Test*/
        Card test = new Card(); bell.add(test);
        panel.add(test, new Integer(1), 0);

        /*Card Class Test2: Testing image*/
        Card test2 = new Card("Banana",1);
        panel.add(test2, new Integer(2), 0);

        //this.pack();
        /*Add bell to Frame*/
        this.add(panel);
        this.setVisible(true);
	} 
	
	public static void main(String args[]){
		MainFrame mainFrame = new MainFrame();
	}
}

