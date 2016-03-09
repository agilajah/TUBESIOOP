#include <iostream>
#include "makhluk.h"
#include "Point.h"
using namespace std;

void Cacing::gerak() {
	int xx, yy;
	xx = getX();
	yy = getY();
	bool cek=true;

	if (!up && !down && !right && !left){
		up=true;
		right=true;
	}
	while (cek){
		if (xx>=2 && xx <=74 && yy>=2 && yy<=38){
			if (up && !down && right && !left){  // move to up and right
				if (i<1){
					yy--;				
				}else if (i>=1 && i<2){
					xx++;
				}else if (i==2){
					yy--;
					xx++;
					i=0;
				}
			}else if (up && !down && !right && left){ // move to up and left
				if (i<1){
					yy--;				
				}else if (i>=1 && i<2){
					xx--;
				}else if (i==2){
					yy--;
					xx--;
					i=0;
				}
			}else if (!up && down && right && !left){ // move to down and right
				if (i<1){
					yy++;				
				}else if (i>=1 && i<2){
					xx++;
				}else if (i==2){
					yy++;
					xx++;
					i=0;
				}
			}else if (!up && down && !right && left){ // move to down and left
				if (i<1){
					yy++;				
				}else if (i>=1 && i<2){
					xx--;
				}else if (i==2){
					yy++;
					xx--;
					i=0;
				}
			}
			cek=false;
			i++;

		}else {
			if (xx<2){
				right=true;
				left=false;
				xx=2;
			}else if (xx>74){
				right=false;
				left=true;
				xx=74;
			}else if (yy<2){
				up=false;
				down=true;
				yy=2;
			}else if (yy>38){
				up=true;
				down=false;
				yy=38;
			}
		}
		SetPoint(xx,yy);
	}
}
