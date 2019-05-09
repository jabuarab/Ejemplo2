package uy.edu.um.Tree;

public class Node<K,T> {
    private K key;
    private T data;

private Node <K,T> leftChild=null;
private Node<K,T> rightChild=null;


    public Node(K key, T data){
    this.key=key;
    this.data=data;
}

public T findKey(K key) {
        T result=null;
        boolean verif=false;
        if(this.key.equals(key)){
            result = this.data;
            verif=true;
        }else {
            if(this.rightChild!=null && result==null){
               result= this.rightChild.findKey(key);
            }
            if (this.leftChild!=null && result==null){
                result=this.leftChild.findKey(key);
            }
        }


    return result;
}

public void addNode(K key, T data, K parentKey)throws HijosCompletosException {
        boolean verif =false;
        if(this.key.equals(parentKey)){
            if(this.leftChild==null){
                this.leftChild=new Node(key, data);
                verif=true;
            }
            else{
                if(this.rightChild==null){
                    this.rightChild=new Node(key,data);
                    verif= true;
                }else{
                    throw new HijosCompletosException();
                }

            }
        }else{
            if(this.leftChild!=null && verif==false){
                this.leftChild.addNode(key,data,parentKey);
            }
            if(this.rightChild!=null && verif ==false){
                this.rightChild.addNode(key,data,parentKey);
            }
        }
}
public Node masIzquierdo(K key){
        Node result=null;
        if(this.leftChild.getLeftChild()==null){
            if(this.key.equals(key)){
                if(this.leftChild.getRightChild()!=null){
                    this.leftChild.setLeftChild(this.leftChild.getRightChild());
                }

            }else {
                if (this.leftChild.getRightChild() != null) {
                    this.leftChild = this.leftChild.getRightChild();
                }
            }

            result=this.leftChild;

                this.leftChild = null;
        }
        else{
           result= this.leftChild.masIzquierdo(key);
        }
        return result;
}
public void deleteNode(K key){
        boolean verif=false;
        if(this.leftChild!=null && verif ==false && this.leftChild.getKey().equals(key)) {

            if (this.leftChild.getLeftChild() == null && verif == false && this.leftChild.getRightChild() == null) {
                this.leftChild = null;
                verif = true;
            }
            if( verif==false ) {
                if (this.leftChild.getLeftChild() != null && verif == false && this.leftChild.getRightChild() == null) {
                    this.leftChild = this.leftChild.getLeftChild();
                    verif = true;
                }
            }
            if( verif==false ) {
                if (this.leftChild.getLeftChild() == null && verif == false && this.leftChild.getRightChild() != null) {
                    this.leftChild = this.leftChild.getRightChild();
                }
            }
            if( verif==false ) {
                if (this.leftChild.getLeftChild() != null && this.leftChild.getRightChild() != null) {
                    this.leftChild = this.leftChild.masIzquierdo(key);
                    verif = true;
                }
            }

        }
        if(this.rightChild!=null && verif ==false && this.rightChild.getKey().equals(key)) {

            if (this.rightChild.getLeftChild() == null && verif == false && this.rightChild.getRightChild() == null) {
                this.rightChild = null;
                verif = true;
            }
            if (verif == false) {
                if (this.rightChild.getLeftChild() != null && this.rightChild.getRightChild() == null) {
                    this.rightChild = this.rightChild.getLeftChild();
                    verif = true;
                }
            }
            if (verif == false) {
                if (this.rightChild.getLeftChild() == null && this.rightChild.getRightChild() != null) {
                    this.rightChild = this.rightChild.getRightChild();
                }
            }
            if (verif == false) {
                if (this.rightChild.getLeftChild() != null && this.rightChild.getRightChild() != null) {
                    this.rightChild = this.rightChild.masIzquierdo(key);
                    verif = true;
                }
            }
        }
        else{
            if(this.leftChild!=null && verif==false){
                this.leftChild.deleteNode(key);
            }
            if(this.rightChild!=null && verif==false){
                this.rightChild.deleteNode(key);
            }
        }

    }


public void setLeftChild(Node <K,T> nodo){
    this.leftChild=nodo;
}

public void setRightChild(Node<K,T> nodo){
    this.rightChild=nodo;
}

public Node<K,T> getLeftChild(){
    return this.leftChild;
}

public Node<K,T> getRightChild(){
    return this.rightChild;
}

public K getKey(){
    return this.key;
}

public T getData(){
    return this.data;
}

public K getLChildKey(){
    return this.leftChild.getKey();
}
public K getRChildKey(){
    return this.rightChild.getKey();
}

public T getLChildData(){
    return this.leftChild.getData();
}
    public T getRChildData(){
    return this.rightChild.getData();
}


}
