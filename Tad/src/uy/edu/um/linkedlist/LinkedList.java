package uy.edu.um.linkedlist;
import uy.edu.um.prog2.linkedlist.MyList;

        
public class LinkedList <R> implements MyList<R> {
    private Nodo primero=null;
    private int size=0;
public LinkedList(){
}

    public void add(R value){
       if(this.primero==null){
           this.primero=new Nodo(value);
           this.size=this.size=1;
       }else {
           if (primero.getNext() == null) {
               primero.setNext(new Nodo(value));
               this.size = this.size + 1;
           } else {
               Nodo nodo2 = primero.getNext();
               while (nodo2.getNext() != null) {
                   nodo2 = nodo2.getNext();
               }
               nodo2.setNext(new Nodo(value));
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

    public Nodo getNodo(int position){
        Nodo nodo=primero;
        for (int i=0; i<position-1;i++){
            if(nodo.getNext()!=null) {
                nodo = nodo.getNext();
            }
        }

        return nodo;
    }

    public void addFirst(R value){
        Nodo nodo= new Nodo(value);
        nodo.setNext(primero);
        this.primero=nodo;
        this.size=this.size+1;
    }
    public void addLast(R value){
        Nodo nodo=primero;
        while(nodo.getNext()!=null){
            nodo=nodo.getNext();
        }
        nodo.setNext(new Nodo(value));
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

    public void printList(){
    Nodo<R> nodo=this.primero;
    for(int i=0; i< this.size; i++) {
        System.out.println(nodo.getValue());
        nodo = nodo.getNext();
    }
    }
public int compareTo(int ind, R value){
    int result=0;
    if(value instanceof Integer ){
        if((Integer) value > (Integer) get(ind)  ){
            result=1;
        }
        if((Integer) value < (Integer) get(ind) ){
            result=-1;
        }
       if((Integer) value < (Integer) get(ind) ){
            result=0;
        }

    }
    if(value instanceof String){
        String aux= (String) value;
        String aux1= (String) get(ind);
        String[] parts=aux.split("");
        String[] parts1=aux1.split("");
        if(parts.length> parts1.length){
            result=1;
        }
        if(parts.length< parts1.length){
            result=-1;
        }
        if(parts.length==parts1.length){
            result=0;
        }
    }
    return result;
}
    public void addInOrder(R value){
    Nodo nodo=new Nodo(value);
    Nodo aux=null;
    if (this.size==0){
        this.primero=nodo;
        this.size=this.size+1;
    }else {
        int i = 1;
        while (compareTo(i, value) == 1 && i < this.size+1) {

            aux = getNodo(i);
            i = i + 1;
        }

        if (aux.getNext() == null) {
            aux.setNext(nodo);
        } else {
            nodo.setNext(aux.getNext());
            aux.setNext(nodo);
        }
        this.size = this.size + 1;
    }
    }

public void vizualisar(LinkedList<Integer> p){
    for (int i=0;i<p.getSize();i++){
        System.out.println(get(p.get(i)));
    }
}

public void intercambiar(R value,int direction){
    boolean verif=false;
    Nodo aux=null;
    int i=1;
    if(direction==1) {
        while (verif == false && i < this.size) {
            if (value.equals(get(i))) {
                verif=true;
                aux=getNodo(i);
            }
            i=i+1;
        }
        R val1= (R) aux.getNext().getValue();
        aux.getNext().setValue(aux.getValue());
        aux.setValue(val1);
    }
    if(direction==-1){
        while (verif == false && i <= this.size) {
            if (value.equals(get(i))) {
                verif=true;
                aux=getNodo(i-1);
            }
            i=i+1;
        }

        R val1= (R) aux.getNext().getValue();
        aux.getNext().setValue(aux.getValue());
        aux.setValue(val1);
    }
}
    public LinkedList<R> compartidos(LinkedList<R> lista){
    LinkedList<R> lista2=new LinkedList();
    for(int i=1;i<=lista.getSize();i++){
        for(int p=1;p<=this.size;p++){
            if(get(p).equals(lista.get(i))){
                lista2.add(get(p));
            }
        }
    }
    return lista2;
    }

    public LinkedList<R> noAmbas(LinkedList<R> lista){
    LinkedList<R> lista2= new LinkedList();
    boolean verif=false;
        for(int i=1;i<=lista.getSize();i++){
            verif=false;
            for(int p=1;p<=this.size;p++){
                if(get(p).equals(lista.get(i))){
                    verif=true;
                }
            }
            if(verif==false){
                lista2.add(lista.get(i));
            }
        }
        for(int i=1;i<=this.size;i++){
            verif=false;
            for(int p=1;p<=lista.getSize();p++){
                if(get(i).equals(lista.get(p))){
                    verif=true;
                }
            }
            if(verif==false){
                lista2.add(get(i));
            }
        }
        return lista2;
    }



public static void main(String[] args){
   LinkedList<Integer> lista=new LinkedList();
    lista.addInOrder(1);
    lista.addInOrder(2);
    lista.addInOrder(3);
    lista.addInOrder(4);
    lista.addInOrder(5);

    LinkedList<Integer> lista2=new LinkedList();
    lista2.addInOrder(1);
    lista2.addInOrder(2);
    lista2.addInOrder(9);
    lista2.addInOrder(4);
    lista2.addInOrder(7);
lista.noAmbas(lista2).printList();
}

}
