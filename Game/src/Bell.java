import java.awt.*;
import javax.swing.*;

public class Bell extends JPanel{
	Bell(){
		super();
		// Set Layout: BorderLayout.
		this.setLayout(new BorderLayout());
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
	    JLabel label = new JLabel();
	    label.setIcon(icon);
	    // Set position: CENTER.
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
	    this.add(label,BorderLayout.CENTER);
    }

}
