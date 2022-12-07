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

class SendEvents implements MouseMotionListener, MouseListener {

   Socket sSocket = null;
   Canvas sCanvas = null;
   PrintWriter writer = null;

  SendEvents(Socket s, Canvas p) {
    sSocket = s;
    sCanvas = p;

    sCanvas.addMouseMotionListener(this);
    sCanvas.addMouseListener(this);

    try {
      writer = new PrintWriter(sSocket.getOutputStream());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public void mouseDragged(MouseEvent e) {}

  public void mouseMoved(MouseEvent e) {
    writer.println(5);
    writer.println((int) (e.getX()));
    writer.println((int) (e.getY()));
    writer.flush();
  }

  public void mouseClicked(MouseEvent e) {
  }

  public void mousePressed(MouseEvent e) {
    writer.println(1);
    int button = e.getButton();
    int xButton = 16;
    if (button == 3) {
      xButton = 4;
    }
    writer.println(xButton);
    writer.flush();
  }

  public void mouseReleased(MouseEvent e) {
    writer.println(2);
    int button = e.getButton();
    int xButton = 16;
    if (button == 3) {
      xButton = 4;
    }
    writer.println(xButton);
    writer.flush();
  }

  public void mouseEntered(MouseEvent e) {}

  public void mouseExited(MouseEvent e) {}

}

