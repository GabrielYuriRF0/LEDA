package problems;

import java.util.Arrays;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		int leftIndex = 0;
		int righIndex = array.length-1;
		int m = (leftIndex + righIndex) / 2;

		quickSort(array,leftIndex,righIndex);

		if(x < array[leftIndex]){
			return null;
		}

		return bynarySearch(x,array,leftIndex,righIndex);
	}

	private Integer bynarySearch(int x, Integer[] array, int left, int right){
		int middle = (left + right) / 2;

		if(left > right){
			return array[middle];
		}


		if(x == array[middle]){
			return x;
		}


		if(x < array[middle]){
			return bynarySearch(x,array,left,middle-1);
		}
		else{
			return bynarySearch(x,array,middle+1,right);
		}

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
