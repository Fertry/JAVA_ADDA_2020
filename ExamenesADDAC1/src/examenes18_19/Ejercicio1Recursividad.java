/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ex�menes del 1� cuatrimestre de ADDA
 */

package examenes18_19;

import java.util.List;
import java.util.stream.IntStream;

public class Ejercicio1Recursividad {
	
	/*
	 * Decidir si los elementos de una lista de enteros forman una progresi�n aritm�tica.
	 * Una progresi�n aritm�tica es una sucesi�n de n�meros tales que su distancia
	 * (diferencia de cualquier par de t�rminos sucesivos de la secuencia) es constante. Se
	 * considera que una lista vac�a o con tama�o igual a 1 o 2, son progresiones
	 * aritm�ticas.
	 */
	
	/*
	 * Soluci�n iterativa (tambi�n en C)
	 */
	public static boolean ejercicioIterativo(List<Integer> lista) {
		
		int i = 2;
		boolean resultado = true;
		
		// Si la lista es de tama�o 2 o menor, automaticamente es true:
		if (lista.size() > 2) {
			
			// Diferencia entre los dos primeros n�meros:
			int diferencia = lista.get(1) - lista.get(0);
			
			// Con la diferencia anterior, recorremos la lista comprobando 
			// si los demas elementos cumplen la sucesi�n:
			while (i < lista.size()) {
				
				resultado = lista.get(i + 1) - lista.get(i) == diferencia;
				i++;
				
			}
		
		}
		
		return resultado;
		
	}
	
	/*
	 * Soluci�n recursiva
	 */
	public static boolean ejercicioRecursivo(List<Integer> lista) {
		
		int i = 2;
		boolean resultado = true;
		
		// Si la lista es de tama�o 2 o menor, automaticamente es true:
		if (lista.size() > 2) {
			
			// Diferencia entre los dos primeros n�meros:
			int diferencia = lista.get(1) - lista.get(0);
			return ejercicioRecursivoPrivado(lista, i, diferencia, resultado);
			
		}
		
		return resultado;
		
	}
	
	private static boolean ejercicioRecursivoPrivado(List<Integer> lista, int i, int diferencia, boolean resultado) {
		
		if (lista.size() > 2) {
			
			// Con la diferencia anterior, recorremos la lista comprobando 
			// si los demas elementos cumplen la sucesi�n:
			resultado = lista.get(i + 1) - lista.get(i) == diferencia;
			
			return ejercicioRecursivoPrivado(lista, i + 1, diferencia, resultado);
			
		} else {
			
			return resultado;
			
		}
		
	}
	
	/*
	 * Soluci�n funcional
	 */
	public static boolean ejercicioFuncional(List<Integer> lista) {
		
		boolean resultado = true;
		
		// Si la lista es de tama�o 2 o menor, automaticamente es true:
		if (lista.size() > 2) {
			
			// Diferencia entre los dos primeros n�meros:
			int diferencia = lista.get(1) - lista.get(0);
			
			// AllMatch devuelve un boolean en base a la condici�n, entre 2 y el tama�o de la lista (range):
			resultado = IntStream.range(2, lista.size()).allMatch(i -> lista.get(i + 1) - lista.get(i) == diferencia); 
			
		}
		
		return resultado;
		
	}
	
	
}
