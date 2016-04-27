import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;


/**.
 * @author Amal Qurany / 13514078
 */
public abstract class Makhluk {
    /**
     * .variabel integer id
     */
    private int id;
    /**
     * .variabel integer kekuatan
     */
    private int kekuatan;
    /** 
     * .variabel Point P
     */
    private Point p;
    /**
     * .variabel karakter bertipe char
     */
    private char karakter;

    protected Image image;

    public Image getImage() {
        return image;
    }


    /**
     * .konstruktor makhluk dengan 5 parameter
     * @param id parameter input id makhluk
     * @param x parameter input koordinat x makhluk
     * @param y parameter input koordinat y makhluk
     * @param karakter parameter input karakter makhluk
     * @param kekuatan paramter input kekuatan makhluk
     */
    Makhluk(int id, int x, int y, char karakter, int kekuatan) {
        setId(id);
        p = new Point(x,y);
        setPoint(x,y);
        setKarakter(karakter);
        setKekuatan(kekuatan);
    }

    /**
     * .konstruktor makhluk dengan 4 parameter
     * @param id parameter input id makhluk
     * @param x parameter input koordinat x makhluk
     * @param y parameter input koordinat y makhluk
     * @param karakter parameter input karakter makhluk
     */
    Makhluk(int id, int x, int y, char karakter) {
        setId(id);
        setPoint(x,y);
        setKarakter(karakter);
        setKekuatan(0);
    }

    /**
     * .prosedur untuk set ID
     * @param id parameter id makhluk
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * .prosedur untuk set point x dan y
     * @param x input parameter koordinat x
     * @param y input parameter koordinat y
     */
    public void setPoint(int x, int y) {
        p.setXY(x,y);
    }

    /**
     * .prosedur untuk set karakter
     * @param karakter input parameter karakter
     */
    public void setKarakter(char karakter) {
        this.karakter = karakter;
    }
    
    /**
     * .prosedur setter kekuatan
     * @param kekuatan input parameter kekuatan 
     */
    public void setKekuatan(int kekuatan) {
        this.kekuatan = kekuatan;
    }

    /**
     * .getter ID
     * @return mengembalikan variabel id
     */
    public int getId() {
        return id;
    }

    /**
     * .getter x
     * @return mengembalikan x
     */
    public int getX() {
        return p.getX();
    }

    /**
     * .getter y
     * @return mengembalikan y
     */
    public int getY() {
        return p.getY();
    }

    /**
     * .getter Point
     * @return mengembalikan point P
     */
    public Point getPoint() {
        return p;
    }

    /**
     * .getter karakter
     * @return mengembalikan karakter char
     */
    public char getKarakter() {
        return karakter;
    }

    /** 
     * .getter kekuatan
     * @return mengembalikan kekuatan makhluk
     */
    public int getKekuatan() {
        return kekuatan;
    }

    /**
     * .prosedur untuk mencetak point P
     */
    public void printPos() {
        p.Print();
    }

    /**Created on April 2016
     * prosedur gerak sebagi parent dari turunannya.
     * prosedur ini kosong dan akan di implementasikan di kelas turunan.
     */
    public abstract void gerak();

    public void cobaMethod(){
        int x = 0;
    }

    /** Returns an ImageIcon, or throwing exceptions if the path was invalid. */
    public ImageIcon createImageIcon(String imagename) throws ImageException {
        String path = "/gambar/" + imagename;
        //URL imgURL = new URL(path);
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            throw new ImageException("Image not found!");
        }
    }
}
