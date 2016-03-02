#define BOARD_H
#ifndef BOARD_H

using namespace std;

class Board{
	public:
		Board(); // constructor
		void Display(){}
		void MovePoint(int, int);

	private:
		static int mtr[100][100];
		const MAX = 100; //banyak makhluk maksimal dalam board

};



#endif