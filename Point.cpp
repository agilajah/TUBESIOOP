#include "Point.h"
#include <iostream>

using namespace std;


//constructor
Point::Point(int x, int y): x(x), y(y){}

//Getter X
int Point::getX() const {
	return x;
}

//Setter X
void Point::SetX(int x) const {
	this->x = x;
}

//Getter Y
int Point::GetY() const {
	return y;
}

//Setter Y
void Point::SetY(int y) const {
	this->y = y;
}

void Point::SetXY(int x, int y) const {
	this->x = x;
	this->y = y;
}

//Printer
void Point::print() const {
	cout << "(" << x << y << ")" << endl;
}