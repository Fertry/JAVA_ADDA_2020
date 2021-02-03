/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Exámenes del 1º cuatrimestre de ADDA
 */

package examenes16_17;

public class Ejercicio1Recursividad {
	
	public static Long factorialNoFinal(Integer n) {
		if (n == 0) {
			return 1L;
		} else {
			return (Long) (n * factorialNoFinal(n - 1));
		}
	}

	public static Long factorialFinalAux(Integer n, Long res) {
		if (n == 0) {
			return res;
		} else {
			return factorialFinalAux(n - 1, n * res);
		}
	}

	public static Long factorialFinal(Integer n) {
		return factorialFinalAux(n, 1L);
	}

	// Febrero
	// No final
	public static Long sfactorialNoFinal(Integer n) {
		Long sf = 0L;
		if (n < 10) {
			sf = factorialNoFinal(n);
		} else {
			sf = sfactorialNoFinal(n / 10) + factorialNoFinal(n % 10);
		}
		return sf;
	}

	// NOTA: e.o.c => EN OTRO CASO

	// Final
	public static Long sfactorialFinal(Integer n) {
		return sfactorialFinalAux(n, 0L);
	}

	public static Long sfactorialFinalAux(Integer n, Long res) {
		Long sf = 0L;
		if (n < 10) {
			sf = res + factorialFinal(n);
		} else {
			sf = sfactorialFinalAux(n / 10, res + factorialFinal(n % 10));
		}
		return sf;
	}

	public static Long sfactorialIter(Integer n) {
		Long res = 0L;
		while (!(n < 10)) {
			res = res + factorialFinal(n % 10);
			n = n / 10;
		}
		res = res + factorialFinal(n);
		return res;
	}

}
