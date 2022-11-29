package client;

import java.net.Socket;

public class Client extends Socket {
    private final static int port = 1901;
    Socket client;

    public Socket getSocket(String ip) throws Exception {
        client = new Socket(ip, port);
        return client;
    }

}
