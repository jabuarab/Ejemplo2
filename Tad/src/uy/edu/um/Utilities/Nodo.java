package uy.edu.um.Utilities;

public class Nodo<T,K> {
    private Nodo<T,K> leftChild = new Nodo<>();
    private Nodo<T,K> rigthChild = new Nodo<>();
    private Nodo<T,K> Parent= new Nodo<>();
    private T value;
    private K key;

    public Nodo() {
    }

    public Nodo(T value, K key) {
        this.value = value;
        this.key = key;
    }


    public Nodo<T, K> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Nodo<T, K> leftChild) {
        this.leftChild = leftChild;
    }

    public Nodo<T, K> getRigthChild() {
        return rigthChild;
    }

    public void setRigthChild(Nodo<T, K> rigthChild) {
        this.rigthChild = rigthChild;
    }

    public Nodo<T, K> getParent() {
        return Parent;
    }

    public void setParent(Nodo<T, K> parent) {
        Parent = parent;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean hasLeftChild(){
        boolean a = false;
        if (this.leftChild!=null){
            a=true;
        }
        return a;
    }
    public boolean hasRigthChild(){
        boolean a = false;
        if (this.rigthChild!=null){
            a=true;
        }
        return a;
    }



    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }
}
