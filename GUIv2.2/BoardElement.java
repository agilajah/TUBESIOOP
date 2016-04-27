/**
 *
 * @author Adi Purnama / 13514006
 */

public class BoardElement {
	/**
     * variabel element array bertipe char.
     */
	private char[] element;

	/**
     * variabel ID array bertipe int.
     */
	private int[] ID;

	/**
     * konstruktor BoardElement.
     */
	public BoardElement() {
		element = new char[2];
		ID = new int[2];
		element[0] = 0;
		element[1] = 0;
		ID[0] = -1;
		ID[1] = -1;
	}

	/**
     * untuk melakukan set pada ID dan element.
     * @param idx parameter input indeks
     * @param ID parameter input ID
     * @param element parameter input karakter element
     */
	public void setBoardElement(final int idx,
								final int ID, final char element) {
		this.ID[idx] = ID;
		this.element[idx] = element;
	}

	 /**
	 * parameter untuk mendapatkan ID.
	 * @param idx parameter input indeks array
	 * @return mengembalikan ID dengan indeks ke idx
	 */
	public int getID(final int idx) {
		return ID[idx];
	}

	/**
     * untuk mendapatkan karakter dengan indeks ke idx.
     * @param idx input indeks array element
     * @return mengembalikan element dengan indeks ke idx
     */
	public char getCharacter(final int idx) {
		return element[idx];
	}

	/**
     * melakukan pengecekan apakah ada konflik atau tidak.
     * @return mengembalikan 0 jika tidak ada konflik dan 1 jika ada konflik
     */
	public int isConflict() {
		int result = 0;
		if ((ID[0] != -1) && (ID[1] != -1)) {
			result = 1;
		}
		return result;
	}

	/**
     * melakukan pengecekan apakah tersedia.
     * @return mengembalikan 1 jika tersedia dan 0 jika tidak tersedia
     */
	public int isAvailable() {
		int result = 0;
		if (isSlotOneAvailable() || isSlotTwoAvailable()) {
			result = 1;
		}
		return result;
	}

	/**
     * melakukan pengecekan apakah ID dengan indeks ke 0 tersedia atau tidak.
     * @return mengembalikan true jika indeks ID ke 0 == -1
     */
	public boolean isSlotOneAvailable() {
		return (ID[0] == -1);
	}

	/**
     * melakukan pengecekan apakah ID dengan indeks ke 1 tersedia atau tidak.
     * @return mengembalikan true jika indeks ID ke 1 == -1
     */
	public boolean isSlotTwoAvailable() {
		return (ID[1] == -1);
	}

	/**
     * menghapus board pada element ke idx.
     * @param idx input parameter idx
     */
	public void clearBoardElement(final int idx) {
		element[idx] = 0;
		ID[idx] = -1;
	}

	/**
     * untuk downgrade element dari lv1 ke lv 0 pada element.
     */
	public void downgradeElement() {
		element[0] = element[1];
		ID[0] = ID[1];
		clearBoardElement(1);
	}

}