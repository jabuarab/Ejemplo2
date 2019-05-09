package edu.um.prog2.tad.linkedlist;

import edu.um.prog2.tad.Exeptions.ValueAintExistExeption;

public class CiruclarLinkedBiList<T> implements MyList<T> {

    private Nodo<T> ultimoNodo;
    private Nodo<T> primerNodo;
    private long length;

    public CiruclarLinkedBiList() {
        this.ultimoNodo.setSiguiente(this.primerNodo);
        this.primerNodo.setAnterior(this.ultimoNodo);
    }

    public void agregar(T value) {
        Nodo<T> nodoTmp = new Nodo<>(value);
        if (this.primerNodo.getValue().equals(null)) {  // xq es siempre false???
            this.primerNodo = nodoTmp;
            this.ultimoNodo = nodoTmp;
            this.length = 1;
        } else {
            Nodo<T> nodoTmp1;
            nodoTmp1 = this.ultimoNodo;
            this.ultimoNodo = nodoTmp;
            nodoTmp1.setSiguiente(this.ultimoNodo);
            this.ultimoNodo.setAnterior(nodoTmp1);
            this.ultimoNodo.setSiguiente(this.primerNodo);
            this.primerNodo.setAnterior(this.ultimoNodo);
            this.length = this.length + 1;

        }
    } //done


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
                this.length = this.length - 1;
                nodotemp1 = nodotemp.getSiguiente();
                nodotemp2 = nodotemp1.getSiguiente();
                nodotemp.setAnterior(nodotemp2);
                nodotemp.setSiguiente(nodotemp2);


            }
        }
        if (!existencia) {
            throw new ValueAintExistExeption();
        }
        this.ultimoNodo.setSiguiente(this.primerNodo);
        this.primerNodo.setAnterior(this.ultimoNodo);

    }


    public void borrar(int i) throws IndexOutOfBoundsException {

        if (i > this.length + 1) {
            throw new IndexOutOfBoundsException();
        }

        Nodo<T> nodoTemp0 = this.primerNodo;
        Nodo<T> nodoTemp1;
        Nodo<T> nodoTemp2;
        if (i != 0) {

            for (int k = 0; k < i; k++) {
                nodoTemp0 = nodoTemp0.getSiguiente();
            }
            nodoTemp1 = nodoTemp0.getAnterior();
            nodoTemp2 = nodoTemp0.getSiguiente();
            nodoTemp1.setSiguiente(nodoTemp2);
            nodoTemp2.setAnterior(nodoTemp1);
            this.length = this.length - 1;
        } else {
            this.primerNodo = this.primerNodo.getSiguiente();
            this.length = this.length - 1;
        }
        this.ultimoNodo.setSiguiente(this.primerNodo);
        this.primerNodo.setAnterior(this.ultimoNodo);


    } //done


    public T obtener(int i) {
        Nodo<T> nodoTemp = this.primerNodo;
        for (int j = 0; j < i; j++) {
            nodoTemp = nodoTemp.getSiguiente();
        }
        return nodoTemp.getValue();
    } //done


    public boolean contiene(T value) {
        boolean btemp = false;
        for (int i = 0; i < this.length - 1; i++) {
            if (obtener(i).equals(value)) {
                btemp = true;
                System.out.println("La lista contiene el valor en la direcion: " + i);
            }
        }
        return btemp;
    } //done


    public long getLength() {
        return length;
    } //done


}

