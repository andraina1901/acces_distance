package serveur;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import serveur.FenetreServeur;
import serveur.PanelServeur;
import serveur.Serveur;

public class ShowScreen extends Thread{
    FenetreServeur fen ;
    ServerSocket ss ;
    Serveur ser;

    public ShowScreen(Serveur ser) throws Exception{
        // this.fen = fen;
        this.ser = ser;
        start();
    }

    public void run(){
        try {
            ss = ser.getSocket();
            Socket client = ss.accept();
            fen = new FenetreServeur();
            fen.setPs(new PanelServeur());
            // System.out.println("fenetre");
            InputStream ois =client.getInputStream();
        while (true) {
            try {
                byte[] bytes = new byte[1024* 1024];
                int count = 0;
                do {
                    count += ois.read(bytes, count, bytes.length-count);
                    System.out.println(count);
                } while ( !(count > 4 && bytes[count - 2] == (byte) -1 && bytes[count - 1] == (byte) -39));
    
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
                fen.getPs().setImage(image);
                fen.getPs().repaint();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }

    public FenetreServeur getFen() {
        return fen;
    }

    public void setFen(FenetreServeur fen) {
        this.fen = fen;
    }

    public ServerSocket getSs() {
        return ss;
    }

    public void setSs(ServerSocket ss) {
        this.ss = ss;
    }

    public Serveur getSer() {
        return ser;
    }

    public void setSer(Serveur ser) {
        this.ser = ser;
    }
}
