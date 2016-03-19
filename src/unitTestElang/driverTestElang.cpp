#include <iostream>
#include "makhluk.h"
#include "Board.h"

using namespace std;

int main(){

	int i=0;
	int xx,yy,xa,ya;
	int jum=50;
	Board b;
	
	Elang A1(1,4,5);
//	A1.SetID(1);
	A1.SetKekuatan(20);

	Elang A2(2,23,15);
//	A2.SetID(2);
	A2.SetKekuatan(20);

	Elang A3(3,3,25);
	A3.SetID(3);
	A3.SetKekuatan(20);

	/////////////////////////// 
	Elang E1(4, 24,21);
//	E1.SetID(4);
	E1.SetKekuatan(999);

	Elang E2(5,2,21);
//	E2.SetID(5);
	E2.SetKekuatan(999);
	
	Elang E3(6,3,4);
//	E3.SetID(6);
	E3.SetKekuatan(999);

	////////////////////////
	Elang C1(7,34,15);
//	C1.SetID(7);
	C1.SetKekuatan(20);

	Elang C2(8,113,5);
//	C2.SetID(7);
	C2.SetKekuatan(21);

	Elang C3(9,142,23);
//	C3.SetID(8);
	C3.SetKekuatan(21);

//================== setting to board
	//ayam
	xx = A1.getX();
	yy = A1.getY();
	b.setPoint(xx, yy, A1.GetKarakter(), A1.GetID());

	xx = A2.getX();
	yy = A2.getY();
	b.setPoint(xx, yy, A2.GetKarakter(), A2.GetID());

	xx = A3.getX();
	yy = A3.getY();
	b.setPoint(xx, yy, A3.GetKarakter(), A3.GetID());

	xx = E1.getX();
	yy = E1.getY();
	b.setPoint(xx, yy, E1.GetKarakter(), E1.GetID());

	xx = E2.getX();
	yy = E2.getY();
	b.setPoint(xx, yy, E2.GetKarakter(), E2.GetID());

	xx = E3.getX();
	yy = E3.getY();
	b.setPoint(xx, yy, E3.GetKarakter(), E3.GetID());

	xx = C1.getX();
	yy = C1.getY();
	b.setPoint(xx, yy, C1.GetKarakter(), C1.GetID());

	xx = C2.getX();
	yy = C2.getY();
	b.setPoint(xx, yy, C2.GetKarakter(), C2.GetID());

	xx = C3.getX();
	yy = C3.getY();
	b.setPoint(xx, yy, C3.GetKarakter(), C3.GetID());
	b.Display();

	
	while(i<100000){
		xa = A1.getX();
		ya = A1.getY();
		A1.gerak();
		xx = A1.getX();
		yy = A1.getY();
		b.setPoint(xx, yy, A1.GetKarakter(), A1.GetID());
		b.clearPoint(xa,ya,A1.GetID());
		
		xa = A2.getX();
		ya = A2.getY();
		A2.gerak();
		xx = A2.getX();
		yy = A2.getY();
		b.setPoint(xx, yy, A2.GetKarakter(), A2.GetID());
		b.clearPoint(xa,ya,A2.GetID());
		
		xa = A3.getX();
		ya = A3.getY();
		A3.gerak();
		xx = A3.getX();
		yy = A3.getY();
		b.setPoint(xx, yy, A3.GetKarakter(), A3.GetID());
		b.clearPoint(xa,ya,A3.GetID());

		xa = E1.getX();
		ya = E1.getY();
		E1.gerak();
		xx = E1.getX();
		yy = E1.getY();
		b.setPoint(xx, yy, E1.GetKarakter(), E1.GetID());
		b.clearPoint(xa,ya,E1.GetID());

		xa = E2.getX();
		ya = E2.getY();
		E2.gerak();
		xx = E2.getX();
		yy = E2.getY();
		b.setPoint(xx, yy, E2.GetKarakter(), E2.GetID());
		b.clearPoint(xa,ya,E2.GetID());

		xa = E3.getX();
		ya = E3.getY();
		E3.gerak();
		xx = E3.getX();
		yy = E3.getY();
		b.setPoint(xx, yy, E3.GetKarakter(), E3.GetID());
		b.clearPoint(xa,ya,E3.GetID());

		xa = C1.getX();
		ya = C1.getY();
		C1.gerak();
		xx = C1.getX();
		yy = C1.getY();
		b.setPoint(xx, yy, C1.GetKarakter(), C1.GetID());
		b.clearPoint(xa,ya,C1.GetID());

		xa = C2.getX();
		ya = C2.getY();
		C2.gerak();
		xx = C2.getX();
		yy = C2.getY();
		b.setPoint(xx, yy, C2.GetKarakter(), C2.GetID());
		b.clearPoint(xa,ya,C2.GetID());

		xa = C3.getX();
		ya = C3.getY();
		C3.gerak();
		xx = C3.getX();
		yy = C3.getY();
		b.setPoint(xx, yy, C3.GetKarakter(), C3.GetID());
		b.clearPoint(xa,ya,C3.GetID());

		b.Display();
		i++;
		//cout << i << endl;
		for(long long j=0; j<60000000 ; j++);
	}
	return 0;
}