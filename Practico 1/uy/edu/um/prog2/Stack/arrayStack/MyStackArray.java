package edu.um.prog2.Stack.arrayStack;

import edu.um.prog2.Stack.Exeptions.EmptyStackException;
import edu.um.prog2.Stack.MyStack;
import edu.um.prog2.Stack.linkedStack.Nodo;

public class MyStackArray<T> implements MyStack<T> {



    private  Nodo<T>[] stackArray ;
    private final Nodo<T>[] stackAux=new Nodo[10];
    private T inicial =null;
    private Nodo<T> NodoAux;
    private int size;



    public MyStackArray(T value) {
        Nodo<T> nodotemp = new Nodo(value);
        this.stackArray=new Nodo[10];
        this.stackArray[0]= nodotemp;
        this.size=1;
    }
    public MyStackArray(T value,int i) {
        Nodo<T> nodotemp = new Nodo(value);
        this.stackArray=new Nodo[i];
        this.stackArray[0]= nodotemp;
        this.size=1;
    }
    public MyStackArray() {
        this.stackArray=new Nodo[10];
        this.size=0;
    }
    public MyStackArray(int i) {
        this.stackArray=new Nodo[i];
        this.size=0;
    }

    public void pop() throws EmptyStackException {
        if(size==0){
            throw new EmptyStackException();
        }
        this.stackArray[this.size-1].setValue(null);

    }


    public T top() throws EmptyStackException {
        if(this.size == 0){
            throw new EmptyStackException();
        }
        return this.stackArray[this.size].getValue();
    }


    public void push(T value) {
        try {
            this.stackArray[this.size].setValue(value);
        }catch (IndexOutOfBoundsException e){
            int b = (int) (this.stackArray.length*1.5);
            Nodo<T>[] stacktemp=new Nodo[b];
            for(int j=0;j<size-1;){
                stacktemp[j]=this.stackArray[j];
            }
            this.stackArray=stacktemp;
        }
    }


    public boolean isEmpty() {
        boolean tbool = false;
        if (this.size == 0) {
            tbool = true;
        }
        return tbool;
    }








    public void makeEmpty() {
        this.stackArray=this.stackAux;

    }

    public long getSize() {
        return size;
    }
    public long getCurrentLength(){
        return this.stackArray.length;
    }

}
