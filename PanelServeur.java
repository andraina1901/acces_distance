package serveur;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PanelServeur extends JPanel{
    BufferedImage image;

    public PanelServeur(){
        // this.setSize(1000, 800);
    }

    public void paint(Graphics g){
        try {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(image, 0, 0, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return image;
    }



    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
