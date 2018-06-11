import javax.swing.*;
import java.io.Serializable;

public class Card extends JLabel implements Serializable{
    private ImageIcon icon = new ImageIcon(); // NEED TO INSERT "RELATIVE PATH" OF "CARD IMAGE"
    private int num;
    private String fruit;
    private Deck deck;
    Card(){
        super();
        this.num = 0;
        this.fruit = null;
        this.deck = null;
    }
    Card(String type, int cnt){
        super();
        this.num = cnt;
        this.fruit = type;
        this.deck = null;
        getCardImageIcon();
        this.setIcon(this.icon);
    }
    public void setDeck(Deck input){
        this.deck = input;
    }
    public Deck getDeck(){
        return this.deck;
    }
    public String getFruit(){
        return this.fruit;
    }
    public int getCnt(){
        return this.num;
    }
    public ImageIcon getIcon(){
        return this.icon;
    }
    public void setCard(Card input){
        this.fruit = input.fruit;
        this.num = input.num;
        this.icon = input.icon;
    }
    private void getCardImageIcon(){
        switch (this.fruit){
            case "Banana":
                switch (this.num){
                    case 1:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Banana/Banana_1.png"));
                        break;
                    case 2:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Banana/Banana_2.png"));
                        break;
                    case 3:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Banana/Banana_3.png"));
                        break;
                    case 4:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Banana/Banana_4.png"));
                        break;
                    case 5:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Banana/Banana_5.png"));
                        break;
                }
                break;
            case "Grapefruit":
                switch (this.num) {
                    case 1:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Grapefruit/Grapefruit_1.png"));
                        break;
                    case 2:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Grapefruit/Grapefruit_2.png"));
                        break;
                    case 3:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Grapefruit/Grapefruit_3.png"));
                        break;
                    case 4:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Grapefruit/Grapefruit_4.png"));
                        break;
                    case 5:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Grapefruit/Grapefruit_5.png"));
                        break;
                }
                break;
            case "Kiwi":
                switch (this.num){
                    case 1:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Kiwi/Kiwi_1.png"));
                        break;
                    case 2:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Kiwi/Kiwi_2.png"));
                        break;
                    case 3:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Kiwi/Kiwi_3.png"));
                        break;
                    case 4:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Kiwi/Kiwi_4.png"));
                        break;
                    case 5:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Kiwi/Kiwi_5.png"));
                        break;
                }
                break;
            case "Strawberry":
                switch (this.num){
                    case 1:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Strawberry/Strawberry_1.png"));
                        break;
                    case 2:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Strawberry/Strawberry_2.png"));
                        break;
                    case 3:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Strawberry/Strawberry_3.png"));
                        break;
                    case 4:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Strawberry/Strawberry_4.png"));
                        break;
                    case 5:
                        this.icon = new ImageIcon(this.getClass().getResource("images/Strawberry/Strawberry_5.png"));
                        break;
                }
                break;
        }
    }
}
