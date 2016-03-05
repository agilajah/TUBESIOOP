#ifndef POINT_H
#define POINT_H

class Point{
	public:
		Point(int x=0, int y =0);
		int GetX() const;
		void SetX(int);
		int GetY() const;
		void SetY(int);
		void SetXY(int, int);
		void Print() const;
		
	private:
		int x, y; //posisi
};



#endif