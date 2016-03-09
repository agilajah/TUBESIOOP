#include <list>
#include "makhluk.h"
#include "Board.h"
#include "List.cpp"
#ifndef MANAGE_H
#define MANAGE_H


using namespace std;

class Manage {
public:
	Manage(int x, Board * _board);	
	void AddMakhluk();
	void GerakAllMakhluk();
	void PrintAllMakhluk();
	void ResolveConflict();
	void Kill(int);
	static int nMakhluk;

private:
	List<Makhluk*> ListOfMakhluk;
	Board * board;
};

#endif
