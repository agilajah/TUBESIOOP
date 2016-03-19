#include <iostream>
#include "makhluk.h"
#include "Board.h"
#include "Point.h"
#include <windows.h>

using namespace std;

int main(){

	int i=0;
	int xx,yy,xa,ya;
	int jum=50;
	Board b;
	
	Ayam A1(1,4,5);
	//A1.SetID(1023);
	A1.SetKekuatan(20);

	Ayam A2(2,23,15);
	//A2.SetID(1023);
	A2.SetKekuatan(20);

	Ayam A3(3,3,25);
	//A3.SetID(1023);
	A3.SetKekuatan(20);

	/////////////////////////// 
	Ayam E1(4, 24,21);
	//E1.SetID(213);
	E1.SetKekuatan(999);

	Ayam E2(5,2,21);
	//E2.SetID(213);
	E2.SetKekuatan(999);
	
	Ayam E3(6,3,4);
	//E3.SetID(213);
	E3.SetKekuatan(999);

	////////////////////////
	Ayam C1(7,34,15);
	//C1.SetID(103);
	C1.SetKekuatan(20);

	Ayam C2(8,113,5);
	//C2.SetID(1023);
	C2.SetKekuatan(21);

	Ayam C3(9,142,23);
	//C3.SetID(1023);
	C3.SetKekuatan(21);

//================== setting to board
	//ayam
	xx = A1.getX();
	yy = A1.getY();
	b.setPoint(xx, yy, A1.GetKarakter());

	xx = A2.getX();
	yy = A2.getY();
	b.setPoint(xx, yy, A2.GetKarakter());

	xx = A3.getX();
	yy = A3.getY();
	b.setPoint(xx, yy, A3.GetKarakter());

	xx = E1.getX();
	yy = E1.getY();
	b.setPoint(xx, yy, E1.GetKarakter());

	xx = E2.getX();
	yy = E2.getY();
	b.setPoint(xx, yy, E2.GetKarakter());

	xx = E3.getX();
	yy = E3.getY();
	b.setPoint(xx, yy, E3.GetKarakter());

	xx = C1.getX();
	yy = C1.getY();
	b.setPoint(xx, yy, C1.GetKarakter());

	xx = C2.getX();
	yy = C2.getY();
	b.setPoint(xx, yy, C2.GetKarakter());

	xx = C3.getX();
	yy = C3.getY();
	b.setPoint(xx, yy, C3.GetKarakter());
	b.Display();

	
	while(i<100000){
		std::system("clear");
		//ayam
		xa = A1.getX();
		ya = A1.getY();
		A1.gerak();
		xx = A1.getX();
		yy = A1.getY();
		b.setPoint(xx, yy, A1.GetKarakter());
		b.clearPoint(xa,ya,A1.GetKarakter());
		
		xa = A2.getX();
		ya = A2.getY();
		A2.gerak();
		xx = A2.getX();
		yy = A2.getY();
		b.setPoint(xx, yy, A2.GetKarakter());
		b.clearPoint(xa,ya,A2.GetKarakter());
		
		xa = A3.getX();
		ya = A3.getY();
		A3.gerak();
		xx = A3.getX();
		yy = A3.getY();
		b.setPoint(xx, yy, A3.GetKarakter());
		b.clearPoint(xa,ya,A3.GetKarakter());

		xa = E1.getX();
		ya = E1.getY();
		E1.gerak();
		xx = E1.getX();
		yy = E1.getY();
		b.setPoint(xx, yy, E1.GetKarakter());
		b.clearPoint(xa,ya,E1.GetKarakter());

		xa = E2.getX();
		ya = E2.getY();
		E2.gerak();
		xx = E2.getX();
		yy = E2.getY();
		b.setPoint(xx, yy, E2.GetKarakter());
		b.clearPoint(xa,ya,E2.GetKarakter());

		xa = E3.getX();
		ya = E3.getY();
		E3.gerak();
		xx = E3.getX();
		yy = E3.getY();
		b.setPoint(xx, yy, E3.GetKarakter());
		b.clearPoint(xa,ya,E3.GetKarakter());

		xa = C1.getX();
		ya = C1.getY();
		C1.gerak();
		xx = C1.getX();
		yy = C1.getY();
		b.setPoint(xx, yy, C1.GetKarakter());
		b.clearPoint(xa,ya,C1.GetKarakter());

		xa = C2.getX();
		ya = C2.getY();
		C2.gerak();
		xx = C2.getX();
		yy = C2.getY();
		b.setPoint(xx, yy, C2.GetKarakter());
		b.clearPoint(xa,ya,C2.GetKarakter());

		xa = C3.getX();
		ya = C3.getY();
		C3.gerak();
		xx = C3.getX();
		yy = C3.getY();
		b.setPoint(xx, yy, C3.GetKarakter());
		b.clearPoint(xa,ya,C3.GetKarakter());

		b.Display();
		i++;
		//cout << i << endl;
		for(long long j=0; j<40000000 ; j++);
	}
}