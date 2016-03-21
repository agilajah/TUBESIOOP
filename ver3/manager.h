#include "makhluk.h"
#include "board.h"
#include <thread>
#include <list>
#include <mutex>
#include <condition_variable>


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
	void resolveConflict();				//Menangani kasus konflik persiangan kehidupan dalam board
	void threadRoutine(int id);			//Prosedur thread
	void createNew(Makhluk**,int);		//Buat objek baru secara acak
	void getCoordinate(Makhluk*, int&, int&);	//Dapatkan koordinat dari sebuah objek
	bool winnerCheck(char,char);				//Algoritma persaingan kehidupan
	void moveOneThread(Makhluk ** t, bool& isLiving); //Gerakkan objek pada sebuah thread
	int threadConflictCheck(Makhluk **t);		//Menangani kasus konflik persaingan kehidupan dalam thread

	
private:
	list<thread> ListOfMakhluk;			//List of Makhluk, menggunakan STL
	Board * board;						//Pointer ke board yang aktif
	int nSpawned;						//Jumlah makhluk yang telah dimunculkan		
	int nLife;							//Jumlah makhluk yang masih ada di board
	mutex mtx;							//Mutex, untuk sinkronisasi antar thread
	condition_variable cv;				//CV , sinkronisasi antar thread
	bool ready;							//Penanda instruksi dari manager ke seluruh thread
};

#endif
