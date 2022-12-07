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
		if(array.length == 0){
			return null;
		}

		for(Integer element: array){
			insert(element);
		}
		return floor(this.root, this.root, (int) numero);
	}

	private Integer floor(BSTNode<Integer> root, BSTNode<Integer> current ,int numero){
		if(!current.isEmpty()){
			if(numero < current.getData()){
				floor(root, (BSTNode<Integer>) current.getLeft(), numero);

			}
			else if(numero > current.getData()){
				floor(root, (BSTNode<Integer>) current.getRight(), numero);
			}

			else{
				return current.getData();
			}



		}

		return null;



	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		//TODO Implemente seu codigo aqui
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
