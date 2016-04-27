import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.Random;

/**
 * Descendant from Hewan
 * @author Febi Agil / 13514010
 */
class Elang extends Hewan {
    /**
     * variabel delay bertipe int
     */
    private int delay;
    /**
     * variabel timer bertipe int
     */
    private int timer;
    /**
     * variabel arah bertipe int
     */
    private int arah;
    
    /**
     * lahir harus langsung punya koordinat
     *  karakter elang adalah E
     * @param id parameter input id elang
     * @param x parameter input koordinat x elang
     * @param y parameter input koordinat y elang
     */
    Elang(int id, int x, int y) {
        super(id, x, y, 'E');
        timer = 0;
        getArahRandom();
        Random rand = new Random();
        /**
         * nextInt is normally exclusive of the top value,
         * so add 1 to make it inclusive
         */
        int min = 1; 
        int max = 3;
        delay = rand.nextInt((max - min) + 1) + min;
        delay = 0;
        ImageIcon ii = new ImageIcon("img3.png");
        image = ii.getImage();
    }

    /**
     * prosedur untuk mendapatkan arah random
     */
    private void getArahRandom() {
        int min = 1;
        int max = 8;
        Random rand = new Random();
        arah = rand.nextInt((max - min) +1) + min;
    }

    /**
     * fungsi boolean untuk melakukan pengecekan apakah terdapat tabrakan atau tidak
     * @param x input parameter koordinat x
     * @param y input parameter koordinat y
     * @return return true is coordinate is on boundaries defined
     */
    private boolean isCollision(int x, int y) {
        if (x>0 && x<(Settings.BOARD_WIDTH - 1) && y>0 && y<(Settings.BOARD_HEIGHT - 1)){
                return false;
        }else {
                return true;
        }	
    }

    /**
     * melakukan pengeceka apakah arahnya sama atau tidak dengan korelasi arah berikut ini.
     * korelasi arah :
     *  dinding kanan : 1, 5, 6
     *  dinding kiri	: 3, 7, 8
     *  dinding atas 	: 2, 5, 6
     *  dinding bawah 	: 4, 6, 8	
     * @param temp parameter input arah
     * @return return true if the direction is same
     */
    private boolean isSameDirection(int temp) {
        if (((temp==1 || temp==5 || temp==6) && (arah==1 || arah==5 || arah==6)) ||
                ((temp==3 || temp==7 || temp==8) && (arah==3 || arah==7 || arah==8)) ||
                ((temp==2 || temp==5 || temp==6) && (arah==2 || arah==5 || arah==6)) ||
                ((temp==4 || temp==6 || temp==8) && (arah==4 || arah==6 || arah==8)) )
                return true;
        else
                return false;
    }

    /**
     * prosedur untuk mengubah koordinat x dan y elang
     * menjadi koordinat baru
     */
    public void gerak() {
        int xx, yy;
        xx = getX();
        yy = getY();

        timer++;
        if(timer > delay) {
            timer = 0;
            if (!isCollision(xx,yy)){
                switch(arah){
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
                }
            } else {
                if (xx >= (Settings.BOARD_WIDTH - 1))
                    xx=(Settings.BOARD_WIDTH - 2);
                else if (xx <= 0)
                    xx=1;
                if (yy >= (Settings.BOARD_HEIGHT - 1))
                    yy=(Settings.BOARD_HEIGHT -2);
                else if (yy <= 0)
                    yy=1;
                int temp = arah;
                boolean cek = true;
                int min = 1;
                int max = 8;
                Random rand = new Random();
                arah = rand.nextInt((max - min) + 1) + min;

                while(cek){
                    if (isSameDirection(temp)){
                            min = 1;
                            max = 8;
                            arah = rand.nextInt((max - min) + 1) + min;
                    }else{
                            cek = false;
                    }
                }
            }
            SetPoint(xx,yy);
        }
    }	
		
}