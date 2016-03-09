#include <cstdlib>
#include <stdlib.h>
#include <time.h>
#include <iostream>
#include "makhluk.h"
#include "Point.h"

using namespace std;

void Ayam::gerak() {
	srand(rand() % 100);
	int arah;
	int oldx = getX();
	int oldy = getY();
	int x = oldx;
	int y = oldy;
	bool isValidMove = false;
	
	while (!isValidMove) {
	arah = (rand() % 8) + 1;
	switch(arah) {
		case 1 : x--;
				 y++;
				 break;
		case 2 : y++;
				 break;
		case 3 : x++;
				 y++;
				 break;
		case 4 : x++;
				 break;
		case 5 : x++;
				 y--;
				 break;
		case 6:	 y--;
				 break;
		case 7 : y--;
				 x--;
				 break;
		case 8 : x--;
				 break;
	}

		if (x>=146 || x <0 || y>=40 || y <0 ){
			x = oldx;
			y = oldy;
			
		}
		else {
			isValidMove = true;
		}
	}
		SetPoint(x,y);
}
