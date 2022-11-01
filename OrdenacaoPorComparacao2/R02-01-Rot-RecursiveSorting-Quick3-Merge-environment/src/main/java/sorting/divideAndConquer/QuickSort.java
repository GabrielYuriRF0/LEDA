package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {



	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (indexValidator(array,leftIndex,rightIndex) == false || arrayValidator(array) == false){
			return;
		}

		else if(leftIndex < rightIndex){
			int indexPivot = partitioning(array,leftIndex,rightIndex);
			sort(array,leftIndex,indexPivot-1);
			sort(array,indexPivot+1,rightIndex);
		}
	}

	private  int partitioning(T[] array, int left, int right){
		int i = left;
		T pivot = array[left];

		for(int j = left + 1; j <= right; j++){
			if(array[j].compareTo(pivot) < 0 || array[j].compareTo(pivot) == 0){
				i++;
				Util.swap(array,i,j);

			}
		}
		Util.swap(array,left, i);
		return i;

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
