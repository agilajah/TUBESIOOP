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
void Point::SetX() const {
	this->x = x;
}

//Getter Y
int Point::GetY() const {
	return y;
}

//Setter Y
void Point::SetY() const {
	this->y = y;
}

//Printer
void Point::print() const {
	cout << "(" << x << y << ")" << endl;
}