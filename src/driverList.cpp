/* 
 * File:   main.cpp
 * Author: ran
 *
 * Created on March 3, 2016, 10:26 AM
 */
 
#include "List.cpp"
#include "makhluk.h"
#include "Point.h"

int main() {

	List<Point> listOfPoint;
	Point P1(1,2);
	listOfPoint.push_back(P1);
	P1.Print();
	
	List<Point>::iterator ip;
	ip = listOfPoint.begin();
	(ip->info).Print();
	
/*
    List<int> listOfInteger;
    listOfInteger.push_back(100);
    listOfInteger.push_back(300);
    listOfInteger.push_back(500);
    listOfInteger.push_back(700);

    Node<int>* pNode;
    pNode = listOfInteger.begin();
    
    cout<<"pNode = listOfInteger.end(); = "<<pNode->info<<endl;
    pNode = listOfInteger.end();
    cout<<"pNode = listOfInteger.end(); = "<<pNode->info<<endl;
    
    List<int>::iterator ci;
    ci = listOfInteger.begin();

	cout<<ci->info<<endl;
*/

/*
    List<Point> listOfPoint;
    Point P1(1,2);
    Point P2(2,3);
    Point P3(3,4);
    
    listOfPoint.insert(P1);
    listOfPoint.insert(P2);
    
    List<Makhluk*> listOfMakhluk;
    
    Makhluk* A1 = new Ayam(1,1,5);
	Makhluk* A2 = new Elang(3,4,10);
	Makhluk* A3 = new Cacing(5,7,1);
	listOfMakhluk.insert(A1);
	listOfMakhluk.insert(A2);
	listOfMakhluk.insert(A3);
	
	listOfMakhluk.print();
*/	
/*    
	List<int> intList;
	intList.insert(3);
	intList.insert(4);
    intList.insert(5);
    intList.insert(6);
    intList.insert(7);
    intList.print();
    
    intList.remove(7);
    intList.print();
    
    List<char> charList;
    charList.insert('i');
    charList.insert('f');
    charList.print();
    
    charList.remove('f');
    charList.insert('t');
    charList.insert('b');
    charList.print();
*/  
	//cout<<"A K H I R "<<endl;
	//cout<<endl;
    return 0;
}

