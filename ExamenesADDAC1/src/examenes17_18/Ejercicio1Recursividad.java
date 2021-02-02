/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Exámenes del 1º cuatrimestre de ADDA
 */

package examenes17_18;

import java.util.List;

public class Ejercicio1Recursividad {
	
	/*
	 * Una progresión geométrica de números enteros se define como una secuencia en la
	 * que cada elemento se obtiene multiplicando el anterior por una constante denominada
	 * “razón” o factor de la progresión.
	 * 
	 * Se pide la implementación de un método que decida si los elementos de una lista de
 	 * enteros forman una progresión geométrica.
	 */
		
	/* 
	 * Dada la definición recursiva del enunciado, implementar:
	 */

	/*
	 * Algoritmo recursivo no final:
	 */ 
	// Función esProgGeom()
	public static boolean esProgGeom(List<Integer> lista) {
		
		boolean resultado;
		
		if (lista.size() < 2) {
			
			resultado = false;
			
		} else {
			
			resultado = pg(lista, (lista.get(1) / lista.get(0)));
			
		}
		
		return resultado;
		
	}
	
	// Función pg()
	private static boolean pg(List<Integer> lista, int i) {
		
		return pgi(lista, i, lista.size() - 1);
		
	}
	
	// Función pgi()
	private static boolean pgi(List<Integer> lista, int i, int j) {
		
		boolean resultado;
		
		if (j == 1) {
			
			resultado = true;
			
		} else {
			
			resultado = pgi(lista, i, j - 1) && (lista.get(j) == (lista.get(j - 1) * i)); 
			
		}
		
		return resultado;
		
	}
	
	/*
	 * Transformación a recursivo final:
	 */
	// Función esProgGeomFinal()
	public static boolean esProgGeomFinal(List<Integer> lista) {
		
		if (lista.size() < 2) {
			
			return false;
			
		} else {
			
			return pgFinal(lista, (lista.get(1) / lista.get(0)));
			
		}
		
	}
	
	// Función pgFinal()
	private static boolean pgFinal(List<Integer> lista, int i) {
		
		return pgiFinal(lista, i, lista.size() - 1, true);
		
	}
	
	// Función pgiFinal()
	private static boolean pgiFinal(List<Integer> lista, int i, int j, boolean resultado) {

		if (j == 1) {

			return true;

		} else {

			resultado = lista.get(j) == (lista.get(j - 1) * i);
			return pgiFinal(lista, i, j - 1, resultado) && resultado;

		}
		
	}
	
	/*
	 * Transformación a iterativo:
	 */
	public static boolean esProgGeomIterativo(List<Integer> lista) {
		
		boolean resultado = true;
		
		if (lista.size() < 2) {
			
			resultado = false;
			
		} else {
			
			int i = 0;
			int j = lista.get(1) / lista.get(0);
			
			while (i < lista.size()) {
				
				resultado = resultado && (lista.get(j) == (lista.get(j - 1) * i));
				i++;
				
			}
			
		}
		
		return resultado;
		
	}

}
