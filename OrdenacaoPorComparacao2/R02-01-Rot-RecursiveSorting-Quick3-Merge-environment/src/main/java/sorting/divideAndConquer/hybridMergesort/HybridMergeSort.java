package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;
import java.util.Arrays;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		this.MERGESORT_APPLICATIONS = 0;
		this.INSERTIONSORT_APPLICATIONS = 0;

		if (indexValidator(array,leftIndex,rightIndex) == false || arrayValidator(array) == false){
			return;
		}

		else if(rightIndex - leftIndex + 1 <= SIZE_LIMIT){
			this.INSERTIONSORT_APPLICATIONS++;
			insertionSort(array,leftIndex,rightIndex);
		}
		else{
			this.MERGESORT_APPLICATIONS++;
			mergeSort(array,leftIndex,rightIndex);

		}

	}
	public void mergeSort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex >= rightIndex){
			return;
		}
		else{
			int middle = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, middle);
			mergeSort(array, middle + 1, rightIndex);

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

	public void insertionSort(T[] array, int leftIndex, int rightIndex){
			for(int i = leftIndex + 1; i <= rightIndex; i++){
				int j = i;
				while(j > leftIndex && array[j].compareTo(array[j-1]) < 0){
					Util.swap(array,j,j-1);
					j--;
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

