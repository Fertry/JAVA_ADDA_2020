/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ex�menes del 1� cuatrimestre de ADDA
 */

package examenes15_16;

public class Ejercicio1Recursividad {
	
	/*
	 * Dada la siguiente definici�n, donde el par�metro v es un array de enteros y la llamada inicial al algoritmo ser�a
	 * sming(0,n,v) siendo n es el tama�o del array v.
	 * 
	 * Considere implementada la funci�n min(a,b).
	 */

	// Implementada previamente:
	public static Integer min(Integer a, Integer b) {
		
		return Math.min(a, b);
		
	}

	// Febrero
	// Ejercicio 1, apartado 1)
	// Tiempo de ejecuci�n = T(n - 2) + 1
	// Complejidad:
	public static Integer smingNoFinal(Integer a, Integer b, Integer[] v) {
		if (a < b) {
			return smingNoFinal(a + 1, b - 2, v) + Math.min(v[a], v[b - 1]);
		}
		return 0;
	}

	// Febrero
	// Ejercicio 1, apartado 2)
	public static Integer smingFinal(Integer a, Integer b, Integer[] v) {
		// Llamada
		return smingFinalAux(a, b, v, 0);
	}

	// Febrero
	// Ejercicio 1, apartado 3)
	// Tiempo de ejecuci�n = T(n - 2) + 1
	// a = 1, b = 2, p = 0, d = 0
	// Complejidad: n^(d+1) * log(p) n = n
	public static Integer smingFinalAux(Integer a, Integer b, Integer[] v, Integer res) {
		if (a < b) {
			return smingFinalAux(a + 1, b - 2, v, res + Math.min(v[a], v[b - 1]));
		}
		return res;
	}

	// Febrero
	// Ejercicio 1, apartado 4)
	// Tiempo de ejecuci�n = log n + 1
	// Complejidad:
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


