#include <list>
#include "point.h"


#ifndef _Board_H
#define _Board_H

using namespace std;


struct mtrk {
	char element[2];
	int ID[2];
	mtrk(char c='0'){
		element[0]=c;
		element[1]=c;
		ID[0]=-1;
		ID[1]=-1;
	}
};

class Board{
	public:
		Board(); // constructor
		void Display();
		void addPosition(int, int);
		void MovePoint(int, int, int, int, char);
		bool cekKosong(int, int);
		void setPoint(int, int, char, int);
		void clearPoint(int, int, int);
		
		char getKarakter(int,int);
		bool isConflictArea(int,int);
		void getFighterID(int,int,int&,int&);
		void getFighterClass(int,int,char&,char&);
		void getAvailableCoordinate(int&, int&);
	

	
	private:
		mtrk mtr[150][45];
		static  const int MAX = 150; //banyak makhluk maksimal dalam board

};



#endif
