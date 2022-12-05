package client;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;

import javax.imageio.ImageIO;

public class ClientScreen extends Thread {
    Socket s;
    Robot robot;
    Rectangle rect;

    public ClientScreen(Socket socket, Robot robot, Rectangle rect) throws Exception{
        this.s = socket;
        this.robot = robot;
        this.rect = rect;
        start();
    }

    public void run() {
        try {
            GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = g.getDefaultScreenDevice();
            Rectangle rec = g.getMaximumWindowBounds();
            Robot r = new Robot(gd);
            BufferedImage bi;

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        
            while (true) {
               bi = r.createScreenCapture(rec);
               ByteArrayOutputStream tabByte = new ByteArrayOutputStream();
               ImageIO.write(bi, "jpeg", tabByte);

               byte[] tb = tabByte.toByteArray();
               dos.write(tb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
