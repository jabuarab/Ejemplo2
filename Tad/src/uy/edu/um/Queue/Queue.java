package uy.edu.um.Queue;

import uy.edu.um.linkedlist.LinkedList;

public class Queue<T> implements MyQueue<T> {
private LinkedList<T> fila=new LinkedList();


public void enqueue(T element){
        fila.addFirst(element);
    }

    public T dequeue() throws EmptyQueueException {
    T result=null;
    if(fila.getSize()==0){
        throw new EmptyQueueException();
    }else{
        result=fila.get(fila.getSize());
        fila.remove(fila.getSize());
    }
    return result;
    }

    public boolean isEmpty(){
    boolean verif=false;

    if(fila.getSize()==0){
        verif=true;
    }
    return verif;
    }

    public T getFirst() throws EmptyQueueException {
    T result=null;
    if(this.fila.getSize()==0){
        throw new EmptyQueueException();
    }else{
        result=fila.get(fila.getSize());
    }
    return result;
    }

    public int size(){
        return fila.getSize();
    }

    public void printQueue(){
    this.fila.printList();
    }
}
