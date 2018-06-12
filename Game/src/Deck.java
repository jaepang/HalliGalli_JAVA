import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.*;

public class Deck implements Serializable {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private Integer size;
    private Card topCard;
    private Integer topIdx;
    Deck(){
        cards.clear();
        topCard = null;
        topIdx = 0;
        size = 0;
    }
    public void addCard(Card arg1){
        this.cards.add(arg1);
        this.topCard = arg1;
        arg1.setDeck(this);
        this.size ++;
    }
    public void removeCard(){
        this.cards.remove(this.getTopIdx());
        this.topIdx --;
    }
    public Card getTopCard(){
        return this.topCard;
    }
    public int getTopIdx() {
        return this.topIdx;
    }
    public int getSize(){
        return this.size;
    }
    public boolean nextTopCard(){
        this.topIdx = this.topIdx + 1;
        try {
            this.topCard = this.cards.get(this.topIdx);
            this.size --;
        } catch(IndexOutOfBoundsException e){
            System.out.println("Player1 Lose; Lost every card");
            sendServerBool(true);
            return true;
        }
        sendServerBool(false);
        return false;
    }
    /* make deck and shuffle */
    public void createDeck(){
        for(int i=0; i<4; i++){
            switch (i){
                case 0:
                    for(int j=0; j<14; j++){ //012 345 678 91011 1213
                        Card card = new Card("Banana", j/3+1);
                        addCard(card);
                    }
                    break;
                case 1:
                    for(int j=0; j<14; j++){ //012 345 678 91011 1213
                        Card card = new Card("Grapefruit", j/3+1);
                        addCard(card);
                    }
                    break;
                case 2:
                    for(int j=0; j<14; j++){ //012 345 678 91011 1213
                        Card card = new Card("Kiwi", j/3+1);
                        addCard(card);
                    }
                    break;
                case 3:
                    for(int j=0; j<14; j++){ //012 345 678 91011 1213
                        Card card = new Card("Strawberry", j/3+1);
                        addCard(card);
                    }
                    break;
            }
        }
        long seed = System.nanoTime();
        Collections.shuffle(this.cards, new Random(seed));
        this.topCard = this.cards.get(this.topIdx);
    }
    /* Merge two deck to one */
    /* when player1 win, run this method */
    public void MergeDeck(Deck deck){
        for(int i=0; i<deck.getTopIdx()+1; i++){
            Card swapCard = deck.cards.get(i);
            swapCard.setDeck(this);
            this.cards.add(swapCard);
        }
        for(int i=0; i<deck.getTopIdx()+1; i++){
            deck.removeCard();
        }
        /* Shuffle Deck After merging */
        long seed = System.nanoTime();
        Collections.shuffle(this.cards, new Random(seed));
    }
    public void sendServerBool(boolean bool){
        //Socket soc = client.getSoc();
        try {
            Socket soc = new Socket("localhost",5000);
            OutputStream os = null;
            os = soc.getOutputStream();
            DataOutputStream oos = new DataOutputStream(os);
            oos.writeBoolean(bool);
            oos.flush();
            os.close();
            soc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
