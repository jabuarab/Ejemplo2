package edu.um.prog2.tad.linkedlist;

public class Nodo<T> {
    private Nodo<T> siguiente;
    private Nodo<T> anterior;
    private T value;


    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }


    public Nodo() {
    }

    public Nodo(T value) {
        this.value=value;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
