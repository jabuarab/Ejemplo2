package uy.edu.um.Tree;

import Queue.*;
import uy.edu.um.prog2.linkedlist.LinkedList;
import java.util.ArrayList;

public  class Tree <K,T> implements MyTree<K,T> {
    private Node<K,T> root=null;
    private int counter=0;


   // public Tree.Tree(Tree.Node<K,T> nodo){
        //this.root=nodo;
   // }
    public Node getRoot(){
        return this.root;
    }
    private void preOrderOrder(Node<K,T> raiz, ArrayList<T> lista){

    }
    public T find(K key) throws NodoNoExisteException {
        T result=this.root.findKey(key);
        if(result==null){
            throw new NodoNoExisteException();
        }
        return result;
    }

    public void insert(K key, T data, K parentKey) throws HijosCompletosException {
        if(this.root==null){
            this.root= new Node(key,data);
        }else {
            this.root.addNode(key, data, parentKey);
        }
    }
    public void delete(K  key){
        if(this.root.getKey().equals(key)){
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
                    Node nodoAux = this.root.masIzquierdo(key);
                    nodoAux.setRightChild(this.root.getRightChild());
                    if(nodoAux.getLeftChild()==null){
                        nodoAux.setLeftChild(this.root.getLeftChild());
                    }
                    this.root = nodoAux;
                    verif = true;
                }
            }

        }else{
            this.root.deleteNode(key);
        }

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

public int countLeaf(Node<K,T> nodo){
        if(nodo.getLeftChild()==null && nodo.getRightChild()==null){
            this.counter=this.counter+1;
        }
        if(nodo.getLeftChild()!=null){
            countLeaf(nodo.getLeftChild());
        }
        if(nodo.getRightChild()!=null){
            countLeaf(nodo.getRightChild());
        }
        return counter;
}

public int countCompleteElements(Node<K,T> nodo){
        if(nodo.getLeftChild()!=null && nodo.getRightChild()!=null){
            this.counter=this.counter+1;
        }
        if(nodo.getLeftChild()!=null){
            countCompleteElements(nodo.getLeftChild());
        }
        if(nodo.getRightChild()!=null){
            countCompleteElements(nodo.getRightChild());
        }
        return counter;
}
public void resetCounter(){
        this.counter=0;
}


    public LinkedList<T> inOrder(LinkedList<T> lista, Node<K,T> nodo){
        if(nodo.getLeftChild()!=null){
            inOrder(lista, nodo.getLeftChild());
        }
        lista.add(nodo.getData());

        if(nodo.getRightChild()!=null){
            inOrder(lista, nodo.getRightChild());
        }
        return lista;
    }


    public LinkedList<K> preOrder(LinkedList<K> lista, Node<K,T> nodo){
        lista.add(nodo.getKey());
        if(nodo.getLeftChild()!=null){
            preOrder(lista, nodo.getLeftChild());
        }
        if(nodo.getRightChild()!=null){
            preOrder(lista, nodo.getRightChild());
        }
        return lista;
    }


    public LinkedList<K> postOrder(LinkedList<K> lista, Node<K,T> nodo){
        if(nodo.getLeftChild()!=null){
            postOrder(lista, nodo.getLeftChild());
        }
        if(nodo.getRightChild()!=null){
            postOrder(lista, nodo.getRightChild());
        }
        lista.add(nodo.getKey());

        return lista;
    }

    public LinkedList<K> recorridaNivel(LinkedList<K> lista, Node<K,T> nodo) throws EmptyQueueException {
        Queue<Node> fila= new Queue();
        Queue<Node> filaAux= new Queue();
        Node aux=null;

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
            lista.add((K) filaAux.dequeue().getKey());
        }
        return lista;
    }

    public void setRoot(K key, T data){
        this.root=new Node(key , data);
    }

    public void loadPostFijaExpression(String sPostFija) {
        String[] partes = sPostFija.split(" ");
        int i = partes.length-1;
        int t=1;
        int p=t;
        setRoot((K) (Integer) (i-(i-1)),(T) partes[partes.length-1]);
        while(i>0){
            t=t+1;
            i=i-1;
            if( (t%2)==0){
                p=t-1;
            }
            try {
                insert((K) (Integer) (i - (i - t)), (T) partes[i], (K) (Integer) (i - (i - p)));
            }catch(HijosCompletosException e){
                e.printStackTrace();
            }
        }

    }
}
