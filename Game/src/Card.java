import javax.swing.*;
import java.awt.*;

public class Card extends JPanel {
    private ImageIcon icon = new ImageIcon(); // NEED TO INSERT "RELATIVE PATH" OF "CARD IMAGE"
    private int num;
    private String fruit;
    Card(){
        super();
        JPanel cardPanel = new JPanel();
    }
    Card(String type, int cnt){
        super();
        JPanel cardPanel = new JPanel();
        this.num = cnt;
        this.fruit = type;
        getCardImageIcon();
        displayImageIcon();

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
        }
    }
}
