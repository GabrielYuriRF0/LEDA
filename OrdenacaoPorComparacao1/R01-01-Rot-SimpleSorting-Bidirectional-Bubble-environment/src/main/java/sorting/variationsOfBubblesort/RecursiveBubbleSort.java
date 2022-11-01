package sorting.variationsOfBubblesort;
import sorting.AbstractSorting;
import util.Util;



public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {


	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (indexValidator(array,leftIndex,rightIndex) == false || arrayValidator(array) == false) {
			return;
		}
		if(leftIndex == rightIndex){
			return;
		}
		for(int i = leftIndex; i <rightIndex; i++){
			if(array[i].compareTo(array[i+1]) > 0){
				Util.swap(array,i,i+1);
			}

		}
		sort(array, leftIndex, --rightIndex);

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
