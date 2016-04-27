import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Craft {

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    private int type;

    public Craft(){
        initCraft();
    }

    public Craft(int x) {
        type = x;
        initCraft();
    }
    
    public void initCraft() {
        
      ImageIcon ii;

        if (type == 1){
            ii = new ImageIcon("p1.png");
        }
        else {
            ii = new ImageIcon("p2.png");
        }

        image = ii.getImage();
        x = 40;
        y = 60;        
    }

    public void changeCraft(){
        ImageIcon ii = new ImageIcon("p2d.png");
        image = ii.getImage();
    }

    public void hide(){
         ImageIcon ii = new ImageIcon("hide.png");
        image = ii.getImage();
        x = 999;
        y = 999;
    }


    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT) && ( type == 1)) {
            dx = -1;
        }

        if ((key == KeyEvent.VK_RIGHT) && (type == 1)) {
            dx = 1;
        }

        if ((key == KeyEvent.VK_UP) && (type == 1)) {
            dy = -1;
        }

        if ((key == KeyEvent.VK_DOWN) && (type == 1)) {
            dy = 1;
        }

        if ((key == KeyEvent.VK_A) && ( type == 2)) {
            dx = -1;
        }

        if ((key == KeyEvent.VK_D) && (type == 2)) {
            dx = 1;
        }

        if ((key == KeyEvent.VK_W) && (type == 2)) {
            dy = -1;
        }

        if ((key == KeyEvent.VK_S) && (type == 2)) {
            dy = 1;
        }

        
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();
        if ((key == KeyEvent.VK_LEFT) && ( type == 1)) {
            dx = 0;
        }

        if ((key == KeyEvent.VK_RIGHT) && (type == 1)) {
            dx = 0;
        }

        if ((key == KeyEvent.VK_UP) && (type == 1)) {
            dy = 0;
        }

        if ((key == KeyEvent.VK_DOWN) && (type == 1)) {
            dy = 0;
        }

        if ((key == KeyEvent.VK_A) && ( type == 2)) {
            dx = 0;
        }

        if ((key == KeyEvent.VK_D) && (type == 2)) {
            dx = 0;
        }

        if ((key == KeyEvent.VK_W) && (type == 2)) {
            dy = 0;
        }

        if ((key == KeyEvent.VK_S) && (type == 2)) {
            dy = 0;
        }

       
    }
}