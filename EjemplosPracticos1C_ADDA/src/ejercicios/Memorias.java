/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Ejemplos practicos del 1º cuatrimestre de ADDA
 */

package ejercicios;

import java.util.HashMap;
import java.util.Map;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;

public class Memorias {

	/*
	 * Ejemplo de llamada opaca a la función con memoria donde se pasan como
	 * paramétros, entre otros detalles, el mapa que representa la memoria de la
	 * función en cuestión:
	 */
	public static Long ejercicio1(Integer numero) {

		Map<Integer, Long> memoria = new HashMap<Integer, Long>();

		return ejercicio1Privado(numero, memoria);

	}

	// #######################################################################################
	// #######################################################################################

	/*
	 * Función para el calculo de una recurrencia dado unicamente un numero y las
	 * condiciones para la actualización de los términos, que además, usa un mapa
	 * como memoria. El map guarda el valor del nº y su resultado tras el calculo y
	 * se comprueba si el calculo para ese nº ha sido realizado ANTES de hacerlo de
	 * nuevo:
	 */
	private static Long ejercicio1Privado(Integer numero, Map<Integer, Long> memoria) {

		Long resultado = 0L;

		// Casos base: se comprueba si el resultado para ese nº está en memoria:
		if (memoria.containsKey(numero)) {
			resultado = memoria.get(numero);
		} else if (numero == 0) {
			resultado = 2L;
			memoria.put(numero, resultado);
		} else if (numero == 1 || numero == 2) {
			resultado = 1L;
			memoria.put(numero, resultado);
			// Caso recursivo:
		} else {
			resultado = (4 * ejercicio1Privado((numero - 1), memoria)) + ejercicio1Privado((numero - 2), memoria)
					+ ejercicio1Privado((numero - 3), memoria);
			memoria.put(numero, resultado);
		}

		return resultado;

	}

	// #######################################################################################
	// #######################################################################################

	/*
	 * Llamada opaca a otra función con memoria en este caso usando tuplas para
	 * guardar un par de valores de entrada y el resultado del calculo efectuado con
	 * estos:
	 */
	public static Long ejercicio2(Integer numeroA, Integer numeroB) {

		// Empleamos Tuple2 para "encapsular" los dos numeros que se reciben como
		// parametros:
		Map<Tuple2<Integer, Integer>, Long> memoria = new HashMap<Tuple2<Integer, Integer>, Long>();

		return ejercicio2Privado(numeroA, numeroB, memoria);

	}

	// #######################################################################################
	// #######################################################################################

	/*
	 * Función recursiva con memoria para el calculo de una recurrencia con entrada de dos nºs 
	 * y memoria que guarda el calculo. La clave para el mapa es la tupla de los dos datos de entrada
	 * y el valor es el resultado asociado a ese par de valores:
	 */
	private static Long ejercicio2Privado(Integer numeroA, Integer numeroB,
			Map<Tuple2<Integer, Integer>, Long> memoria) {

		Long resultado;
		Tuple2<Integer, Integer> tupla = Tuple.create(numeroA, numeroB);

		// Casos bases: se comprueba si el resultado para ese par está en memoria:
		if (memoria.containsKey(tupla)) {
			resultado = memoria.get(tupla);
		} else if (numeroA < 2 && numeroB < 2) {
			resultado = (long) (numeroA + Math.pow(numeroB, 2));
			memoria.put(tupla, resultado);
		} else if (numeroA < 2 || numeroB < 2) {
			resultado = (long) (Math.pow(numeroA, 2) + numeroB);
			memoria.put(tupla, resultado);
		// Caso recursivo:
		} else {
			resultado = (long) ejercicio2Privado((numeroA / 2), (numeroB - 1), memoria)
					+ ejercicio2Privado((numeroA / 3), (numeroB - 2), memoria)
					+ ejercicio2Privado((numeroA - 2), (numeroB / 4), memoria);
		}

		return resultado;

	}

}
