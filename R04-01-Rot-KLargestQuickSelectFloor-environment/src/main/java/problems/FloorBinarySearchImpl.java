package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if(validator(array,x) == false){
			return null;
		}
		int leftIndex = 0;
		int righIndex = array.length-1;
		int m = (leftIndex + righIndex) / 2;

		quickSort(array,leftIndex,righIndex);

		if(x < array[leftIndex]){
			return null;
		}

		return bynarySearch(x,array,leftIndex,righIndex);
	}

	private boolean validator(Integer[] array, Integer x){
		if(array == null || array.length == 0 || x < 0){
			return false;
		}
		return true;
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
		Util.swap(array, leftIndex, rand_pivot_index);

		int pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j] <= pivot) {
				i+=1;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;
	}
}
