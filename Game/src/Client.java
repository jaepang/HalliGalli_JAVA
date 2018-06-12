import java.io.*;
import java.net.Socket;

public class Client implements Runnable{
    private Display playerFrame = null;
    private String serverIP = "localhost";
    private Socket soc = null;
    private Card topCard = null;
    private Deck deck = null;
    private Card oppoTopCard = null;
    private Deck oppoDeck = null;
    Client(){
        this.deck = new Deck();
        this.deck.createDeck();
        this.topCard = this.deck.getTopCard();
    }
    Client(Deck inputDeck){
        this.deck = inputDeck;
        this.topCard = this.deck.getTopCard();
    }

    @Override
    public void run(){
        this.acceptServer();
        this.playerFrame = new Display(this.deck, this.oppoDeck);
    }

    private synchronized boolean acceptServer(){
        try {
            soc = new Socket(serverIP, 5000);
            InputStream in = soc.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            ObjectInputStream ois = new ObjectInputStream(in);
            try {
                this.oppoDeck = (Deck) ois.readObject();
            } catch(ClassNotFoundException e){
                System.out.println("Deck Class Not Found");
                Thread.yield();
                try {
                    this.oppoDeck = (Deck) ois.readObject();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
            this.oppoTopCard = this.oppoDeck.getTopCard();
            System.out.println(dis.readUTF());
            System.out.println("Fruit:"+this.oppoTopCard.getFruit());
            System.out.println("Client closing....");

            //dis.close();
            //in.close();

            //soc.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}