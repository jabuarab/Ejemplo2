/**
 * 
 */
package uy.edu.um.adt.binarytree.withnode;

import java.util.List;

/**
 * @author pegardan
 *
 */
public interface BinaryTreeWithNode<T extends Comparable<T>> {

	void add(T oElement);

	void remove(T oElement);

	T findMin();

	List<T> preOrder();

	List<T> posOrder();

	List<T> inOrder();

}
