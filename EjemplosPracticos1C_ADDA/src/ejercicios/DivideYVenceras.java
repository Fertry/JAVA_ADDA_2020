/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ejemplos practicos del 1� cuatrimestre de ADDA
 */

package ejercicios;

public class DivideYVenceras {
	
	// Divide y vencer�s o b�squeda binaria sobre arrays: 

	/*
	 * 
	 */
	public static Integer ejercicio1(String frase1, String frase2) {

		Integer i = 0;
		Integer k = 0;
		Integer resultado = -1;
		Integer j = frase1.length();

		while (j - i > 0 && resultado == -1) {

			// Posicion: la mitad
			k = ((i + j) / 2);
			if (frase1.charAt(k) == frase2.charAt(k)) {
				i = k + 1;
			} else {

				// Hacia la izquierda
				if (frase1.charAt(k - 1) == frase2.charAt(k - 1)) {
					resultado = k;
				} else {
					j = k;
				}

			}

		}

		return resultado;

	}
	
	// #######################################################################################
	// #######################################################################################

	/*
	 * 
	 */
	public static Integer ejercicio2(String frase1, String frase2) {

		Integer i = 0;
		Integer j = frase1.length();

		return ejercicio2Privado(i, j, frase1, frase2);

	}
	
	// #######################################################################################
	// #######################################################################################

	/*
	 * 
	 */
	private static Integer ejercicio2Privado(int i, int j, String frase1, String frase2) {

		Integer k = 0;
		Integer resultado = -1;

		if (j - i > 0 && resultado == -1) {
			// Posicion: la mitad
			k = ((i + j) / 2);
			if (frase1.charAt(k) == frase2.charAt(k)) {
				// i = k + 1;
				return ejercicio2Privado((k + 1), j, frase1, frase2);
			} else {
				// Hacia la izquierda
				if (frase1.charAt(k - 1) == frase2.charAt(k - 1)) {
					resultado = k;
				} else {
					// j = k;
					return ejercicio2Privado(i, k, frase1, frase2);
				}
			}
			
		} else {
			return resultado;
		}
		
		return resultado;
	}

}
