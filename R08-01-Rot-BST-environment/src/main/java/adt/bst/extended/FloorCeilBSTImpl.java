package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

import java.util.Arrays;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		if (array.length == 0) {
			return null;
		}

		for (Integer element : array) {
			insert(element);
		}
		return floor(root, (int) numero);
	}

	private Integer floor(BSTNode<Integer> current, int numero) {
		if (numero < current.getData()) {
			if (!current.getLeft().isEmpty()) {
				return floor((BSTNode<Integer>) current.getLeft(), numero);
			}

			if (current.getLeft().isEmpty()) {
				return null;
			}
			return current.getData();

		} else if (numero > current.getData()) {
			if (current.getRight().isEmpty()) {
				return current.getData();
			}
			return floor((BSTNode<Integer>) current.getRight(), numero);
		} else if (current.getData() == numero) {
			return current.getData();
		}


		return null;

	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		if (array.length == 0) {
			return null;
		} else {
			for (Integer element : array) {
				insert(element);
			}
			return ceil(this.root, (int) numero);
		}
	}

	private Integer ceil(BSTNode<Integer> current, int numero) {
		if (!current.isEmpty()) {
			if (current.getData() == numero) {
				return current.getData();
			}

			if(numero < current.getData()){
				if(current.getLeft().getData() < numero)
					if(current.getLeft().getData() < numero && current.getRight().isEmpty() && current){
						return current.getData();
					}
				return ceil((BSTNode<Integer>) current.getLeft(), numero);
			}

			else if (numero > current.getData()){
				return ceil((BSTNode<Integer>) current.getRight(), numero);
			}
		}
		return null;
	}
}



