import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    private Opponent oppo = new Opponent();
    ServerSocket ss = null;
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
        while(true){
            if(!this.acceptClient()){
                break;
            }
        }

        System.out.println("closing Server..");
    }

    private synchronized boolean acceptClient(){
        Socket soc = null;
        try {
            soc = ss.accept();

            System.out.println("New client socket arrived");
            this.oppo = new Opponent();
            OutputStream out = soc.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(this.oppo.getOppoDeck());
            oos.flush();

            dos.writeUTF("message from server");
            dos.flush();
            //dos.close();
            //out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
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