/**
 * 
 */
package uy.edu.um.adt.binarytree.withnode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pegardan
 * @param <T>
 *
 */
public class SearchBinaryTreeImpl<T extends Comparable<T>> implements
		BinaryTreeWithNode<T> {

	private TreeNode<T> root;

	@Override
	public void add(T oElement) {
		TreeNode<T> oElementToAdd = new TreeNode<T>(oElement);

		if (root == null) {

			root = oElementToAdd;

		} else {

			root.add(oElement);

		}
	}

	public boolean contains(T oElement) {

		return contains(oElement, root);
	}

	private boolean contains(T oElement, TreeNode<T> oElementToSearch) {
		boolean bContains = false;
		if (oElementToSearch != null) {

			int nValue = ((Comparable<T>) oElementToSearch.getValue())
					.compareTo(oElement);

			if (nValue == 0) {
				bContains = true;
			} else if (nValue > 0) {
				bContains = contains(oElement, oElementToSearch.getRight());
			} else {
				bContains = contains(oElement, oElementToSearch.getLeft());
			}

		}

		return bContains;
	}

	public T findMin() {
		T oMin = null;

		if (root != null) {

			oMin = root.findMin();

		}

		return oMin;
	}

	@Override
	public void remove(T oElement) {

		if (root != null) {

			root.remove(oElement);

		}

	}

	@Override
	public List<T> preOrder() {
		List<T> colValues = new ArrayList<T>();

		if (root != null) {

			colValues.addAll(root.preOrderTraverse());

		}

		return colValues;
	}

	@Override
	public List<T> posOrder() {
		List<T> colValues = new ArrayList<T>();

		if (root != null) {

			colValues.addAll(root.postOrderTraverse());

		}

		return colValues;
	}

	@Override
	public List<T> inOrder() {
		List<T> colValues = new ArrayList<T>();

		if (root != null) {

			colValues.addAll(root.inOrderTraverse());

		}

		return colValues;
	}

}
