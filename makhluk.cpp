#include "makhluk.h"
#include <iostream>
#include <string>


using namepace std;

//From class makhluk
		void Makhluk::SetID(int id){
			this->id=id;

		}
		void Makhluk::SetKekuatan(int kekuatan){
			this->kekuatan=kekuatan;
		}
		void Makhluk::SetPoint(int x, int y){
			Makhluk::Point::SetXY(x,y);
		}
		int Makhluk::GetID() const {
			return Makhluk::id;
		}
		int Makhluk::GetKekuatan() const {
			return Makhluk::kekuatan;
		}
		Point Makhluk::GetPoint() const{
			return Makhluk::P;
		}



//From Class Hewan

		int GetLangkah() const{} {
			return Hewan::langkah;
		}

		void SetLangkah(int langkah){
			return Hewan::Langkah;
		}

//From Class Ayam

		//i know nothing to do here

//From Class Elang

		//brh
		
//From Class Cacing

		//for the sake of indentation, forgive me to doing something not useful lol
		
//From Class Padi