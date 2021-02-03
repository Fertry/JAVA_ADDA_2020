/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ex�menes del 1� cuatrimestre de ADDA
 */

package examenes16_17;

public class Ejercicio1Recursividad {
	
	/*
	 * La funci�n sfactorial(n) calcula la suma de los factores de cada uno de los d�gitos del
	 * n�mero n. Ejemplo: sfactorial(1024) =1! + 0! + 2! + 4! = 1 +1 + 2 + 24 = 28
	 * Sabiendo que para realizar el ejercicio tiene disponible la funci�n factorial(n), resuelva
	 * los siguientes apartados:
	 * 
	 * a) De una definici�n para la funci�n sfactorial(n) que sea recursiva no final.
	 * b) Implemente en Java la funci�n sfactorial(n) definida en el apartado a).
	 * c) De una definici�n para la funci�n sfactorial(n) que sea recursiva final
	 * d) Implemente en Java la funci�n sfactorial(n) definida en el apartado c).
     * e) Implementar una versi�n iterativa para la funci�n sfactorial(n) en Java.
	 */
	
	/*
	 * Implementaci�n recursiva NO Final:
	 */
	public static Long factorialNoFinal(Integer n) {
		
		if (n == 0) {
			
			return 1L;
			
		} else {
			
			return (Long) (n * factorialNoFinal(n - 1));
			
		}
		
	}

	/*
	 * Implementaci�n recursiva Final:
	 */
	public static Long factorialFinal(Integer n) {
		
		return factorialFinalAux(n, 1L);
		
	}
	
	public static Long factorialFinalAux(Integer n, Long res) {
		
		if (n == 0) {
			
			return res;
			
		} else {
			
			// Notese como n*res aqu� se pasa como un par�metro a la
			// llamada de la funci�n mientras que arriba, se calcula
			// n * llamadaFuncion():
			return factorialFinalAux(n - 1, n * res);
			
		}
		
	}

	/*
	 * Implementaci�n recursiva NO Final:
	 */
	public static Long sfactorialNoFinal(Integer n) {
		
		Long sf = 0L;
		if (n < 10) {
			
			sf = factorialNoFinal(n);
			
		} else {
			
			// Notese como en NO final, se est� calculando (una suma) con el dato
			// devuelto por la llamada a la funci�n:
			sf = sfactorialNoFinal(n / 10) + factorialNoFinal(n % 10);
			
		}
		
		return sf;
		
	}

	/*
	 * Implementaci�n recursiva Final:
	 */
	public static Long sfactorialFinal(Integer n) {
		
		return sfactorialFinalAux(n, 0L);
		
	}

	public static Long sfactorialFinalAux(Integer n, Long res) {
		
		Long sf = 0L;
		if (n < 10) {
			
			sf = res + factorialFinal(n);
			
		} else {
			
			// Notese como en final, se est� usando la llamada a factorialFinal() como arriba,
			// pero DENTRO de la llamada recursiva de la funci�n sfactorialFinalAux():
			sf = sfactorialFinalAux(n / 10, res + factorialFinal(n % 10));
			
		}
		
		return sf;
		
	}

	/*
	 * Implementaci�n iterativa:
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
