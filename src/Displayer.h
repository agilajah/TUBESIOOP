#inlude "Board.h"

#ifndef DISPLAYER_H
#define DISPLAYER_H

class Viewer {
	
	public :
		Viewer(Board *);
		void Viewer();

	private :
		Board * board;

};

#endif