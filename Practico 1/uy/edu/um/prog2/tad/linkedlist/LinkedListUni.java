package edu.um.prog2.tad.linkedlist;

import edu.um.prog2.tad.Exeptions.ValueAintExistExeption;

public class LinkedListUni<T> implements MyList<T> {

    private Nodo<T> ultimoNodo;
    private Nodo<T> primerNodo;
    private long length;

    public LinkedListUni() {

    }

    public void agregar(T value) {
        Nodo<T> nodoTmp = new Nodo<>(value);
        if (this.primerNodo==null) {

            this.primerNodo = nodoTmp;
            this.ultimoNodo = nodoTmp;
            this.length = 1;
        } else {
            Nodo<T> nodoTmp1;
            nodoTmp1 = this.ultimoNodo;
            this.ultimoNodo = nodoTmp;
            nodoTmp1.setSiguiente(this.ultimoNodo);


            this.length = this.length + 1;
        }
    }



    public void borrar(T value) throws ValueAintExistExeption {
        Nodo<T> nodotemp = this.primerNodo;
        Nodo<T> nodotemp1;
        Nodo<T> nodotemp2;
        boolean existencia = false;
        for (int i = 0; i < this.length; i++) {
            if (obtener(i).equals(value)) {
                existencia = true;
                for (int j = 0; j < i - 1; j++) {
                    nodotemp = nodotemp.getSiguiente();
                }
                nodotemp1 = nodotemp.getSiguiente();
                nodotemp2 = nodotemp1.getSiguiente();
                this.length = this.length - 1;
                nodotemp.setSiguiente(nodotemp2);
            }
        }
        if (!existencia) {
            throw new ValueAintExistExeption();
        }

    }


    public void borrar(int i) throws IndexOutOfBoundsException {

        if (i >= this.length) {
            throw new IndexOutOfBoundsException();
        }
       // if()
        if (i != 0) {
            Nodo<T> nodoTemp0 = new Nodo<>();
            for (int j = 0; j < i ; j++) {
                nodoTemp0 = nodoTemp0.getSiguiente();
            }
            Nodo<T> nodoTemp1 = nodoTemp0.getSiguiente();
            Nodo<T> nodoTemp2 = nodoTemp0.getSiguiente();

            nodoTemp0.setSiguiente(nodoTemp2);
            nodoTemp1.setSiguiente(null);
            nodoTemp1.setValue(null);
            this.length = this.length - 1;
        } else {
            this.primerNodo = this.primerNodo.getSiguiente();
            this.length = this.length - 1;
        }


    }


    public T obtener(int i) throws IndexOutOfBoundsException {
        if (i >= this.length) {
            throw new IndexOutOfBoundsException();
        }

        Nodo<T> nodoTemp = this.primerNodo;
        for (int j = 0; j < i; j++) {
            nodoTemp = nodoTemp.getSiguiente();
        }
            T a= nodoTemp.getValue();
        return a;
    }

    public boolean contiene(T value) {
        boolean btemp = false;
        for (int i = 0; i < this.length ; i++) {
            if (obtener(i).equals(value)) {
                btemp = true;
                System.out.println("La lista contiene el valor en on: " + i);
            }
        }
        return btemp;
    }

    public long getLength() {
        return length;
    }

    public void addFirst(T value) {

        Nodo<T> nodoTmp = new Nodo<>(value);
        if (this.primerNodo.getValue() == null) {
            this.primerNodo = nodoTmp;
            this.ultimoNodo = nodoTmp;
            this.length = 1;
        } else {
            Nodo<T> nodoTemp1;
            nodoTemp1 = this.primerNodo;
            this.primerNodo = nodoTmp;
            this.primerNodo.setSiguiente(nodoTemp1);

            this.length = this.length + 1;
        }
    }

}

  /*  public void agregar(int i) throws IndexOutOfBoundsException {

        if (i > this.length - 1) throw new IndexOutOfBoundsException();
        Nodo<T> nodoTemp = this.primerNodo;

        Nodo<T> nodoTemp2;
        for (int j = 0; j < i - 1; j++) {
            nodoTemp = nodoTemp.getSiguiente();
        }
        nodoTemp2 = nodoTemp.getSiguiente().getSiguiente();
        nodoTemp.setSiguiente(nodoTemp2);


    } //leer comentraios */