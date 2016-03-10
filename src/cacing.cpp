#include <iostream>
#include "makhluk.h"
#include "Point.h"
using namespace std;

void Cacing::gerak() {
	int xx, yy;
	xx = getX();
	yy = getY();

	state++;

	if (state == 3 ) {
		state = 0;
		//do nothing
	}
	else {

	if (!up && !down && !right && !left){
		up=true;
		right=true;
	}
	
	if (yy>0 && yy<39){
		if (up && !down){
			yy--;
		}else if (!up && down){
			yy++;
		}
	}else{
		if (right && !left){
			xx++;
		}else if (!right && left){
			xx--;
		}

		if (xx>=144){
			xx=143;
			right = false;
			left = true;
		}else if (xx<=0){
			xx=1;
			right = true;
			left = false;
		}

		if (up && !down){
			yy=1;
			up = false;
			down = true;
		}else if (!up && down){
			yy=38;
			up = true;
			down = false	;
		}
	}
	SetPoint(xx,yy);

}

}

