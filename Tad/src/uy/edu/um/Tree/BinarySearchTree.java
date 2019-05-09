package uy.edu.um.Tree;

import Queue.EmptyQueueException;
import Queue.Queue;
import uy.edu.um.prog2.linkedlist.LinkedList;

public class  BinarySearchTree<K extends Comparable<K>, T> implements MyBinarySearchTree<K , T> {
    private NodeBST root=null;
    private int counter=0;

public void insert(K key, T data){
    if(this.root==null){
        this.root=new NodeBST(key, data);
    }else{
        this.root.insertNode(key, data);
    }
}


    public T find( K key){
        return (T) this.root.findKey(key);
    }



public void delete(K key){
    if(key.compareTo((K) this.root.getKey())==0){
        boolean verif =false;
        if(this.root.getLeftChild()==null && verif==false&& this.root.getRightChild()==null){
            this.root=null;
            verif=true;
        }
        if(verif==false) {
            if (this.root.getLeftChild() != null && this.root.getRightChild() == null) {
                this.root = this.root.getLeftChild();
                verif = true;
            }
        }
        if(verif==false) {
            if (this.root.getLeftChild() == null && this.root.getRightChild() != null) {

                this.root = this.root.getRightChild();
                verif = true;
            }
        }
        if(verif==false) {
            if (this.root.getLeftChild() != null && this.root.getRightChild() != null) {
                if(this.root.getRightChild().getLeftChild()==null){
                    this.root.getRightChild().setLeftChild(this.root.getLeftChild());
                    this.root=this.root.getRightChild();
                }else {
                    NodeBST nodoAux = this.root.getRightChild().masIzquierdo(key);
                    nodoAux.setRightChild(this.root.getRightChild());
                    if (nodoAux.getLeftChild() == null) {
                        nodoAux.setLeftChild(this.root.getLeftChild());
                    }
                    this.root = nodoAux;
                }
                verif = true;
            }
        }

    }else{
        this.root.deleteNode(key);
    }
}

    public NodeBST getRoot(){
        return this.root;
    }


    public LinkedList<T> inOrder(LinkedList<T> lista, NodeBST<K,T> nodo){
        if(nodo.getLeftChild()!=null){
            inOrder(lista, nodo.getLeftChild());
        }
        lista.add(nodo.getData());

        if(nodo.getRightChild()!=null){
            inOrder(lista, nodo.getRightChild());
        }
        return lista;
    }


    public LinkedList<T> preOrder(LinkedList<T> lista, NodeBST<K,T> nodo){
        lista.add(nodo.getData());
        if(nodo.getLeftChild()!=null){
            preOrder(lista, nodo.getLeftChild());
        }
        if(nodo.getRightChild()!=null){
            preOrder(lista, nodo.getRightChild());
        }
        return lista;
    }


    public LinkedList<T> postOrder(LinkedList<T> lista, NodeBST<K,T> nodo){
        if(nodo.getLeftChild()!=null){
            postOrder(lista, nodo.getLeftChild());
        }
        if(nodo.getRightChild()!=null){
            postOrder(lista, nodo.getRightChild());
        }
        lista.add(nodo.getData());

        return lista;
    }

    public LinkedList<T> recorridaNivel(LinkedList<T> lista, NodeBST<K,T> nodo) throws EmptyQueueException {
        Queue<NodeBST> fila= new Queue();
        Queue<NodeBST> filaAux= new Queue();
        NodeBST aux=null;

        fila.enqueue(nodo);
        while(fila.size()!=0){
            filaAux.enqueue(aux=fila.dequeue());

            if(aux.getLeftChild()!=null){
                fila.enqueue(aux.getLeftChild());
            }
            if(aux.getRightChild()!=null){
                fila.enqueue(aux.getRightChild());
            }
        }
        while(filaAux.size()!=0){
            lista.add((T) filaAux.dequeue().getData());
        }
        return lista;
    }












    public int size( Node<K,T> nodo){
        if(this.root!=null) {
            this.counter = this.counter + 1;
        }
        if(nodo.getLeftChild()!=null){
            size(nodo.getLeftChild());
        }
        if(nodo.getRightChild()!=null){
            size(nodo.getRightChild());
        }
        return counter;
    }

}
