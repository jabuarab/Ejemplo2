/**
 * 
 */
package uy.edu.um.adt.binarytree.recursive;



/**
 * Representa un arbol binario de busqueda
 * 
 * @author danielpereda
 */
public interface BinaryTree <AnyType extends Comparable<AnyType>> {

	void add(AnyType oElement) throws InvalidValue;
	
	BinaryTree<AnyType> delete(AnyType oElement);
	
	boolean exists(AnyType oElement);
	
	AnyType getMinValue();
	
	AnyType getMaxValue();
	
	int getHeight();
	
	AnyType getRoot();
	
	BinaryTree<AnyType> getLeftChild();
	
	BinaryTree<AnyType> getRightChild();
}
