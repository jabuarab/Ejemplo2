package edu.um.prog2.Stack.linkedStack;

import edu.um.prog2.Stack.Exeptions.EmptyStackException;
import edu.um.prog2.Stack.MyStack;

public class MyStackEnlazada<T> implements MyStack<T> {
    private Nodo<T> top;
    private long size;


    public void pop() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Nodo<T> tNodo;
        tNodo = this.top.getSiguiente();
        tNodo.setAnterior(null);
        this.top = tNodo;
        this.size = this.size - 1;
    }

    public T top() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return this.top.getValue();
    }

    public void push(T value) {

        Nodo<T> nTemp = new Nodo(value);
        if (this.size == 0) {
            this.top = nTemp;
            this.size = 1;
        } else {
            nTemp.setSiguiente(this.top);
            this.top.setAnterior(nTemp);
            this.top = nTemp;
            this.size = this.size + 1;
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
        this.top = null;
        this.top.setSiguiente(null);
        size = 0;

    }

    public long getSize() {
        return size;
    }
}