#ifndef _makhluk_h
#define _makhluk_h

#include "Point.h"

using namespace std;

class Makhluk : Point {
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
		Point GetPoint() const;
		char GetKarakter() const;

		

	private:
		int id; 				//id makhluk 	
		int kekuatan;
		Point P; 				//posisi makhluk (opsional), bisa pakai x,y langsung
		char karakter; 			//name, there is no way to access this private data member 
								//'cause we don't have any setter-getter for this variable

};

class Hewan : public Makhluk{ //Descendant from mahluk
	public:
		explicit
			Hewan(int x, int y, int langkah, char karakter):
				langkah(langkah), Makhluk(x, y, karakter) {};

		virtual void gerak()=0;		//pure virtual, this class can't be instantiated, too (?)


		//Getter-Setter
		void SetLangkah(int langkah);
		int GetLangkah() const;

	private:
		int langkah; // atau jarak pandang.
		virtual const char* bicara() =0;	//opsional
};

class Ayam : public Hewan {		//Descendant from hewan
	//lahir langsung harus menghasilkan koordinat
	
	const char c = 'A'; 
	public:
		explicit
			Ayam(int langkah, int x, int y): Hewan(x, y, langkah, c) {};

		void gerak();
		virtual const char* bicara() {return "Ptok Ptok";}

};

class Elang : public Hewan { 	//Descendant from Hewan
	//lahir harus langsung punya koordinat
	const char c = 'E';
	public :
		explicit
			Elang(int langkah, int x, int y): Hewan(x, y, langkah, c){};

		void gerak();
		virtual const char* bicara() {return "Eaaak";}
};

class Cacing : public Hewan {
	char c = 'C';
	public :
		explicit
			Cacing(int langkah, int x, int y): Hewan(x, y, langkah, c){};

		void gerak();
		virtual const char* bicara() {return "I can't speak, baka baka!.";}
};

class Tumbuhan : public Makhluk{
	public :
		//explicit
			//Tumbuhan(int langkah, int x, int y): Hewan(x, y, langkah, 'P'){};

		virtual const char* bicara() {return "I can't speak, baka baka!.";}
	
};


#endif