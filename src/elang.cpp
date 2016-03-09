#include <iostream>
#include "makhluk.h"
#include "Point.h"
using namespace std;


void Elang::gerak() {
	int xx, yy;
	xx = getX();
	yy = getY();
	bool cek=true;

	if (!up && !down && !right && !left){
		up=true;
		right=true;
	}
	while (cek){
		if (xx>=2 && xx <=73 && yy>=2 && yy<=37){ // ukuran layar 40 x 76
			if (up && !down && right && !left){  // move to up and right
				if (i<7){
					yy--;				
				}else if (i>=7 && i<15){
					xx++;
				}else if (i==15){
					yy--;
					xx++;
					i=0;
				}
				yy--;
			}else if (up && !down && !right && left){ // move to up and left
				if (i<7){
					yy--;				
				}else if (i>=7 && i<15){
					xx--;
				}else if (i==15){
					yy--;
					xx--;
					i=0;
				}
			}else if (!up && down && right && !left){ // move to down and right
				if (i<7){
					yy++;				
				}else if (i>=7 && i<15){
					xx++;
				}else if (i==15){
					yy++;
					xx++;
					i=0;
				}
				yy++;
				xx++;
			}else if (!up && down && !right && left){ // move to down and left
				if (i<7){
					yy++;				
				}else if (i>=7 && i<15){
					xx--;
				}else if (i==15){
					yy++;
					xx--;
					i=0;
				}
				yy++;
				xx--;
			}
			cek=false;
			i++;

		}else {
			if (xx<2){ 
				right=true;
				left=false;
				xx++;
			}else if (xx>73){
				right=false;
				left=true;
				xx--;
			}else if (yy<2){
				up=false;
				down=true;
				yy++;
			}else if (yy>37){
				up=true;
				down=false;
				yy--;
			}
		}
		SetPoint(xx,yy);
	}
}
