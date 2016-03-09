/* 
 * File:   main.cpp
 * Author: ran
 *
 * Created on March 3, 2016, 10:26 AM
 */

#include "List.cpp"
#include "Point.cpp"

int main() {
    List<Point> listOfPoint;
    Point P1(1,2);
    Point P2(2,3);
    
    listOfPoint.insert(P1);
    listOfPoint.insert(P2);
    
/*  intList.insert(4);
    intList.insert(5);
    intList.insert(6);
    intList.insert(7);
    intList.print();
    
    intList.remove(5);
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
    return 0;
}

