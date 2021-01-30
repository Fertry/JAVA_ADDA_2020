/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ejemplos practicos del 1º cuatrimestre de ADDA
 */

package ejercicios;

import java.util.HashSet;

public class Matrices {

	/*
	 * Ejemplo de llamada opaca al ejercicio final para una matriz donde se pasa no
	 * solo la matriz sino su dimensión que se calcula como el length de matriz.
	 */
	public static Boolean ejercicio1(Integer[][] matriz) {

		int fila = 0;
		int columna = 0;
		int dimension = matriz.length;

		return ejercicio1Privada(matriz, fila, columna, dimension);

	}

	// #######################################################################################
	// #######################################################################################

	/*
	 * Ejercicio de tipo recursivo que dada una matriz obtiene sus esquinas. En matrices representadas
	 * como arrays bidimensionales se usan los subíndices [0][0], [0][1], [1][0] y [1][1] para referir 
	 * a las esquinas de la misma. 
	 */
	private static Boolean ejercicio1Privada(Integer[][] matriz, Integer fila, Integer columna, Integer dimension) {

		Boolean resultado = false;

		if (dimension == 2) {

			// Caso base:
			HashSet<Integer> extremos1 = new HashSet<>();
			extremos1.add(matriz[fila][columna]); 			// [0][0]
			extremos1.add(matriz[fila][columna + 1]); 		// [0][1]
			extremos1.add(matriz[fila + 1][columna]); 		// [1][0]
			extremos1.add(matriz[fila + 1][columna + 1]); 	// [1][1]

			if (extremos1.size() == 4) {
				resultado = true;
			} else {
				resultado = false;
			}

		} else {

			// Caso recursivo:
			HashSet<Integer> extremos2 = new HashSet<>();
			extremos2.add(matriz[fila][columna]); 			// [0][0]
			extremos2.add(matriz[fila][columna + 1]); 		// [0][1]
			extremos2.add(matriz[fila + 1][columna]); 		// [1][0]
			extremos2.add(matriz[fila + 1][columna + 1]); 	// [1][1]

			if (extremos2.size() == 4) {

				Boolean matriz1 = ejercicio1Privada(matriz, fila, columna, (dimension / 2));
				Boolean matriz2 = ejercicio1Privada(matriz, fila, (columna + dimension / 2), (dimension / 2));
				Boolean matriz3 = ejercicio1Privada(matriz, (fila + dimension / 2), columna, (dimension / 2));
				Boolean matriz4 = ejercicio1Privada(matriz, (fila + dimension / 2), (columna + dimension / 2),
						(dimension / 2));

				resultado = matriz1 && matriz2 && matriz3 && matriz4;

			} else {
				resultado = false;
			}

		}

		return resultado;

	}

}
