import javax.swing.*;

public class MainFrame extends JFrame{
	public MainFrame() {
		int width, height;
		width = 800;
		height = 600;
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Halli-Galli");
		
		/*Create "Bell" Panel Instance*/
		Bell panel = new Bell();

		/*Add panel to Frame*/
		this.add(panel);
		this.setVisible(true);

		/*Card Class Test*/
        Card test = new Card();

        /*Card Class Test2: Testing image*/
        Card test2 = new Card("Banana",1);
	} 
	
	public static void main(String args[]){
		MainFrame mainFrame = new MainFrame();
	}
}

