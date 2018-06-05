import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    private int mouseIsEntered = 0;
    @Override
    public void mouseClicked(MouseEvent e){
        if(this.mouseIsEntered == 1) {
            System.out.println("CLICKED");
            Card card = (Card) e.getSource();
            Deck deck = card.getDeck();
            deck.nextTopCard();
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
}
