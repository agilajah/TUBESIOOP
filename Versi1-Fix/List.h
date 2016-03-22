/* 
 * File:   List.h
 * Author: ran
 *
 * Created on March 3, 2016, 10:28 AM
 */

#ifndef LIST_H
#define LIST_H


template<class Type>
class Node{
    public:
        //ctor, cctor, dtor
        Node<Type>();				// konstruktor node generik
        Node<Type>(Type);			// copy constuctor node generik
        ~Node<Type>();				// destruktor node generik

        //setter getter
        void setInfo(Type);			// mengeset nilai info node generik
        void setNext(Node&);		// mengeset nilai next dari node generik
        int getInfo();				// mengembalikan nilai info dari node generik
        Node<Type>* getNext();		// meengembalikan nilai next dari node generik
        Node<Type> *next;			// atribut untuk menyimpan alamat next node
        Type info;					// atribut untuk menyimpan info node generik
    private:
};

template <class Type>
class list{
    public:
    	//ctor, cctor, dtor
        list<Type>();					// konstruktor list generik
        ~list<Type>();					// destruktor list generik

        //service
        void push_back(Type);			// menambahkan anggota baru dari list, anggota baru ditambah sebagai elemen terakhir	
        void erase(Type);				// menghapus suatu anggota list
        Node<Type>* search(Type);		// mencari suatu anggota list, jika ditemukan dikembalikan alamat node, jika tidak dikembalikan NULL
		Node<Type>* begin();			// mengembalikan anggota pertama (first) dari list
		Node<Type>* end();				// mengembalikan angota terakhir dari lisst
		int isEmpty();
		void print();					// mencetak seluruh anggota list, dapat digunakan untuk unit test dan debuging
		typedef Node<Type>* iterator;	// digunakan sebagai iterator untuk anggota list
		
    private:
		Node<Type>* first;				// menyimpan alamat node pertama dari list
};

#endif /* LIST_H */

