import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class MainFrame extends JFrame implements MouseListener{
    private JLayeredPane base_pane = new JLayeredPane();
    Bell bell = new Bell();
    Card card1, card2;
    ArrayList <Long> ringBellLog = new ArrayList<Long>();
    /* Check whether it is time to ring the bell */
    /* When player gets more than 2, we may need ArrayList <Deck> */
    /*
    public boolean Ringdingdong(Deck one, Deck two){
        if(one.getTopCard().getFruit() == two.getTopCard().getFruit()){
            if(one.getTopCard().getCnt()+two.getTopCard().getCnt() == 5){
                return true;
            }
        }
        return false;
    }
    */
	public MainFrame() {
        int width, height, card_width, card_height;
		/* 4:3 resolution */
		width = 800;
		height = 600;
		card_width = width/8;
		card_height = height/6;

		this.setPreferredSize(new Dimension(width, height));
		this.setResizable(false);        // No frame resize occurs, except for future feature: Configure settings
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Halli-Galli");

        /*Add base_pane to Frame*/
        this.add(this.base_pane, BorderLayout.CENTER);

        /* Set Boundary */
        this.base_pane.setBounds(0, 0, width, height);

		/*Create "Bell" bell Instance*/
        bell.setOpaque(true);
        bell.setBounds(0, 0, width, height);

		/*Deck Class this.card1*/
        Deck deck1 = new Deck();
        deck1.createDeck();
        this.card1 = deck1.getTopCard();
        card1.setBounds(width/2 -card_width/2, height - card_height, card_width, card_height);

        /*Card Class this.card2: this.card1ing image*/
        Deck deck2 = new Deck();
        deck2.createDeck();
        this.card2 = deck2.getTopCard();
        this.card2.setBounds(width/2 -card_width/2, 0, card_width, card_height);

        base_pane.add(bell, new Integer(0));
        base_pane.add(this.card1, new Integer(1), 0);
        base_pane.add(this.card2, new Integer(1), 1);
        this.pack();
        this.setVisible(true);

        /* Mouse click eventListener used for this.card1ing*/
        this.card1.addMouseListener(this);
        this.bell.getLabel().addMouseListener(this);

        this.card1 = deck1.getTopCard();
	}
    private int mouseIsEntered = 0;
    @Override
    public void mouseClicked(MouseEvent e){
        if(this.mouseIsEntered == 1 && e.getSource()==card1) {
            System.out.println("CLICKED CARD");
            this.card1.getDeck().nextTopCard();
            this.card1.setCard(this.card1.getDeck().getTopCard());

            base_pane.revalidate();
            base_pane.repaint();
        }
        else if(this.mouseIsEntered == 1 && e.getSource() == this.bell.getLabel()){
            ringBellLog.add(System.currentTimeMillis());
            for(int i=0; i<ringBellLog.size(); i++){
                System.out.print(ringBellLog.get(i)+" ");
            }
            System.out.println();
        }
    }
    @Override
    public void mouseEntered(MouseEvent e){
        this.mouseIsEntered = 1;
    }
    @Override
    public void mouseExited(MouseEvent e){
        this.mouseIsEntered = 0;
    }
    @Override
    public void mousePressed(MouseEvent e){

    }
    @Override
    public void mouseReleased(MouseEvent e){

    }

	public static void main(String args[]){

	    new MainFrame();

	    /*Server testing*/
        /*Currently not working, cause might be: portNum is not appropriate, or ArrayList<Thread> issue.*/

        Server server = new Server(5000);
        new Thread(server).start();

        System.out.println("Server sleeping begin...");
        try {
            Thread.sleep(20*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Server starts making clients");

        Client client_1 = new Client();
        System.out.println("client_1.start()");
        new Thread(client_1).start();

        Client client_2 = new Client();
        System.out.println("client_2.start()");
        new Thread(client_2).start();

        Client client_3 = new Client();
        System.out.println("client_3.start()");
        new Thread(client_3).start();

    }



}

