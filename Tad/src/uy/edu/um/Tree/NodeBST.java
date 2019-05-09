package uy.edu.um.Tree;

public class NodeBST<K extends Comparable<K>, T> {
    private K key;
    private T data;
    private NodeBST leftChild=null;
    private NodeBST rightChild=null;

    public NodeBST(K key, T data){
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
            if (key.compareTo(this.key)>0) {

                if (this.rightChild != null && result == null) {
                    result = (T) this.rightChild.findKey(key);
                }
            }else {
                if (this.leftChild != null && result == null) {
                    result = (T) this.leftChild.findKey(key);
                }
            }
        }
        return result;

    }
    public void insertNode(K key, T data){
        if(key.compareTo(this.key)<0 && this.leftChild==null){
            this.leftChild=new NodeBST(key, data);
        }
        if(key.compareTo(this.key)>0 && this.rightChild==null){
            this.rightChild=new NodeBST(key, data);
        }else{
            if( this.leftChild!=null && key.compareTo(this.key)<0){
                this.leftChild.insertNode(key, data);
            }
            if(this.rightChild!=null && key.compareTo(this.key)>0){
                this.rightChild.insertNode(key, data);
            }
        }


    }

   public NodeBST masIzquierdo(K key){
        NodeBST result=null;

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


    public NodeBST masDerecho(K key){
        NodeBST result=null;
        if(this.rightChild.getLeftChild()==null){
            if(this.key.equals(key)){
                if(this.rightChild.getRightChild()!=null){
                    this.rightChild.setRightChild(this.rightChild.getLeftChild());
                }

            }else {
                if (this.rightChild.getRightChild() != null) {
                    this.rightChild = this.rightChild.getLeftChild();
                }
            }

            result=this.rightChild;

            this.rightChild = null;
        }
        else{
            result= this.rightChild.masIzquierdo(key);
        }
        return result;
    }

public T getData(){
        return this.data;
}

    public void deleteNode(K key){
        boolean verif=false;
        if(key.compareTo(this.key)<0) {
            if (this.leftChild != null && verif == false && this.leftChild.getKey().equals(key)) {

                if (this.leftChild.getLeftChild() == null && verif == false && this.leftChild.getRightChild() == null) {
                    this.leftChild = null;
                    verif = true;
                }
                if (verif == false) {
                    if (this.leftChild.getLeftChild() != null && verif == false && this.leftChild.getRightChild() == null) {
                        this.leftChild = this.leftChild.getLeftChild();
                        verif = true;
                    }
                }
                if (verif == false) {
                    if (this.leftChild.getLeftChild() == null && verif == false && this.leftChild.getRightChild() != null) {
                        this.leftChild = this.leftChild.getRightChild();
                    }
                }
                if (verif == false) {
                    if (this.leftChild.getLeftChild() != null && this.leftChild.getRightChild() != null) {
                        this.leftChild = this.leftChild.masDerecho(key);
                        verif = true;
                    }
                }

            }
        }
        if(key.compareTo(this.key)>0){
            if (this.rightChild != null && verif == false && this.rightChild.getKey().equals(key)) {

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

    }
    public K getKey(){
        return this.key;
    }
    public NodeBST getLeftChild(){
        return this.leftChild;
    }

    public NodeBST getRightChild(){
        return this.rightChild;
    }

    public void setLeftChild(NodeBST nodo){
        this.leftChild=nodo;
    }

    public void setRightChild(NodeBST nodo){
        this.rightChild=nodo;
    }
}
