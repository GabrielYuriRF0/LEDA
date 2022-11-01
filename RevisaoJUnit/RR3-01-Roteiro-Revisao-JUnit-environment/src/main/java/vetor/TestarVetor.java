package vetor;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
public class TestarVetor {

	private Vetor vetor;
	private Aluno aluno1;
	private Aluno aluno2;

	@Before
	public void inicializarVetor(){
		this.vetor = new Vetor<Aluno>(10);
		this.aluno1 = new Aluno("Gabriel",10);
		this.aluno2 = new Aluno("Pedro",7);

		ComparadorMaximo compMax = new ComparadorMaximo();
		vetor.setComparadorMaximo(compMax);
		vetor.setComparadorMaximo(compMax);
		ComparadorMinimo compMin = new ComparadorMinimo();
		vetor.setComparadorMinimo(compMin);
		vetor.setComparadorMinimo(compMin);
	}

	@Test
	public void inserirAlunosValidos(){
		this.vetor.inserir(aluno1);
		this.vetor.inserir(aluno2);
		assertEquals(aluno1,vetor.procurar(aluno1));
		assertEquals(aluno2,vetor.procurar(aluno2));
	}

	@Test
	public void inserirAlunosExcedentes(){
		Vetor vetor2 = new Vetor<Aluno>(2);
		vetor2.inserir(aluno1);
		vetor2.inserir(aluno2);
		try{
			vetor2.inserir(new Aluno("Rodrigo",9));
		}
		catch (Exception e){
			assertEquals("Não há mais limite no array!", e.getMessage());
		}
	}

	@Test
	public void remocaoAlunoValida(){
		vetor.inserir(aluno1);
		assertEquals(aluno1, vetor.remover(aluno1));
	}

	@Test
	public void remocaoAlunoInvalida(){
		vetor.inserir(aluno1);
		assertEquals(null,vetor.remover(aluno2));
	}

	@Test
	public void procurarAlunoInvalido(){
		assertEquals(null, vetor.procurar(aluno1));
	}

	@Test
	public void verificarVazioValido(){
		assertEquals(true, vetor.isVazio());
	}

	@Test
	public void verificarVazioInvalido(){
		vetor.inserir(aluno1);
		assertEquals(false, vetor.isVazio());
	}

	@Test
	public void verificarCheioValido(){
		Vetor vetor2 = new Vetor<Aluno>(2);
		vetor2.inserir(aluno1);
		vetor2.inserir(aluno2);

		assertEquals(true, vetor2.isCheio());

	}

	@Test
	public void arrayCheioInvalido(){
		assertEquals(false, vetor.isCheio());
		vetor.inserir(aluno1);
		vetor.inserir(aluno2);
		assertEquals(false, vetor.isCheio());
	}

	@Test
	public void exibirMaximo(){
		vetor.inserir(aluno1);
		assertEquals(aluno1, vetor.maximo());
		vetor.inserir(aluno2);
		assertEquals(aluno1, vetor.maximo());
	}

	@Test
	public void exibirMinimo(){
		vetor.inserir(aluno2);
		assertEquals(aluno2, vetor.minimo());
		vetor.inserir(aluno1);
		assertEquals(aluno2, vetor.minimo());
	}

	@Test
	public void exibirMaximoMinimoInvalido(){
		assertEquals(null,vetor.maximo());
		assertEquals(null, vetor.minimo());
	}






}
