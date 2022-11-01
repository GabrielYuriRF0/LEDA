package vetor;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 *
 * @author Adalberto
 *
 */
public class Vetor  <T extends Comparable<T>> {

	// O array interno onde os objetos manipulados são guardados
	private Object[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
		this.arrayInterno = new Object[tamanho];
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}


	public int getIndice(T objeto){
		int index = -1;
		for(int i = 0; i <= this.indice;i++){
			if(this.arrayInterno[i].equals(objeto)){
				index = i;
				break;
			}
		}
		return index;
	}
	public void inserir(T obj) {
		if(this.indice == this.arrayInterno.length - 1){
			System.out.println("entrou");
			throw new IndexOutOfBoundsException("Não há mais limite no array!");
		}
		else{
			this.arrayInterno[++indice] = obj;

		}
	}


	public T remover(T obj) {
		int indice = getIndice(obj);

		if(indice == -1){
			return null;
		}
		this.indice--;
		return (T) this.arrayInterno[indice];
	}

	public T procurar(T obj) {
		int indice = getIndice(obj);
		if(indice == -1){
			return null;
		}
		return (T)this.arrayInterno[indice];

	}


	// Diz se o vetor está vazio
	public boolean isVazio() {
		boolean ehVazio = true;
		for (Object objeto : this.arrayInterno) {
			if (Objects.isNull(objeto) == false) {
				ehVazio = false;
				break;
			}

		}
		return ehVazio;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		boolean estaCheio = true;
		for (Object obj : this.arrayInterno) {
			if (Objects.isNull(obj)) {
				estaCheio = false;
				break;
			}
		}
		return estaCheio;
	}


	public T maximo() {
		T result = null;
		if (!isVazio()) {
			result = (T)arrayInterno[0];
			for (int i = 0; i < indice; i++) {
				if (comparadorMaximo.compare(result, arrayInterno[i]) < 0) {
					result = (T) arrayInterno[i];
				}
			}
		}
		return result;
	}

	public T minimo() {
		T result = null;
		if (!isVazio()) {
			result = (T) arrayInterno[0];
			for (int i = 0; i < indice; i++) {
				if (comparadorMinimo.compare(result, arrayInterno[i]) < 0) {
					result = (T)arrayInterno[i];
				}
			}
		}
		return result;
	}

}

class ComparadorMaximo implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o1.getMedia() - o2.getMedia());
	}

}

class ComparadorMinimo implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o2.getMedia() - o1.getMedia());
	}
}
