package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;
/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (indexValidator(array,leftIndex,rightIndex) == false || arrayValidator(array) == false) {
			return;
		}
		else{
			for(int i = leftIndex + 1; i <= rightIndex; i++){
				int j = i;
				while(j > leftIndex && array[j].compareTo(array[j-1]) < 0){
					Util.swap(array,j,j-1);
					j--;
				}
			}

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
