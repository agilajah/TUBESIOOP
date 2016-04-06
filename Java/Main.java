//Setiap include class tinggal pake import, masukkan kelas ke package yang sama. Atau class dan main ini di tempat yang sama biar gausah pake import2an

import.util.*;


class Main {
	Board board;
	Manager worldManager(100, board);
	Viewer view(board);
	boolean stop, paused, stepByStep = false;

	public void nonblock() {
		//idk
	}

	public void loop() {
		  while (!stop) {
            if (!paused) {
                view.displayToScreen();
                worldManager.moveAll();
            }
            else if (stepByStep) {
                worldManager.moveAll(); 
                view.displayToScreen();
                stepByStep = false;
            }
        }
	}


	public static void main(String args[]) {
		char cc;

		//nonblock();
		//thread t(loop);
		do {
	        cc = getchar();
	        switch(cc) {
	            case 'p'    :   paused = true;
	                            cout << " | Program paused... (Press 'c' to continue or 's' for step by step execution) ";
	                            break;
	            case 'f'    :   if(paused) view.displayToFile();
	                            break;
	            case 'c'    :   paused = false;
	                            break;
	            case 's'    :   stepByStep = true;
	                            break;
	            case 'e'    :   stop = true;
	                            t.join();
	                            break;
	            case ','    :   view.increaseRefreshRate();
	                            break;
	            case '.'    :   view.decreaseRefreshRate();
	                            break;
	        }
	    } while (!stop);
	    System.out.println("Program exited.. ");
	}
}
	