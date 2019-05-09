package uy.edu.um.Queue;

import uy.edu.um.prog2.linkedlist.LinkedListF;

public class MyDoubleQueue<T> {
    private LinkedListF<T> fila= new LinkedListF();

    public void enqueueLeft(T element){
        fila.addFirst(element);
    }

    public void enqueueRight(T element){
        fila.addLast(element);
    }

    public T dequeueLeft() throws EmptyQueueException {
       T result=null;
        if(this.fila.getSize()==0){
            throw new EmptyQueueException();
        }else{
            result=fila.getPrimero();
            fila.remove(1);
        }
        return result;
    }
    public T dequeueRight() throws EmptyQueueException {
        T result =null;
        if(fila.getSize()==0){
            throw new EmptyQueueException();
        }else{
            result=fila.getUltimo();
            fila.remove(fila.getSize());
        }
        return result;
    }
public void print(){
        fila.printList();
}
}
