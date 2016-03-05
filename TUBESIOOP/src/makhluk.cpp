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
		Point Makhluk::GetPoint() const{
			return P;
		}

		char Makhluk::GetKarakter() const {
			return karakter;
		}



//From Class Hewan

		int Hewan::GetLangkah() const {
			return langkah;
		}

		void Hewan::SetLangkah(int langkah){
			this->langkah = langkah;
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