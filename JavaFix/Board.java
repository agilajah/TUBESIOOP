import java.lang.Math;

/**
 * class Board untuk papan permainan
 * @author Adi Purnama / 13514006
 */
public class Board {

	/**
     * variabel array of BoardElement
     */
	private BoardElement elem[][];


	/**
     * Konstruktor Board
     */
	public Board(){
		elem = new BoardElement[80][30];
		for (int i = 0 ; i<80 ; i++){
			for (int j = 0 ; j <30 ; j++){
				elem[i][j] = new BoardElement();
			}
		}
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
     * untuk mendapatkan karakter di board dengan koordinat x dan y
     * @param x input parameter koordinat x
     * @param y input parameter koordinat y
     * @return mengembalikan karakter di board dengan koordinat x dan y
     */
	public char getCharacter(int x, int y){
		return elem[x][y].getCharacter(0);
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
     * @return array of int, int[0] berisi ID1, int[1] berisi ID2
     */
	public int[] getFighterID(int x, int y){
		int temp[] = new int[2];
		temp[0] = elem[x][y].getID(0);
		temp[1] = elem[x][y].getID(1);
		return temp;
	}

	/**
     * Mengeluarkan karakter objek yang saling bersaing
     * @param x parameter input koordinat x
     * @param y parameter input koordinat y
     * @return array of char, char[0] berisi char1, char[1] berisi char2
     */
	public char[] getFighterClass(int x, int y){
		char temp[] = new char[2];
		temp[0] = elem[x][y].getCharacter(0);
		temp[1] = elem[x][y].getCharacter(1);
		return temp;
	}


	/**
     * untuk mendapatkan koordinat yang tersedia (available)
     * @return mengembalikan koordinate yang tersedia
     */	
	public int[] getAvailableCoordinate(){
		int temp[] = new int[2];

		do {
			temp[0] = (int) Math.floor(Math.random() * 79 );
			temp[1] = (int) Math.floor(Math.random() * 29);
 		}
 		while (isCoordinateAvailable(temp[0],temp[1]) != 1);

 		return temp;
	}

}