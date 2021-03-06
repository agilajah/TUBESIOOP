#include "board.h"
#include <iostream>

using namespace std;


//constructor
Board::Board() {
	//initialize all element in matrix with zero
	for (int i=0; i<40; i++) {// i adalah y
		for (int j=0; j<146; j++) {// j adalah x
			mtr[j][i].element[0] = '0';
			mtr[j][i].element[1] = '0';
			mtr[j][i].ID[0] = -1;
			mtr[j][i].ID[1] = -1;
		}
	}
	
}

//Displaying current state of Board
void Board::Display(){
	std::system("clear");
	string show;
     for (int i  = 0 ; i <40 ; i++) {
		for (int j = 0 ; j<146 ;j++ ){
			if ( mtr[j][i].element[0] == '0' ) {
				show.push_back('-');
			}
			else {
				show.push_back(mtr[j][i].element[0]);
			}
	}
	}
	cout << show << endl;
}

bool Board::isCoordinateAvailable(int x, int y){
	// melakukan pengecekan apakah element 1 atau 2 ada yang kosong atau tidak
	if (mtr[x][y].element[0]=='0' || mtr[x][y].element[1]=='0') return true;
	else return false;
}


void Board::setPoint(int x, int y, char kar, int ID){
	if (isCoordinateAvailable(x,y)){
		if (mtr[x][y].element[0]=='0'){
			mtr[x][y].element[0]=kar;
			mtr[x][y].ID[0]= ID;

		}else if (mtr[x][y].element[1]=='0'){
			mtr[x][y].element[1]=kar;
			mtr[x][y].ID[1]=ID;		
			}
	}
}

void Board::clearPoint(int x, int y, int ID){
	if (mtr[x][y].ID[0]==ID){
			mtr[x][y].element[0]='0';
			mtr[x][y].ID[0] = -1;
	}else if (mtr[x][y].ID[1]==ID){
			mtr[x][y].element[1]='0';
			mtr[x][y].ID[1]=-1;
	}

}


bool Board::isConflictArea(int x, int y) {
	return ((mtr[x][y].ID[0] != -1) && (mtr[x][y].ID[1] != -1));
}

void Board::getFighterID(int x, int y, int& ID1, int& ID2){
	ID1 = mtr[x][y].ID[0];
	ID2 = mtr[x][y].ID[1];
}

void Board::getFighterClass(int x, int y, char& ID1, char& ID2){
	ID1 = mtr[x][y].element[0];
	ID2 = mtr[x][y].element[1];
}

char Board::getKarakter(int x, int y){
	return mtr[x][y].element[0];
}

void Board::getAvailableCoordinate(int& x, int& y) {
	do {
		 x = (rand() % 146) ;
		 y = (rand() % 39) ;
	}
	while (!isCoordinateAvailable(x,y));
}