
/**
 * Setiap include class tinggal pake import, masukkan kelas ke package yang sama.
 * Atau class dan main ini di tempat yang sama biar gausah pake import2an
 * @author Febi Agil / 13514010
 */

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class Main {
  /**
   * .Main method untuk versi command line
   * @param args daftar argumen pemanggilan main method
   * @throws IOException input/output exception
   * @throws InterruptedException exception interupsi
   */
  public static void main(String[] args) throws IOException, InterruptedException {
        Board board = new Board();
        Manager worldManager = new Manager(100, board);
        Viewer view = new Viewer(board);
    
    while (true) {
      view.displayToScreen();
      worldManager.moveAll();
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
  }

}
