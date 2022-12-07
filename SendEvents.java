package serveur;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JPanel;

class SendEvents implements MouseMotionListener {

  private Socket sSocket = null;
  private JPanel sJPanel = null;
  private PrintWriter writer = null;

  SendEvents(Socket s, JPanel p) {
    sSocket = s;
    sJPanel = p;

    sJPanel.addMouseMotionListener(this);

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

}

