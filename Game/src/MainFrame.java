import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class MainFrame {

	public static void main(String args[]){

	    //Display GUIFrame = new Display();
	    Deck deck1 = new Deck();
	    deck1.createDeck();
        Thread serverThread = null;
	    Thread thread1 = null;

        Server server = new Server(5000);
        serverThread = new Thread(server);
        serverThread.start();


        System.out.println("Server sleeping begin...");
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Server starts making clients");

        Client client_1 = new Client(deck1);
        System.out.println("client_1.start()");
        client_1.setServer(server);
        thread1 = new Thread(client_1);
        synchronized (thread1) {
            thread1.start();
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



}

