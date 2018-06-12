import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Server implements Runnable{
    private Opponent oppo = new Opponent();
    ServerSocket ss = null;
    Client client = null;
    Socket clientSoc = null;
    boolean isPlayerTurn = true;
    boolean isPCTurn = false;
    long ServerTime = 0;
    long ClientTime = 0;
    boolean endGame = false;
    boolean whoWon;
    private int cmd;
    long level = 5000;
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
        while(true) {
            if (endGame) break;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            checkGame();
            String Option[] = {"Quit", "Play again"};
            if(endGame) {
                if (whoWon) {
                    cmd = JOptionPane.showOptionDialog(this.client.getPlayerFrame(), "You won! Play again?", "End of Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, Option, "Quit");
                } else {
                    cmd = JOptionPane.showOptionDialog(this.client.getPlayerFrame(), "You Lose! Play again?", "End of Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, Option, "Quit");
                }
                if(cmd == 0){
                    System.exit(0);
                }
                else{
                    this.client.getPlayerFrame().dispose();
                    MainFrame.Restart();
                }
            }
        }
        System.out.println("closing Server..");
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
        return true;
    }

    private synchronized long GetBellRing(Socket clientSoc){
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
            System.out.println("FUCK");
            return timeDifference;
        } catch (IOException e) {
            //e.printStackTrace();
            return 0;
        }
    }
    private synchronized boolean GetisDeckEmpty(Socket clientSoc){
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
            return true;
        }
    }

    private synchronized void checkGame(){
        if(this.client == null) return;
        if(this.client.getPlayerFrame() == null) return;
        if(this.ClientTime == 0) return;
        if(this.client.getPlayerFrame().isFive()){
            System.out.println(this.ServerTime);
            if(Math.abs(this.ServerTime - this.ClientTime) >= level){
                System.out.println("PC wins!");
                whoWon = false;
            }else{
                System.out.println("Player wins!");
                whoWon = true;
            }
            this.endGame = true;
        }
    }
    public int getCmd(){
        return this.cmd;
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
