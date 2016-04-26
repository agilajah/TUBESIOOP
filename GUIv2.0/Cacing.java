import javax.swing.ImageIcon;
import java.awt.Image;


/**
 * kelas cacing turunan dari hewan
 * @author Febi Agil / 13514010
 */
class Cacing extends Hewan {
    /**
     * boolean arah atas
     */
    private boolean up;
    /**
     * boolean arah bawah
     */
    private boolean down;
    /**
     * boolean arah kanan
     */
    private boolean right;
    /**
     * boolean arah kiri
     */
    private boolean left;

    /**
     * Konstruktor cacing
     * karakter cacing adalah 'C'
     * @param id parameter input id cacing
     * @param x parameter input koordinat x cacing
     * @param y parameter input koordinat y cacing
     */
    Cacing(int id, int x, int y) {
        super(id, x, y, 'C');
        up = false;
        down = false;
        right = false;
        left = false;
        ImageIcon ii = new ImageIcon("img4.png");
        image = ii.getImage();
    }

    /**
     * boolean untuk mengecek apakah arah sudah di inisialisasi atau belum
     * @return return true if unitialized
     */
    public boolean isDirectionsNotInitialized() {				
        if (!up && !down && !right && !left)
            return true;
        else
            return false;
    }

    /**
     * boolean untuk melakukan checking apakah cacing menabrak dinding atas/bawah atau tidak
     * @param yy input parameter koordinat y
     * @return return ture if hit the bottom and upper wall
     */
    public boolean isYHitTheWall(int yy) {
        if (yy<=0 || yy>=(Settings.BOARD_HEIGHT -1)) 
            return true;
        else
            return false;
    }

    /**
     * prosedur untuk mengubah koordinat x dan y cacing
     * menjadi koordinat baru
     */
    public void gerak() {
        int xx, yy;
        xx = getX();
        yy = getY();

        if (isDirectionsNotInitialized()){
                up=true;
                right=true;
        }

        if (!isYHitTheWall(yy)){
            if (up && !down){
                yy--;
            }else if (!up && down){
                yy++;
            }
        }else{
            if (right && !left){
                xx++;
            }else if (!right && left){
                xx--;
            }

            if (xx>= (Settings.BOARD_WIDTH - 1) ){
                xx=(Settings.BOARD_WIDTH - 2);
                right = false;
                left = true;
            }else if (xx<=0){
                xx=1;
                right = true;
                left = false;
            }

            if (up && !down){
                yy++;
                up = false;
                down = true;
            }else if (!up && down){
                yy--;
                up = true;
                down = false;
            }
        }
        SetPoint(xx,yy); //SetPoint is method from its class parent, eh? idk
    }
}