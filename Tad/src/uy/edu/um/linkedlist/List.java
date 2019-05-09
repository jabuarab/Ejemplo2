package uy.edu.um.linkedlist;

public class List {
    private ListNode primero=null;
    private int size=0;

    public void add(int value){
        if(this.primero==null){
            this.primero=new ListNode(value);
            this.size=this.size=1;
        }else {
            if (primero.getNext() == null) {
                primero.setNext(new ListNode(value));
                this.size = this.size + 1;
            } else {
                ListNode nodo2 = primero.getNext();
                while (nodo2.getNext() != null) {
                    nodo2 = nodo2.getNext();
                }
                nodo2.setNext(new ListNode(value));
                this.size = this.size + 1;
            }
        }

    }



    public void remove(int position){
        ListNode nodo=primero;
        ListNode nodo2 = null;
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
            }
        }
        this.size=this.size-1;
    }

    public int get(int position){
        ListNode nodo=primero;
        for (int i=0; i<position-1;i++){
            if(nodo.getNext()!=null) {
                nodo = nodo.getNext();
            }
        }

        return  nodo.getItem();
    }

    public ListNode getNodo(int position){
        ListNode nodo=primero;
        for (int i=0; i<position-1;i++){
            if(nodo.getNext()!=null) {
                nodo = nodo.getNext();
            }
        }

        return nodo;
    }

    public void printList(){
        ListNode nodo=this.primero;
        for(int i=0; i< this.size; i++) {
            System.out.println(nodo.getItem());
            nodo = nodo.getNext();
        }
    }


    public List getNoNegativos(){
        List lista=new List();
        for(int i=1;i<=this.size;i++){
            if(get(i)>=0){
                lista.add(get(i));
            }
        }
        return lista;
    }


    public void removeNoNegativos(){
        for(int i=1; i<=this.size; i++){
            if(get(i)>=0){
                remove(i);
                i=i-1;
            }
        }
    }

    public static void main(String[] args){
        List lista=new List();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(-11);
        lista.add(-2);
        lista.add(0);
        lista.removeNoNegativos();
        lista.printList();


    }

}
