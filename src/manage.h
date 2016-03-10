#include <list>
#include "makhluk.h"
#include "Board.h"

#ifndef Manager_H
#define Manager_H


using namespace std;

class Manager {
public:
	Manager(int x, Board * _board);	
	void spawn();
	void spawnRandomAmount();
	void moveAll();
	void PrintAllMakhluk();
	void ResolveConflict();
	void kill(int);
	static int nSpawned;
	static int nLife;

private:
	list<Makhluk*> ListOfMakhluk;
	Board * board;
};

#endif
