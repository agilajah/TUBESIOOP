/**
 *
 * @author Amal Qurany / 13514078
 */
public abstract class Tumbuhan extends Makhluk{
    /**
     * parameter untuk waktu tumbuh tumbuhan
     */
    protected int growTime;

    /**
     * konstruktor tumbuhan
     * @param id parameter input id tumbuhan
     * @param x parameter input koordinat x tumbuhan
     * @param y parameter input koordinat y tumbuhan
     * @param karakter 
     */
    public Tumbuhan(int id, int x, int y, char karakter){
        super(id, x, y, karakter);
    }

    /**
     * prosedur gerak sebagi parent dari turunannya.
     * prosedur ini kosong dan akan di implementasikan di kelas turunannya.
     */
    public abstract void gerak();
}