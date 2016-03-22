/*
	Viewer.h
	Menampilkan informasi pada board ke file atau ke layar

*/
#ifndef VIEWER_H
#define VIEWER_H

#include "board.h"
#include <string>

class Viewer {

	public :
		Viewer(Board *);				//Konstruktor Viewer
		string convertBoardToString();	//Ubah informasi pada board menjadi string
		void displayToScreen();			//Tampilkan informasi pada layar
		void displayToFile();			//Simpan informasi pada file
		void delay();					//Menghentikan Viewer sementara
		void increaseRefreshRate();		//Meningkatkan kecepatan refresh dari viewer
		void decreaseRefreshRate();		//Menurunkan kecepatan refresh dari viewer

	private :
		Board * board;					//Board yang akan ditampilkan
		long long speed;				//Waktu delay pada viewer

};

#endif