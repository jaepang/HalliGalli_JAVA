import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		int width, height, card_width, card_height;
		/* 4:3 resolution */
		width = 800;
		height = 600;
		card_width = width/8;
		card_height = height/6;

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
        test.setBounds(width/2 -card_width/2, height - card_height, card_width, card_height);

        /*Card Class Test2: Testing image*/
        Deck testDeck2 = new Deck();
        testDeck2.createDeck();
        Card test2 = testDeck2.getTopCard();
        test2.setBounds(width/2 -card_width/2, 0, card_width, card_height);

        base_pane.add(bell, new Integer(0));
        base_pane.add(test, new Integer(1), 0);
        base_pane.add(test2, new Integer(1), 1);
        this.pack();
        this.setVisible(true);

        /* Deck shuffle*/
        /* Mouse click eventListener used for testing*/
        test.addMouseListener(new MouseHandler());
        /* Should be changed in future*/
        test = testDeck.getTopCard();

        this.setResizable(false);   // No frame resize occurs, except for future feature: Configure settings
	} 

	public static void main(String args[]){
		new MainFrame();
	}



}

