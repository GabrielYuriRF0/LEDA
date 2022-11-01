package vetor;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static junit.framework.TestCase.assertEquals;

public class TestarVetor {

	@BeforeEach
	public Vetor init(){
		Vetor <String>  vetor = new Vetor <String>(10);

		return vetor;
	}

	public Vetor init2(){
		Vetor<Aluno> vetorAluno = new Vetor<Aluno>(5);
		return vetorAluno;
	}

	@Test
	public void adicionarElemento(){
		Vetor vetor = init();
		vetor.inserir("Gabriel");
		assertEquals("Gabriel",vetor.procurar("Gabriel"));
	}

	@Test
	public void removerElemento(){
		Vetor vetor = init();
		vetor.inserir("Gabriel");
		assertEquals("Gabriel",vetor.remover("Gabriel"));
	}

	@Test
	public void procurarElemento(){
		Vetor vetor = init();
		vetor.inserir("Gabriel");
		vetor.inserir("Arthur");

		assertEquals("Arthur",vetor.procurar("Arthur"));
	}

	@Test
	public void verificarArrayNaoVazio(){
		Vetor vetor = init();
		vetor.inserir("Gabriel");
		assertEquals(false,vetor.isVazio());
	}

	@Test
	public void verificarArrayVazio(){
		Vetor vetor = init();
		assertEquals(true, vetor.isVazio());
	}
	@Test
	public void verificarArrayCheio(){
		Vetor vetor = new Vetor(2);
		vetor.inserir("Gabriel");
		vetor.inserir("Joao");
		assertEquals(true,vetor.isCheio());
	}
	@Test
	public void verificarArrayNaoCheio(){
		Vetor vetor = new Vetor(2);
		vetor.inserir("Gabriel");
		assertEquals(false,vetor.isCheio());
	}

	@Test
	public void verificarMelhorAluno(){
		Vetor vetorAluno = init2();
		Aluno alunoTeste = new Aluno("Gabriel",10);
		vetorAluno.inserir(new Aluno("Gabriel",10));
		vetorAluno.inserir((new Aluno("Pedro",8)));
		assertEquals(alunoTeste,vetorAluno.maximo());
	}
}
