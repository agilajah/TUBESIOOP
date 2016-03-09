#include <iostream>
#include "makhluk.h"
#include "Board.h"
#include "Point.h"
#include <windows.h>

using namespace std;

int main(){

	int i=0;
	int xx,yy,xa,ya;
	Ayam A1(3,4,5);
	A1.SetID(1023);
	A1.SetKekuatan(20);

	Ayam A2(3,23,15);
	A2.SetID(1023);
	A2.SetKekuatan(20);

	Ayam A3(3,34,25);
	A3.SetID(1023);
	A3.SetKekuatan(20);

	Elang E1(212,24,21);
	E1.SetID(213);
	E1.SetKekuatan(999);

	Elang E2(212,2,21);
	E2.SetID(213);
	E2.SetKekuatan(999);

	Elang E3(212,3,4);
	E3.SetID(213);
	E3.SetKekuatan(999);

	Board b;
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

	b.Display();

	
	while(i<100){
		system("cls");
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

		//elang
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

		b.Display();
		i++;
		cout << i << endl;
		Sleep(600);
	}
}