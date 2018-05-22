import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    {
        try {
            Socket s = new Socket("127.0.0.1", 65535);

            InputStream in;

            in = s.getInputStream();

            DataInputStream dis = new DataInputStream(in);

            System.out.println(dis.readUTF());

            dis.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
