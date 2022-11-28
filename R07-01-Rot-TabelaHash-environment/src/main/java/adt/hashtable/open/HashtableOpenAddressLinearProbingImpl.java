package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunction;
import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

import javax.swing.plaf.SeparatorUI;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if(isFull()){
			throw  new HashtableOverflowException();
		}
		else if(element != null && search(element) == null){
			boolean inserted = false;
			int prob = 0;
			while(!inserted){
				int hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, prob++);
				if(super.table[hash] == null || super.table[hash].equals(super.deletedElement)){
					super.table[hash] = element;
					super.elements++;
					inserted = true;
				}
				else{
					super.COLLISIONS++;
				}

			}

		}
	}

	@Override
	public void remove(T element) {
		if(indexOf(element) != -1){
			super.table[indexOf(element)] = super.deletedElement;
			super.elements--;
		}
	}

	@Override
	public T search(T element) {
		T out = null;

		if(indexOf(element) != -1){
			return (T) super.table[indexOf(element)];

		}

		return  out;
	}

	@Override
	public int indexOf(T element) {
		if(element != null && !isEmpty()){
			int prob = 0;
			while(prob < super.capacity()){
				int hash = ((HashFunctionLinearProbing<T>) hashFunction).hash(element, prob);

				if(super.table[hash] == null || super.table[hash].equals(super.deletedElement)){
					return -1;
				}

				else if(super.table[hash].equals(element)){
					return hash;
				}
				prob++;
			}
		}
		return -1;
	}

}
