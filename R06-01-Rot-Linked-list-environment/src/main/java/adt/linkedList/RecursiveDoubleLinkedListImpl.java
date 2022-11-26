package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if (super.isEmpty()) {

			this.setData(element);
			this.setNext(new RecursiveDoubleLinkedListImpl<>());
			((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);

		}
		else {
			this.getNext().insert(element);
		}
	}

	@Override
	public void insertFirst(T element) {
		if (super.isEmpty()) {
			this.insert(element);

		}
		else {
			RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<>();
			newNode.setData(this.getData());
			newNode.setNext(this.getNext());

			this.setData(element);
			this.setNext(newNode);

			newNode.setPrevious(this);
			((RecursiveDoubleLinkedListImpl<T>) newNode.getNext()).setPrevious(newNode);

		}
	}

	@Override
	public void remove(T element) {
		if (!super.isEmpty()) {
			if (this.getData().equals(element)) {
				if (super.size()==1) {
					this.removeFirst();
				}
				else {
					this.setData(this.getNext().getData());
					this.setNext(this.getNext().getNext());

					if (this.getNext()!=null) {
						((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
					}

				}

			}
			else {
				this.getNext().remove(element);

			}
		}
	}

	@Override
	public void removeFirst() {
		if (!super.isEmpty()) {

			if (super.size()==1) {

				this.setData(null);
				this.setPrevious(null);
				this.setNext(null);

			}
			else {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);

			}
		}
	}

	@Override
	public void removeLast() {
		if (!super.isEmpty()) {
			if (this.getNext().isEmpty()) {
				this.remove(this.getData());

			}
			else {
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).removeLast();

			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
