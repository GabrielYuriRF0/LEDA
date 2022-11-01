package sorting.variationsOfBubblesort;
import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (indexValidator(array,leftIndex,rightIndex) == false || arrayValidator(array) == false) {
			return;
		}
		else{
			T aux;
			while(leftIndex < rightIndex){
					for(int j = leftIndex; j < rightIndex; j++){
						if(array[j].compareTo(array[j+1]) > 0){
							Util.swap(array,j, j+1);
						}
					}
					rightIndex--;

					for(int k = rightIndex; k > leftIndex; k--){
						if(array[k].compareTo(array[k-1]) < 0){
							Util.swap(array,k, k-1);
						}

					}
					leftIndex++;

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

