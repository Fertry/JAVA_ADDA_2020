/*
 *  	Analisis y Dise�o de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ejemplos practicos del 1� cuatrimestre de ADDA
 */

package ejercicios;

import java.util.ArrayList;
import java.util.List;

import us.lsi.math.Math2;

public class Listas {
	
	/* 
	 * Funci�n gen�rica para recorrer una lista de listas de elementos de un tipo
	 * y aplicar condicionales sobre los elementos: en este caso comprobar si son 
	 * primos mediante funciones de la libreria de Miguel y en consecuencia operar
	 * con ellos (a�adirlos a una lista). 
	 */
	public static List<Integer> ejercicio1(List<List<Integer>> lista) {

		int i = 0;
		int j = 0;
		// Lista de resultado del tipo especificado: 
		List<Integer> resultado = new ArrayList<Integer>();

		// Bucle sobre los elementos de la lista "grande": 
		while (i < lista.size()) {
			// Bucle sobre los elementos de la lista "peque�a":
			while (j < lista.get(i).size()) {

				// Condicional sobre los elementos de la lista "peque�a":
				if (Math2.esPrimo(lista.get(i).get(j))) {
					resultado.add(lista.get(i).get(j));
				}
				j++;
			}
			j = 0;
			i++;
		}

		return resultado;

	}

}
