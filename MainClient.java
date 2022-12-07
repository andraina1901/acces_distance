package client;

import java.net.InetAddress;
import java.net.Socket;
import client.ClientScreen;

public class MainClient {
    public static void main(String[] args) throws Exception {
        String hostAdress = "172.16.1.7";

        Client c = new Client(hostAdress);
        Socket client = c.getSocket();
        ClientScreen cs = new ClientScreen(client);
        cs.screen();
    }
}