import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    int clientNum = 0;
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
            if(this.clientNum >= 2){
                System.out.println("clientNum >= 2, break");
                break;
            }
            Socket soc = null;
            try {
                soc = ss.accept();
                this.clientNum++;
                OutputStream out = soc.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF("message from server");

                dos.close();
                out.close();
                soc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("clientNum >= 2");
    }

}