#include "manager.h"
#include <iostream>
#include <cstdlib>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <string>
#include <thread>
#include <list>
#include <mutex>
#include <condition_variable>
#define P1_LOST 0
#define P2_LOST 1
#define NO_CONFLICT 2

using namespace std;

Manager::Manager(int x, Board * _board): board() {
	board = _board;
	srand(time(NULL));
	nSpawned = 0;
	nLife = 0;
	ready = false;
	for ( int i = 1 ; i<= 10 ; i++) {
		spawn();
	}
}

//Membuat objek makhluk baru secara acak
void Manager::createNew(Makhluk ** t, int id){
	int classType,x,y;
	board->getAvailableCoordinate(x,y);
	classType = (rand() % 4) + 1;
	switch (classType) {
		case 1 	:	*t = new Elang(id,x,y);
					break;
		case 2	:	*t = new Ayam(id,x,y);
					break;
		case 3	:	*t = new Cacing(id,x,y);
					break;
		case 4 	:	*t = new Rumput(id,x,y);
					break;
	}
	board->setPoint(x,y, (*t)->GetKarakter(), id);
}


void Manager::getCoordinate(Makhluk * t, int& x , int& y){
	x = t->getX();
	y = t->getY();
}

//Fungsi untuk menentukan pemenang persaingan kehidupan
bool Manager::winnerCheck(char C1, char C2){
	return (((C1 == 'E') && (C2=='A')) || (C1 == C2) || ((C1 == 'A') && (C2 == 'C'))
			|| ((C1 == 'E') && (C2=='C')) || (C2 == 'R') || ((C1=='X') && (C2=='E'))); 	
}

//Cek konflik yang terjadi pada sebuah thread
//Mengembalikan P2_LOST jika objek kedua pada koordinat thread kalah
//Mengembalikan P1_LOST jika objek pertama pada koordinat thread kalah
//Mengembalikan NO_CONFLICT jika tidak ada persaingan kehidupan pada
//koordinat thread
int Manager::threadConflictCheck(Makhluk **t){
	int result,X,Y,newX,newY,ID1,ID2;
	char C1,C2;

	getCoordinate((*t),X,Y);
	if (board->isConflictArea(X,Y)) {
		board->getFighterID(newX,newY,ID1,ID2);
		board->getFighterClass(newX,newY,C1,C2);
		if (winnerCheck(C1,C2)) {
			board->clearPoint(newX,newY,ID2);
			result = P2_LOST;
		}
		else{
			board->clearPoint(newX,newY,ID1);
			result = P1_LOST;
		}
		nLife--;
	}
	else {
		result = NO_CONFLICT;
	}
	return result;

}


//Menggereakkan sebuah objek thread 
void Manager::moveOneThread(Makhluk ** t, bool& isLiving){
	int oldX,oldY,newX,newY,ID1,ID2;
	char C1,C2;

	//Kasus jika sebelum bergerak, thread sudah mengalami persaingan 
	//kehidupan
	if (threadConflictCheck(t) == P1_LOST) {
		isLiving = false;
	}
	else {
		getCoordinate(*t,oldX,oldY);
		(*t)->gerak();
		getCoordinate(*t,newX,newY);

		//Kasus jika koordinat tujuan thread dapat ditempati
		if (board->cekKosong(newX,newY)) {

				//Pindah lokasi
				board->clearPoint(oldX,oldY,(*t)->GetID());
				board->setPoint(newX,newY,(*t)->GetKarakter(),(*t)->GetID());	

				//Tangani persaingan kehidupan pada koordinat tujuan
				if (threadConflictCheck(t) == P2_LOST) {
					isLiving = false;
				}

			}
		//Jika koordinat tujuan thread tidak dapat ditempati
		//Kembali ke tempat semula
		else {
			(*t)->SetPoint(oldX,oldY);
		}
	}
}


//Prosedur yang dijalankan thread
//Menunggu sinyal untuk bergerak
//Ulangi terus selama thread masih hidup (isLiving)
void Manager::threadRoutine(int id) {
	bool isLiving = true;
	std::unique_lock<std::mutex> lck(mtx);	
	Makhluk * t;
	createNew(&t,id);

	while (isLiving) {
		while ( (!ready) ) cv.wait(lck);
		moveOneThread(&t,isLiving);		
		ready=false;			
	}
}


//Memunculkan sebuah thread baru
void Manager::spawn(){
	nSpawned++;
	nLife++;
	ListOfMakhluk.push_back(thread (&Manager::threadRoutine, this,nSpawned));
}


//Memunculkan beberapa thread secara acak
void Manager::spawnRandomAmount(){
	int amount = ( rand() % 50 ) + 1;
	for (int i = 1 ; i<amount ; i++) spawn(); 
}


//Menggerakkan seluruh thread 
void Manager::moveAll(){
	std::unique_lock<std::mutex> lck(mtx);
	ready = true;
	cv.notify_all();
	resolveConflict();
}


//Kontrol populasi
//Memastikan bahwa thread muncul otomatis jika populasi menurun
void Manager::resolveConflict(){
	int y,x;
	int ID1,ID2;
	char C1,C2;

	for (int y  = 0 ; y <40 ; y++) {
		for (int x = 0 ; x<146 ;x++ ){
			if ( board->isConflictArea(x,y) ){
				board->getFighterID(x,y,ID1,ID2);
				board->getFighterClass(x,y,C1,C2);
				
				if (winnerCheck(C1,C2)) {
					board->clearPoint(x,y,ID2);
				}
				else {
					board->clearPoint(x,y,ID1);
				}
				nLife--;
			}
		}
	}
	if (nLife < 30) {
		spawnRandomAmount();	
	}
}