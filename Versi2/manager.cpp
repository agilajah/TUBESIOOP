#include "manager.h"
#include <iostream>
#include <list>
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
	int x,y,id,classType;
	bool isCoordinateAvailable = false;
	Makhluk * t;

	/*
	while ( !isCoordinateAvailable ) {
		 x = (rand() % 146) ;
		 y = (rand() % 39) ;
		if (board->cekKosong(x,y)) isCoordinateAvailable = true;
	}
	*/

	board->getAvailableCoordinate(x,y);

	nSpawned++;
	nLife++;
	id = nSpawned;

	classType = (rand() % 4) + 1;
	switch (classType) {
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

	for (list<Makhluk *>::const_iterator ci = ListOfMakhluk.begin() ; ci != ListOfMakhluk.end() ; ++ci) {
		oldX = (*ci)->getX();
		oldY = (*ci)->getY();
		isCoordinateAvailable = false;

		
		(*ci)->gerak();
		newX = (*ci)->getX();
		newY = (*ci)->getY();
		if (board->isCoordinateAvailable(newX,newY)) {
			isCoordinateAvailable = true;
			board->clearPoint(oldX,oldY,(*ci)->GetID());
			board->setPoint(newX,newY,(*ci)->GetKarakter(),(*ci)->GetID());
		}
		else {
			(*ci)->SetPoint(oldX,oldY);
		}
			
	
	}
	resolveConflict();
}



void Manager::displayListOfMakhluk(){
	for (list<Makhluk *>::const_iterator ci = ListOfMakhluk.begin() ; ci != ListOfMakhluk.end() ; ++ci) {		
		cout << "ID :" << (*ci)->GetID() << " position " << (*ci)->getX() <<"+" << (*ci)->getY() << endl;
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

	list<Makhluk*>::iterator ci = ListOfMakhluk.begin();
	while ((ci != ListOfMakhluk.end()) && (!done)) {
		IDtarget = (*ci)->GetID();
		if ( IDtarget == ID) {
			delete (*ci);
			ListOfMakhluk.erase(ci++);	
			done == true;
		}
		else {
			++ci;
		}
	}	

}
	