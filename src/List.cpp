/* 
 * File:   List.cpp
 * Author: ran
 * 
 * Created on March 3, 2016, 10:28 AM
 */

#include "List.h"
#include <iostream>
using namespace std;


template<class Type>
Node<Type>::Node(Type x){
        //cout<<"--ctor node"<<endl;
        info = x;
        this->next = NULL;
}

template<class Type>
Node<Type>::~Node(){
        //cout<<"--dtor node"<<endl;
        delete next;
}

template<class Type>
void Node<Type>::setInfo(Type x){
        info = x;
}

template<class Type>
void Node<Type>::setNext(Node<Type>& N){
        next = &N;
}

template<class Type>
int Node<Type>::getInfo(){
        return info;
}

template<class Type>
Node<Type>* Node<Type>::getNext(){
        return next;
}


template<class Type>
void Node<Type>::operator++(){
    //this=this->next;    
}


//////// IMPLEMENTASI KELAS LIST /////////

template<class Type>
list<Type>::list(){
        //cout<<"ctor list"<<endl;
        first = NULL;
}

template<class Type>
list<Type>::~list(){
        //cout<<"dtor list"<<endl;
		
        delete first;
}

template<class Type>
void list<Type>::push_back(Type x){
		Node<Type>* pNodeIns = new Node<Type>(x);
		
        if (first==NULL){
                first = pNodeIns;
        }else{
				Node<Type>* pNode;
                pNode = first;
                while(pNode->next!=NULL){
                        pNode = pNode->next;
                }
                pNode->next = pNodeIns;
        }
}

template<class Type>
void list<Type>::erase(Type x){
        Node<Type>* pNodeRem = search(x);

        if(pNodeRem!=NULL){
                if (pNodeRem==first){
						//cout<<"hapus elemen pertama"<<endl;
                        first = first->next;
                }else{
                        Node<Type>* pNode = first;
                        while(pNode->next!=pNodeRem){
                                pNode = pNode->next;
                        }
                        pNode->next = pNode->next->next;
                }
                //delete pNodeRem;		//bener ga sih kaya gini delet nya?
        }
}

template<class Type>
Node<Type>* list<Type>::search(Type x){
        Node<Type>* pNode;
        bool found=false;

        pNode = begin();
        while(pNode!=NULL && !found){
                if (pNode->info==x) found=true;
                else pNode = pNode->next;
        }
		//if(found) cout<<x<<" ditemukan"<<endl;
        //else cout<<x<<" tidak ditemukan"<<endl;
        return pNode;
}

template<class Type>
void list<Type>::print(){
        Type tmp;
        Node<Type>* pNode;
        pNode = begin();

        while(pNode!=NULL){
                tmp = pNode->info;
                cout<<tmp;
                if (pNode->next!=NULL) cout<<", ";
                pNode = pNode->next;
        }
        cout<<endl;
}

template<class Type>
Node<Type>* list<Type>::begin(){
	return this->first;
}

template<class Type>
Node<Type>* list<Type>::end(){
	Node<Type>* pNode;
	pNode=this->first;
	while(pNode->next!=NULL){
		pNode=pNode->next;
	}
	return pNode;
}


