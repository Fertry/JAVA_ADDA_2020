/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Exámenes del 1º cuatrimestre de ADDA
 */

package examenes18_19;

import java.util.List;

public class Ejercicio3DivideYVenceras {
	
	/*
	 * La función eliminaPar(l,x,y) recibe una lista l ordenada con todos sus elementos distintos
	 * y busca sobre la lista el par de elementos consecutivos (x,y), si los encuentra devuelve la
	 * lista eliminando el par y en caso contrario devuelve la lista sin cambios.
	 * SE PIDE:
	 * 1) Dar una definición recursiva para la función eliminaPar(l,x,y) de O(log(n)).
	 * 2) Implementar en Java de forma recursiva la definición del apartado anterior.
	 * Ejemplos:
	 * eliminaPar([2, 3, 4], 3, 4) = [2]
	 * eliminaPar([2, 3, 4], 4, 3) = [2, 3, 4]
	 * eliminaPar([2, 3, 10, 11], 2, 3) = [10, 11]
	 * eliminaPar([2, 3, 10, 11], 3, 10) = [2, 11]
	 */

	public static List<Integer> eliminaPar(List<Integer> lista, int i, int j) {
		
		// Se le pasa como parámetro los nºs de entrada y los índices para leer 
		// la lista de entrada de 0 a tamaño de la lista:
		return eliminaParPrivado(lista, i, j, 0, lista.size());
		
	}
	
	private static List<Integer> eliminaParPrivado(List<Integer> lista, int i, int j, int x, int y) {
		
		List<Integer> resultado = lista;
		
		// Si la lista es mayor de un elemento (el caso contrario se devuelve la lista):
		if (y - x >= 1) {
			
			// Posición: la mitad:
			int m = (x + y) / 2;
			
			// Caso en el que i se encuentra en la posición m de la lista:
			if (i == lista.get(m)) {
				
				// Si el elemento m+1 es j y no se pasa del largo de la lista:
				if (m+1 < lista.size() && j == lista.get(m + 1)) {
					
					resultado.remove(m + 1);
					resultado.remove(m);
					
				}
				
			// Caso en el que i es menor al elemento m de la lista:
			} else if (i < lista.get(m)) {
				
				// Llamada recursiva para buscar entre [x...m,...]
				resultado = eliminaParPrivado(lista, i, j, x, m);
				
			} else {
				
				// Llamada recursiva para buscar entre [...,m+1...y]
				resultado = eliminaParPrivado(lista, i, j, m + 1, y);
				
			}
			
		}
		
		return resultado;
		
	}
	
}
