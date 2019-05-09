package edu.um.prog2.Arbol.Mytree;

public class Node<K,T> {
    private K key;
    private T data;
    private Node<K, T> leftChild;
    private Node<K, T> rightChild;

    public Node(K key,T data) {
        this.data = data;
        this.key= key;
    }

    public K getKey() {
        return key;
    }

 //   public void setKey(K key) {
  //      this.key = key;
  //  }

    public T getData() {
        return data;
    }

    //public void setData(T data) {
  //      this.data = data;
   // }

    public Node<K, T> getLeftChild() {
        return leftChild;
    }

     public void setLeftChild(Node<K, T> leftChild) {
       this.leftChild = leftChild;
    }

    public Node<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<K, T> rightChild) {
        this.rightChild = rightChild;
    }
    public  boolean hasRigth(){
        boolean a = true;
        if(getRightChild() == null){
            a= false;
        }
        return  a;
    }
    public  boolean hasLeft(){
        boolean a = true;
        if(getLeftChild() == null){
            a= false;
        }
        return  a;
    }






}
