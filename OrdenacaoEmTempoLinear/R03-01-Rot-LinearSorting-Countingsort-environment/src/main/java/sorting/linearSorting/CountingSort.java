package sorting.linearSorting;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		//Validations
		if (validator(array, leftIndex, rightIndex) == false) {
			return;
		}

		Integer[] arrayPart = Arrays.copyOfRange(array,leftIndex,rightIndex+1);
		int[] aux = new int[arrayPart.length];
		int max = getMaxNumber(arrayPart);
		int c[] = new int [max+1];

		//Frequency
		for(int i = 0; i < arrayPart.length; i++){
			c[arrayPart[i]]++;
		}

		//Cumulative
		for(int i = 1; i < c.length;i++){
			c[i] += c[i-1];
		}
		for(int i = arrayPart.length-1; i >=0 ; i--){
			aux[c[arrayPart[i]]-1] = arrayPart[i];
			c[arrayPart[i]]--;
		}

		int j = 0;
		for(int  i = leftIndex; i <= rightIndex; i++){
			array[i] = aux[j++];

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
