/*
 *  	Analisis y Diseño de Datos y Algoritmos - 2020
 *      Author: Alejandro Fernandez Trigo
 *      Practica Individual 1
 */

package ejercicios;

//Librerias:
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.flujossecuenciales.StreamsS;
import us.lsi.math.Math2;

public class Ejercicio1 {

	// ###################################################################################
	// ###################################################################################
	// ####################### 				EJERCICIO 1 				##################
	// ###################################################################################
	// ###################################################################################

	// Funcion que lee un fichero de entrada; dado un fichero con multiples lineas
	// y en cada linea numeros enteros separados por comas, devuelve una lista de
	// listas formadas por los numeros del fichero:
	public static List<List<Integer>> leeDatosEjercicio1(String fichero) {

		int i = 0;
		int j = 0;
		List<String> lista = StreamsS.file(fichero).collect(Collectors.toList());
		List<List<Integer>> resultado = new ArrayList<>();

		while (i < lista.size()) {

			String fila = lista.get(i);
			String[] numeros = fila.split(", ");
			List<Integer> miniLista = new ArrayList<>();

			while (j < numeros.length) {

				miniLista.add(Integer.parseInt(numeros[j]));
				j++;

			}

			resultado.add(miniLista);
			j = 0;
			i++;

		}

		return resultado;

	}

	// Dada una lista de listas de enteros, comprueba que elementos son primos
	// y los devuelve, todos, en una lista nueva como resultado:
	public static List<Integer> compruebaSiEsPrimo(List<List<Integer>> lista) {

		int i = 0;
		int j = 0;
		List<Integer> resultado = new ArrayList<Integer>();

		while (i < lista.size()) {
			while (j < lista.get(i).size()) {

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
