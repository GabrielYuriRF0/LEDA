package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;
import java.util.Arrays;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (indexValidator(array,leftIndex,rightIndex) == false || arrayValidator(array) == false){
			return;
		}


		else if(rightIndex - leftIndex+1 == 2) {
			arrayTamanho2(array, leftIndex, rightIndex);
		}

		else if (leftIndex < rightIndex){
			int indexPivot = partition(array,leftIndex,rightIndex);
			sort(array,leftIndex,indexPivot-1);
			sort(array,indexPivot+1,rightIndex);

		}



		}




	public int partition(T[] array, int leftIndex, int rightIndex){
		int pivotIndex = pickPivotIndex(array,leftIndex,rightIndex);
		int i = rightIndex - 1;
		Util.swap(array, pivotIndex, rightIndex - 1);

		for (int j = i - 1; j >= leftIndex + 1; j--){
			if (array[j].compareTo(array[rightIndex - 1]) >= 0){
				i--;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, i, rightIndex - 1);

		return i;


	}

	public int pickPivotIndex(T[] array, int leftIndex, int rightIndex){
		int middle = (leftIndex + rightIndex)/2;
		T[] aux = (T[]) new Comparable[] {array[leftIndex], array[middle], array[rightIndex]};

		Arrays.sort(aux);
		array[leftIndex] = aux[0];
		array[middle] = aux[1];
		array[rightIndex] = aux[2];

		return ((leftIndex + rightIndex) / 2);
	}

	public void arrayTamanho2(T[] array, int leftIndex, int rightIndex){
		if(array[leftIndex].compareTo(array[rightIndex]) > 0){
			Util.swap(array,leftIndex,rightIndex);
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
