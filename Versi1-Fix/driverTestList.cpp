/* 
 * File:   main.cpp
 * Author: ran
 *
 * Created on March 3, 2016, 10:26 AM
 */
 
#include "List.cpp"
#include "makhluk.h"
#include "Point.h"
#include <stdlib.h>

int main() {

    list<int> listOfInteger;
    cout<<"listOfInteger.isEmpty() = "<<listOfInteger.isEmpty()<<endl;
    listOfInteger.push_back(100);
    listOfInteger.push_back(300);
    listOfInteger.push_back(500);
    listOfInteger.push_back(700);
    cout<<"listOfInteger.isEmpty() = "<<listOfInteger.isEmpty()<<endl;

    Node<int>* pNode;
    pNode = listOfInteger.begin();
    cout<<"pNode = listOfInteger.begin(); = "<<pNode->info<<endl;
    pNode = listOfInteger.end();
    cout<<"pNode = listOfInteger.end(); = "<<pNode->info<<endl;
    
    list<char> charList;
    charList.push_back('i');
    charList.push_back('f');
    charList.print();
    
    charList.erase('f');
    charList.push_back('t');
    charList.push_back('b');
    charList.print();

	list<Point> listOfPoint;
	Point P1(1,2);
	Point P2(2,3);
	Point P3(3,4);
	listOfPoint.push_back(P1);
	listOfPoint.push_back(P2);
	listOfPoint.push_back(P3);
	
	list<Point>::iterator ip;
	ip = listOfPoint.begin();
	
	do{
		(ip->info).Print();
		ip = ip->next;
	} while (ip != listOfPoint.end());
	(ip->info).Print();


    list<Makhluk*> listOfMakhluk;
    Makhluk* A1 = new Ayam(1,1,5);
	Makhluk* A2 = new Elang(3,4,10);
	Makhluk* A3 = new Cacing(5,7,1);
	listOfMakhluk.push_back(A1);
	listOfMakhluk.push_back(A2);
	listOfMakhluk.push_back(A3);
	
	list<int> intList;
	intList.push_back(3);
	intList.push_back(4);
    intList.push_back(5);
    intList.push_back(6);
    intList.push_back(7);
    intList.print();
	
	cout<<"erase 3"<<endl;    
    intList.erase(3);
    intList.print();

	cout<<"erase 7"<<endl;    
    intList.erase(7);
    intList.print();
    
    cout<<"erase 5"<<endl;    
    intList.erase(5);
    intList.print();
   
    return 0;
}

