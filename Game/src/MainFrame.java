import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private JLayeredPane panel = new JLayeredPane();
	public MainFrame() {
		int width, height;
		width = 800;
		height = 600;
		this.setPreferredSize(new Dimension(width, height));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Halli-Galli");

        /*Add panel to Frame*/
        this.add(panel, BorderLayout.CENTER);

        /* Set Boundary */
        panel.setBounds(0, 0, 800, 600);

		/*Create "Bell" bell Instance*/
		Bell bell = new Bell();
        bell.setOpaque(true);
        bell.setBounds(0, 0, 800, 600);

		/*Card Class Test*/
        Card test = new Card();
        test.setOpaque(true);
        test.setBounds(0, 0, 100, 100);

        /*Card Class Test2: Testing image*/
        Card test2 = new Card("Banana",1);
        test2.setOpaque(true);
        test2.setBounds(100, 100, 100, 100);

        panel.add(bell, new Integer(0));
        panel.add(test, new Integer(1));
        panel.add(test2, new Integer(1));
        this.pack();
        this.setVisible(true);
	} 
	
	public static void main(String args[]){
		new MainFrame();
	}
}

