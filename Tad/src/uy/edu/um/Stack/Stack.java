package uy.edu.um.Stack;

import uy.edu.um.prog2.linkedlist.LinkedList;
import uy.edu.um.prog2.linkedlist.Nodo;

public class Stack<T> implements MyStack<T> {
    private int size=0;
    LinkedList<T> pila= new LinkedList();


    public Stack(){

    }
    public T getPrimero(){
        return this.pila.getPrimero();
    }

public T pop() throws EmptyStackException {
            T result=null;
            if (this.size != 0) {
                result=pila.get(this.size);
                pila.remove(this.size);

            } else {
                throw new EmptyStackException();
            }
            this.size=this.size-1;
        return result;
    }

    public T top() throws EmptyStackException {
    T result=null;
    if(this.size!=0) {
        result=pila.get(this.size);
    }
    else{
        throw new EmptyStackException();
    }
    return result;
    }
    public void push(T element){
        pila.add(element);
        this.size=this.size+1;
    }
public boolean isEmpty(){
        boolean verif=false;
        if(this.size==0){
            verif=true;
        }
        return verif;
}
public void makeEmpty() {
 for (int i=1; i<this.size; i++){
     this.pila.remove(i);
 }
    this.size=0;
}

public void print(){
        this.pila.printList();
}
}
