import java.io.FileWriter;
import java.io.BufferedWriter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Amal Qurany / 13514078
 */
public class GUIViewer extends JPanel implements ActionListener {
    /**
     * variabel board bertipe Board
     */
    private Board board;
    private Timer timer;
    private Craft craft;
    private final int DELAY = 10;
    

    /**
     * konstruktor Viewer
     * @param board parameter inputan board
     */
    public Viewer(Board board){
        this.board = board;

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);

        craft = new Craft();

        timer = new Timer(DELAY, this);
        timer.start(); 
       
    }

    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);        
    }

    private void doDrawingEnemy(Graphics g){
        Graphisc2D g2d = (Graphics2D) g;
        for (int i=0; i<30; i++){
            for (int j=0; j<80; j++){
                if (board.getCharacter(j,i)!=0){
                    g2d.drawImage(craft.getImage(), j, i, this);       
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        craft.move();
        repaint();  
    }




    

   

   private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }


}