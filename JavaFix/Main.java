
/**
 * Setiap include class tinggal pake import, masukkan kelas ke package yang sama.
 * Atau class dan main ini di tempat yang sama biar gausah pake import2an
 * @author Febi Agil / 13514010
 */


import java.io.IOException;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;


public class Main  {

	/**
	* class main program
	* @param args input args
	* @throws IOException 
	* @throws InterruptedException
	*/
	public static void main(String args[]) throws IOException, InterruptedException {
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
	