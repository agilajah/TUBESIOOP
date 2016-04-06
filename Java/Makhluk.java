
/**
 *
 * @author Amal Qurany / 13514078
 */
public abstract class Makhluk{
	
    /**
     * variabel integer id
     */
    private int id;
    /**
     * variabel integer kekuatan
     */
    private int kekuatan;
    /**
     * variabel Point P
     */
    private Point P;
    /**
     * variabel karakter bertipe char
     */
    private char karakter;

    /**
     * konstruktor makhluk dengan 5 parameter
     * @param id parameter input id makhluk
     * @param x parameter input koordinat x makhluk
     * @param y parameter input koordinat y makhluk
     * @param karakter parameter input karakter makhluk
     * @param kekuatan paramter input kekuatan makhluk
     */
    Makhluk(int id, int x, int y, char karakter, int kekuatan){
		SetID(id);
		P = new Point(x,y);
		SetKarakter(karakter);
		SetKekuatan(kekuatan);
    }

    /**
     * konstruktor makhluk dengan 4 parameter
     * @param id parameter input id makhluk
     * @param x parameter input koordinat x makhluk
     * @param y parameter input koordinat y makhluk
     * @param karakter parameter input karakter makhluk
     */
    Makhluk(int id, int x, int y, char karakter){
		SetID(id);
		P = new Point(x,y);
		SetKarakter(karakter);
		SetKekuatan(0);
    }

    /**
     * prosedur untuk set ID
     * @param id parameter id makhluk
     */
    public void SetID(int id){
        this.id = id;
    }

    /**
     * prosedur untuk set point x dan y
     * @param x input parameter koordinat x
     * @param y input parameter koordinat y
     */
    public void SetPoint(int x, int y){
        P.SetXY(x,y);
    }

    /**
     * prosedur untuk set karakter
     * @param karakter input parameter karakter
     */
    public void SetKarakter(char karakter){
        this.karakter = karakter;
    }

    /**
     * prosedur setter kekuatan
     * @param kekuatan input parameter kekuatan 
     */
    public void SetKekuatan(int kekuatan){
            this.kekuatan = kekuatan;
    }

    /**
     * getter ID
     * @return mengembalikan variabel id
     */
    public int GetID(){
        return id;
    }

    /**
     * getter x
     * @return mengembalikan x
     */
    public int getX(){
        return P.GetX();
    }

    /**
     * getter y
     * @return mengembalikan y
     */
    public int getY(){
        return P.GetY();
    }

    /**
     * getter Point
     * @return mengembalikan point P
     */
    public Point GetPoint(){
        return P;
    }

    /**
     * getter karakter
     * @return mengembalikan karakter char
     */
    public char GetKarakter(){
        return karakter;	
    }

    /**
     * getter kekuatan
     * @return mengembalikan kekuatan makhluk
     */
    public int GetKekuatan(){
        return kekuatan;
    }

    /**
     * prosedur untuk mencetak point P
     */
    public void PrintPos(){
        P.Print();
    }

    /**
     * prosedur gerak sebagi parent dari turunannya.
     * prosedur ini kosong dan akan di implementasikan di kelas turunan.
     */
    public abstract void gerak();
}
