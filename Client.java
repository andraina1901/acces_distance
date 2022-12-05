package client;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.Socket;
import javax.imageio.ImageIO;

public class Client extends Socket {
    private final static int port = 1901;
    Socket client;
    String ip;

    public Client(String ip) throws Exception {
        this.ip = ip;

    }

    public Socket getSocket() throws Exception {
        client = new Socket(ip, port);
        return client;
    }
}
