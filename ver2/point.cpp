#include "point.h"
#include <iostream>

using namespace std;


//constructor
Point::Point(int x, int y): x(x), y(y){};

//Getter X
int Point::GetX() const {
	return x;
}

//Setter X
void Point::SetX(int x){
	this->x = x;
}

//Getter Y
int Point::GetY() const {
	return y;
}

//Setter Y
void Point::SetY(int y) {
	this->y = y;
}

void Point::SetXY(int x, int y) {
	this->x = x;
	this->y = y;
}

//Printer
void Point::Print() const {
	cout << "(" << x <<  ',' << y << ")" << endl;
}