#ifndef _makhluk_h
#define _makhluk_h

#include "point.h"
#include <cstdlib>

using namespace std;

class Makhluk {
	public:
		explicit 
			Makhluk(int x, int y,char karakter, int id, int kekuatan=0):
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
			Hewan(int x, int y, char karakter, int id):
				Makhluk(x, y, karakter, id) {};

		virtual void gerak()=0;		//pure virtual, this class can't be instantiated, too (?)

};

class Ayam : public Hewan {		//Descendant from hewan
	//lahir langsung harus menghasilkan koordinat
	// Karakter Ayam adalah A
	public:
		explicit
			Ayam(int id, int x, int y):
				Hewan(x, y, 'A', id) ,timer(0){
					delay = (rand() % 3)+1;
				};

		void gerak();
	private:
		int delay;
		int timer;

};

class Elang : public Hewan { 	//Descendant from Hewan
	//lahir harus langsung punya koordinat
	// karakter elang adalah E
	public :
		explicit
			Elang(int id, int x, int y):

				Hewan(x, y, 'E', id) , timer(0){
					getArahRandom();
					delay = (rand() % 3)+1;
				};

		void gerak();
	private:
		int delay;
		int timer;
		int arah;
		void getArahRandom();
		bool isCollision(int x, int y);
		bool isSameDirection(int);
};

class Cacing : public Hewan {
	// karakter cacing adalah 'C'
	public :
		explicit
			Cacing(int id, int x, int y):
				Hewan(x, y, 'C', id),
				up(false), down(false), right(false), left(false){};

		void gerak();
		bool isDirectionsNotInitialized();
		bool isYHitTheWall(int);
	
	private:
		bool up, down, right, left;
};

class Tumbuhan : public Makhluk{
	public :
		explicit
			Tumbuhan(int id, int x, int y, char karakter): Makhluk(x, y, karakter, id) {

			};
	
		virtual void gerak()=0;	
	protected :
		int growTime;

};

class Rumput : public Tumbuhan{
	public :
		explicit
			Rumput(int id, int x, int y): Tumbuhan(id, x,y,'R') ,age(0)  {
				growTime= 500;
			};
		void gerak();
	private :
		int age;
};

#endif