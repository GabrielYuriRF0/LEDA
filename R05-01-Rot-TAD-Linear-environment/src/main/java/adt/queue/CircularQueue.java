package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
			throw new QueueOverflowException();
		}
		if(element != null){
			if(this.tail == this.array.length-1){
				this.tail = -1;
			}
			this.tail++;
			this.elements++;
			this.array[this.tail] = element;

		}


	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}

		if(this.head == this.array.length - 1){
			this.head = -1;
		}
		this.head++;
		this.elements--;
		T element = this.array[this.head];
		return element;
	}

	@Override
	public T head() {
		if(isEmpty()){
			return null;
		}
		int aux = -1;
		if(this.head == -1){
			aux++;
		}
		else{
			aux = this.head + 1;
		}
		return this.array[aux];
	}

	@Override
	public boolean isEmpty() {
		return this.elements == 0;
	}

	@Override
	public boolean isFull() {
		return this.elements == this.array.length;
	}

}
