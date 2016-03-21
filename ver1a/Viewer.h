#include "Board.h"
#include <string>

#ifndef VIEWER_H
#define VIEWER_H

class Viewer {
	
	public :
		Viewer(Board *);
		string convertBoardToString();
		void displayToScreen();
		void delay();
		void increaseRefreshRate();
		void decreaseRefreshRate();	
		void displayToFile();

	private :
		Board * board;
		long long speed;

};

#endif