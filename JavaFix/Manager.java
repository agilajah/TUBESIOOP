import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * <h1> Manager </h1>
 * Kelas Manager digunakan untuk mengatur segala aktivitas yang terjadi di papan / Board yang ditampilkan
 * @author Farhan Ghifari / 13515602
 */
public class Manager{
    /**
     * ListOfMakhluk adalah variabel bertipe List<Makhluk>
     * untuk menyimpan list makhluk
     */
    static List<Makhluk> ListOfMakhluk = new ArrayList<Makhluk>();
    /**
     * Board Manager
     */
    Board board = new Board();
    /**
    *   Jumlah makhluk yang telah dimunculkan
    */
    int nSpawned;
    /**
     *  Jumlah makhluk yang masih ada di board
     */
    int nLife;
    
    
    /**
     * 
     * @param x parameter untuk membuat makhluk sebanyak x
     * @param _board parameter inisialisasi board
     */
    public Manager(int x, Board _board){
        board = _board;
        //srand(time(NULL));
        nSpawned = 0;
        nLife = 0;
        for (int i=1;i<=x;i++) {
            spawn();
        }
    }
    
    /**
     * spawn adalah prosedur untuk memunculkan satu makhluk
     */
    void spawn(){
        int id,classType;
        int coordinate[];
        boolean isCoordinateAvailable = false;
            Random rand = new Random();
        Makhluk t;
        t = new Elang(0,0,0);
            
            /// cek apakah berjalan baik disini saat passing parameter
        coordinate = board.getAvailableCoordinate();

        nSpawned++;
        nLife++;
        id = nSpawned;

        classType = rand.nextInt(4) + 1;
        switch (classType) {
            case 1  :   t = new Elang(id,coordinate[0],coordinate[1]);
                                break;
            case 2  :   t = new Ayam(id,coordinate[0],coordinate[1]);
                                break;
            case 3  :   t = new Cacing(id,coordinate[0],coordinate[1]);
                                break;
            case 4  :   t = new Rumput(id,coordinate[0],coordinate[1]);
                                break;
        }
        ListOfMakhluk.add(t);
        board.setPoint(coordinate[0],coordinate[1], t.GetKarakter(), id);
    }
    
    /**
     * spawnRandomAmount adalah prosedur untuk memunculkan makhluk dengan banyaknya random
     */
    void spawnRandomAmount(){
        Random rand = new Random();
        int amount = rand.nextInt(7) + 1;
        for (int i = 1 ; i<amount ; i++) spawn(); 
    }
    
    /**
     * moveAll adalah prosedur untuk membuat semua makhluk bergerak / berpindah
     */
    void moveAll(){
        int oldX,oldY,newX,newY;
        boolean isCoordinateAvailable ;
        
        for (int i=0; i < ListOfMakhluk.size() ; i++) {
            Iterator makluk = ListOfMakhluk.listIterator(i);
            oldX = ListOfMakhluk.get(i).getX();
            oldY = ListOfMakhluk.get(i).getY();
            isCoordinateAvailable = false;

            ListOfMakhluk.get(i).gerak();
            newX = ListOfMakhluk.get(i).getX();
            newY = ListOfMakhluk.get(i).getY();
            if (board.isCoordinateAvailable(newX,newY)==1) {
                isCoordinateAvailable = true;
                board.clearPoint(oldX,oldY,ListOfMakhluk.get(i).GetID());
                board.setPoint(newX,newY,ListOfMakhluk.get(i).GetKarakter(),ListOfMakhluk.get(i).GetID());
            }
            else {
                ListOfMakhluk.get(i).SetPoint(oldX,oldY);
            }
            
    
        }
        resolveConflict();
    }

    /**
     * prosedur untuk menampilkan semua makhluk yang ada di dalam list
     */
    void displayListOfMakhluk(){
        for (int i=0; i < ListOfMakhluk.size() ; i++) {
            System.out.println("ID : " + ListOfMakhluk.get(i).GetID() +
                    " position " + ListOfMakhluk.get(i).getX() + " + " +
                    ListOfMakhluk.get(i).getY());
        }
    }

    /**
     * resolveConflict adalah prosedur untuk menyelesaikan masalah tabrakan yang terjadi di board
     */
    void resolveConflict(){
        int id[];
        char ch[];


        for (int y  = 0 ; y <30 ; y++) {
            for (int x = 0 ; x<80 ;x++ ){
                if (board.isConflictArea(x,y) ){
                    id = board.getFighterID(x,y);
                    ch = board.getFighterClass(x,y);
                    char C1 = ch[0];
                    char C2 = ch[1];
                    int ID1 = id[0];
                    int ID2 = id[1];
                    
                    if (((C1 == 'E') && (C2=='A')) || (C1 == C2) || ((C1 == 'A') && (C2 == 'C'))
                    || ((C1 == 'E') && (C2=='C')) || (C2 == 'R') || ((C1=='X') && (C2=='E'))){
                        board.clearPoint(x,y,ID2);
                        kill(ID2);
                    }
                    else {
                        board.clearPoint(x,y,ID1);
                        kill(ID1);
                    }
                    nLife--;
                }
            }
        }

    }

    /**
     * kill adalah prosedur untuk membunuh makhluk dengan id = ID
     * @param ID adalah parameter untuk membuat makhluk yang memiliki id = ID terbunuh
     */
    void kill(int ID){
        boolean done = false;
        int IDtarget, i=0;
        Iterator<Makhluk> ci = ListOfMakhluk.iterator();

        while (ci.hasNext() && (!done)) {
            IDtarget = ListOfMakhluk.get(i).GetID();
            if (IDtarget == ID) {
                ListOfMakhluk.remove(i);
                done = true;
            }
            else {
                ci.next();
            }
            i++;
        }   

    }
    
    
}
