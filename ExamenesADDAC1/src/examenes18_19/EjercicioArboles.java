package examenes18_19;

import us.lsi.tiposrecursivos.BinaryTree;

public class EjercicioArboles {
	
	/*
	 * El árbol de sumas del árbol de enteros A, es otro árbol B
	 *  con la misma estructura, tal que cada nodo de B es la 
	 *  suma de todoslos descendientes de su correspondiente 
	 *  en A, incluyendo éste.
	 */
	
	public static BinaryTree<Integer> sumaArbol(BinaryTree<Integer> arbol) {
		
		BinaryTree<Integer> resultado = null;
		
		switch (arbol.getType()) {
		
		case Empty:
			
			// Si el arbol es vacío, se devuelve un árbol vacío:
			resultado = BinaryTree.empty(); 
			break;
			
		case Leaf:
			
			// Si el árbol es una hoja, se devuelve una hoja con el label del original:
			resultado = BinaryTree.leaf(arbol.getLabel());
			break;
			
		case Binary:
			
			int suma = arbol.getLabel() 
			+ sumaArbol(arbol.getLeft()).getLabel() 
			+ sumaArbol(arbol.getRight()).getLabel();
			BinaryTree<Integer> izquierda = sumaArbol(arbol.getLeft());
			BinaryTree<Integer> derecha = sumaArbol(arbol.getRight());
			
			resultado = BinaryTree.binary(suma, izquierda, derecha);
			break;
			
		}
		
		return resultado;
		
	}
	
	/*
	 * Complejidad algoritmo: como se recorre TODOS los nodos, la complejidad es "n", 
	 * es decir, el tamaño del problema original. 
	 */

}
