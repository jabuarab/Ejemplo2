package uy.edu.um.Queue;

import static java.util.Arrays.copyOf;

public class MyPriorityQueue<T> implements PriorityQueue<T> {
    private T[] fila= (T[]) new Object[10];
    private int size=0;
    private int hP=0;
    public void insert(T element, int priority){
        if(priority>hP){
            hP=priority;
        }
        while(priority>fila.length){
            T[] array=copyOf(this.fila, this.fila.length*2);
        }
        if (this.fila[priority]!=null){
            hP=hP+1;
            fila[hP]=element;
        }else{
            fila[priority]=element;

        }
        this.size=this.size+1;
    }

    public void enqueue(T element){
        T[] array=(T[]) new  Object[this.fila.length+1];
        array[0]=element;
        for(int i=0; i< this.fila.length; i++){
            array[i+1]=this.fila[i];
        }
        this.fila=array;
        hP=hP+1;
        this.size=this.size+1;
    }

    public T dequeue() throws EmptyQueueException{
        T result=null;
        if(this.size==0){
            throw new EmptyQueueException();
        }else {
            if (this.fila[this.fila.length-1] != null) {
                result = this.fila[this.fila.length-1];
                this.fila[this.fila.length-1] = null;
            } else {
                int i = this.fila.length-1;
                while (this.fila[i] == null) {
                    result = this.fila[i - 1];
                    this.fila[i - 1] = null;
                }
            }
        }
        this.size=this.size-1;
        return result;
    }

    public boolean isEmpty(){
        boolean verif=false;
        if(this.size==0){
            verif=true;
        }
        return verif;
    }

    public T getFirst() throws EmptyQueueException{
        T result=null;
        if(this.size==0){
            throw new EmptyQueueException();
        }else{
            result=this.fila[0];
        }
        return result;
    }
public void print(){
        for(int i=0;i<this.fila.length;i++){
            if(this.fila[i]!=null){
                System.out.println(this.fila[i] + " prioridad:"+i);
            }
        }
}
public int getLength(){
        return this.fila.length;
}
public int getSize(){
        return this.size;
}
}
