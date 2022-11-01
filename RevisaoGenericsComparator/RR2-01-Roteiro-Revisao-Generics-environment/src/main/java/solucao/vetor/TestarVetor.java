package solucao.vetor;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import respostas.A;
import vetor.Aluno;
import static junit.framework.TestCase.assertEquals;


public class TestarVetor {

	@BeforeEach
	public void init(){

	}
	@Test
	public void verificaMaximo() {
		Vetor<Aluno> vetor = new Vetor<Aluno>(20);
		ComparadorMaximo compMax = new ComparadorMaximo();
		vetor.setComparadorMaximo(compMax);
		ComparadorMinimo compMin = new ComparadorMinimo();
		vetor.setComparadorMinimo(compMin);

		Aluno alunoMaximo = new Aluno("Gabriel",10);
		vetor.inserir(alunoMaximo);
		vetor.inserir(new Aluno("Pedro" ,8));

		assertEquals(alunoMaximo,vetor.maximo());
	}

	@Test
		public void verificarMinimo() {
		Vetor<Aluno> vetor = new Vetor<Aluno>(20);
		ComparadorMaximo compMax = new ComparadorMaximo();
		vetor.setComparadorMaximo(compMax);
		ComparadorMinimo compMin = new ComparadorMinimo();
		vetor.setComparadorMinimo(compMin);

		Aluno alunoMinimo = new Aluno("Pedro",8);
		vetor.inserir(alunoMinimo);
		vetor.inserir(new Aluno("Gabriel" ,10));

		assertEquals(alunoMinimo,vetor.minimo());
	}
}
