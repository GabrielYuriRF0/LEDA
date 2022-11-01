package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.CountingSort;
import sorting.linearSorting.ExtendedCountingSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new ExtendedCountingSort();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */

	@Test
	public void leftIndexInvalido1(){
		Integer[] arrayTest = Arrays.copyOf(this.vetorTamPar, this.vetorTamPar.length);
		this.implementation.sort(arrayTest,-1,5);
		Assert.assertArrayEquals(arrayTest,this.vetorTamPar);
	}

	@Test
	public void leftIndexInvalido2(){
		Integer[] arrayTest = Arrays.copyOf(this.vetorTamPar, this.vetorTamPar.length);
		this.implementation.sort(arrayTest,8,5);
		Assert.assertArrayEquals(arrayTest,this.vetorTamPar);
	}

	@Test
	public void rightIndexInvalido1(){
		Integer[] arrayTest = Arrays.copyOf(this.vetorTamPar,this.vetorTamPar.length);
		this.implementation.sort(arrayTest,2,arrayTest.length+1);
		Assert.assertArrayEquals(arrayTest,this.vetorTamPar);
	}

	@Test
	public void rightLeftIguais1(){
		Integer[] arrayTest = Arrays.copyOf(this.vetorTamPar,this.vetorTamPar.length);
		this.implementation.sort(arrayTest,0,0);
		Assert.assertArrayEquals(arrayTest,this.vetorTamPar);
	}
	@Test
	public void rightLeftIguais2(){
		Integer[] arrayTest = Arrays.copyOf(this.vetorTamPar,this.vetorTamPar.length);
		this.implementation.sort(arrayTest,arrayTest.length-1,arrayTest.length-1);
		Assert.assertArrayEquals(arrayTest,this.vetorTamPar);
	}

	@Test
	public void arrayNulo(){
		Integer[] arrayTest = null;
		this.implementation.sort(arrayTest, 3, 5);
		Assert.assertArrayEquals(null,arrayTest);
	}
	@Test
	public void testeArrayPar2(){
		Integer[] arrayTest = {4,2,1,5,3,56,7,8,9,5,3,43,32,123,32,32,42,12};
		Integer[] arrayTest2 = Arrays.copyOf(arrayTest,arrayTest.length);
		Arrays.sort(arrayTest);
		this.implementation.sort(arrayTest2);
		Assert.assertArrayEquals(arrayTest,arrayTest2);
	}

	@Test
	public void ordenarPedacoPar(){
		Integer[] arrayTest1 = Arrays.copyOf(this.vetorTamPar,this.vetorTamPar.length);
		Arrays.sort(arrayTest1,2,6);
		Integer[] arrayTest2 = Arrays.copyOf(this.vetorTamPar, this.vetorTamPar.length);
		this.implementation.sort(arrayTest2,2,5);
		Assert.assertArrayEquals(arrayTest1,arrayTest2);

	}
	@Test
	public void testPedacoPar2(){
		Integer[] arrayTest = Arrays.copyOf(this.vetorTamPar, this.vetorTamPar.length);
		Integer[] arrayTest2 = Arrays.copyOf(this.vetorTamPar, this.vetorTamPar.length);
		this.implementation.sort(arrayTest, 2, 4);
		Arrays.sort(arrayTest2, 2,5);
		Assert.assertArrayEquals(arrayTest,arrayTest2);
	}

	@Test
	public void ordenarPedacoImpar(){
		Integer[] arrayTest1 = Arrays.copyOf(this.vetorTamPar, this.vetorTamPar.length);
		Arrays.sort(arrayTest1,3,6);
		Integer[] arrayTest2 = Arrays.copyOf(this.vetorTamPar, this.vetorTamPar.length);
		this.implementation.sort(arrayTest2,3,5);
		Assert.assertArrayEquals(arrayTest1,arrayTest2);
	}

	@Test
	public void arrayVazio(){
		Integer[] arrayTest = this.vetorVazio;
		Integer[] arrayTest2 = this.vetorVazio;
		Arrays.sort(arrayTest);
		this.implementation.sort(arrayTest2);
		Assert.assertArrayEquals(arrayTest,arrayTest2);
	}

	@Test
	public void arrayUnitario(){
		Integer[] arrayTest1 = {2};
		Integer[] arrrayTest2 = {2};

		Arrays.sort(arrayTest1);
		this.implementation.sort(arrrayTest2);

		Assert.assertArrayEquals(arrayTest1,arrrayTest2);
	}

	@Test
	public void arrayDe2Posicoes(){
		Integer[] arrayTest = Arrays.copyOf(this.vetorTamPar, 2);
		Integer[] array = new Integer[] {28, 30};
		this.implementation.sort(arrayTest);
		Assert.assertArrayEquals(arrayTest,array);
	}
	@Test
	public void arrayDe3Posicoes(){
		Integer[] arrayTest = Arrays.copyOf(this.vetorTamPar, 3);
		Integer[] array = new Integer[] {7, 28, 30};
		this.implementation.sort(arrayTest);
		Assert.assertArrayEquals(arrayTest,array);
	}

	// Os 4 testes abaixo estão comentados pois só servem para o ExtendedCountingSort
//	@Test
//	public void arrayComNegativo(){
//		Integer[] array = {5,3,4,-2,1,7};
//		Integer[] array2 = {5,3,4,-2,1,7};
//		Arrays.sort(array,2,5);
//		this.implementation.sort(array2,2,4);
//		Assert.assertArrayEquals(array, array2);
//	}
//	@Test
//	public void arrayComNegativo2(){
//		Integer[] arrayTest = {-1, -3, -2, -7, 5, 3, 2, 1, 56, 23, 122, 32};
//		Integer[] arrayTest2 = {-1, -3, -2, -7, 5, 3, 2, 1, 56, 23, 122, 32};
//		Arrays.sort(arrayTest);
//		this.implementation.sort(arrayTest2);
//		Assert.assertArrayEquals(arrayTest,arrayTest2);
//	}
//
//	@Test
//	public void arrayComNegativoEZero(){
//		Integer[] array = {5,3,4,-2,1,7,0};
//		Integer[] array2 = {5,3,4,-2,1,7,0};
//		Arrays.sort(array,2,6);
//		this.implementation.sort(array2,2,5);
//		Assert.assertArrayEquals(array, array2);
//	}
//
//	@Test
//	public void arrayComNegativo3(){
//		Integer[] array1 = {-2,5,3,4,1};
//		Integer[] array2 = Arrays.copyOf(array1,array1.length);
//		Arrays.sort(array1,0,3);
//		this.implementation.sort(array2,0,2);
//		Assert.assertArrayEquals(array1,array2);
//	}
}