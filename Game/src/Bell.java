import java.awt.*;
import javax.swing.*;

public class Bell extends JPanel{
    JLabel label = new JLabel();
	Bell(){
		super();
		// Set Layout: null; BorderLayout has problem, when add one label, it contain all whitespace
        this.setLayout(null);

		// Background: Pink
		this.setBackground(Color.PINK);
		// Load Bell image.
	    ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/Bell.jpg"));

	    /*
	        ------ Start Resizing imageIcon ------
	     */

	    Image orgImg = icon.getImage();
	    Image scaledImg = orgImg.getScaledInstance(100,100,Image.SCALE_SMOOTH);
	    icon = new ImageIcon(scaledImg);

	    /*
	        ------------ Resize done----------------
	     */

	    // Make Bell as JLabel.
	    this.label.setIcon(icon);
	    // Set position: CENTER.
        this.label.setLocation(350, 250);
        this.label.setSize(100, 100);
	    this.add(label);
    }
    public JLabel getLabel(){
	    return this.label;
    }
}
