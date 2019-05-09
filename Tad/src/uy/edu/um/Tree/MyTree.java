package uy.edu.um.Tree;

import Queue.EmptyQueueException;
import uy.edu.um.prog2.linkedlist.LinkedList;

public interface MyTree<K,T> {
    public T find(K key) throws NodoNoExisteException;

    public void insert(K key, T data, K parentKey) throws HijosCompletosException;

    public void delete(K key);

    public int size(Node<K, T> nodo);

    public int countLeaf(Node<K, T> nodo);

    public int countCompleteElements(Node<K, T> nodo);

    public LinkedList<T> inOrder(LinkedList<T> lista, Node<K, T> nodo);

    public LinkedList<K> preOrder(LinkedList<K> lista, Node<K, T> nodo);

    public LinkedList<K> postOrder(LinkedList<K> lista, Node<K, T> nodo);

    public LinkedList<K> recorridaNivel(LinkedList<K> lista, Node<K, T> nodo) throws EmptyQueueException;

    public void loadPostFijaExpression(String sPostFija);
}
