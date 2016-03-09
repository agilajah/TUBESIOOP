#include "manage.h"
#include <iostream>
#include "List.h"
#include <cstdlib>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <string>

using namespace std;


int Manage::nMakhluk = 0;

Manage::Manage(int x, Board * _board): board() {
	board = _board;
	srand(time(NULL));
	for (int i = 1 ; i<=x; i++){
		AddMakhluk();
	}

} 

void Manage::AddMakhluk(){
	int x,y,id,typeClass;
	bool isCoordinateAvailable = false;
	Makhluk * t;

	while ( !isCoordinateAvailable ) {
		 x = (rand() % 146) ;
		 y = (rand() % 40) ;
		if (board->cekKosong(x,y)) isCoordinateAvailable = true;
	}

	typeClass = (rand() % 3) + 1;
	switch (typeClass) {
		case 1 	:	t = new Ayam(id,x,y);
					break;
		case 2	:	t = new Elang(id,x,y);
					break;
		case 3	:	t = new Cacing(id,x,y);
					break;
	}


	nMakhluk = nMakhluk+ 1;
	id = nMakhluk;
	ListOfMakhluk.push_back(t);
	board->setPoint(x,y, t->GetKarakter(), id);

}

void Manage::GerakAllMakhluk(){
	int oldX,oldY,newX,newY;
	bool isCoordinateAvailable ;

	Node<Makhluk*>* pNode;
	pNode = ListOfMakhluk.first;
	
	//for (list<Makhluk *>::const_iterator ci = ListOfMakhluk.first ; ci != ListOfMakhluk.end() ; ++ci) {
	while (pNode!=NULL){
		oldX = pNode->info->getX();
		oldY = pNode->info->getY();
		isCoordinateAvailable = false;

		while ( !isCoordinateAvailable ){
			pNode->info->gerak();
			newX = pNode->info->getX();
			newY = pNode->info->getY();
			if (board->cekKosong(newX,newY)) {
				isCoordinateAvailable = true;
				board->clearPoint(oldX,oldY,pNode->info->GetID());
				board->setPoint(newX,newY,pNode->info->GetKarakter(),pNode->info->GetID());
			}
			else {
				pNode->info->SetPoint(oldX,oldY);
			}
			
		}
		pNode = pNode->next;
	}

	ResolveConflict();
	
}



void Manage::PrintAllMakhluk(){


	//for (List<Makhluk *>::const_iterator ci = ListOfMakhluk.first ; ci != ListOfMakhluk.end() ; ++ci) {
		
	//	cout << "ID :" << (*ci)->GetID() << " position " << (*ci)->getX() <<"+" << (*ci)->getY() << endl;
	//}
	
}

void Manage::ResolveConflict(){
	int y,x;
	int ID1,ID2;
	char C1,C2;

	for (int y  = 0 ; y <40 ; y++) {
		for (int x = 0 ; x<146 ;x++ ){
			if ( board->isConflictArea(x,y) ){
				board->getFighterID(x,y,ID1,ID2);
				board->getFighterClass(x,y,C1,C2);

				if ( C1 == C2 ){
					board->clearPoint(x,y,ID2);
					Kill(ID2);
				}


			}
	}
}
}



void Manage::Kill(int _ID){
	bool done = false;
	int ID;

	Node<Makhluk*>* pNode;
	pNode = ListOfMakhluk.first;

	//list<Makhluk*>::iterator ci = ListOfMakhluk.first;
	//while ((ci != ListOfMakhluk.end()) && (!done)) {
	while (pNode!=NULL){
		ID = pNode->info->GetID();
		if ( ID == _ID) {
			ListOfMakhluk.erase(pNode->info);	
			done == true;
		}
		pNode = pNode->next;
	}	

}
	