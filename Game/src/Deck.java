import javax.swing.*;
import java.util.ArrayList;
import java.util.*;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private Integer size;
    private Card topCard;
    private Integer topIdx;
    Deck(){
        cards.clear();
        topCard = null;
        topIdx = 0;
    }
    public void addCard(Card arg1){
        this.cards.add(arg1);
        topCard = arg1;
        arg1.setDeck(this);
    }
    /* Treat blank deck back; to display empty deck */
    public Card getTopCard(){
        return this.topCard;
    }
    public int getSize(){
        this.size = this.cards.size();
        return this.size;
    }
    public void nextTopCard(){
        this.topIdx = this.topIdx + 1;
        this.topCard = this.cards.get(this.topIdx);
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
    public void MergeDeck(Deck deck){
        this.cards.addAll(deck.cards);
        for(int i=0; i<this.cards.size(); i++){
            cards.get(i).setDeck(this);
        }
        long seed = System.nanoTime();
        Collections.shuffle(this.cards, new Random(seed));
        /* clear a deck */
        deck = new Deck();
    }
}
