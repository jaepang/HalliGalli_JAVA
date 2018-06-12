import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    private int clientNum = 0;
    private Deck oppoDeck = new Deck();
    private Card topCard = null; // Temporally used; for checking object interchange
    ServerSocket ss = null;
    Server(){
        this.clientNum = 0;
        try {
            this.ss = new ServerSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Server(int portNum){
        this.clientNum = 0;
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

        if(this.clientNum >= 2){
            System.out.println("clientNum >= 2, break");
            return false;
        }

        Socket soc = null;
        try {
            this.oppoDeck.createDeck();
            this.topCard = this.oppoDeck.getTopCard();
            soc = ss.accept();

            System.out.println("New client socket arrived");
            OutputStream out = soc.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(this.oppoDeck);
            oos.flush();

            dos.writeUTF("message from server");
            dos.flush();
            this.clientNum++;
            //dos.close();
            //out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}