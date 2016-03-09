#include "makhluk.h"
#include "Board.h"
#include "Point.h"
#include "manage.h"
#include <unistd.h>
#include <iostream>

using namespace std;

int main() {
		Board board;
		Manage worldManager(100,&board);

		while(1){
		worldManager.GerakAllMakhluk();
		board.Display();
		sleep(1);
		}	
	
	
	
		
		
		return 0;
}
