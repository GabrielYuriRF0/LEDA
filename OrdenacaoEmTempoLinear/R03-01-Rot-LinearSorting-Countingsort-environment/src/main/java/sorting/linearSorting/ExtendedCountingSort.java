package sorting.linearSorting;

import sorting.AbstractSorting;
import java.util.Arrays;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		//Validations
		if(validator(array,leftIndex,rightIndex) == false){
			return;
		}

		else{
			Integer[] arrayPart = Arrays.copyOfRange(array,leftIndex,rightIndex+1);
			int[] aux = new int[arrayPart.length];
			int min = getMinNumber(arrayPart);
			int max = getMaxNumber(arrayPart);
			int c[] = new int [max-min+1];

			//Frequency
			for(int i = 0; i < arrayPart.length; i++){
				c[arrayPart[i] - min]++;
			}

			//Cumulative
			for(int i = 1; i < c.length;i++){
				c[i] += c[i-1];
			}
			for(int i = arrayPart.length-1; i >=0 ; i--){
				aux[c[arrayPart[i] - min]-1] = arrayPart[i];
				c[arrayPart[i] - min]--;
			}

			int j = 0;
			for(int  i = leftIndex; i <= rightIndex; i++){
				array[i] = aux[j++];

			}


		}

	}

	public static int getMaxNumber(Integer[] array){
		int maxNumber = array[0];

		for(int i = 0; i < array.length; i++){
			if(array[i] > maxNumber){
				maxNumber = array[i];
			}
		}

		return maxNumber;
	}

	public static int getMinNumber(Integer[] array){
		int minNumber = array[0];
		for(int i = 0; i < array.length; i++){
			if(array[i] < minNumber){
				minNumber = array[i];
			}
		}

		return minNumber;
	}

	private boolean validator(Integer[] array, int leftIndex, int rightIndex){
		if(array == null){
			return false;
		}

		if(leftIndex >= 0 && leftIndex <= array.length-1 && leftIndex <= rightIndex && rightIndex <= array.length-1){
			return true;
		}

		else if(array.length == 0 || array.length == 1){
			return false;
		}
		return false;
	}


}
