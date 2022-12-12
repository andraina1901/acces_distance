package serveur;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class FenetreServeur extends JFrame{
    Canvas cs;
    Graphics g;
    BufferedImage image;
    BufferStrategy bs;

    public FenetreServeur(){
        Dimension d = getToolkit().getScreenSize();
        setSize(d);
        // setLocation();
        setTitle("Client screen");
        setResizable(false);
        setVisible(true);
    }

    

    public void update(){
        Graphics2D g2d = (Graphics2D) g;
        // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(image, 0, 0, this);
        bs.show();
    }
    public Canvas getCs() {
        return cs;
    }

    public void setCs(Canvas cs) {
        this.cs = cs;
        add(cs);
        cs.createBufferStrategy(3);
        bs = cs.getBufferStrategy();
        g = bs.getDrawGraphics();
    }



    public BufferedImage getImage() {
        return image;
    }



    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
