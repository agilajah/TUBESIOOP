import java.awt.Image;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;

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
     * The class constructor of craft class.
     */
    public Craft() {
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
    private void initCraft() {
        try {
            ImageIcon ii = createImageIcon("search.png");
            image = ii.getImage();
            x = INIT_X;
            y = INIT_Y;
        } catch (ImageException e) {
            System.out.println("Error occured when trying to "
                    + "get image for Craft class: " + e.getMessage());
        }

    }

    /**
     * a method used for change craft's field such as image icon
     */
    public void changeCraft() {
        try {
            ImageIcon ii = createImageIcon("img4.png");
            image = ii.getImage();
        } catch (ImageException e) {
            System.out.println("Error occured when trying to "
                    + "get image for Craft class: " + e.getMessage());
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

    /**
     * This is the compelemeter of the keypressed method.
     * @param e the key event
     */
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
