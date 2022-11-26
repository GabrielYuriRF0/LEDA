package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) this.head;
	}

	@Override
	public void insert(T element) {
		if (!element.equals(null)) {
			if (super.isEmpty()) {
				super.getHead().setData(element);
				super.getHead().setNext(new DoubleLinkedListNode<T>());
				getLast().setNext(new DoubleLinkedListNode<T>());
				getLast().setPrevious(new DoubleLinkedListNode<T>());
				((DoubleLinkedListNode<T>) super.getHead()).setPrevious(new DoubleLinkedListNode<T>());

			} else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>)super.getHead();

				while (!aux.getNext().isNIL()) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}

				((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux);
				this.last = (DoubleLinkedListNode<T>) aux.getNext();
				aux.getNext().setData(element);
				aux.getNext().setNext(new DoubleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (!element.equals(null)) {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(
					element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());

			if (this.isEmpty()) {
				super.setHead(newNode);
				setLast(newNode);
			} else {
				newNode.next = super.getHead();
				((DoubleLinkedListNode<T>) super.getHead()).previous = newNode;
				super.setHead( newNode);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!super.isEmpty()) {
			if (super.size() == 1) {
				super.setHead(new DoubleLinkedListNode<T>());
				setLast((DoubleLinkedListNode<T>) this.head);
			} else {
				super.setHead(this.head.next);
				((DoubleLinkedListNode<T>) super.getHead()).previous = new DoubleLinkedListNode<T>();
			}
		}
	}

	@Override
	public void removeLast() {
		if(!this.last.isNIL()) {
			setLast(getLast().getPrevious());
			getLast().setNext(new DoubleLinkedListNode<T>());
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}


}