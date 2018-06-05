import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client implements Runnable{

    private Socket clientSocket;
    private String serverText;

    public Client(){
        this.clientSocket = null;
    }

    public Client(Socket clientSocket, String serverText){
        this.clientSocket = clientSocket;
        this.serverText = serverText;
    }

    @Override
    public void run(){
        try {
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            output.write("NYANG".getBytes());

            output.close();
            input.close();
            System.out.println("Request processed: "+ time);
        } catch (IOException e) {
            // report exception somewhere.
            e.printStackTrace();
        }
    }
}
