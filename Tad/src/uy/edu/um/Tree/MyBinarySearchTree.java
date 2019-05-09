package uy.edu.um.Tree;

public interface MyBinarySearchTree<K extends Comparable<K>, T> {

    public T find(K key);

   public void insert(K key, T data);

   public void delete(K key);
}
