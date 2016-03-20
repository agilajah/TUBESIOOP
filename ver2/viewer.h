#include "board.h"
#include <string>

#ifndef VIEWER_H
#define VIEWER_H

class Viewer {
	
	public :
		Viewer(Board *);
		string convertBoardToString();
		void displayToScreen();
		void displayToFile();
		void delay();
		void increaseRefreshRate();
		void decreaseRefreshRate();	

	private :
		Board * board;
		long long speed;

};

#endif