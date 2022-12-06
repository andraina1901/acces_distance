package client;

import java.net.InetAddress;
import java.net.Socket;

import client.ClientScreen;

public class MainClient {
    public static void main(String[] args) throws Exception {
        String hostAdress = InetAddress.getLocalHost().getHostAddress();
        Client c = new Client(hostAdress);
        Socket client = c.getSocket();
        
        
    }
}