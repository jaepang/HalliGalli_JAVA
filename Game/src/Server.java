import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    private int clientNum = 0;
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

        System.out.println("clientNum >= 2");
    }

    private synchronized boolean acceptClient(){
        if(this.clientNum >= 2){
            System.out.println("clientNum >= 2, break");
            return false;
        }
        Socket soc = null;
        try {
            soc = ss.accept();


            System.out.println("New client socket arrived");
            this.clientNum++;
            OutputStream out = soc.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            dos.writeUTF("message from server");

            InputStream in = soc.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(in);

            this.topCard = (Card)ois.readObject();
            System.out.println("This topcard's fruit:"+this.topCard.getFruit()+"and its num is:"+this.topCard.getCnt());

            dos.close();
            out.close();
            ois.close();
            in.close();
            soc.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}