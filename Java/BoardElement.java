public class BoardElement {
	private char element[];
	private int ID[];

	public BoardElement(){
		element = new char [2];
		ID = new int[2];
		element[0] = '0';
		element[1] = '0';
		ID[0] = -1;
		ID[1] = -1;
	}

	public void setBoardElement(int idx, int ID, char element){
		this.ID[idx] = ID;
		this.element[idx] = element; 
	}

	public int getID(int idx){
		return ID[idx];
	}

	public char getCharacter(int idx){
		return element[idx];
	}

	public int isConflict(){
		int result = 0;
		if ((ID[0] != -1) && (ID[1] != -1)) {
			result = 1;
		}
		return result;
	}

	public int isAvailable(){
		int result = 0;
		if (isSlotOneAvailable() || isSlotTwoAvailable()) {
			result = 1;
		}
		return result;
	}

	public boolean isSlotOneAvailable(){
		return (ID[0] == -1);
	}

	public boolean isSlotTwoAvailable(){
		return (ID[1] == -1);
	}

	public void clearBoardElement(int idx){
		element[idx] = '0';
		ID[idx] = -1;
	}

	public void downgradeElement(){
		element[0] = element[1];
		ID[0] = ID[1];
		clearBoardElement(1);
	}

}