package client;

import java.net.Socket;

public class MainClient {
    public static void main(String[] args) throws Exception {

        Client c = new Client();
        Socket client = c.getSocket("192.168.10.168");
    }
}