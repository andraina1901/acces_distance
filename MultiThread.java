package serveur;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import client.Client;
import serveur.Serveur;
import serveur.ShowScreen;

public class MultiThread extends Thread {
    Serveur s = new Serveur();
    Vector<Socket> lc = new Vector<Socket>();

    public MultiThread() throws Exception {

    }

    public void run() {
        // ServerSocket sck = s.getSocket();
        try {
            ServerSocket sck = s.getSocket();
            while (true) {
                Socket c = sck.accept();
                lc.add(c);
                ShowScreen sh = new ShowScreen(c);
                sh.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
