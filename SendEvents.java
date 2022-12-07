package serveur;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.awt.Canvas;

class SendEvents implements MouseMotionListener, MouseListener, KeyListener {

   Socket sSocket = null;
   Canvas sCanvas = null;
   PrintWriter writer = null;

  SendEvents(Socket s, Canvas p) {
    sSocket = s;
    sCanvas = p;

    sCanvas.addMouseMotionListener(this);
    sCanvas.addMouseListener(this);
    sCanvas.addKeyListener(this);

    try {
      writer = new PrintWriter(sSocket.getOutputStream());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public void mouseDragged(MouseEvent e) {}

  public void mouseMoved(MouseEvent e) {
    writer.println(0);
    writer.println((int) (e.getX()));
    writer.println((int) (e.getY()));
    writer.flush();
  }

  public void mouseClicked(MouseEvent e) {
  }

  public void mousePressed(MouseEvent e) {
    writer.println(1);
    int button = e.getButton();
    int xButton = 1024;
    if (button == 3) {
      xButton = 4096;
    }
    writer.println(xButton);
    writer.flush();
  }

  public void mouseReleased(MouseEvent e) {
    writer.println(2);
    int button = e.getButton();
    int xButton = 1024;
    if (button == 3) {
      xButton = 4096;
    }
    writer.println(xButton);
    writer.flush();
  }

  public void mouseEntered(MouseEvent e) {}

  public void mouseExited(MouseEvent e) {}

  public void keyTyped(KeyEvent e) {
    
  }

  public void keyPressed(KeyEvent e) {
    writer.println(3);
    writer.println(e.getKeyCode());
    writer.flush();
  }

  public void keyReleased(KeyEvent e) {
    writer.println(4);
    writer.println(e.getKeyCode());
    writer.flush();
  }

}

