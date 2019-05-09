package edu.um.prog2.Stack.linkedStack;

public class Nodo<T> {

    private T value;
    private Nodo oSig;
    private Nodo oAnt;

    public Nodo() {
    }

    public Nodo(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setSiguiente(Nodo oSig) {
        this.oSig = oSig;
    }

    public void setAnterior(Nodo oAnt) {
        this.oAnt = oAnt;
    }

    public Nodo getSiguiente() {
        return oSig;
    }

    public Nodo getAnterior() {
        return oAnt;
    }

    public T getValue() {
        return value;
    }
}