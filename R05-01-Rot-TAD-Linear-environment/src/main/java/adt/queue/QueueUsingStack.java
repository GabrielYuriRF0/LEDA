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
		int elements = 0;
		if(stack1.isFull()){
			while(!stack1.isEmpty()){
				try{
					stack2.push(stack1.pop());
				}
				catch (Exception e){

				}
			}
		}

		else{

			try{
				stack2.push(stack1.top());
			}
			catch (Exception e){

			}
		}



	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
        T element = stack2.top();
        try {
            stack2.pop();
            stack1.pop();

        }
        catch (Exception e){

        }

        return element;
	}

	@Override
	public T head() {
		if(isEmpty()){
            System.out.println("Entrou");
            return null;
        }
        return stack2.top();

	}

	@Override
	public boolean isEmpty() {
		return stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack2.isFull();
	}

}
