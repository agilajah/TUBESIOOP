
import java.io.IOException; 
import java.io.ByteArrayOutputStream; 
import java.io.InputStream;

/**
 * In java, we can use JCurses :  [curses](http://en.wikipedia.org/wiki/Curses_(programming_library))
 * library for that authentic 80s look using the JCurses library.
 * Java does not make the pragmatic exceptions to portability that Python does, so there is no convenient package
 * to switch the console to character mode. Instead we have to run stty from a shell.
 * Otherwise the principle is the same. Much of this code is borrowed from the JLine project.
 * @author Febi Agil / 13514010
 */
public class NumbersConsole {

    /**
     * String ttyConfig
     */
    private static String ttyConfig;

    /**
     * Prosedur untuk setting terminalCBreak
     * @throws IOException
     * @throws InterruptedException 
     */
    private static void setTerminalToCBreak() throws IOException, InterruptedException {
        ttyConfig = stty("-g");
        /**
         * set the console to be character-buffered instead of line-buffered
         */
        stty("-icanon min 1");
        /**
         * disable character echoing
         */
        stty("-echo");
    }

    /**
     *  Execute the stty command with the specified arguments
     *  against the current active terminal.
     * @param args
     * @return
     * @throws IOException
     * @throws InterruptedException 
     */
    private static String stty(final String args)
                    throws IOException, InterruptedException {
        String cmd = "stty " + args + " < /dev/tty";

        return exec(new String[] {
                    "sh",
                    "-c",
                    cmd
                });
    }

    /**
     *  Execute the specified command and return the output
     *  (both stdout and stderr).
     */
    private static String exec(final String[] cmd)
                    throws IOException, InterruptedException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        Process p = Runtime.getRuntime().exec(cmd);
        int c;
        InputStream in = p.getInputStream();

        while ((c = in.read()) != -1) {
            bout.write(c);
        }

        in = p.getErrorStream();

        while ((c = in.read()) != -1) {
            bout.write(c);
        }

        p.waitFor();

        String result = new String(bout.toByteArray());
        return result;
    }


    public static void main(String[] args) {

            try {
                    setTerminalToCBreak();

                    int i=0;
                   // while (true) {
                     t = new Thread (sesuatu, "x");
                     t.start();

                            if ( System.in.available() != 0 ) {
                                    char c = System.in.read();
                                    switch(c) {
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
                            }

                  //  } // end while
            }
            catch (IOException e) {
                    System.err.println("IOException");
            }
            catch (InterruptedException e) {
                    System.err.println("InterruptedException");
            }
            finally {
                try {
                    stty( ttyConfig.trim() );
                 }
                 catch (Exception e) {
                     System.err.println("Exception restoring tty config");
                 }
            }

    }


}

/* Andai di python, kita bisa gini : 

import sys, select, tty, termios
old_setting = termios.tgetattr(sys.stdin)
try :
    tty.setcbreak(sys.stdin.fileno())
    poll = select.poll()
    poll.register(sys.stdin, select.POLLIN)
    while 1 :
        poll.poll()
        c = sys.stdin.read(1)
        print(c)

finally :
    termios.tcsetattr(sys.stdin, termios.TCSADRAIN, old_settings)