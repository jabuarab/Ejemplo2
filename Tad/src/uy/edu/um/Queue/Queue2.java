package uy.edu.um.Queue;

import uy.edu.um.linkedlist.LinkedListF;

public class Queue2<T> implements MyQueue<T> {

    private LinkedListF<T> fila= new LinkedListF();


    public void enqueue(T element){
        fila.addFirst(element);
    }

    public T dequeue() throws EmptyQueueException {
        T result=null;
        if(fila.getSize()==0){
            throw new EmptyQueueException();
        }else{
            result=fila.getUltimo();
            fila.remove(fila.getSize());
        }
        return result;
    }

    public boolean isEmpty(){
        boolean verif=false;
        if(fila.getSize()==0){
            verif =true;
        }
        return verif;
    }

    public T getFirst() throws EmptyQueueException {
        if(fila.getSize()==0){
            throw new EmptyQueueException();
        }else {
            return fila.getUltimo();
        }
    }

}
