#include "makhluk.h"
#include "Board.h"
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
		
		void Ayam::gerak() {
			//Ayam akan menjauhi elang, mendekati cacing
			

		}

//From Class Elang

		void Elang::gerak() {
			//Elang akan bergerak mendekati ayam yang ada dalam jangkauannya, jika ada
		}
		
//From Class Cacing

		void Cacing::gerak() {
			//Cacing akan bergerak mendekati 

		}
		
//From Class Padi