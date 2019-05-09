package uy.edu.um.linkedlist;
import uy.edu.um.prog2.linkedlist.Nodo;
public interface MyList<R> {

    public void addFirst(R value);

    public void addLast(R value);

    public void add(R value);

    public void remove(int position)throws NodoNoExiste;

    public R get(int position)throws NodoNoExiste;

}
