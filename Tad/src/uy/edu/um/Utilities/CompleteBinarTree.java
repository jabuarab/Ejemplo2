package uy.edu.um.Utilities;
import uy.edu.um.Queue.EmptyQueueException;
import uy.edu.um.Queue.Queue;

import java.util.ArrayList;

public class CompleteBinarTree<T,K> {
    private Nodo<T,K> raiz = new Nodo<T,K>();
    private Queue<Nodo<T,K>>  fila = new Queue<>();
    private int length;

    public void agregar(Nodo<T,K> agregar) throws EmptyQueueException {
        Nodo<T,K> auxiliar;
        Queue<Nodo<T,K>>  fila = new Queue<>();
        ArrayList<Nodo<T,K>> filaaux = new ArrayList<>();
        fila.enqueue(this.raiz);
        while (!fila.isEmpty()){
           auxiliar = fila.dequeue();
           filaaux.add(auxiliar);
           if (auxiliar.hasRigthChild()){
               fila.enqueue(auxiliar.getRigthChild());
           }
            if (auxiliar.hasLeftChild()){
                fila.enqueue(auxiliar.getLeftChild());
            }
        }
        filaaux.add(agregar);
        for (int i=0;i<filaaux.size();i++){
            filaaux.get(i).setRigthChild(filaaux.get(2*i+1));
            filaaux.get(i).setLeftChild(filaaux.get(2*i+2));
        }
        this.raiz=filaaux.get(0);
    }

    public boolean agregar2(Nodo<T,K> agregar,Nodo<T,K> raiz) throws EmptyQueueException {

        Nodo<T, K> auxiliar;



        if (!raiz.hasLeftChild()) {
            raiz.setLeftChild(agregar);
        }
        if (!raiz.hasRigthChild()) {
            raiz.setRigthChild(agregar);
        }
    }




















































        //    Queue<Nodo<T,K>>  fila = new Queue<>();



}
