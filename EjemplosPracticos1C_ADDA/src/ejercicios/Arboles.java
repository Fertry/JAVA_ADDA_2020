/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ejemplos practicos del 1º cuatrimestre de ADDA
 */

package ejercicios;

import java.util.List;

import us.lsi.common.Tuple2;
import us.lsi.tiposrecursivos.BinaryTree;

public class Arboles {

	/*
	 * Funcion booleana para arboles binarios y como se obtiene el valor
	 * de sus etiquetas para los nodos de la rama izquierda y derecha de cada padre:
	 * 
	 * Tiene un supress para evitar avisos de funciones no usadas.
	 */
	@SuppressWarnings("unused")
	private static Boolean ejercicio1(BinaryTree<Integer> arbol) {

		// Recursion:
		if (arbol.isBinary()) {

			// Valores de los nodos:
			int label = arbol.getLabel();
			int izquierda = arbol.getLeft().getLabel();
			int derecha = arbol.getRight().getLabel();
			Boolean iguales = (izquierda + derecha) == label;
			// Llamada recursiva del ejercicio para las ramas izquierda/derecha del padre:
			return iguales && ejercicio1(arbol.getLeft()) && ejercicio1(arbol.getRight());

		// Caso base:
		} else {
			return true;
		}

	}

	//#######################################################################################
	// #######################################################################################

	/*
	 * Llamada opaca para una función que actua sobre arboles binarios:
	 * 
	 * Tiene un supress para evitar avisos de funciones no usadas.
	 */
	@SuppressWarnings("unused")
	private static Boolean ejercicio2(Tuple2<BinaryTree<String>, List<String>> conjunto) {

		BinaryTree<String> arbol = conjunto.getV1();
		List<String> lista = conjunto.getV2();

		return ejercicio2Privado(arbol, lista, 0);

	}
	
	//#######################################################################################
	// #######################################################################################
	
	/*
	 * Función para recorrer arboles binarios junto a una lista de valores que compruebe a la par 
	 * si se cumple cierto predicado entre el valor de los nodos y los valores de la lista dada:
	 */
	private static Boolean ejercicio2Privado(
			BinaryTree<String> arbol, 
			List<String> lista, 
			Integer i) {
		
		// Recursividad:
		if (arbol.isBinary()) {
			int indice = i + 1;
			// Se llama recursivamente a las ramas izquierda/derecha del padre junto a la lista de 
			// valores y el indice corresponde al valor que toca evaluar en cada caso:
			return arbol.getLabel().equals(lista.get(i)) && 
					(ejercicio2Privado(arbol.getLeft(), lista, indice) || 
					ejercicio2Privado(arbol.getRight(), lista, indice));
		// Caso base:
		} else {
			if (i == lista.size() - 1) {	
				return arbol.getLabel().equals(lista.get(i));		
			} else {	
				return false;		
			}
		}
	}
	
}
