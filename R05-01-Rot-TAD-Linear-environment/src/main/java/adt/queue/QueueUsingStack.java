package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
			throw new QueueOverflowException();
		}
		//Insert elements in stack1
		try{
			stack1.push(element);

		}
		catch (Exception e){

		}



	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
		T element = null;
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				try{
					stack2.push(stack1.pop());
				}
				catch (Exception e){

				}
			}
			try {
				element = stack2.pop();

			}
			catch (Exception e){

			}

		}
		else{
			try {
				element = stack2.pop();

			}
			catch (Exception e){

			}

		}
		return element;

	}


	@Override
	public T head() {
		if (isEmpty()) {
			return null;
		}
		T element = null;
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				try {
					stack2.push(stack1.pop());
				} catch (Exception e) {

				}
			}
			try {
				element = stack2.top();

			} catch (Exception e) {

			}

		} else {
			try {
				element = stack2.top();

			}
			catch (Exception e) {

			}

		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		 return stack1.isEmpty() && stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}

}
