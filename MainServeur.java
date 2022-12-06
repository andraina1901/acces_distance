package serveur;

import java.net.ServerSocket;
import java.net.Socket;

import serveur.FenetreServeur;
import serveur.ShowScreen;


public class MainServeur {
    public static void main(String[] args) throws Exception {
        Serveur s = new Serveur();
        // ServerSocket ss = s.getSocket();
        ShowScreen sc = new ShowScreen(s);
        
        
        // ss.close();
    }
}
