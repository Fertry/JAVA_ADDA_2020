/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Exámenes del 1º cuatrimestre de ADDA
 */

package examenes16_17;

public class Ejercicio1Recursividad {
	
	/*
	 * La función sfactorial(n) calcula la suma de los factores de cada uno de los dígitos del
	 * número n. Ejemplo: sfactorial(1024) =1! + 0! + 2! + 4! = 1 +1 + 2 + 24 = 28
	 * Sabiendo que para realizar el ejercicio tiene disponible la función factorial(n), resuelva
	 * los siguientes apartados:
	 * 
	 * a) De una definición para la función sfactorial(n) que sea recursiva no final.
	 * b) Implemente en Java la función sfactorial(n) definida en el apartado a).
	 * c) De una definición para la función sfactorial(n) que sea recursiva final
	 * d) Implemente en Java la función sfactorial(n) definida en el apartado c).
     * e) Implementar una versión iterativa para la función sfactorial(n) en Java.
	 */
	
	/*
	 * Implementación recursiva NO Final:
	 */
	public static Long factorialNoFinal(Integer n) {
		
		if (n == 0) {
			
			return 1L;
			
		} else {
			
			return (Long) (n * factorialNoFinal(n - 1));
			
		}
		
	}

	/*
	 * Implementación recursiva Final:
	 */
	public static Long factorialFinal(Integer n) {
		
		return factorialFinalAux(n, 1L);
		
	}
	
	public static Long factorialFinalAux(Integer n, Long res) {
		
		if (n == 0) {
			
			return res;
			
		} else {
			
			// Notese como n*res aquí se pasa como un parámetro a la
			// llamada de la función mientras que arriba, se calcula
			// n * llamadaFuncion():
			return factorialFinalAux(n - 1, n * res);
			
		}
		
	}

	/*
	 * Implementación recursiva NO Final:
	 */
	public static Long sfactorialNoFinal(Integer n) {
		
		Long sf = 0L;
		if (n < 10) {
			
			sf = factorialNoFinal(n);
			
		} else {
			
			// Notese como en NO final, se está calculando (una suma) con el dato
			// devuelto por la llamada a la función:
			sf = sfactorialNoFinal(n / 10) + factorialNoFinal(n % 10);
			
		}
		
		return sf;
		
	}

	/*
	 * Implementación recursiva Final:
	 */
	public static Long sfactorialFinal(Integer n) {
		
		return sfactorialFinalAux(n, 0L);
		
	}

	public static Long sfactorialFinalAux(Integer n, Long res) {
		
		Long sf = 0L;
		if (n < 10) {
			
			sf = res + factorialFinal(n);
			
		} else {
			
			// Notese como en final, se está usando la llamada a factorialFinal() como arriba,
			// pero DENTRO de la llamada recursiva de la función sfactorialFinalAux():
			sf = sfactorialFinalAux(n / 10, res + factorialFinal(n % 10));
			
		}
		
		return sf;
		
	}

	/*
	 * Implementación iterativa:
	 */
	public static Long sfactorialIter(Integer n) {
		
		Long res = 0L;
		while (!(n < 10)) {
			
			res = res + factorialFinal(n % 10);
			// Forma de parar el bucle es decrementar n:
			n = n / 10;
			
		}
		
		res = res + factorialFinal(n);
		return res;
		
	}

}
