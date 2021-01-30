/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ejemplos practicos del 1º cuatrimestre de ADDA
 */

package ejercicios;

import java.util.List;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple3;

public class Subsecuencias {

	// Ejemplos de calculos de subsecuencias: emplea el divide y vencerás siempre
	// como
	// se ve en el fichero DivideYVenceras.java para dividir el problema:

	/*
	 * Ejemplo de llamada opaca al ejercicio final para una subsecuencia donde se
	 * pasa no solo la lista de entrada sino su el tamaño y un índice de comienzo.
	 */
	public static Tuple3<Integer, Integer, Integer> ejercicio1(List<Integer> lista) {

		// El tamaño se calcula como el size() de la lista menos 1:
		Integer i = lista.size() - 1;

		return ejercicio1Privado(lista, 0, i);

	}

	// #######################################################################################
	// #######################################################################################

	/*
	 * Función de cruce de una lista que parte el problema en 2 en mitad =
	 * (inicio+fin)/2 y calcula lo requerido a un lado, al otro y en el cruce de
	 * ambos con una función auxiliar.
	 */
	private static Tuple3<Integer, Integer, Integer> ejercicio1Privado(List<Integer> lista, int inicio, int fin) {

		// Caso base:
		if (inicio == fin) {
			return Tuple.create(inicio, fin, lista.get(inicio));
		}

		int mitad = (inicio + fin) / 2;

		// Casos recursivos:
		// Calcula la suma de la izquierda:
		Tuple3<Integer, Integer, Integer> secuenciaIzquierda = ejercicio1Privado(lista, inicio, mitad);
		// Calcula la suma de la derecha:
		Tuple3<Integer, Integer, Integer> secuenciaDerecha = ejercicio1Privado(lista, mitad + 1, fin);
		// Calcula la suma del cruze: es necesario una funcion adicional para el cruce
		// de ambas partes:
		Tuple3<Integer, Integer, Integer> secuenciaMitad = calculaSecuenciaMitad(lista, inicio, fin, mitad);

		// Obtiene los valores de sus sumas:
		int totalIzquierda = secuenciaIzquierda.getV3();
		int totalDerecha = secuenciaDerecha.getV3();
		int totalMitad = secuenciaMitad.getV3();

		// Compara las sumas para devolver la mayor:
		if (totalIzquierda > totalDerecha && totalIzquierda > totalMitad) {
			return secuenciaIzquierda;
		} else if (totalDerecha > totalIzquierda && totalDerecha > totalMitad) {
			return secuenciaDerecha;
		} else {
			return secuenciaMitad;
		}

	}

	// #######################################################################################
	// #######################################################################################

	/*
	 * Funcion auxiliar para el calculo de un cruce de una subsecuencia (izquierda y derecha) 
	 * dada una lista de elementos y el indice ya "partido" que en este caso corresponde a "k". 
	 */
	public static Tuple3<Integer, Integer, Integer> calculaSecuenciaMitad(List<Integer> lista, Integer i, Integer j,
			Integer k) {

		int total = lista.get(k);
		int maximoIzquierda = k;
		int maximoDerecha = k + 1;
		int totalDerecha = lista.get(k);
		int totalIzquierda = lista.get(k);

		int indice1 = k - 1;
		while (indice1 >= i) {
			total = total + lista.get(indice1);
			if (total > totalIzquierda) {
				totalIzquierda = total;
				maximoIzquierda = indice1;
			}
			indice1--;
		}

		// Reseteo:
		total = lista.get(k);

		int indice2 = k + 1;
		while (indice2 < j) {
			total = total + lista.get(indice2);
			if (total > totalDerecha) {
				totalDerecha = total;
				maximoDerecha = indice2 + 1;
			}
			indice2++;
		}

		return Tuple.create(maximoIzquierda, maximoDerecha, totalIzquierda + totalDerecha - lista.get(k));

	}

}
