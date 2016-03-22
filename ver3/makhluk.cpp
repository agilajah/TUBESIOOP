#include "makhluk.h"
#include "board.h"
#include <iostream>
#include <string>
#include <time.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

using namespace std;

//From class makhluk
		void Makhluk::PrintPos() const {
			P.Print();
		}

		void Makhluk::SetID(int id){
			this->id=id;

		}
		void Makhluk::SetKekuatan(int kekuatan){
			this->kekuatan=kekuatan;
		}
		void Makhluk::SetPoint(int x, int y){
			this->P.SetXY(x,y);
		}

		void Makhluk::SetKarakter(char karakter){
			this->karakter=karakter;
		}

		int Makhluk::GetID() const {
			return id;
		}
		int Makhluk::GetKekuatan() const {
			return kekuatan;
		}

		int Makhluk::getX(){
			return this->P.GetX();
		}

		int Makhluk::getY(){
			return this->P.GetY();
		}

		Point Makhluk::GetPoint() const{
			return P;
		}

		char Makhluk::GetKarakter() const {
			return karakter;
		}
//////////////// from kelas hewan

//////////////// from kelas ayam
		
void Ayam::gerak() {
	int xx, yy;

	timer++;

	if (timer == delay) {
	timer = 0;
	xx = getX();
	yy = getY();
	srand(rand() % 1000);
	int random = rand() % 8;
	switch(random){
		case 1 : xx++;
			break;
		case 2 : yy++;
			break;
		case 3 : xx--;
			break;
		case 4 : yy--;
			break;
		case 5 : xx++;
				 yy++;
			break;
		case 6 : xx++;
				 yy--;
			break;
		case 7 : xx--;
				 yy++;
			break;
		case 8 : xx--;
				 yy--;
			break;
		default :
			break;
	}

	if (xx >= 145)
		xx=144;
	else if (xx < 0)
		xx=1;
	if (yy >= 39)
		yy=38;
	else if (yy < 0)
		yy=1;
	SetPoint(xx,yy);

	}
	else {
		//do nothing

	}	
}

//////////////// from kelas cacing
bool Cacing::isDirectionsNotInitialized(){
	// return true if unitialized
	if (!up && !down && !right && !left)
		return true;
	else
		return false;
}

bool Cacing::isYHitTheWall(int yy){
	//return true if hit the bottom and upper wall
	if (yy<=0 || yy>=39)
		return true;
	else
		return false;
}

void Cacing::gerak() {
	int xx, yy;
	xx = getX();
	yy = getY();

	if (isDirectionsNotInitialized()){
		up=true;
		right=true;
	}
	
	if (!isYHitTheWall(yy)){
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

		if (xx>=145){
			xx=144;
			right = false;
			left = true;
		}else if (xx<=0){
			xx=1;
			right = true;
			left = false;
		}


		if (up && !down){
			yy++;
			up = false;
			down = true;
		}else if (!up && down){
			yy--;
			up = true;
			down = false;
		}
	}
	SetPoint(xx,yy);
}
/////////// from kelas cacing		

bool Elang::isCollision(int xx, int yy){
	// send true if coordinat is hit the wall
	if (xx>0 && xx<145 && yy>0 && yy<39){
		return false;
	}else {
		return true;
	}
}

void Elang::getArahRandom(){
	srand(rand() % 10000);
	arah = rand() % 8 + 1;
}

bool Elang::isSameDirection(int temp){
	//return true if the direction is same
	//korelasi arah :
	//// dinding kanan 	: 1, 5, 6
	//// dinding kiri	: 3, 7, 8
	//// dinding atas 	: 2, 5, 6
	//// dinding bawah 	: 4, 6, 8	
	if (((temp==1 || temp==5 || temp==6) && (arah==1 || arah==5 || arah==6)) ||
		((temp==3 || temp==7 || temp==8) && (arah==3 || arah==7 || arah==8)) ||
		((temp==2 || temp==5 || temp==6) && (arah==2 || arah==5 || arah==6)) ||
		((temp==4 || temp==6 || temp==8) && (arah==4 || arah==6 || arah==8)) )
		return true;
	else
		return false;
}

void Elang::gerak() {
	int xx, yy;
	xx = getX();
	yy = getY();

	timer++;

	if(timer == delay) {
		timer = 0;

	if (!isCollision(xx,yy)){
		switch(arah){
			case 1 : xx++;
				break;
			case 2 : yy++;
				break;
			case 3 : xx--;
				break;
			case 4 : yy--;
				break;
			case 5 : xx++;
					 yy++;
				break;
			case 6 : xx++;
					 yy--;
				break;
			case 7 : xx--;
					 yy++;
				break;
			case 8 : xx--;
					 yy--;
				break;
		}
	}else{
		if (xx >= 145)
			xx=144;
		else if (xx <= 0)
			xx=1;
		if (yy >= 39)
			yy=38;
		else if (yy <= 0)
			yy=1;
		int temp = arah;
		bool cek = true;
		srand(rand() % 1000);
		arah = rand() % 8 + 1;
		
		while(cek){
			if (isSameDirection(temp)){
				srand(rand() % 100000);
				arah = rand() % 8 + 1;	
			}else{
				cek = false;
			}
		}
	}
	SetPoint(xx,yy);	
}
}


void Rumput::gerak() {
	// do nothing
	age++;
	if ( age > growTime ) {
		SetKarakter('X');
	}

}