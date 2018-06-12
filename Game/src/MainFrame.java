import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class MainFrame {

	public static void main(String args[]){

	    new Display();

	    /*Server testing*/
        /*Currently not working, cause might be: portNum is not appropriate, or ArrayList<Thread> issue.*/

        Server server = new Server(5000);
        new Thread(server).start();

        System.out.println("Server sleeping begin...");
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Server starts making clients");

        Client client_1 = new Client();
        System.out.println("client_1.start()");
        new Thread(client_1).start();

        Client client_2 = new Client();
        System.out.println("client_2.start()");
        new Thread(client_2).start();

        /*
        * Client_3 should not be accepted
        */
        Client client_3 = new Client();
        System.out.println("client_3.start()");
        new Thread(client_3).start();

    }



}

