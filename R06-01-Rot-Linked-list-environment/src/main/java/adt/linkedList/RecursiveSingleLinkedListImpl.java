package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;



	@Override
	public boolean isEmpty() {
		return data == null;
	}

	@Override
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		return 1 + next.size();
	}

	@Override
	public T search(T element) {
		if(isEmpty()) {
			return null;
		}
		if(data.equals(element)) {
			return data;
		}
		return next.search(element);
	}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			data = element;
			next = new RecursiveSingleLinkedListImpl<T>();
		} else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()) {
			if(data.equals(element)) {
				data = next.getData();
				next = next.getNext();
			} else {
				next.remove(element);
			}
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		toArray(array, 0);
		return array;
	}

	private void toArray(T[] array, int i) {
		if(!isEmpty()) {
			array[i] = data;
			next.toArray(array, i+1);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}
}