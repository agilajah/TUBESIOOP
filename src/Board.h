#ifndef BOARD_H
#define BOARD_H

using namespace std;

class Board{
	public:
		Board(); // constructor
		void Display(){};
		void MovePoint(int, int);
		void AlgoGerak(int){};

	private:
		static int mtr[100][100];
		const int MAX = 100; //banyak makhluk maksimal dalam board

};



#endif