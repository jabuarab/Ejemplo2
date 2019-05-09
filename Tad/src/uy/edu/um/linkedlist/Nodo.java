package uy.edu.um.linkedlist;

public class Nodo <R> {
    private R value;
    private Nodo next;
    private Nodo previous;

    public Nodo(R value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }


    public Nodo getPrevious() {

        return this.previous;
    }

    public void setPrevious(Nodo nodo) {

        this.previous = nodo;
    }

    public Nodo getNext() {

        return this.next;
    }

    public void setNext(Nodo nodo) {

        this.next = nodo;
    }

    public R getValue() {
        return this.value;
    }

    public void setValue(R value){
        this.value=value;
    }
}