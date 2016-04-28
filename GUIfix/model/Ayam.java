package model;

import javax.swing.ImageIcon;
import java.util.Random;

/**
 * Descendant from hewan.
 * @author Febi Agil / 13514010
 */
public class Ayam extends Hewan {
    /**
     * constant value of one.
     */
    private static final int ONE = 1;
    /**
     * constant value of two.
     */
    private static final int TWO = 2;
    /**
     * constant value of three.
     */
    private static final int THREE = 3;
    /**
     * constant value of four.
     */
    private static final int FOUR = 4;
    /**
     * constant value of five.
     */
    private static final int FIVE = 5;
    /**
     * constant value of six.
     */
    private static final int SIX = 6;
    /**
     * constant value of seven.
     */
    private static final int SEVEN = 7;
    /**
     * constant value of eight.
     */
    private static final int EIGHT = 8;
    /**
     * variabel delay bertipe int.
     */
    private int delay;
    /**
     * variabel timer bertipe int.
     */
    private int timer;

    /**
     * lahir langsung harus menghasilkan koordinat.
     * Karakter Ayam adalah A
     * @param id parameter input id ayam
     * @param x parameter input koordinat x ayam
     * @param y parameter input koordinat y ayam
     */
    public Ayam(final int id, final int x, final int y) {
            super(id, x, y, 'A');
            timer = 0;
            Random rand = new Random();
            /**
             * nextInt is normally exclusive of the top value,
             * so add 1 to make it inclusive
             */
            int min = ONE;
            int max = THREE;
            delay = rand.nextInt((max - min) + 1) + min;
            try {
                ImageIcon ii = createImageIcon("img1.png");
                image = ii.getImage();
            } catch (ImageException e) {
                System.out.println("Error occured when trying to get "
                        + "image for Ayam class: " + e.getMessage());
            }
    }

    /**
     * * prosedur untuk mengubah koordinat x dan y ayam.
     * menjadi koordinat baru
     */
    public void gerak() {
        int xx, yy;
        timer++;

        if (timer == delay) {
            timer = 0;
            xx = getX();
            yy = getY();
            Random rand = new Random();
            int min = ONE;
            int max = EIGHT;
            int random = rand.nextInt((max - min) + 1) + min;
            switch (random) {
                case ONE : xx++;
                        break;
                case TWO : yy++;
                        break;
                case THREE : xx--;
                        break;
                case FOUR : yy--;
                        break;
                case FIVE : xx++;
                         yy++;
                        break;
                case SIX : xx++;
                        yy--;
                        break;
                case SEVEN : xx--;
                        yy++;
                        break;
                case EIGHT : xx--;
                        yy--;
                        break;
                default :
                		assert false;
                        break;
            }

            if (xx >= (Settings.BOARD_WIDTH - 1)) {
                xx = (Settings.BOARD_WIDTH - 2);
            } else if (xx < 0) {
                xx = 1;
            }
            if (yy >= (Settings.BOARD_HEIGHT - 1)) {
                yy = (Settings.BOARD_HEIGHT - 2);
            } else if (yy < 0) {
                yy = 1;
            }

            setPoint(xx, yy);

        }
    }
}
