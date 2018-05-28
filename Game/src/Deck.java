import java.util.ArrayList;

public class Deck extends Card{
    private ArrayList<Card> cards;
    private Card topCard;
    Deck(){
        cards.clear();
        topCard = null;
    }
    public void addCard(Card arg1){
        cards.add(arg1);
        topCard = arg1;
    }
}
