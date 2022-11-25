package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode newNode = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), new DoubleLinkedListNode<>());


		if(super.isEmpty()){
			super.setHead(newNode);
			setLast(newNode);
			newNode.setNext(new DoubleLinkedListNode());
			newNode.setPrevious(new DoubleLinkedListNode());
		}
		else{
			newNode.setNext(super.getHead());
			newNode.setPrevious(new DoubleLinkedListNode());
			super.setHead(newNode);

		}

	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			if((super.getHead().equals(getLast()))){
				super.setHead(new DoubleLinkedListNode<>());
				setLast(new DoubleLinkedListNode<>());
			}

			else{
				super.setHead(super.getHead().getNext());
			}
		}



	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
