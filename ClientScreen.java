package client;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

public class ClientScreen {
    Socket s;
    Robot robot;
    Rectangle rect;

    public ClientScreen(Socket socket) throws Exception {
        this.s = socket;
    }

    public void screen() {
        try {
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rec = new Rectangle(d);
            Robot r = new Robot();
            BufferedImage bi;
            this.setRect(rec);
            this.setRobot(r);

            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            ByteArrayOutputStream tabByte;
            while (true) {
                bi = r.createScreenCapture(rec);
                tabByte = new ByteArrayOutputStream();
                ImageIO.write(bi, "png", tabByte);

                byte[] tb = ByteBuffer.allocate(4).putInt(tabByte.size()).array();

                dos.write(tb);
                dos.write(tabByte.toByteArray());
                dos.flush();
                new ReceiveEvents(s, r);
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
