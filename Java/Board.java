import java.lang.Math;

public class Board {
	private BoardElement elem[][];


	public Board(){
		elem = new BoardElement[150][45];
	}

	public int isCoordinateAvailable(int x, int y){
		return elem[x][y].isAvailable();
	}

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


	public void clearPoint(int x, int y, int id){
		if( elem[x][y].getID(0) == id) {
			elem[x][y].clearBoardElement(0);
			elem[x][y].downgradeElement();
		}
		else if ( elem[x][y].getID(1) == id) {
			elem[x][y].clearBoardElement(0);
		}
	}


	public char getKarakter(int x,int y){					//! Mengelukarkan karakter pada koordinat
		return elem[x][y].getCharacter(0);
	}
		
	public boolean isConflictArea(int x,int y){
		int result = elem[x][y].isConflict();
		if (result == 1) {
			return true;
		}
		else {
			return false;
		}

	}				//! Mengecek apakah koordinat merupakan tempat terjadi konflik
		
	void getFighterID(int x,int y , Integer ID1 , Integer ID2){
		ID1 = new Integer(elem[x][y].getID(0));
		ID2 = new Integer(elem[x][y].getID(1));

	}		//! Mengeluarkan ID objek yang saling bersaing

	void getFighterClass(int x,int y,Character C1,Character C2) {
		C1 = new Character(elem[x][y].getCharacter(0));
		C2 = new Character(elem[x][y].getCharacter(1));
	}	
		
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