package client;

import java.awt.Robot;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/* Used to recieve server commands then execute them at the client side*/

class ReceiveEvents extends Thread {

  Socket socket = null;
  Robot robot = null;

  public ReceiveEvents(Socket socket, Robot robot) {
    this.socket = socket;
    this.robot = robot;
    start();
  }

  public void run() {
    Scanner scanner = null;
    try {
      scanner = new Scanner(socket.getInputStream());

      while (true) {
        int command = scanner.nextInt();
        if(command==5) {
            robot.mouseMove(scanner.nextInt(), scanner.nextInt());
        }if(command == 1){
          robot.mousePress(scanner.nextInt());
        }
        if(command == 2){
            robot.mouseRelease(scanner.nextInt());
        }
        System.out.println(command);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  } //end function
}

