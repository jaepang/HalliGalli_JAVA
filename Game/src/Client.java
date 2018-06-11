import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client implements Runnable{
    String serverIP = "localhost";
    Socket soc = null;
    Client(){
    }

    @Override
    public void run(){
        try {
            soc = new Socket(serverIP, 5000);

            InputStream in = soc.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            System.out.println(dis.readUTF());


            System.out.println("Client closing....");
            dis.close();
            soc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}