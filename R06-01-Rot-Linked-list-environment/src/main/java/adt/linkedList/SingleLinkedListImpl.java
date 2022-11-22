package adt.linkedList;

import java.util.Arrays;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		if(isEmpty()){
			return 0;
		}
		else if(head.getNext().isNIL()){
			return 1;
		}

		SingleLinkedListNode aux = head;
		int cont = 1;

		while (!aux.getNext().isNIL()){
			aux = aux.getNext();
			cont++;
		}
		return cont;


	}

	@Override
	public T search(T element) {
		if(isEmpty()){
			return null;
		}
		if(size() == 1){
			return head.getData();
		}
		SingleLinkedListNode aux = head;
		while(!aux.getNext().isNIL()){
			if(aux.getData().equals(element)){
				return (T) aux.getData();
			}
			aux = aux.getNext();

		}
		return null;
	}

	@Override
	public void insert(T element) {
		if(!(element == null)){
			SingleLinkedListNode newNode = new SingleLinkedListNode();
			newNode.setData(element);
			SingleLinkedListNode aux = head;


			if(size() == 0){
				head = newNode;
				newNode.setNext(new SingleLinkedListNode<>());
			}
			else{
				while(!aux.getNext().isNIL()){
					aux = aux.getNext();
				}
				aux.setNext(newNode);
				newNode.setNext(new SingleLinkedListNode<>());

			}

		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()){
			if(size() == 1){
				head.setNext(new SingleLinkedListNode<>());
			}
			else{
				SingleLinkedListNode aux = head;
				while(!aux.getNext().isNIL()){
					if(aux.getNext().getData().equals(element)){
						aux.setNext(aux.getNext().getNext());
						aux.setNext(new SingleLinkedListNode<>());
						break;
					}
					aux = aux.getNext();
				}
			}
		}
	}

	@Override
	public T[] toArray() {

		if(isEmpty()){
			T[] out = (T[]) new Comparable[0];
			return out;
		}
		T[] out = (T[]) new Comparable[size()];
		SingleLinkedListNode aux = head;
		int cont = 0;
		while(!aux.getNext().isNIL()){
			out[cont] = (T) aux.getData();
			aux = aux.getNext();
		}
		System.out.println(Arrays.toString(out));

		return out;


	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
