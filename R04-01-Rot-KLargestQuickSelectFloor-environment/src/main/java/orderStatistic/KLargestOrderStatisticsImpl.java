package orderStatistic;

import util.Util;


/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 *
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1].
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 *
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as
 * estatisticas de ordem maiores que k.
 *
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 *   Voce pode criar ainda um array de tamanho k que vai armazenar apenas
 *   os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala
 *   para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 *   ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 *   Este metodo NUNCA deve retornar null.
 *
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {
		if(validator(array,k) == false){
			T[] arrayVazio = (T[]) new Comparable[0];
			return arrayVazio;
		}
		T[] result = (T[]) new Comparable[k];

		int cont = k-1;
		for(int i = 1; i <= k; i++){
			result[cont--] = orderStatistics(array,i);
		}
		return result;

	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista
	 * a k-esima estatistica de ordem, entao retorna null.
	 *
	 * Obs: o valor de k deve ser entre 1 e N.
	 *
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		if(k > array.length || k <= 0){
			return null;
		}
		else{
			quickSort(array,0,array.length - 1);
			return array[array.length - k];
		}


	}
	private boolean validator(T[] array, int k){

		if(array == null || array.length == 0 || k <= 0 || k > array.length){
			return false;
		}
		return true;
	}

	private void quickSort(T[] array, int left, int right){
		if(left < right){
			int index_pivot = partition(array, left, right);
			quickSort(array, left, index_pivot - 1);
			quickSort(array, index_pivot + 1, right);
		}

	}
	private int partition(T[] array, int leftIndex, int rightIndex){
		int range = rightIndex - leftIndex + 1;
		int rand_pivot_index = (int)(Math.random() * range) + leftIndex;
		Util.swap(array, leftIndex, rand_pivot_index);
		T pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j] .compareTo(pivot) <=0) {
				i+=1;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;
	}



}
