package client;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ClientScreen {

    public void Screen() throws Exception {
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = g.getDefaultScreenDevice();
        Rectangle rec = g.getMaximumWindowBounds();
        Robot r = new Robot(gd);
        BufferedImage bi = r.createScreenCapture(rec);
        File f = new File("L:/ITU_L2/S3/System&reseau_Mr Naina/screen.jpeg");
        f.createNewFile();
        ImageIO.write(bi, "jpeg", f);

    }
}
