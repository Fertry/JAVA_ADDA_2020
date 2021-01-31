/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ejemplos practicos del 1º cuatrimestre de ADDA
 */

package ejercicios;

public class Recurrencias {

	/*
	 * Función iterativa para operar dados dos numeros según un bucle que se
	 * actualiza en base a estos dos y una condición.
	 */
	public static boolean ejercicio1(Integer numero1, Integer numero2) {

		boolean resultado = false;

		while (numero1 > 0) {
			numero1 = numero1 - numero2;
			if (numero1 == 0) {
				return true;
			} else if (numero1 < 0) {
				return false;
			}
		}

		return resultado;

	}

	// #######################################################################################
	// #######################################################################################

	/*
	 * Función de caracter recursivo NO final. Opera sobre el resultado obtenido como resultado
	 * tras evaluar las condiciones requeridas del ejercicio. 
	 */
	public static Long ejercicio2(Integer exponente, Integer n) {

		Long resultado;

		if (n > 0) {
			// Llamada recursiva:
			resultado = ejercicio2(exponente, (n / 2));
			if (n % 2 == 1) {
				// Operación sobre el resultado (recursividad no final):
				resultado = ((resultado * resultado) * exponente);
			} else {
				// Operación sobre el resultado (recursividad no final):
				resultado *= resultado;
			}

		} else {
			resultado = 1L;
		}

		return resultado;

	}

	// #######################################################################################
	// #######################################################################################
	
	/*
	 * Función iterativa para calculo de una recurrencia dado como entrada
	 * solo un número y las condiciones de la recurrencia: 
	 */
	public static Long ejercicio3Iterativo(Integer numero) {
		
		// Nº de terminos a calcular:
	    int i = 3;
	    // Valores iniciales de los términos:
	    Long f1 = 1L;
	    Long f2 = 1L;
	    Long f3 = 2L;
	    Long fn = 0L;
	        
	    // Bucle de ejecución con las condiciones del ejercicio:
	    while (i <= numero) {
	        fn = 4 * f1 + f2 + f3;
	        f3 = f2;
	        f2 = f1;
	        f1 = fn;
	        i++;   
	    }
	    
	    return fn;
		 
	}

}
