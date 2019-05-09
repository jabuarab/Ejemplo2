package uy.edu.um.linkedlist;

public  class DLinkedList<R> implements MyList<R> {
    private Nodo primero;
    private Nodo ultimo;
    private int size=0;

    public DLinkedList(Nodo primero, Nodo ultimo){
        if(primero==ultimo){
            this.primero=primero;
            this.ultimo=primero;
            this.ultimo.setNext(this.primero);
            this.primero.setPrevious(this.ultimo);
            this.size=this.size++;
        }
        else{
            this.primero=primero;
            this.ultimo=ultimo;
            this.primero.setNext(this.ultimo);
            this.ultimo.setPrevious(this.primero);
            this.ultimo.setNext(this.primero);
            this.primero.setPrevious(this.ultimo);
            this.size=this.size+2;
        }
    }
    public void add(R value){
        Nodo nodo=new Nodo(value);
        Nodo nodo2=primero;
        if(this.size==1){
            this.primero.setNext(nodo);
            this.ultimo=nodo;
            nodo.setPrevious(this.primero);
            nodo.setNext(this.primero);
            this.size=this.size++;
        }else {
            while (nodo2.getNext() != null) {
                nodo2 = nodo2.getNext();
            }
            nodo2.setNext(nodo);
            nodo.setPrevious(nodo2);
            this.ultimo=nodo;
            this.size=this.size++;
        }
    }

public R get(int position)throws NodoNoExiste{
        Nodo nodo=primero;
        if(position>this.size){
            throw new NodoNoExiste();
        }else {
            for (int i = 0; i < position - 1; i++) {
                nodo = nodo.getNext();
            }
            return (R) nodo.getValue();
        }
}

public void remove(int position)throws NodoNoExiste{
    Nodo nodo=primero;
    Nodo nodo2 = null;
    if(position>this.size){
        throw new NodoNoExiste();
    }
    else {
        if (position < this.size) {
            for (int i = 0; i < position - 1; i++) {
                nodo = nodo.getNext();

                if (i == (position - 2)) {
                    nodo2 = nodo;
                }
            }
            nodo2.setNext(nodo.getNext());
            nodo.getNext().setPrevious(nodo2);
            nodo.setNext(null);
            nodo.setPrevious(null);
        } else {
            for (int i = 0; i < position - 2; i++) {
                nodo = nodo.getNext();
            }
            nodo.setNext(null);
            this.ultimo=nodo;
        }
        this.size = this.size - 1;
    }
}
public void addFirst(R value){
        Nodo nodo=new Nodo(value);
        this.primero.setPrevious(nodo);
        nodo.setNext(this.primero);
        this.primero=nodo;
}
public void addLast(R value){
        Nodo nodo=new Nodo(value);
        nodo.setPrevious(this.ultimo);
        this.ultimo.setNext(nodo);
        this.ultimo=nodo;
}


}
