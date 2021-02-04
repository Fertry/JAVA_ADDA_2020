/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Exámenes del 1º cuatrimestre de ADDA
 */

package examenes18_19;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.BinaryTree.BinaryType;

public class Ejercicio4Grafos {
	
	/*
	 * Implemente un algoritmo para comprobar si dos árboles binarios son iguales
	 * cuya cabecera sea:
	 * boolean iguales(BinaryTree<T> t1, BinaryTree<T> t2)
	 */
	 
	public static <T> boolean iguales(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		
		boolean resultado = false;
		
		switch(arbol1.getType()) {
		
		case Empty:
			
			// Si arbol 1 es vacío: comprueba si arbol 2 también lo es:
			resultado = arbol2.getType() == BinaryType.Empty;
			break;
			
		case Leaf:
			
			// Si arbol 1 hoja: comprueba si arbol 2 también lo es y sus etiquetas son iguales:
			resultado = arbol2.getType() == BinaryType.Leaf && arbol1.getLabel().equals(arbol2.getLabel());
			
		case Binary:
			
			// Si arbol 1 es binario: comprueba si arbol 2 también lo es y sus etiquetas para ambos
			// hijos son iguales, recursivamente: 
			boolean binario = arbol2.getType() == BinaryType.Binary;
			boolean etiquetas = arbol1.getLabel().equals(arbol2.getLabel());
			boolean igualIzquierda = iguales(arbol1.getLeft(), arbol2.getLeft());
			boolean igualDerecha = iguales(arbol1.getRight(), arbol2.getRight());
			
			resultado = binario && etiquetas && igualIzquierda && igualDerecha;
			
		}
		
		return resultado;
		
	}
	
	
	/*
	 * Dados dos árboles binarios, realizar un método que devuelva verdadero si ambos
	 * árboles son simétricos y la suma de los nodos hijos (descendientes directos) es
     * mayor que la de su nodo padre.
	 */
	public static <E> boolean simetricos(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		
		boolean resultado = false;
		
		switch(arbol1.getType()) {
		
		case Empty:
			
			// Si arbol 1 es vacío: comprueba si arbol 2 también lo es:
			resultado = arbol2.getType() == BinaryType.Empty;
			break;
			
		case Leaf:
			
			// Si el árbol 1 es una hoja: comprueba si el arbol 2 es hoja y son simétricos:
			resultado = arbol2.isLeaf() && arbol1.getLabel().equals(arbol2.getLabel());
			break;
			
		case Binary:
			
			// Si arbol 1 es binario: obtengo los valores de las etiquetas:
			int etiqueta1 = arbol1.getLabel();
			int etiqueta2 = arbol2.getLabel();
			
			// Comparo si el arbol 2 también es binario Y llamo recursivamente a 
			// la función con la rama izquierda/derecha de cada árbol:
			
			// Simetría:
			boolean simetrico = simetricos(arbol1.getRight(), arbol2.getLeft()) && simetricos (arbol1.getLeft(), arbol2.getRight());
			
			// Etiquetas de los hijos mayor que la del padre:
			boolean suma = etiqueta1 == etiqueta2;
			boolean suma1 = arbol1.getLabel() < (arbol1.getLeft().getLabel() + arbol1.getRight().getLabel());
			boolean suma2 = arbol2.getLabel() < (arbol2.getLeft().getLabel() + arbol2.getRight().getLabel());
					
			resultado = simetrico && suma && suma1 && suma2;
			
		}
		
		return resultado;
		
	}

}
