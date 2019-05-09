package edu.um.prog2.Arbol.Mytree;

public interface MyTree<K,T>{
    public T find(K key);

    public void insert(K key, T data, K parentKey);

    public void delete (K key);

}
