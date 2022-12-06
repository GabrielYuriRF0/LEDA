package adt.bst;

import adt.bt.BTNode;

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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> search(T element) {
		if(isEmpty()){
			return new BSTNode<>();
		}
		else{
			return search(this.root, element);
		}

	}
	private BSTNode<T> search(BSTNode<T> current, T element){

		if(current.isEmpty()){
			return new BSTNode<>();
		}
		else if(element.compareTo(current.getData()) == 0){
			return current;
		}
		else if (element.compareTo((T) current.getData()) < 0){
			return search((BSTNode<T>) current.getLeft(), element);
		}
		else{
			return search((BSTNode<T>) current.getRight(), element);
		}

	}

	@Override
	public void insert(T element) {
		if(element != null){
			if(isEmpty()){
				 		BSTNode<Integer> newNode = (BSTNode<Integer>) new BSTNode.Builder<Integer>()
							.data((Integer) element)
							.left(null)
							.right(null)
							.parent(null)
							.build();
						 this.root = (BSTNode<T>) newNode;
						 this.root.setLeft(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(this.root).build());
						 this.root.setRight(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(this.root).build());
			}
			else{
				insert(element, this.root);
			}
		}
	}

	private void insert(T element, BSTNode current){
		if(element.compareTo((T) current.getData()) < 0){
			if(current.getLeft().isEmpty()){
				current.getLeft().setData(element);
				current.getLeft().setParent(current);
				current.getLeft().setLeft(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(current).build());
				current.getLeft().setRight(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(current).build());
				return;

			}
			insert(element,(BSTNode<T>)current.getLeft());
		}
		else{
			if(current.getRight().isEmpty()){
				current.getRight().setData(element);
				current.getRight().setParent(current);
				current.getRight().setLeft(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(current).build());
				current.getRight().setRight(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(current).build());
				return;

			}
			insert(element,(BSTNode<T>)current.getRight());
		}

	}

	@Override
	public BSTNode<T> maximum() {
		if(isEmpty()){
			return null;
		}
		else{
			return maximum(this.root);
		}

	}

	private BSTNode maximum(BSTNode current){
		if(current.getRight().isEmpty()){
			return current;
		}
		else{
			return maximum((BSTNode) current.getRight());
		}
	}

	@Override
	public BSTNode<T> minimum() {
		if(isEmpty()){
			return null;
		}
		else{
			return minimum(this.root);
		}
	}

	private BSTNode minimum(BSTNode current){
		if(current.getLeft().isEmpty()){
			return (BSTNode<T>) current;
		}
		else{
			return minimum((BSTNode<T>) current.getLeft());
		}
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);

		if(isEmpty() || node.isEmpty()){
			return null;
		}

		else if(!node.getRight().isEmpty()){
			return minimum((BSTNode<T>) node.getRight());
		}
		else if (node.getRight().isEmpty()){
			BSTNode<T> aux = (BSTNode<T>) node.getParent();

			while(!aux.getParent().isEmpty() && aux.getData().compareTo(element) < 0){
				aux = (BSTNode<T>) aux.getParent();
			}
			return aux;

		}
		return null;

	}





	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);

		if(isEmpty() || node.isEmpty() || node.getParent().isEmpty()){
			return null;
		}
		else if(!node.getLeft().isEmpty()){
			return maximum((BSTNode<T>) node.getLeft());
		}
		else{
			BSTNode<T> aux = (BSTNode<T>) node.getParent();

			while (aux != null  && aux.getData().compareTo(element) > 0){
				aux = (BSTNode<T>) aux.getParent();
			}
			return aux;
		}

	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if(!isEmpty() && !node.isEmpty()){
			if(node.isLeaf()){
				node = new BSTNode<T>();
			}

			else if(!node.getLeft().isEmpty() && node.getRight().isEmpty()){
				if(node.equals(this.root)){
					this.root = (BSTNode<T>) node.getLeft();
					this.root.setParent(null);
				}
				else{
					node.getLeft().setParent(node.getParent());

					if(node.getData().compareTo(node.getParent().getData()) < 0){
						node.getParent().setLeft(node.getLeft());

					}
					else{
						node.getParent().setRight(node.getLeft());
					}

				}
			}
			else if(node.getLeft().isEmpty() && !node.getRight().isEmpty()){
				if(node.equals(this.root)){
					this.root = (BSTNode<T>) node.getRight();
					this.root.setParent(null);
				}
				else{
					node.getRight().setParent(node.getParent());

					if(node.getData().compareTo(node.getParent().getData()) < 0){
						node.getParent().setLeft(node.getRight());

					}
					else{
						node.getParent().setRight(node.getRight());
					}
				}
			}

			else{
				T sucessor = sucessor(node.getData()).getData();
				remove(sucessor);
				node.setData(sucessor);
			}
		}
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
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
