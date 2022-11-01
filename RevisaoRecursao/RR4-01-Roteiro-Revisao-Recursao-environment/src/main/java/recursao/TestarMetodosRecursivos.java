package recursao;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

public class TestarMetodosRecursivos {
	private MetodosRecursivos recursao;
	private int[] array1;
	private int[] array2;

	@Before
	public void init(){
		this.recursao = new MetodosRecursivos();

	}


	@Test
	public void calcularSomaArray1(){
		int[] array = {1,2,4,3,5};
		assertEquals(15,recursao.calcularSomaArray(array,0));
	}

	@Test
	public void calcularSomaArray2(){
		int[] array = {1,1,1,1,1,1,1,1,1,1,1,1};
		assertEquals(12,recursao.calcularSomaArray(array,0));
	}

	@Test
	public void calcularSomaArray3(){
		int[] array = {5};
		assertEquals(5,recursao.calcularSomaArray(array,0));
	}
	@Test
	public void calcularSomaArray4(){
		int[] array = {3,0};
		assertEquals(3,recursao.calcularSomaArray(array,0));
	}

	@Test
	public void calcularFatorial1(){
		assertEquals(720,recursao.calcularFatorial(6));
	}
	@Test
	public void calcularFatorial2(){
		assertEquals(1,recursao.calcularFatorial(1));
	}
	@Test
	public void calcularFatorial3(){
		assertEquals(1,recursao.calcularFatorial(0));
	}

	@Test
	public void testeElementosNaoNulos1(){
		Object[] objetos = {"casa",5,8,7,9};
		assertEquals(5,recursao.countNotNull(objetos,0));
	}

	@Test
	public void testeElementosNaoNulos2(){
		Object[] objetos = {"casa",5,null};
		assertEquals(2,recursao.countNotNull(objetos,0));
	}
	@Test
	public void testeElementosNaoNulos3(){
		Object[] objetos = {null,null,null};
		assertEquals(0,recursao.countNotNull(objetos,0));
	}

	@Test
	public void testeElementosNaoNulos4(){
		Object[] objetos = {null};
		assertEquals(0,recursao.countNotNull(objetos,0));
	}

	@Test
	public void testeElementosNaoNulos5(){
		Object[] objetos = {1};
		assertEquals(1,recursao.countNotNull(objetos,0));
	}

	@Test
	public void potenciaDeDois1(){
		assertEquals(1,recursao.potenciaDe2(0));
	}
	@Test
	public void potenciaDeDois2(){
		assertEquals(16,recursao.potenciaDe2(4));
	}

	@Test
	public void potenciaDeDois3(){
		assertEquals(2,recursao.potenciaDe2(1));
	}

	@Test
	public void pa1(){
		assertEquals(11,recursao.progressaoAritmetica(2,3,4),0);
	}

	@Test
	public void pa2(){
		assertEquals(10,recursao.progressaoAritmetica(5,5,2),0);

	}

	@Test
	public void pa3(){
		assertEquals(15,recursao.progressaoAritmetica(3,2,7),0);
	}

	@Test
	public void pg1(){
		assertEquals(64,recursao.progressaoGeometrica(2,2,6),0);

	}

	@Test
	public void pg2(){
		assertEquals(3000,recursao.progressaoGeometrica(3,10,4),0);
	}

	@Test
	public void pg3(){
		assertEquals(0,recursao.progressaoGeometrica(5,0,8),0);
	}

	@Test
	public void fibonacci1(){
		assertEquals(3,recursao.calcularFibonacci(4));
	}

	@Test
	public void fibonacci2(){
		assertEquals(21,recursao.calcularFibonacci(8));
	}

	@Test
	public void fibonacci3(){
		assertEquals(1,recursao.calcularFibonacci(1));
	}
}
