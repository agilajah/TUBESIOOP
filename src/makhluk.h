#ifndef _makhluk_h
#define _makhluk_h

#include "Point.h"

using namespace std;

class Makhluk {
	public:
		explicit 
			Makhluk(int x, int y,char karakter, int id=0, int kekuatan=0):
				id(id), kekuatan(kekuatan), karakter(karakter){
					SetPoint(x, y);
				};
		
		virtual void gerak()=0; //pure virtual, this class can't be instantiated
		void PrintPos() const;
		//getter-setter
		void SetID(int);
		void SetKekuatan(int kekuatan);
		void SetPoint(int x, int y);
		void SetKarakter(char);
		int GetID() const;
		int GetKekuatan() const;
		int getX();
		int getY();
		Point GetPoint() const;
		char GetKarakter() const;

		

	protected:
		int id; 				//id makhluk 	
		int kekuatan;
		Point P; 				//posisi makhluk (opsional), bisa pakai x,y langsung
		char karakter; 			//name, there is no way to access this private data member 
								//'cause we don't have any setter-getter for this variable

};

class Hewan : public Makhluk{ //Descendant from mahluk
	public:
		explicit
			Hewan(int x, int y, int ID, char karakter):
				langkah(ID), Makhluk(x, y, karakter, ID) {};

		virtual void gerak()=0;		//pure virtual, this class can't be instantiated, too (?)


		//Getter-Setter
		void SetLangkah(int langkah);
		int GetLangkah() const;

	private:
		int langkah; // atau jarak pandang.
		
};

class Ayam : public Hewan {		//Descendant from hewan
	public:
		explicit
			Ayam(int ID, int x, int y):
				Hewan(x, y, ID, 'A')
				{};

		void gerak();
		
};

class Elang : public Hewan { 	//Descendant from Hewan
	//lahir harus langsung punya koordinat
	// karakter elang adalah E
	public :
		explicit
			Elang(int langkah, int x, int y): 
				i(0),
				Hewan(x, y, langkah, 'E'),
				up(false), down(false), right(false), left(false){};

		void gerak();
		
	private:
		int i;
		bool up, down, right, left;
};

class Cacing : public Hewan {
	// karakter cacing adalah 'C'
	public :
		explicit
			Cacing(int langkah, int x, int y):
				i(0),
				Hewan(x, y, langkah, 'C'),
				up(false), down(false), right(false), left(false){};

		void gerak();
		
	private:
		int i;
		bool up, down, right, left;
};

#endif