#ifndef POINT_H
#define POINT_H

class Point{
	public:
		Point(int x=0, int y =0);		
		int GetX() const;
		int GetY() const;
		void SetX(int);
		void SetY(int);
		void SetXY(int, int);
		void Print() const;
	private:
		int x;	//Absis
		int y;	//Ordinat
};



#endif