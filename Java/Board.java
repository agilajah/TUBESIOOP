
/**
 *
 * @author Adi Purnama / 13514006
 */
public class Board {
    /**
    * elem matriks untuk papan penampil makhluk
    */
    private BoardElement elem[][];

    /**
    * Konstruktor Board untuk menginisiasi elem[][]
    */
    public Board(){
            elem = new BoardElement[150][45];
    }

    /**
     * untuk melakukan pengecekan apakah kordinatnya tersedia atau tidak
     * @param x input koordinat x
     * @param y input koordinat y
     * @return mengembalikan 1 jika ada dan 0 jika tidak ada
     */
    public int isCoordinateAvailable(int x, int y){
            return elem[x][y].isAvailable();
    }

    /**
     * melakukan setPoint dengan inisialisasi 4 parameter yaitu x,y,element, dan id
     * @param x koordinat x
     * @param y koordinat y
     * @param element parameter element
     * @param id parameter id
     */
    public void setPoint(int x, int y, char element, int id){
        if (isCoordinateAvailable(x,y) == 1) {
            if (elem[x][y].isSlotOneAvailable()) {
                    elem[x][y].setBoardElement(0,id,element);
            }
            else {
                    elem[x][y].setBoardElement(1,id,element);
            }
        }
    }

    /**
     * untuk menghapus point
     * @param x parameter input koordinat x
     * @param y parameter input koordinat y
     * @param id parameter input id makhluk
     */
    public void clearPoint(int x, int y, int id){
            if( elem[x][y].getID(0) == id) {
                    elem[x][y].clearBoardElement(0);
                    elem[x][y].downgradeElement();
            }
            else if ( elem[x][y].getID(1) == id) {
                    elem[x][y].clearBoardElement(0);
            }
    }

    /**
     * untuk mendapatkan karakter di board dengan koordinat x dan y
     * @param x input parameter koordinat x
     * @param y input parameter koordinat y
     * @return mengembalikan karakter di board dengan koordinat x dan y
     */
    public char getKarakter(int x,int y){//! Mengelukarkan karakter pada koordinat
            return elem[x][y].getCharacter(0);
    }

    /**
     * melakukan pengecekan boolean apakah pada koordinat x y terjadi conflict atau tidak
     * @param x parameter input koordinat x
     * @param y parameter input koordinat y
     * @return mengembalikan true jika ada confloct dan false jika tidak ada conflict
     */
    public boolean isConflictArea(int x,int y){
            int result = elem[x][y].isConflict();
            if (result == 1) {
                    return true;
            }
            else {
                    return false;
            }

    }				

    /**
     * Mengeluarkan ID objek yang saling bersaing
     * @param x parameter input koordinat x
     * @param y parameter input koordinat y
     * @param ID1 parameter input/output ID1
     * @param ID2 parameter input/output ID2
     */
    void getFighterID(int x,int y , Integer ID1 , Integer ID2){
            ID1 = new Integer(elem[x][y].getID(0));
            ID2 = new Integer(elem[x][y].getID(1));

    }

    /**
     * Mengeluarkan karakter objek yang saling bersaing
     * @param x parameter input koordinat x
     * @param y parameter input koordinat y
     * @param C1 parameter input/output C1
     * @param C2 paramter input/output C2
     */
    void getFighterClass(int x,int y,Character C1,Character C2) {
            C1 = new Character(elem[x][y].getCharacter(0));
            C2 = new Character(elem[x][y].getCharacter(1));
    }	

    /**
     * untuk mendapatkan koordinat yang tersedia (available)
     * @param x parameter input koordinat x
     * @param y parameter input koordinat y
     */
    void getAvailableCoordinate(Integer x, Integer y){
            int x_;
            int y_;


            do {
                    x_ = (int) Math.floor(Math.random() * 145 );
                    y_ = (int) Math.floor(Math.random() * 39);
            }
            while (isCoordinateAvailable(x_,y_) != 1);

            x = new Integer(x_);
            y = new Integer(y_);

    }
}
