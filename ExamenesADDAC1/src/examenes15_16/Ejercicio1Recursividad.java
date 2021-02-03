/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Exámenes del 1º cuatrimestre de ADDA
 */

package examenes15_16;

public class Ejercicio1Recursividad {
	
	/*
	 * Dada la siguiente definición, donde el parámetro v es un array de enteros y la llamada inicial al algoritmo sería
	 * sming(0,n,v) siendo n es el tamaño del array v.
	 * 
	 * Considere implementada la función min(a,b).
	 */

	// Implementada previamente:
	public static Integer min(Integer a, Integer b) {
		
		return Math.min(a, b);
		
	}

	/*
	 * Implementación recursiva NO Final:
	 */
	// Tiempo de ejecución = T(n - 2) + 1
	public static Integer smingNoFinal(Integer a, Integer b, Integer[] v) {
		
		if (a < b) {
			
			return smingNoFinal(a + 1, b - 2, v) + Math.min(v[a], v[b - 1]);
			
		}
		
		return 0;
		
	}

	/*
	 * Implementación recursiva Final:
	 */
	public static Integer smingFinal(Integer a, Integer b, Integer[] v) {

		return smingFinalAux(a, b, v, 0);
		
	}


	// Tiempo de ejecución = T(n - 2) + 1
	// a = 1, b = 2, p = 0, d = 0
	// Complejidad: n^(d+1) * log(p) n = n
	public static Integer smingFinalAux(Integer a, Integer b, Integer[] v, Integer res) {
		
		if (a < b) {
			
			return smingFinalAux(a + 1, b - 2, v, res + Math.min(v[a], v[b - 1]));
			
		}
		
		return res;
		
	}

	/*
	 * Implementación iterativa:
	 */
	// Tiempo de ejecución = log n + 1
	public static Integer smingIter(Integer a, Integer b, Integer[] v) {
		
		Integer res = 0;
		while (a < b) {
			
			res = res + Math.min(v[a], v[b - 1]);
			a = a + 1;
			b = b - 2;
			
		}
		
		return res;
		
	}

}
