import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.Random;

/**
 * Descendant from hewan
 * @author Febi Agil / 13514010
 */
class Ayam extends Hewan {
    /**
     * variabel delay bertipe int
     */
    private int delay;
    /**
     * variabel timer bertipe int
     */
    private int timer;

    /**
     * lahir langsung harus menghasilkan koordinat
     * Karakter Ayam adalah A
     * @param id parameter input id ayam
     * @param x parameter input koordinat x ayam
     * @param y parameter input koordinat y ayam
     */
    Ayam(int id, int x, int y) {
            super(id, x, y, 'A');
            timer = 0;
            Random rand = new Random();
            /**
             * nextInt is normally exclusive of the top value,
             * so add 1 to make it inclusive
             */
            int min = 1; 
            int max = 3;
            delay = rand.nextInt((max - min) + 1) + min;

            ImageIcon ii = new ImageIcon("img1.png");
            image = ii.getImage();
    }

    /**
     * prosedur untuk mengubah koordinat x dan y ayam 
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
            int min = 1;
            int max = 8; 
            int random = rand.nextInt((max - min) + 1) + min;
            switch(random){
                case 1 : xx++;
                        break;
                case 2 : yy++;
                        break;
                case 3 : xx--;
                        break;
                case 4 : yy--;
                        break;
                case 5 : xx++;
                         yy++;
                        break;
                case 6 : xx++;
                                 yy--;
                        break;
                case 7 : xx--;
                                 yy++;
                        break;
                case 8 : xx--;
                                 yy--;
                        break;
                default :
                        break;
            }

            if (xx >= (Settings.BOARD_WIDTH - 1))
                    xx= (Settings.BOARD_WIDTH -2);
            else if (xx < 0)
                    xx=1;
            if (yy >= (Settings.BOARD_HEIGHT - 1))
                    yy=(Settings.BOARD_HEIGHT - 2);
            else if (yy < 0)
                    yy=1;
            SetPoint(xx,yy);

        } else {
            //do nothing
        }
    }
}
