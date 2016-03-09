#include "makhluk.h"
#include "Board.h"
#include <iostream>
#include <string>


using namespace std;

//From class makhluk
	
		void Makhluk::PrintPos() const {
			P.Print();
		}

		void Makhluk::SetID(int id){
			this->id=id;

		}
		void Makhluk::SetKekuatan(int kekuatan){
			this->kekuatan=kekuatan;
		}
		void Makhluk::SetPoint(int x, int y){
			this->P.SetXY(x,y);
		}

		void Makhluk::SetKarakter(char karakter){
			this->karakter=karakter;
		}

		int Makhluk::GetID() const {
			return id;
		}
		int Makhluk::GetKekuatan() const {
			return kekuatan;
		}

		int Makhluk::getX(){
			return this->P.GetX();
		}

		int Makhluk::getY(){
			return this->P.GetY();
		}

		Point Makhluk::GetPoint() const{
			return P;
		}

		char Makhluk::GetKarakter() const {
			return karakter;
		}
//////////////// from kelas hewan
//////////////// from kelas ayam
//////////////// from kelas elang

/////////// from kelas cacing		
