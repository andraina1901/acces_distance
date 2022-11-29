package serveur;

import java.net.ServerSocket;
import java.net.Socket;


public class MainServeur {
    public static void main(String[] args) throws Exception {
        Serveur s = new Serveur();
        ServerSocket ss = s.getSocket();

        Socket client = ss.accept();
        System.out.println("connecte");
        ss.close();
    }
}
