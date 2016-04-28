package model;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.net.URL;

/**
 * Class craft, as a handler to move.
 */
public class Craft {
    /**
     * The distance of moving object in x.
     */
    private int dx;
    /**
     * The distance of moving object in y.
     */
    private int dy;
    /**
     * The absis.
     */
    private int x;
    /**
     * The ordinate.
     */
    private int y;
    /**
     * An image container.
     */
    private Image image;
    /**
     * an initial value of x, to be assigned to the variable.
     */
    private static final int INIT_X = 40;
    /**
     * an initial value of y, to be assigned to the variable.
     */
    private static final int INIT_Y = 60;
    /**
     * type 1 is single player, type 2 is multiplayer game
     */
    private int type;

    /**
     * The class constructor of craft class.
     */
    public Craft() {
        initCraft();
    }

    /**
     * The second class constructor for craft class.
     * @param x is parameter for player, assigned value is between 1 or 2
     */
    public Craft(int x) {
        type = x;
        initCraft();
    }

    /**
     * @param imagename name of the image file.
     * @return an ImageIcon, or throwing exception if the path was invalid
     * @throws ImageException throwing string as caution
     * if the image needed does not found in gambar directory
     */
    public ImageIcon createImageIcon(final String imagename)
            throws ImageException {
        String path = "/gambar/" + imagename;
        //URL imgURL = new URL(path);
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            throw new ImageException("Image not found!");
        }
    }

    /**
     * a method used for initializing craft.
     */
     public void initCraft() {
        ImageIcon ii;
        try {
            if (type == 1) {
                ii = createImageIcon("p1.png");
            } else {
                ii = createImageIcon("p2.png");
            }

            image = ii.getImage();
            x = INIT_X;
            y = INIT_Y;
        } catch (ImageException e) {
            System.out.println("Error occured when trying to "
                    + "get image for craft class, check image for p1 or p2: " + e.getMessage());
        }

    }

    /**
     * a method used for change craft's field such as image icon.
     */
    public void changeCraft() {
        try {
            ImageIcon ii = createImageIcon("p2d.png");
            image = ii.getImage();
        } catch (ImageException e) {
            System.out.println("Error occured when trying to "
                    + "get image for change player: " + e.getMessage());
        }
    }

    /**
     * hiding the window.
     */
    public void hide() {
        try {
            ImageIcon ii = createImageIcon("hide.png");
            image = ii.getImage();
            x = 999;
            y = 999;
        } catch (ImageException e) {
            System.out.println("Error occured when trying to "
                    + "get image for Craft class, hide method: " + e.getMessage());
        }

    }

    /**
     * a procedure to take a move.
     */
    public void move() {
        x += dx;
        y += dy;
    }

    /**
     * a function that returns absis x.
     * @return integer absis
     */
    public int getX() {
        return x;
    }

    /**
     * a function that returns ordinat y.
     * @return integer ordinat
     */
    public int getY() {
        return y;
    }

    /**
     * get image to show on the frame.
     * @return image
     */
    public Image getImage() {
        return image;
    }

    /**
     * a method to catch a key event and trigger some actions based on the key.
     * @param e as the key event
     */
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

    /**
     * This is the compelemeter of the keypressed method.
     * @param e the key event
     */
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
