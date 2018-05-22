import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    {
        try {
            ServerSocket ss;
            ss = new ServerSocket(65535);
            Socket s = ss.accept();

            OutputStream os = s.getOutputStream();

            DataOutputStream dos = new DataOutputStream(os);

            dos.writeUTF("Test message from server.");

            dos.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
