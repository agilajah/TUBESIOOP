
/**
 *
 * @author Ghifari
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


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
    public void Plugin(int x, Board _board){
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
	Integer x,y,id,classType;
	boolean isCoordinateAvailable = false;
        Random rand = new Random();
	Makhluk t;
        x = new Integer(0);
        y = new Integer(0);
        t = new Makhluk();
        
        /// cek apakah berjalan baik disini saat passing parameter
	board.getAvailableCoordinate(x,y);

	nSpawned++;
	nLife++;
	id = nSpawned;

	classType = rand.nextInt(4) + 1;
	switch (classType) {
            case 1 	:   t = new Elang(id,x,y);
                                break;
            case 2	:   t = new Ayam(id,x,y);
                                break;
            case 3	:   t = new Cacing(id,x,y);
                                break;
            case 4 	:   t = new Rumput(id,x,y);
                                break;
	}
	ListOfMakhluk.add(t);
	board.setPoint(x,y, t.GetKarakter(), id);
    }
    
    /**
     * spawnRandomAmount adalah prosedur untuk memunculkan makhluk dengan banyaknya random
     */
    void spawnRandomAmount(){
        Random rand = new Random();
	int amount = rand.nextInt(50) + 1;
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
            if (board.isCoordinateAvailable(newX,newY)) {
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
	Integer ID1 = new Integer(-1);
        Integer ID2 = new Integer(-1);
        
	Character C1 = new Character('0');
        Character C2 = new Character('0');

	for (int y  = 0 ; y <40 ; y++) {
            for (int x = 0 ; x<146 ;x++ ){
                if (board.isConflictArea(x,y) ){
                    board.getFighterID(x,y,ID1,ID2);
                    board.getFighterClass(x,y,C1,C2);
                    
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

	if (nLife < 30) {
            spawnRandomAmount();	
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