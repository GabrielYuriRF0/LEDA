package recursao;
import java.util.Objects;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array, int indice){
		int result = array[indice];
		if(indice == array.length - 1 ){
			return array[indice];
		}
		return result + calcularSomaArray(array,++indice);

	}
	public long calcularFatorial(int n) {

		if(n == 1 || n == 0){
			return 1;
		}
		long result = n * calcularFatorial(n - 1);
		System.out.println(n + "! = " +  result );
		return result;
	}

	public int calcularFibonacci(int n){
		if(n == 1 || n == 2){
			return 1;
		}
		return calcularFibonacci(n-1) + calcularFibonacci(n-2);
	}

	public int countNotNull(Object[] array, int indice) {
		if(indice == array.length){
			return 0;
		}
		if(Objects.isNull(array[indice]) == false){
			return 1 + countNotNull(array, ++indice);
		}
		return 0;
	}

	public long potenciaDe2(int expoente) {
		if(expoente == 0) {
			return 1;
		}
		return 2 * potenciaDe2(--expoente);
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		/*
		temorInicial = 2, razao = 3, n = 4
		[2,5,8,11]
		an = 11
		 */
		if(n == 1){
			return termoInicial;
		}

		return razao + progressaoAritmetica(termoInicial,razao, --n);
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		if(n == 1){
			return termoInicial;
		}
		return razao * progressaoGeometrica(termoInicial,razao, --n);

	}
	
	
}
