package sorting.divideAndConquer;


import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (indexValidator(array,leftIndex,rightIndex) == false || arrayValidator(array) == false) {
			return;
		}
		if( leftIndex >= rightIndex){
			return;
		}

		else{
			int middle = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);

			merge(array, leftIndex, middle, rightIndex);
		}

	}
	public void merge(T[] array, int leftIndex, int middle, int righIndex){
		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;
		T[] aux = Arrays.copyOf(array, array.length);

		while(i <= middle && j <= righIndex){
			if(aux[i].compareTo(aux[j]) < 0 || aux[i].compareTo(aux[j]) == 0){
				array[k++] = aux[i++];
			}
			else{
				array[k++] = aux[j++];
			}

		}
		while(i<= middle){
			array[k++] = aux[i++];
		}

		while(j <= righIndex){
			array[k++] = aux[j++];
		}


	}
	public static boolean indexValidator(Object[] array, int leftIndex, int rightIndex){
		boolean validate = false;

		if(array == null){
			return false;
		}
		else if(leftIndex >= 0 && leftIndex <= array.length-1 && leftIndex <= rightIndex && rightIndex <= array.length-1){
			validate = true;
		}
		return validate;
	}

	public static boolean arrayValidator(Object[] array){
		boolean validate = true;

		if(array == null){
			return false;
		}
		else if(array.length == 0 || array.length == 1){
			validate = false;
		}
		return validate;
	}
}
