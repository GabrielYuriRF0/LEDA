package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.getRoot());
	}

	public int height(BSTNode<T> node) {
		int treeHeight = -1;

		if (!node.isEmpty()) {
			treeHeight = 1 + Math.max(height((BSTNode<T>) node.getLeft()),
					height((BSTNode<T>) node.getRight()));
		}

		return treeHeight;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> result = new BSTNode<T>();

		if (element!=null && !this.isEmpty()) {
			result = search(this.getRoot(), element);
		}

		return result;
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> searchedNode = new BSTNode<T>();

		if (!node.isEmpty()) {

			if (node.getData().equals(element)) {
				searchedNode = node;
			} else if (node.getData().compareTo(element)>0) {
				searchedNode = search((BSTNode<T>) node.getLeft(), element);
			} else {
				searchedNode = search((BSTNode<T>) node.getRight(), element);
			}
		}

		return searchedNode;
	}

	@Override
	public void insert(T element) {
		if (element!=null) {
			insert(this.getRoot(), element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {

			node.setData(element);
			node.setLeft(new BSTNode.Builder<T>()
					.data(null)
					.left(null)
					.right(null)
					.parent(node)
					.build());
			node.setRight(new BSTNode.Builder<T>()
					.data(null)
					.left(null)
					.right(null)
					.parent(node)
					.build());

		} else {

			if (node.getData().compareTo(element)>0) {
				insert((BSTNode<T>) node.getLeft(), element);
			} else {
				insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;

		if (!this.isEmpty()) {
			result = maximum(this.getRoot());
		}

		return result;
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> maxElement = node;

		if (!node.getRight().isEmpty()) {
			maxElement = maximum((BSTNode<T>) node.getRight());
		}

		return maxElement;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> result = null;

		if (!this.isEmpty()) {
			result = minimum(this.getRoot());
		}

		return result;
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> minElement = node;

		if (!node.getLeft().isEmpty()) {
			minElement = minimum((BSTNode<T>) node.getLeft());
		}

		return minElement;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> result = null;
		BSTNode<T> auxNode = search(element);

		if (element!=null && !this.getRoot().isEmpty() && !auxNode.isEmpty()) {

			if (!auxNode.getRight().isEmpty()) {
				auxNode = minimum((BSTNode<T>) auxNode.getRight());
			} else {
				auxNode = sucessor(auxNode);
			}

			result = auxNode;
		}

		return result;
	}

	private BSTNode<T> sucessor(BSTNode<T> node) {
		BSTNode<T> sucessor = (BSTNode<T>) node.getParent();

		if (node.getParent()!=null && !sucessor.isEmpty() && sucessor.getRight().equals(node)) {
			sucessor = sucessor((BSTNode<T>) node.getParent());
		}

		return sucessor;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> result = null;
		BSTNode<T> auxNode = search(element);

		if (element!=null && !this.getRoot().isEmpty() && !auxNode.isEmpty()) {

			if (!auxNode.getLeft().isEmpty()) {
				auxNode = maximum((BSTNode<T>) auxNode.getLeft());
			} else {
				auxNode = predecessor(auxNode);
			}

			result = auxNode;
		}

		return result;
	}

	private BSTNode<T> predecessor(BSTNode<T> node) {
		BSTNode<T> predecessor = (BSTNode<T>) node.getParent();

		if (node.getParent()!=null && !predecessor.isEmpty() && predecessor.getLeft().equals(node)) {
			predecessor = predecessor((BSTNode<T>) node.getParent());
		}

		return predecessor;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> nodeToRemove = search(element);

		if (!nodeToRemove.isEmpty()) {

			if (nodeToRemove.isLeaf()) {
				nodeToRemove.setData(null);
				nodeToRemove.setLeft(null);
				nodeToRemove.setRight(null);

			} else if (nodeToRemove.getLeft().isEmpty() || nodeToRemove.getRight().isEmpty()) {
				BSTNode<T> parent = (BSTNode<T>) nodeToRemove.getParent();

				if (parent!=null) {

					if (!parent.getLeft().equals(nodeToRemove)) {

						if (!nodeToRemove.getLeft().isEmpty()) {
							parent.setRight(nodeToRemove.getLeft());
							nodeToRemove.getLeft().setParent(parent);
						} else {
							parent.setRight(nodeToRemove.getRight());
							nodeToRemove.getRight().setParent(parent);
						}

					} else {

						if (!nodeToRemove.getLeft().isEmpty()) {
							parent.setLeft(nodeToRemove.getLeft());
							nodeToRemove.getLeft().setParent(parent);
						} else {
							parent.setLeft(nodeToRemove.getRight());
							nodeToRemove.getRight().setParent(parent);
						}
					}

				} else {

					if (!nodeToRemove.getLeft().isEmpty()) {
						this.root = (BSTNode<T>) nodeToRemove.getLeft();
					} else {
						this.root = (BSTNode<T>) nodeToRemove.getRight();
					}

					this.root.setParent(null);
				}

			} else {

				T sucessor = sucessor(nodeToRemove.getData()).getData();
				remove(sucessor);
				nodeToRemove.setData(sucessor);

			}
		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<T>();
		preOrder(list, this.getRoot());
		return (T[]) list.toArray(new Comparable[this.size()]);
	}

	private void preOrder(ArrayList<T> list, BSTNode<T> node) {
		if (!node.isEmpty()) {

			list.add(node.getData());
			preOrder(list, (BSTNode<T>) node.getLeft());
			preOrder(list, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> list = new ArrayList<T>();
		order(list, this.getRoot());
		return (T[]) list.toArray(new Comparable[this.size()]);
	}

	private void order(ArrayList<T> list, BSTNode<T> node) {
		if (!node.isEmpty()) {

			order(list, (BSTNode<T>) node.getLeft());
			list.add(node.getData());
			order(list, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<T>();
		postOrder(list, this.getRoot());
		return (T[]) list.toArray(new Comparable[this.size()]);
	}

	private void postOrder(ArrayList<T> list, BSTNode<T> node) {
		if (!node.isEmpty()) {

			postOrder(list, (BSTNode<T>) node.getLeft());
			postOrder(list, (BSTNode<T>) node.getRight());
			list.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}