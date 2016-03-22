#include "viewer.h"
#include "board.h"
#include <iostream>
#include <fstream>
using namespace std;

Viewer::Viewer(Board * _board) {
	board = _board;
	speed = 9000000;
}

//Ubah array of character pada board
//menjadi sebuah string
string Viewer::convertBoardToString() {
	string temp;
	for (int i  = 0 ; i <40 ; i++) {
		for (int j = 0 ; j<146 ;j++ ){
			if ( board->getKarakter(j,i) == '0' ) {
				temp.push_back('-');
			}
			else {
				temp.push_back(board->getKarakter(j,i));
			}
	}
	}
	return temp;

}


//Tampilkan pada layar
void Viewer::displayToScreen() {
	cout << convertBoardToString() << endl;
	delay();
}

//Menghentikan semexplicit entara layar 
void Viewer::delay(){
	for(long long i = 1 ; i <= speed ; i++);
}


//Simpan string dari board ke file
void Viewer::displayToFile(){
	string data;
 	ofstream outfile;
 	outfile.open("log.txt");

	for (int i  = 0 ; i <40 ; i++) {
		for (int j = 0 ; j<146 ;j++ ){
			if ( board->getKarakter(j,i) == '0' ) {
				data.push_back('-');
			}
			else {
				data.push_back(board->getKarakter(j,i));
			}
		}
		outfile << data << endl;
		data.clear();
	}
	cout << endl << "Snapshot saved... (see log.txt)" << endl;
   outfile.close();
}


void Viewer::increaseRefreshRate() {
	speed += 1000000;
}

void Viewer::decreaseRefreshRate(){
	speed -= 1000000;
}
