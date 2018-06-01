import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private JLayeredPane base_pane = new JLayeredPane();
    /* Check whether it is time to ring the bell */
    /* When player gets more than 2, we may need ArrayList <Deck> */
    public boolean Ringdingdong(Deck one, Deck two){
        if(one.getTopCard().getFruit() == two.getTopCard().getFruit()){
            if(one.getTopCard().getCnt()+two.getTopCard().getCnt() == 5){
                return true;
            }
        }
        return false;
    }
	public MainFrame() {
		int width, height;
		width = 800;
		height = 600;
		this.setPreferredSize(new Dimension(width, height));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Halli-Galli");

        /*Add base_pane to Frame*/
        this.add(base_pane, BorderLayout.CENTER);

        /* Set Boundary */
        base_pane.setBounds(0, 0, width, height);

		/*Create "Bell" bell Instance*/
		Bell bell = new Bell();
        bell.setOpaque(true);
        bell.setBounds(0, 0, width, height);

		/*Deck Class Test*/
        Deck testDeck = new Deck();
        testDeck.createDeck();
        Card test = testDeck.getTopCard();
        test.setBounds(0, 0, width/8, height/8);

        /*Card Class Test2: Testing image*/
        Deck testDeck2 = new Deck();
        testDeck2.createDeck();
        Card test2 = testDeck2.getTopCard();
        test2.setBounds(width/8, height/8, width/8, height/8);

        base_pane.add(bell, new Integer(0));
        base_pane.add(test, new Integer(1), 0);
        base_pane.add(test2, new Integer(1));
        this.pack();
        this.setVisible(true);
	} 
	
	public static void main(String args[]){
		new MainFrame();
	}
}

