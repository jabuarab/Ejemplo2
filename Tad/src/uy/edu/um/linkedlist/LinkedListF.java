package uy.edu.um.linkedlist;

public class LinkedListF<R> implements MyList<R>{
    private Nodo primero=null;
    private Nodo ultimo=null;
    private int size=0;
    public LinkedListF(){
    }

    public void add(R value){
        Nodo nodo=new Nodo(value);
        if(this.primero==null){
            this.primero=nodo;
            this.ultimo=nodo;
            this.primero.setNext(this.ultimo);
            this.size=this.size=1;
        }else {
            if (primero.getNext() == null) {
                primero.setNext(nodo);
                this.ultimo=nodo;
                this.size = this.size + 1;
            } else {
                Nodo nodo2 = primero.getNext();
                while (nodo2.getNext() != null) {
                    nodo2 = nodo2.getNext();
                }
                nodo2.setNext(nodo);
                this.ultimo=nodo;
                this.size = this.size + 1;
            }
        }

    }
    public int getSize(){
        return this.size;
    }
    public void remove(int position){
        Nodo nodo=primero;
        Nodo nodo2 = null;
        if(position==1){
            this.primero=this.primero.getNext();
        }else {
            if (position < this.size) {
                for (int i = 0; i < position - 1; i++) {
                    nodo = nodo.getNext();

                    if (i == (position - 2)) {
                        nodo2 = nodo;
                    }
                }
                nodo2.setNext(nodo.getNext());
                nodo.setNext(null);
            } else {
                for (int i = 0; i < position - 2; i++) {
                    nodo = nodo.getNext();
                }
                nodo.setNext(null);
                this.ultimo = nodo;
            }
        }
        this.size=this.size-1;
    }
    public R get(int position){
        Nodo nodo=primero;
        for (int i=0; i<position-1;i++){
            if(nodo.getNext()!=null) {
                nodo = nodo.getNext();
            }
        }

        return (R) nodo.getValue();
    }
    public void addFirst(R value){
        Nodo nodo= new Nodo(value);
        if(this.primero==null){
            this.primero=nodo;
            this.ultimo=nodo;
            this.primero.setNext(this.ultimo);
            this.size = this.size + 1;
        }else {
            nodo.setNext(primero);
            this.primero = nodo;
            this.size = this.size + 1;
        }
    }
    public void addLast(R value){
        Nodo nodo= new Nodo(value);
        if(this.primero==null){
            this.primero=nodo;
            this.ultimo=nodo;
            this.primero.setNext(this.ultimo);
            this.size=this.size+1;
        }
        this.ultimo.setNext(nodo);
        this.ultimo=nodo;
        this.size=this.size+1;
    }
    public boolean check(R value){
        Nodo nodo= primero;
        boolean verif=false;
        while(nodo.getNext()!=null && verif==false){
            if(nodo.getValue()==value){
                verif=true;
            }
            nodo=nodo.getNext();


        }

        return verif;
    }
    public R getPrimero(){
        return (R) this.primero.getValue();
    }
    public R getUltimo(){
        return (R) this.ultimo.getValue();
    }
    public void printList(){
        Nodo<R> nodo=this.primero;
        for(int i=0; i< this.size-1; i++) {
            System.out.println(nodo.getValue());
            nodo = nodo.getNext();
        }
    }
}
