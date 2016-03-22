#include "List.cpp"
//#include <list>
#include "manager.h"
#include <iostream>
#include <cstdlib>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <string>

using namespace std;


Manager::Manager(int x, Board * _board): board() {
	board = _board;
	srand(time(NULL));
	nSpawned = 0;
	nLife = 0;
	for ( int i = 1 ; i<= x ; i++) {
		spawn();
	}
	
}

void Manager::spawn(){
	int x,y,id,typeClass;
	bool isCoordinateAvailable = false;
	Makhluk * t;


		do {
			 x = (rand() % 146) ;
			 y = (rand() % 39) ;
		}
		while (!board->isCoordinateAvailable(x,y));
			

		nSpawned++;
		nLife++;
		id = nSpawned;

		typeClass = (rand() % 4) + 1;
		switch (typeClass) {
			case 1 	:	t = new Elang(id,x,y);
						break;
			case 2	:	t = new Ayam(id,x,y);
						break;
			case 3	:	t = new Cacing(id,x,y);
						break;
			case 4 	:	t = new Rumput(id,x,y);
						break;
		}
		ListOfMakhluk.push_back(t);
		board->setPoint(x,y, t->GetKarakter(), id);
}


void Manager::spawnRandomAmount(){
	int amount = ( rand() % 50 ) + 1;
	for (int i = 1 ; i<amount ; i++) spawn(); 

}

void Manager::moveAll(){
	int oldX,oldY,newX,newY;
	bool isCoordinateAvailable ;

	Node<Makhluk*>* ci;
    ci = ListOfMakhluk.begin(); 

	while (ci != ListOfMakhluk.end()){
		oldX = (ci->info)->getX();
		oldY = (ci->info)->getY();
		isCoordinateAvailable = false;

		(ci->info)->gerak();
		newX = (ci->info)->getX();
		newY = (ci->info)->getY();
		if (board->isCoordinateAvailable(newX,newY)) {
			isCoordinateAvailable = true;
			board->clearPoint(oldX,oldY,(ci->info)->GetID());
			board->setPoint(newX,newY,(ci->info)->GetKarakter(),(ci->info)->GetID());
		}
		else {
			(ci->info)->SetPoint(oldX,oldY);
		}
		ci = ci->next;
	}
	resolveConflict();
}


void Manager::displayListOfMakhluk(){
	for (list<Makhluk *>::iterator ci = ListOfMakhluk.begin() ; ci != ListOfMakhluk.end() ; ++ci) {		
		cout << "ID :" << (ci->info)->GetID() << " position " << (ci->info)->getX() <<"+" << (ci->info)->getY() << endl;
	}
	
}

void Manager::resolveConflict(){
	int y,x;
	int ID1,ID2;
	char C1,C2;

	for (int y  = 0 ; y <40 ; y++) {
		for (int x = 0 ; x<146 ;x++ ){
			if ( board->isConflictArea(x,y) ){
				board->getFighterID(x,y,ID1,ID2);
				board->getFighterClass(x,y,C1,C2);
				
				if (((C1 == 'E') && (C2=='A')) || (C1 == C2) || ((C1 == 'A') && (C2 == 'C'))
				|| ((C1 == 'E') && (C2=='C')) || (C2 == 'R') || ((C1=='X') && (C2=='E'))
				  ) {
					board->clearPoint(x,y,ID2);
					kill(ID2);
				}
				else {
					board->clearPoint(x,y,ID1);
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


void Manager::kill(int ID){
	bool done = false;
	int IDtarget;

	Node<Makhluk*>* ci = ListOfMakhluk.begin();

	while ((ci != ListOfMakhluk.end()) && (!done)) {
		IDtarget = (ci->info)->GetID();
		if ( IDtarget == ID) {
			ListOfMakhluk.erase(ci->info);
			ci = ci->next;	
			done == true;
		}
		else {
			ci = ci->next;
		}
	}	
}