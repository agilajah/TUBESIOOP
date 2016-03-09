//Driver Makhluk
//Author : Febi Agil Ifdillah

////////////////////////////////////////////////////////
//KALAU GAGAL ASSERT BERARTI PROGRAM GAGAL. Wrong Asnwer 


//PESAN : Coba garis '//' di baris ke 39 sama 65 hapus. Kalau ngeluarin pesan error, berarti nilai karakternya salah. coba perbaiki 
#include "makhluk.h"
#include <iostream>
#include <cassert>

using namespace std;

int main(int argc, char* argv[]) {
	Ayam A1(3,4,5); 		//Invoke Ayam A1 with 3,3 position on cartesian coordinates, and 3 for step
	A1.SetID(1023);
	A1.SetKekuatan(20);
	//int x = A1.GetX();
	cout << "x = " << A1.getX() << endl;
	cout << "Invokasi :" << endl;
	cout << "Ayam di bangkitkan dengan posisi 3,3" << endl;
	cout << "Ayam memiliki karakter : A" << endl;
	cout << "Kekuatan ayam di awal adalah 20" << endl;
	cout << "Ayam yang lahir memiliki ID : 1023" << endl;

	cout << endl;

	cout << "Setelah Eksekusi :" << endl;
	cout << "Ini Kekuatan : " << A1.GetKekuatan() << endl;
	cout << "Ini ID       : " << A1.GetID() << endl;
	cout << "Ini karakter : " << A1.GetKarakter() << endl;
	cout << "Print Posisi : " ; A1.PrintPos();
	cout << "Kalau lapar ayam akan berbunyi : " << A1.bicara() << endl;  
	cout << endl;

	int a= A1.GetKekuatan(); int b=A1.GetID(); char c=A1.GetKarakter();
	assert(a==20 && "Kekuatan salah!");
	assert(b==1023 && "ID Salah!");
	//assert(c=='A' && "Karakter Salah!");
	cout << "Verdict::Ayam SUCCESS" << endl;		//kalau ini tidak muncul berarti invokasi ayam gagal

	Elang E1(212,24,2);
	E1.SetID(213);
	E1.SetKekuatan(999);

	cout << "Invokasi :" << endl;
	cout << "Elang di bangkitkan dengan posisi 212,24" << endl;
	cout << "Elang memiliki karakter : E" << endl;
	cout << "Kekuatan Elang di awal adalah 999" << endl;
	cout << "Elang yang lahir memiliki ID : 213" << endl;

	cout << endl;

	cout << "Setelah Eksekusi :" << endl;
	cout << "Ini Kekuatan : " << E1.GetKekuatan() << endl;
	cout << "Ini ID       : " << E1.GetID() << endl;
	cout << "Ini karakter : " << E1.GetKarakter() << endl;
	cout << "Print Posisi : " ; E1.PrintPos();
	cout << "Kalau lapar Elang akan berbunyi : " << E1.bicara() << endl;  
	cout << endl;

	a= E1.GetKekuatan(); b=E1.GetID(); c=E1.GetKarakter();
	assert(a==999 && "Kekuatan salah!");
	assert(b==213 && "ID Salah!");
	//assert(c=='A' && "Karakter Salah!");
	cout << "Verdict::Elang SUCCESS" << endl;


	return 0;	

}