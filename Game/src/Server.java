import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable{
    private Opponent oppo = new Opponent();
    ServerSocket ss = null;
    Socket clientSoc = null;
    long ServerTime;
    Server(){
        try {
            this.ss = new ServerSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Server(int portNum){
        try {
            this.ss = new ServerSocket(portNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        if(!this.acceptClient()) return;
        while(true){
            if(GetisDeckEmpty(this.clientSoc)){ // 0.5s
                System.out.println("Computer won the game");
                break;
            }
            else if(oppo.getOppoDeck().nextTopCard()){
                System.out.println("Player won the game");
            }
            // TODO: Turn starts ~ Flipping Card done here
            this.ServerTime = System.currentTimeMillis();
            if(GetBellRing(this.clientSoc) >= 500){ // 0.5s
                System.out.println("PC wins this turn");
                // TODO: Computer Would Get Card
            }
        }

        //System.out.println("closing Server..");
    }

    private synchronized boolean acceptClient(){
        clientSoc = null;
        try {
            clientSoc = ss.accept();

            System.out.println("New client socket arrived");
            this.oppo = new Opponent();
            OutputStream out = clientSoc.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(this.oppo.getOppoDeck());
            oos.flush();

            dos.writeUTF("message from server");
            dos.flush();
            dos.close();
            out.close();
            clientSoc.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    private long GetBellRing(Socket clientSoc){
        long clientBellTime = 0;
        Socket displaySoc = null;
        try {
            displaySoc = ss.accept();
            InputStream is = displaySoc.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            clientBellTime = dis.readLong();
            long timeDifference = clientBellTime - this.ServerTime;
            if(timeDifference < 0){
                timeDifference = -timeDifference;
            }
            return timeDifference;
        } catch (IOException e) {
            //e.printStackTrace();
            return 0;
        }
    }
    private boolean GetisDeckEmpty(Socket clientSoc){
        boolean isPlayerEmpty;
        Socket displaySoc = null;
        try {
            displaySoc = ss.accept();
            InputStream is = displaySoc.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            isPlayerEmpty = dis.readBoolean();
            return isPlayerEmpty;
        } catch (IOException e) {
            System.out.println("Read Boolean error");
        }
    }
}

class Opponent implements Serializable{
    private Deck oppoDeck = new Deck();
    private Card topCard = null; // Temporally used; for checking object interchange

    Opponent(){
        this.oppoDeck = new Deck();
        this.oppoDeck.createDeck();
        this.topCard = this.oppoDeck.getTopCard();
    }

    public Deck getOppoDeck(){
        return this.oppoDeck;
    }
}
