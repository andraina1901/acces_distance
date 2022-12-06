package serveur;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PanelServeur extends JPanel{
    BufferedImage image;

    public PanelServeur(){
        this.setSize(1000, 800);
    }

    public void paint(Graphics g){
        try {
            super.paint(g);
            if (image!=null) {
                g.drawImage(image, 0, 0, this);
                image = null;
            }
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
