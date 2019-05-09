package uy.edu.um.Queue;

import static java.util.Arrays.copyOf;


public class CircularQueue<T> implements MyQueue<T> {
    private T[] fila = (T[]) new Object[10];
    private int size = 0;

    public void enqueue(T element) {
        if (this.fila.length == this.size) {
            T[] array = copyOf(this.fila, this.fila.length * 2);
        } else {
            if (this.size == 0) {
                this.fila[0] = element;
                this.size = this.size + 1;
            } else {
                this.fila[this.size] = element;
                this.size = this.size + 1;
            }
        }
    }

    public T dequeue() throws EmptyQueueException {
        T result = null;
        if (this.size == 0) {
            throw new EmptyQueueException();
        } else {
            if(this.fila[this.fila.length-1]!=null){
                result=this.fila[this.fila.length-1];
                this.fila[this.fila.length-1]=null;

            }else{
                int i = this.fila.length-1;
                while (this.fila[i] == null) {
                    result = this.fila[i - 1];
                    this.fila[i - 1] = null;
                }
            }
        }
        return result;
    }

    public boolean isEmpty(){
        boolean verif=false;
        if(this.size==0){
            verif=true;
        }
        return verif;
    }

    public T getFirst() throws EmptyQueueException {
        T result=null;
        if(this.size==0){
            throw new EmptyQueueException();
        }else{
            result= this.fila[this.size-1];
        }
        return result;
    }
}

