#ifndef BOARD_H
#define BOARD_H

#include "point.h"
using namespace std;

struct mtrk {
	char element[2];
	int ID[2];
	mtrk(char c='0'){
		element[0]=c;
		element[1]=c;
		ID[0]=-1;
		ID[1]=-1;
	}
};

class Board{
	public:
		Board(); // constructor
		void Display();								//Tampilkan isi board
		bool isCoordinateAvailable(int, int);		//Bernilai true jika koordinat dapat ditempati objek
		void setPoint(int, int, char, int);			//Menempatkan objek pada koordinat
		void clearPoint(int, int, int);				//Menghapus objek pada koordinat
		char getKarakter(int,int);					//Mengelukarkan karakter pada koordinat
		bool isConflictArea(int,int);				//Mengecek apakah koordinat merupakan tempat terjadi konflik
		void getFighterID(int,int,int&,int&);		//Mengeluarkan ID objek yang saling bersaing
		void getFighterClass(int,int,char&,char&);	//Mengeluarkan kelas-kelas objek yang bersaing
		void getAvailableCoordinate(int&, int&);	//Mengeluarkan koordinat yang masih bisa ditempati
	private:
		mtrk mtr[150][45];							//Struktur infromasi setiap sel pada koordinat
};
#endif
