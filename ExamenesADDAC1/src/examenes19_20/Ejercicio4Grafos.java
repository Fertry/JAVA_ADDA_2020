/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ex�menes del 1� cuatrimestre de ADDA
 */

package examenes19_20;

import java.util.ArrayList;
import java.util.List;

import us.lsi.tiposrecursivos.Tree;

public class Ejercicio4Grafos {
	
	/*
	 * Dado un �rbol n-ario de enteros, implemente un algoritmo en Java que devuelva una
	 * lista con las etiquetas de los elementos que forman parte del camino m�s largo.
	 * 
	 * Notas: (1) Si existen varios caminos con la misma longitud, la lista contendr� los elementos
	 * de uno cualquiera de ellos. (2) Los �rboles Empty no se considerar�n como parte del camino.
	 */
	
	public static List<Integer> ejercicioArboles(Tree<Integer> arbol) {
		
		List<Integer> lista = new ArrayList<Integer>();
		
		return ejercicioArbolesPrivado(arbol, lista);
		
	}
	
	private static List<Integer> ejercicioArbolesPrivado(Tree<Integer> arbol, List<Integer> lista) {
		
		List<Integer> listaAuxiliar = new ArrayList<Integer>();
		
		switch(arbol.getType()) {
		
		case Empty: 
			
			// Si el �rbol es vac�o, acaba el algoritmo:
			break;
		
		case Leaf:
			
			// Si es una hoja, devolvemos el valor de su etiqueta y acabamos:
			int etiqueta = arbol.getLabel();
			lista.add(etiqueta);
			
			// Obtenemos el largo de la lista con su size()
			int size = lista.size();
			
			// Igualamos la lista a la auxiliar:
			listaAuxiliar = lista;
			
			break;
			
		case Nary:
			
			// Si es n-ario aplicamos recursividad:
			etiqueta = arbol.getLabel();
			lista.add(etiqueta);
			size = lista.size();
			listaAuxiliar = lista;
			
			for (Tree<Integer> hijo: arbol.getChildren()) {
				
				List<Integer> camino = ejercicioArbolesPrivado(hijo, listaAuxiliar);
				
				// Comparamos el tama�o: 
				if (camino.size() > size) {
					
					listaAuxiliar = camino;
					size = camino.size();
					
				}
				
			}
		
		}
		
		return listaAuxiliar;
		
	}
	
}
