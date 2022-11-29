package serveur;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Vector;

public class Serveur {
    private final static int port = 1901;
    private String ip;
    private ServerSocket s;

    public ServerSocket getSocket() throws Exception {
        ip = InetAddress.getLocalHost().getHostAddress();
        s = new ServerSocket(this.port);
        return this.s;
    }

}
