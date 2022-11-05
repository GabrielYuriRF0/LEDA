package problems;

import java.util.Arrays;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		quickSort(array,0,array.length-1);

		return 0;
	}

	private boolean binarySearch(int x, Integer[] array, int left, int right){


	}


	private void quickSort(Integer[] array, int left, int right){
		if(left < right){
			int index_pivot = partition(array, left, right);
			quickSort(array, left, index_pivot - 1);
			quickSort(array, index_pivot + 1, right);
		}

	}
	private int partition(Integer[] array, int leftIndex, int rightIndex){
		int range = rightIndex - leftIndex + 1;
		int rand_pivot_index = (int)(Math.random() * range) + leftIndex;
		swap(array, leftIndex, rand_pivot_index);

		int pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j] <= pivot) {
				i+=1;
				swap(array, i, j);
			}
		}
		swap(array, leftIndex, i);
		return i;
	}

	private static void swap(Integer[] array, int i, int j) {
		if (array == null)
			throw new IllegalArgumentException();

		Integer temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}





}
