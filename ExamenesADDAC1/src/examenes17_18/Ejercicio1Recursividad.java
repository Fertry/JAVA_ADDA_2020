/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ex�menes del 1� cuatrimestre de ADDA
 */

package examenes17_18;

import java.util.List;

public class Ejercicio1Recursividad {
	
	/*
	 * Una progresi�n geom�trica de n�meros enteros se define como una secuencia en la
	 * que cada elemento se obtiene multiplicando el anterior por una constante denominada
	 * �raz�n� o factor de la progresi�n.
	 * 
	 * Se pide la implementaci�n de un m�todo que decida si los elementos de una lista de
 	 * enteros forman una progresi�n geom�trica.
	 */
		
	/* 
	 * Dada la definici�n recursiva del enunciado, implementar:
	 */

	/*
	 * Algoritmo recursivo no final:
	 */ 
	// Funci�n esProgGeom()
	public static boolean esProgGeom(List<Integer> lista) {
		
		boolean resultado;
		
		if (lista.size() < 2) {
			
			resultado = false;
			
		} else {
			
			resultado = pg(lista, (lista.get(1) / lista.get(0)));
			
		}
		
		return resultado;
		
	}
	
	// Funci�n pg()
	private static boolean pg(List<Integer> lista, int i) {
		
		return pgi(lista, i, lista.size() - 1);
		
	}
	
	// Funci�n pgi()
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
	 * Transformaci�n a recursivo final:
	 */
	// Funci�n esProgGeomFinal()
	public static boolean esProgGeomFinal(List<Integer> lista) {
		
		if (lista.size() < 2) {
			
			return false;
			
		} else {
			
			return pgFinal(lista, (lista.get(1) / lista.get(0)));
			
		}
		
	}
	
	// Funci�n pgFinal()
	private static boolean pgFinal(List<Integer> lista, int i) {
		
		return pgiFinal(lista, i, lista.size() - 1, true);
		
	}
	
	// Funci�n pgiFinal()
	private static boolean pgiFinal(List<Integer> lista, int i, int j, boolean resultado) {

		if (j == 1) {

			return true;

		} else {

			resultado = lista.get(j) == (lista.get(j - 1) * i);
			return pgiFinal(lista, i, j - 1, resultado) && resultado;

		}
		
	}
	
	/*
	 * Transformaci�n a iterativo:
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
