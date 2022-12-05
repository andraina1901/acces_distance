package client;

import java.net.Socket;

public class MainClient {
    public static void main(String[] args) throws Exception {

        Client c = new Client("192.168.10.168");
        Socket client = c.getSocket();
    }
}