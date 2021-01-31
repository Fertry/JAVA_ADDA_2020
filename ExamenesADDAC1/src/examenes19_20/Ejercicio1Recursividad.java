/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Exámenes del 1º cuatrimestre de ADDA
 */

package examenes19_20;

import java.util.stream.LongStream;

public class Ejercicio1Recursividad {
	
	/*
	 * Dada la siguiente implementación funcional se pide dar una versión iterativa y recursiva
	 * final en Java (también hay un proyecto en C):
	 */
	
	// ##############################################
	// Versión funcional del enunciado:
	public static Long mistral(int n, int k) {
		return LongStream.rangeClosed(1l, k)
				.filter(e -> e % 2==0)
				.map(e -> (n-e + 1) / e)
				.sum();
	}
	// ##############################################
	
	/*
	 * Solución iterativa: la función recibe dos parámetros n y k de tipo entero e itera de 1 
	 * a k, mientras dura la iteración filtra los nº que cumplan el predicado (e%2 == 0), es 
	 * decir, aquellos cuyo módulo sea igual a 0 (pares). Actualiza el nº en base a una condición
	 * ((n-e + 1) / e) y devuelve la suma de todos los nºs al final como dato de tipo Long. 
	 */
	public static Long solucionIterativa(int n, int k) {
		
		// Arranca el bucle en 1 y declara un acumulador que será el resultado:
		int e = 1;
		Long resultado = 0L;
		
		// Mientras que e <= k (rangeClosed(1l, k)):
		while (e <= k) {
			
			if (e % 2 == 0) {
				
				// Calcula el nº en base a la condición dada y lo suma al resultado (acumulador):
				Long numero = (long) ((n-e + 1) / e);
				resultado += numero;
				
			}
			
			e += 1;
			
		}
		
		return resultado;
		
	}
	
	// ##############################################
	// ##############################################
	
	/*
	 * Solución recursiva final: la función recibe dos parámetros n y k de tipo entero e itera de 1 
	 * a k, mientras dura la iteración filtra los nº que cumplan el predicado (e%2 == 0), es 
	 * decir, aquellos cuyo módulo sea igual a 0 (pares). Actualiza el nº en base a una condición
	 * ((n-e + 1) / e) y devuelve la suma de todos los nºs al final como dato de tipo Long. 
	 */
	public static Long solucionRecursiva(int n, int k) {
		
		int e = 1;
		Long resultado = 0L;
		
		// Llamada opaca a la función recursiva con datos iniciales como el inicio (e = 1) y el resultado a 0:
		return solucionRecursivaPrivada(n, k, e, resultado);
		
	}
	
	public static Long solucionRecursivaPrivada(int n, int k, int e, Long resultado) {
		
		if (e <= k) {
			if (e % 2 == 0) {
				
				// Calculo del término y llamada recursiva a la función con los nuevos parámetros:
				Long numero = (long) ((n-e + 1) / e);
				resultado = solucionRecursivaPrivada(n, k, e + 1, resultado + numero);
				
			} else {
				
				// Llamada recursiva en el caso de que no se cumpla la condición
				// e%2==0, el valor de resultado no se actualiza pero si lo hace
				// el contador e:
				resultado = solucionRecursivaPrivada(n, k, e + 1, resultado);
				
			}
			
		}
		
		return resultado;
		
	}
	
}
