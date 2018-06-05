import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable{
    private int portNum;
    private ArrayList<Thread> runningThreads;
    private ServerSocket serverSocket;
    private boolean isStopped;

    public Server(){
        this.portNum = 0000;
        this.runningThreads.clear();
        this.serverSocket = null;
        this.isStopped = true;
    }

    public Server(int port){
        this.portNum = port;
        this.runningThreads.clear();
        this.serverSocket = null;
        this.isStopped = true;
    }

    @Override
    public void run(){
        synchronized (this){
            this.runningThreads.add(Thread.currentThread());
        }
        openServerSocket();
        while(! isStopped()){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()){
                    System.out.println("Server Stopped.");
                    return;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e);
            }
            new Thread(
                    new Client(
                            clientSocket, "Multithreaded Server")
            ).start();
        }
        System.out.println("Server Stopped.");
    }

    private void openServerSocket(){
        try {
            this.serverSocket = new ServerSocket(this.portNum);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port "+ this.portNum, e);
        }
    }

    private synchronized boolean isStopped(){
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }
}
