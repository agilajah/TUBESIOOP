/*
	Manager.h
	Mengatur pergerakan setiap objek pada board	
*/
#ifndef MANAGER_H
#define MANAGER_H

#include "makhluk.h"
#include "board.h"
#include <thread>
#include <list>
#include <mutex>
#include <condition_variable>
using namespace std;

class Manager {
	public:
		Manager(int x, Board * _board);						//Inisialisasi World Manager dengan x jumlah makhluk pada board
		void spawn();										//Munculkan satu thread berjenis acak di koordinat acak
		void spawnRandomAmount();							//Munculkan banyak thread dengan jumlah acak
		void moveAll();										//Gerakkan seluruh thread 
		void populationControl();							//Kontrol populasi pada keseluruhan world
		void threadRoutine(int id);							//Prosedur thread
		void createNew(Makhluk**,int);						//Buat objek baru secara acak
		void getCoordinate(Makhluk*, int&, int&);			//Dapatkan koordinat dari sebuah objek
		bool winnerCheck(char,char);						//Algoritma persaingan antar thread
		void moveOneThread(Makhluk ** t, bool& isLiving); 	//Gerakkan objek pada sebuah thread
		int threadConflictCheck(Makhluk **t);				//Menangani kasus konflik persaingan kehidupan dalam thread

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
