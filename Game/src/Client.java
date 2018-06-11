import java.io.*;
import java.net.Socket;

public class Client implements Runnable{
    private String serverIP = "localhost";
    private Socket soc = null;
    private Card topCard = null;
    private Deck deck = null;
    Client(){
        this.deck = new Deck();
        this.deck.createDeck();
        this.topCard = this.deck.getTopCard();
    }

    @Override
    public void run(){
        this.acceptServer();
    }

    private synchronized boolean acceptServer(){
        try {
            soc = new Socket(serverIP, 5000);

            InputStream in = soc.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            System.out.println(dis.readUTF());


            System.out.println("Client closing....");


            OutputStream out = soc.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);

            oos.writeObject(topCard);
            dis.close();
            in.close();
            oos.close();
            out.close();
            soc.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}