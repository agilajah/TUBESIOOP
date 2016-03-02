#define POINT_H
#ifndef POINT_H

using namespace std;

class  Point {
	public:
		Point(int x=0; int y =0);
		int getX() const;
		void setX(int);
		int getY() const;
		void setY(int);
		void setXY(int, int);
		void print() const;
		
	private:
		int x, int y; //posisi
};



#endif