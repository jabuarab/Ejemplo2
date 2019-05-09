package edu.um.prog2.Arbol.Mytree;

public class Tree<K,T> implements MyTree<K,T> {
    Node<K,T> parent;
    long size;
    long leaf;



    public Tree(K o,T data) {
        K O;
        Node<K,T> parent1 = new Node<K,T>(o,data);
        this.parent = parent1;


    }



    public Tree() {
    }


    private Node<K,T> find(Node<K,T> nodoHelp1,K key){
        Node<K,T> nodoReturn;
        nodoReturn=nodoHelp1;
        if(nodoHelp1.getKey().equals(key)){
            nodoReturn=nodoHelp1;
        }
        if(nodoHelp1.hasRigth()){
            find(nodoHelp1.getRightChild(),key);
        }
        if(nodoHelp1.hasLeft()){
            find(nodoHelp1.getLeftChild(),key);
        }
        return nodoReturn;
    }



    public void insert(K key, T data, K parentKey) {
        Node<K,T> nodoTemp =  find(this.parent,parentKey);
        Node<K,T> nodoTempleft =  nodoTemp.getLeftChild();
        Node<K,T> nodoTemprigth =  nodoTemp.getRightChild();
        Node<K,T> nodoTemphelp =  new Node<>(key, data);




    }

    public T find(K key) {
        Node<K,T> nodotemp = find(this.parent,key);
        return nodotemp.getData();
    }



    public void delete(K key) {

    }
}
