/* Test Driver Program (TestPoint.cpp)	*/

#include "Point.h"
#include <iostream>

using namespace std;

int main(int argc, char* argv[]) {
	//Instances (objects)

	Point p1;	//default constructor

	Point p2(3,3 );	//invoke constructor
					// Point p2 = Point(3,3)

	cout << "ini point p1 : ";				
	p1.Print();					//point @ (0,0)
	cout << endl;

	cout << "ini point p2 : ";
	p2. Print();				//point @ (3,3)
	cout << endl;

	//Object pointers with dynamic allocation	
	Point * ptrP3, *ptrP4, *ptrP5;		//declare three point pointers

	ptrP4 = new Point(5,5);
	ptrP5 = new Point(1,1);
	ptrP3 = new Point();
	cout << "ini point p3 : ";
	ptrP3->Print(); 			//Point @(0,0)

	cout << "ini point p4 : ";
	ptrP4->Print();

	cout << "ini point p5 : ";
	ptrP5->Print();

	delete ptrP5;
	delete ptrP3;
	delete ptrP4;

	//object reference (Alias)

	Point & P6=p2;
	P6.Print();				//Point @ (3,3)
	cout << endl;

	/*************************
	*	Arrays			     *
	*************************/

	Point ptsArray1[2];
	ptsArray1[0].Print(); //Point @(0,0)
	ptsArray1[1].SetX(10);
	ptsArray1[1].Print();		//Point @(0,10)

	cout << "SUCCESS" << endl;
}