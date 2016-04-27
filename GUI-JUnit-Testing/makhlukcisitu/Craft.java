/*
 *  This is a game from Cisitu Corps
 *  The name of this game is Ricefield Battle
 *  @CopyRight 2016
 */
package makhlukcisitu;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Craft {

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;

    public Craft() {
        
        initCraft();
    }
    
    private void initCraft() {
        
        ImageIcon ii = new ImageIcon("search.png");
        image = ii.getImage();
        x = 40;
        y = 60;        
    }

    public void changeCraft(){
        ImageIcon ii = new ImageIcon("img4.png");
        image = ii.getImage();

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

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}