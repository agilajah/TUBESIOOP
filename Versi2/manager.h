#include <list>
#include "makhluk.h"
#include "board.h"

#ifndef MANAGER_H
#define MANAGER_H

using namespace std;

class Manager {
//Kelas pengatur kehidupan makhluk pada board
	
public:
	Manager(int x, Board * _board);		//Inisialisasi World Manager dengan x jumlah makhluk pada board
	void spawn();						//Munculkan satu makhluk acak di koordinat acak
	void spawnRandomAmount();			//Munculkan banyak makhluk dengan jumlah acak
	void moveAll();						//Gerakkan seluruh makhluk di dalam board
	void displayListOfMakhluk();		//Tampilkan informasi makhluk yang ada di dalam board
	void resolveConflict();				//Menangani kasus konflik persiangan kehidupan dalam board
	void kill(int ID);					//Mematikan makhluk dengan ID tertentu
	

private:
	list<Makhluk*> ListOfMakhluk;		//List of Makhluk, menggunakan STL
	Board * board;						//Pointer ke board yang aktif
	int nSpawned;						//Jumlah makhluk yang telah dimunculkan		
	int nLife;							//Jumlah makhluk yang masih ada di board
};

#endif
