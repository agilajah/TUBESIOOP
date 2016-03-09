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
        Node<Type>();
        Node<Type>(Type);
        ~Node<Type>();

        //setter getter
        void setInfo(Type);
        void setNext(Node&);
        int getInfo();
        Node<Type>* getNext();
        Node<Type> *next;
        Type info;
    private:
};

template <class Type>
class List{
    public:
        List<Type>();
        ~List<Type>();
        void push_back(Type);
        void erase(Type);
        Node<Type>* search(Type);
        void print();
        Node<Type>* first;
    private:
};

#endif /* LIST_H */

