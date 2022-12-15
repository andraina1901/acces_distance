package serveur;

import java.net.ServerSocket;
import java.net.Socket;

import serveur.MultiThread;
import serveur.FenetreServeur;
import serveur.ShowScreen;

public class MainServeur {
    public static void main(String[] args) throws Exception {
        new MultiThread().start();
    }
}
