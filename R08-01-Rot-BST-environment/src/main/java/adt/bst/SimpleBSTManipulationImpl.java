package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return equals((BST<T>) tree1.getRoot(), (BST<T>) tree2.getRoot());
	}

	private boolean equals(BSTNode<T> nodeT1, BSTNode<T> nodeT2) {
		boolean result;

		if (nodeT1==null && nodeT2==null) {
			result = true;
		} else if ((nodeT1!=null && nodeT2==null) || (nodeT1==null && nodeT2!=null)) {
			result = false;
		} else {
			if (nodeT1.equals(nodeT2) &&
					equals((BST<T>) nodeT1.getLeft(), (BST<T>) nodeT2.getLeft()) &&
					equals((BST<T>) nodeT1.getRight(), (BST<T>) nodeT2.getRight())) {
				result = true;
			} else {
				result = false;
			}
		}

		return result;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return isSimilar((BST<T>) tree1.getRoot(), (BST<T>) tree2.getRoot());
	}

	private boolean isSimilar(BSTNode<T> nodeT1, BSTNode<T> nodeT2) {
		boolean result;

		if (nodeT1==null && nodeT2==null) {
			result = true;
		} else if ((nodeT1!=null && nodeT2==null) || (nodeT1==null && nodeT2!=null)) {
			result = false;
		} else {
			if (isSimilar((BST<T>) nodeT1.getLeft(), (BST<T>) nodeT2.getLeft()) &&
					isSimilar((BST<T>) nodeT1.getRight(), (BST<T>) nodeT2.getRight())) {
				result = true;
			} else {
				result = false;
			}
		}

		return result;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T result = null;

		if (!tree.isEmpty() && k>0 && k<=tree.size()) {
			result = orderStatistic(tree, tree.minimum(), k);
		}

		return result;
	}
	private T orderStatistic(BST<T> tree, BSTNode<T> currentNode, int k) {
		T result = null;

		if (currentNode!=null && !currentNode.isEmpty()) {

			k--;

			if (k==0) {
				result = currentNode.getData();
			} else {
				BSTNode<T> sucessor = tree.sucessor(currentNode.getData());
				result = orderStatistic(tree, sucessor, k);
			}
		}

		return result;
	}

}
