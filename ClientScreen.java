package client;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;

import javax.imageio.ImageIO;

public class ClientScreen{
    Socket s;
    Robot robot;
    Rectangle rect;

    public ClientScreen(Socket socket) throws Exception{
        this.s = socket;
        // this.robot = robot;
        // this.rect = rect;
        // start();
    }

    public void screen() {
        try {
            GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = g.getDefaultScreenDevice();
            Rectangle rec = g.getMaximumWindowBounds();
            Robot r = new Robot(gd);
            BufferedImage bi;
            this.setRect(rec);
            this.setRobot(r);
            
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        
            while (true) {
               bi = r.createScreenCapture(rec);
               ByteArrayOutputStream tabByte = new ByteArrayOutputStream();
               ImageIO.write(bi, "jpeg", tabByte);

               byte[] tb = tabByte.toByteArray();
               dos.write(tb);
               Thread.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }
}
