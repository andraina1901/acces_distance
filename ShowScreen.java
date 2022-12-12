package serveur;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.spi.CurrencyNameProvider;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import serveur.FenetreServeur;
import serveur.Serveur;

public class ShowScreen implements Runnable{
    FenetreServeur fen ;
    ServerSocket ss ;
    Serveur ser;
    boolean running = true;
    int tickCount=0;

    public ShowScreen(Serveur ser) throws Exception{
        this.ser = ser;
    }

    //// GAME LOOP
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D / 64;

        int ticks = 0;
        int frames = 0;

        long lastTimer = System.currentTimeMillis();
        double delta = 0;

        try {
            ss = ser.getSocket();
            Socket client = ss.accept();
            fen = new FenetreServeur();
            fen.setCs(new Canvas());
            new SendEvents(client, fen.getCs());
            InputStream in = client.getInputStream();
            DataInputStream ois =new DataInputStream(in);
            BufferedImage image = null;
        
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = true;

            while (delta >= 1) {
                ticks++;
                tick();
                delta -= 1;
                shouldRender = true;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            if (shouldRender) {
                frames++;
                render(ois, image, client);
            }

            if (System.currentTimeMillis() - lastTimer >= 1000) {
                lastTimer += 1000;
                // System.out.println(ticks + " ticks, " + frames + " frames");
                frames = 0;
                ticks = 0;
            }
        } } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        tickCount++;
    }

    public void render(DataInputStream ois, BufferedImage image, Socket client) {
        try {
            byte[] bytes = new byte[4];
            ois.readFully(bytes);
    
            int size = ByteBuffer.wrap(bytes).asIntBuffer().get();
            byte[] img = new byte[size];
            int totalRead = 0;
            int currentRead;
            while (totalRead<size && (currentRead = ois.read(img, totalRead, size-totalRead))>0) {
                totalRead += currentRead;
            }
    
            image = ImageIO.read(new ByteArrayInputStream(img));
            image.getScaledInstance(image.getWidth(null), image.getHeight(null), image.SCALE_FAST);
            fen.getCs().setSize(image.getWidth(null), image.getHeight(null));
            fen.setImage(image);
            fen.update();
            
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
