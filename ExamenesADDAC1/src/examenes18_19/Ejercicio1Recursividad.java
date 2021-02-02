/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Exámenes del 1º cuatrimestre de ADDA
 */

package examenes18_19;

import java.util.List;
import java.util.stream.IntStream;

public class Ejercicio1Recursividad {
	
	/*
	 * Decidir si los elementos de una lista de enteros forman una progresión aritmética.
	 * Una progresión aritmética es una sucesión de números tales que su distancia
	 * (diferencia de cualquier par de términos sucesivos de la secuencia) es constante. Se
	 * considera que una lista vacía o con tamaño igual a 1 o 2, son progresiones
	 * aritméticas.
	 */
	
	/*
	 * Solución iterativa (también en C)
	 */
	public static boolean ejercicioIterativo(List<Integer> lista) {
		
		int i = 2;
		boolean resultado = true;
		
		// Si la lista es de tamaño 2 o menor, automaticamente es true:
		if (lista.size() > 2) {
			
			// Diferencia entre los dos primeros números:
			int diferencia = lista.get(1) - lista.get(0);
			
			// Con la diferencia anterior, recorremos la lista comprobando 
			// si los demas elementos cumplen la sucesión:
			while (i < lista.size()) {
				
				resultado = lista.get(i + 1) - lista.get(i) == diferencia;
				i++;
				
			}
		
		}
		
		return resultado;
		
	}
	
	/*
	 * Solución recursiva
	 */
	public static boolean ejercicioRecursivo(List<Integer> lista) {
		
		int i = 2;
		boolean resultado = true;
		
		// Si la lista es de tamaño 2 o menor, automaticamente es true:
		if (lista.size() > 2) {
			
			// Diferencia entre los dos primeros números:
			int diferencia = lista.get(1) - lista.get(0);
			return ejercicioRecursivoPrivado(lista, i, diferencia, resultado);
			
		}
		
		return resultado;
		
	}
	
	private static boolean ejercicioRecursivoPrivado(List<Integer> lista, int i, int diferencia, boolean resultado) {
		
		if (lista.size() > 2) {
			
			// Con la diferencia anterior, recorremos la lista comprobando 
			// si los demas elementos cumplen la sucesión:
			resultado = lista.get(i + 1) - lista.get(i) == diferencia;
			
			return ejercicioRecursivoPrivado(lista, i + 1, diferencia, resultado);
			
		} else {
			
			return resultado;
			
		}
		
	}
	
	/*
	 * Solución funcional
	 */
	public static boolean ejercicioFuncional(List<Integer> lista) {
		
		boolean resultado = true;
		
		// Si la lista es de tamaño 2 o menor, automaticamente es true:
		if (lista.size() > 2) {
			
			// Diferencia entre los dos primeros números:
			int diferencia = lista.get(1) - lista.get(0);
			
			// AllMatch devuelve un boolean en base a la condición, entre 2 y el tamaño de la lista (range):
			resultado = IntStream.range(2, lista.size()).allMatch(i -> lista.get(i + 1) - lista.get(i) == diferencia); 
			
		}
		
		return resultado;
		
	}
	
	
}
