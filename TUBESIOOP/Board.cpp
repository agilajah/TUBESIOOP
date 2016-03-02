#include <iostream>
#include "Board.h"

using namespace std;


//constructor
Board::Board() {
	//initialize all element in matrix with zero
	for (int i=0; i<MAX; i++) {
		for (int j=0; i<MAX; i++) {
			mtr[i][j] = 0;
		}
	}
}

//Displaying current state of Board
void Board::Display() {
	//do something useful here
}

void Board::MovePoint() {

}