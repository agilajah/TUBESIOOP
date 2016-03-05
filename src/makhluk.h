#ifndef _makhluk_h
#define _makhluk_h

#include "Point.h"

using namespace std;

class Makhluk{
	public:
		explicit 
			Makhluk(int x, int y, int id=0, int kekuatan=0, char karakter=''):
				Point(x,y), id(id), kekuatan(kekuatan), karakter(karakter){} 
		
		virtual void gerak()=0; //pure virtual, this class can't be instantiated

		//getter-setter
		void SetID(int id){};
		void SetKekuatan(int kekuatan){};
		void SetPoint(int x, int y){};
		int GetID() const {};
		int GetKekuatan() const {};
		Point GetPoint() const{};
		

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
			Hewan(int x, int y, char karakter):
				langkah(langkah), Makhluk(x, y, karakter), {};

		virtual void gerak()=0;		//pure virtual, this class can't be instantiated, too (?)


		//Getter-Setter
		void SetLangkah(int langkah){};
		int GetLangkah() const{};

	private:
		int langkah; // atau jarak pandang.
		virtual const char* bicara =0;	//opsional
};

class Ayam : public Hewan {		//Descendant from hewan
	//lahir langsung harus menghasilkan koordinat
	public:
		explicit
			Ayam(int langkah, int x, int y): Hewan(x, y, langkah, 'A') {};

		void gerak();
		virtual const char* bicara() {return "Ptok Ptok";}

}

class Elang : public Hewan { 	//Descendant from Hewan
	//lahir harus langsung punya koordinat
	public :
		explicit
			Elang(int langkah, int x, int y): Hewan(x, y, langkah, 'E'){};

		void gerak();
		virtual const char* bicara() {return "Eaaak";}
}

class Cacing : public Cacing {
	public :
		explicit
			Cacing(int langkah, int x, int y): Hewan(x, y, langkah, 'C'){};

		void gerak();
		virtual const char* bicara() {return "I can't speak, baka baka!.";}
}

class Tumbuhan : public Makhluk{
	public :
		explicit
			Cacing(int langkah, int x, int y): Hewan(x, y, langkah, 'P'){};

		virtual const char* bicara() {return "I can't speak, baka baka!.";}
	
};


#endif