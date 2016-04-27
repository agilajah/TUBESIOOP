package model;

import javax.swing.ImageIcon;
import java.util.Random;

/**
 * Descendant from Hewan.
 * @author Febi Agil / 13514010
 */
public class Elang extends Hewan {
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
     * variabel arah bertipe int.
     */
    private int arah;

    /**
     * lahir harus langsung punya koordinat.
     *  karakter elang adalah E
     * @param id parameter input id elang
     * @param x parameter input koordinat x elang
     * @param y parameter input koordinat y elang
     */
    public Elang(final int id, final int x, final int y) {
        super(id, x, y, 'E');
        timer = 0;
        getArahRandom();
        Random rand = new Random();
        /**
         * nextInt is normally exclusive of the top value,
         * so add 1 to make it inclusive
         */
        final int min = 1;
        final int max = 3;
        delay = rand.nextInt((max - min) + 1) + min;
        delay = 0;
        try {
            ImageIcon ii = createImageIcon("img3.png");
            image = ii.getImage();
        } catch (ImageException e) {
            System.out.println("Error occured when trying to "
                    + "get image for Elang class: " + e.getMessage());
        }

    }

    /**
     * prosedur untuk mendapatkan arah random.
     */
    private void getArahRandom() {
        final int min = 1;
        final int max = 8;
        Random rand = new Random();
        arah = rand.nextInt((max - min) + 1) + min;
    }

    /**
     * fungsi boolean untuk melakukan pengecekan.
     * apakah terdapat tabrakan atau tidak.
     * @param x input parameter koordinat x
     * @param y input parameter koordinat y
     * @return return true is coordinate is on boundaries defined
     */
    private boolean isCollision(final int x, final int y) {
        if (x > 0 && x < (Settings.BOARD_WIDTH - 1)
                && y > 0 && y < (Settings.BOARD_HEIGHT - 1)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * melakukan pengecekan apakah arahnya sama atau tidak.
     * dengan korelasi arah berikut ini.
     * korelasi arah :
     *  dinding kanan : 1, 5, 6
     *  dinding kiri  : 3, 7, 8
     *  dinding atas  : 2, 5, 6
     *  dinding bawah : 4, 6, 8
     * @param temp parameter input arah
     * @return return true if the direction is same
     */
    private boolean isSameDirection(final int temp) {
        if (((temp == ONE || temp == FIVE || temp == SIX) 
                && (arah == 1 || arah == FIVE || arah == SIX))
            || ((temp == THREE || temp == SEVEN || temp == EIGHT)
                && (arah == THREE || arah == SEVEN || arah == EIGHT))
            || ((temp == TWO || temp == FIVE || temp == SIX)
                && (arah == TWO || arah == FIVE || arah == SIX))
            || ((temp == FOUR || temp == SIX || temp == EIGHT)
                && (arah == FOUR || arah == SIX || arah == EIGHT))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * prosedur untuk mengubah koordinat x dan y elang.
     * menjadi koordinat baru
     */
    public void gerak() {
        int xx, yy;
        xx = getX();
        yy = getY();

        timer++;
        if (timer > delay) {
            timer = 0;
            if (!isCollision(xx, yy)) {
                switch (arah) {
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
                    default:
                    		assert false;
                }
            } else {
                if (xx >= (Settings.BOARD_WIDTH - 1)) {
                    xx = (Settings.BOARD_WIDTH - 2);
                } else if (xx <= 0) {
                    xx = 1;
                }
                if (yy >= (Settings.BOARD_HEIGHT - 1)) {
                    yy = (Settings.BOARD_HEIGHT - 2);
                } else if (yy <= 0) {
                    yy = 1;
                }
                int temp = arah;
                boolean cek = true;
                int min = ONE;
                int max = EIGHT;
                Random rand = new Random();
                arah = rand.nextInt((max - min) + 1) + min;

                while (cek) {
                    if (isSameDirection(temp)) {
                            min = ONE;
                            max = EIGHT;
                            arah = rand.nextInt((max - min) + 1) + min;
                    } else {
                            cek = false;
                    }
                }
            }
            setPoint(xx, yy);
        }
    }
}
